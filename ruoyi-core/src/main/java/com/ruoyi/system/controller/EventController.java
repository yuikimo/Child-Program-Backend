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
import com.ruoyi.system.domain.Event;
import com.ruoyi.system.service.IEventService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 官网活动Controller
 * 
 * @author ruoyi
 * @date 2024-12-06
 */
@RestController
@RequestMapping("/system/event")
public class EventController extends BaseController
{
    @Autowired
    private IEventService eventService;

    /**
     * 查询官网活动列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Event event)
    {
        startPage();
        List<Event> list = eventService.selectEventList(event);
        return getDataTable(list);
    }

    /**
     * 导出官网活动列表
     */
    @PreAuthorize("@ss.hasPermi('system:event:export')")
    @Log(title = "官网活动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Event event)
    {
        List<Event> list = eventService.selectEventList(event);
        ExcelUtil<Event> util = new ExcelUtil<Event>(Event.class);
        util.exportExcel(response, list, "官网活动数据");
    }

    /**
     * 获取官网活动详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:event:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(eventService.selectEventById(id));
    }

    /**
     * 新增官网活动
     */
    @PreAuthorize("@ss.hasPermi('system:event:add')")
    @Log(title = "官网活动", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Event event)
    {
        return toAjax(eventService.insertEvent(event));
    }

    /**
     * 修改官网活动
     */
    @PreAuthorize("@ss.hasPermi('system:event:edit')")
    @Log(title = "官网活动", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Event event)
    {
        return toAjax(eventService.updateEvent(event));
    }

    /**
     * 删除官网活动
     */
    @PreAuthorize("@ss.hasPermi('system:event:remove')")
    @Log(title = "官网活动", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eventService.deleteEventByIds(ids));
    }
}
