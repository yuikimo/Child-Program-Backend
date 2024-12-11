package com.ruoyi.system.controller;

import java.util.List;
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
import com.ruoyi.system.domain.VipItem;
import com.ruoyi.system.service.IVipItemService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会员等级Controller
 * 
 * @author ruoyi
 * @date 2024-12-06
 */
@RestController
@RequestMapping("/system/vip")
public class VipItemController extends BaseController
{
    @Autowired
    private IVipItemService vipItemService;

    /**
     * 查询会员等级列表
     */
    @GetMapping("/list")
    public TableDataInfo list(VipItem vipItem)
    {
        startPage();
        List<VipItem> list = vipItemService.selectVipItemList(vipItem);
        return getDataTable(list);
    }

    /**
     * 导出会员等级列表
     */
    @PreAuthorize("@ss.hasPermi('system:vip:export')")
    @Log(title = "会员等级", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VipItem vipItem)
    {
        List<VipItem> list = vipItemService.selectVipItemList(vipItem);
        ExcelUtil<VipItem> util = new ExcelUtil<VipItem>(VipItem.class);
        util.exportExcel(response, list, "会员等级数据");
    }

    /**
     * 获取会员等级详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:vip:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(vipItemService.selectVipItemById(id));
    }

    /**
     * 新增会员等级
     */
    @PreAuthorize("@ss.hasPermi('system:vip:add')")
    @Log(title = "会员等级", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VipItem vipItem)
    {
        return toAjax(vipItemService.insertVipItem(vipItem));
    }

    /**
     * 修改会员等级
     */
    @PreAuthorize("@ss.hasPermi('system:vip:edit')")
    @Log(title = "会员等级", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VipItem vipItem)
    {
        return toAjax(vipItemService.updateVipItem(vipItem));
    }

    /**
     * 删除会员等级
     */
    @PreAuthorize("@ss.hasPermi('system:vip:remove')")
    @Log(title = "会员等级", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(vipItemService.deleteVipItemByIds(ids));
    }
}
