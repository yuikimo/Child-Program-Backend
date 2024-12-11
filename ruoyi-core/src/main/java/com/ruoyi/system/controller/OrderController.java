package com.ruoyi.system.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.OrderItem;
import com.ruoyi.system.domain.ShoppingCart;
import com.ruoyi.system.domain.VipItem;
import com.ruoyi.system.service.IShoppingCartService;
import com.ruoyi.system.service.IVipItemService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Order;
import com.ruoyi.system.service.IOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单列表Controller
 *
 * @author ruoyi
 * @date 2024-12-05
 */
@RestController
@RequestMapping("/system/order")
public class OrderController extends BaseController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IShoppingCartService shoppingCartService;

    @Autowired
    private IVipItemService vipItemService;

    /**
     * 查询订单列表列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(Order order) {
        startPage();
        List<Order> list = orderService.selectOrderList(order);
        return getDataTable(list);
    }

    /**
     * 导出订单列表列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:export')")
    @Log(title = "订单列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Order order) {
        List<Order> list = orderService.selectOrderList(order);
        ExcelUtil<Order> util = new ExcelUtil<Order>(Order.class);
        util.exportExcel(response, list, "订单列表数据");
    }

    /**
     * 获取订单列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(orderService.selectOrderById(id));
    }

    /**
     * 新增订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:add')")
    @Log(title = "订单列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Order order) {
        return toAjax(orderService.insertOrder(order));
    }

    /**
     * 修改订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:edit')")
    @Log(title = "订单列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Order order) {
        return toAjax(orderService.updateOrder(order));
    }

    /**
     * 删除订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:remove')")
    @Log(title = "订单列表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(orderService.deleteOrderByIds(ids));
    }

    @PostMapping("/create-normal")
    public AjaxResult createUserOrder(@RequestBody Order order) {
        List<ShoppingCart> carts = shoppingCartService.selectShoppingCartListByUid(SecurityUtils.getUserId());
        List<OrderItem> orderItemList = carts.stream().map(item -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setCount(item.getCount().longValue());
            orderItem.setPrice(item.getPrice());
            orderItem.setTitle(item.getTitle());
            return orderItem;
        }).toList();
        Long totalPrice = orderItemList
                .stream()
                .map(item -> {
                    return item.getCount() * item.getPrice().longValue();
                })
                .reduce(Long::sum)
                .orElse(0L);
        order.setUid(SecurityUtils.getUserId());
        order.setTime(new Date());
        order.setPrice(totalPrice.doubleValue());
        order.setOrderItemList(orderItemList);
        int rows = orderService.insertOrder(order);
        if(rows > 0) {
            shoppingCartService.deleteShoppingCartByIds(carts.stream().map(ShoppingCart::getId).toArray(Integer[]::new));
        }
        return toAjax(rows);
    }

    @PostMapping("/create-vip")
    public AjaxResult createUserVipOrder(@RequestBody Order order,
                                         @RequestParam Long id) {
        VipItem vipItem = vipItemService.selectVipItemById(id);
        OrderItem orderItem = new OrderItem();
        orderItem.setTitle(vipItem.getTitle());
        orderItem.setPrice(BigDecimal.valueOf(vipItem.getPrice()));
        orderItem.setCount(1L);
        order.setUid(SecurityUtils.getUserId());
        order.setTime(new Date());
        order.setPrice(vipItem.getPrice().doubleValue());
        order.setOrderItemList(List.of(orderItem));
        return toAjax(orderService.insertOrder(order));
    }

    @GetMapping("/my-list")
    public TableDataInfo userList() {
        startPage();
        List<Order> list = orderService.selectOrderListByUid(SecurityUtils.getUserId());
        return getDataTable(list);
    }
}
