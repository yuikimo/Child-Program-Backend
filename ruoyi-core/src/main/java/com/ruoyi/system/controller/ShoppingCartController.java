package com.ruoyi.system.controller;

import java.math.BigDecimal;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.Course;
import com.ruoyi.system.service.ICourseService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.ShoppingCart;
import com.ruoyi.system.service.IShoppingCartService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 购物车商品Controller
 *
 * @author ruoyi
 * @date 2024-12-04
 */
@RestController
@RequestMapping("/system/cart")
public class ShoppingCartController extends BaseController {
    @Autowired
    private IShoppingCartService shoppingCartService;

    @Autowired
    private ICourseService courseService;

    /**
     * 查询购物车商品列表
     */
    @PreAuthorize("@ss.hasPermi('system:cart:list')")
    @GetMapping("/list")
    public TableDataInfo list(ShoppingCart shoppingCart) {
        startPage();
        List<ShoppingCart> list = shoppingCartService.selectShoppingCartList(shoppingCart);
        return getDataTable(list);
    }

    /**
     * 导出购物车商品列表
     */
    @PreAuthorize("@ss.hasPermi('system:cart:export')")
    @Log(title = "购物车商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShoppingCart shoppingCart) {
        List<ShoppingCart> list = shoppingCartService.selectShoppingCartList(shoppingCart);
        ExcelUtil<ShoppingCart> util = new ExcelUtil<ShoppingCart>(ShoppingCart.class);
        util.exportExcel(response, list, "购物车商品数据");
    }

    /**
     * 获取购物车商品详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cart:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id) {
        return success(shoppingCartService.selectShoppingCartById(id));
    }

    /**
     * 新增购物车商品
     */
    @PreAuthorize("@ss.hasPermi('system:cart:add')")
    @Log(title = "购物车商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShoppingCart shoppingCart) {
        return toAjax(shoppingCartService.insertShoppingCart(shoppingCart));
    }

    /**
     * 修改购物车商品
     */
    @PreAuthorize("@ss.hasPermi('system:cart:edit')")
    @Log(title = "购物车商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShoppingCart shoppingCart) {
        return toAjax(shoppingCartService.updateShoppingCart(shoppingCart));
    }

    /**
     * 删除购物车商品
     */
    @PreAuthorize("@ss.hasPermi('system:cart:remove')")
    @Log(title = "购物车商品", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids) {
        return toAjax(shoppingCartService.deleteShoppingCartByIds(ids));
    }

    /**
     * 普通用户添加购物车商品
     */
    @PostMapping("/add/{courseId}")
    public AjaxResult addByUser(@PathVariable Integer courseId) {
        Course course = courseService.selectCourseById(courseId);
        if (course == null) {
            return toAjax(false);
        }
        Long userId = SecurityUtils.getUserId();
        ShoppingCart shoppingCart = shoppingCartService.selectShoppingCartByUidAndCid(courseId, userId);
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            shoppingCart.setUid(Math.toIntExact(userId));
            shoppingCart.setPrice(new BigDecimal(course.getPrice()));
            shoppingCart.setTitle(course.getTitle());
            shoppingCart.setCourseId(courseId);
            shoppingCart.setCount(1);
            shoppingCartService.insertShoppingCart(shoppingCart);
        } else {
            shoppingCart.setCount(shoppingCart.getCount() + 1);
            shoppingCartService.updateShoppingCart(shoppingCart);
        }
        return toAjax(true);
    }

    @GetMapping("/count")
    public AjaxResult shoppingCartCount() {
        return AjaxResult.success(shoppingCartService.countShoppingCartListByUid(SecurityUtils.getUserId()));
    }

    @GetMapping("/my-list")
    public AjaxResult userList() {
        return AjaxResult.success(shoppingCartService.selectShoppingCartListByUid(SecurityUtils.getUserId()));
    }

    @DeleteMapping("/delete/{id}")
    public AjaxResult deleteShoppingCart(@PathVariable Integer id) {
        return toAjax(shoppingCartService.deleteShoppingCarByIdAndUid(id, SecurityUtils.getUserId()));
    }

    @PutMapping("/increase/{id}")
    public AjaxResult increase(@PathVariable Integer id) {
        System.out.println("increaseId: "+ id);
        ShoppingCart shoppingCart = shoppingCartService.selectShoppingCartByUidAndCid(id, SecurityUtils.getUserId());
        shoppingCart.setCount(shoppingCart.getCount() + 1);
        return toAjax(shoppingCartService.updateShoppingCart(shoppingCart));
    }

    @PutMapping("/decrease/{id}")
    public AjaxResult decrease(@PathVariable Integer id) {
        ShoppingCart shoppingCart = shoppingCartService.selectShoppingCartByUidAndCid(id, SecurityUtils.getUserId());
        Integer count = shoppingCart.getCount();
        if (count <= 1) {
            return toAjax(shoppingCartService.deleteShoppingCarByIdAndUid(id, SecurityUtils.getUserId()));
        } else {
            shoppingCart.setCount(shoppingCart.getCount() - 1);
            return toAjax(shoppingCartService.updateShoppingCart(shoppingCart));
        }
    }
}
