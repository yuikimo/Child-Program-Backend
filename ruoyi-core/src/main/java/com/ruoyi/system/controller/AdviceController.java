package com.ruoyi.system.controller;

import java.util.Date;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
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
import com.ruoyi.system.domain.Advice;
import com.ruoyi.system.service.IAdviceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户意见Controller
 * 
 * @author ruoyi
 * @date 2024-12-06
 */
@RestController
@RequestMapping("/system/advice")
public class AdviceController extends BaseController
{
    @Autowired
    private IAdviceService adviceService;

    /**
     * 查询用户意见列表
     */
    @PreAuthorize("@ss.hasPermi('system:advice:list')")
    @GetMapping("/list")
    public TableDataInfo list(Advice advice)
    {
        startPage();
        List<Advice> list = adviceService.selectAdviceList(advice);
        return getDataTable(list);
    }

    /**
     * 导出用户意见列表
     */
    @PreAuthorize("@ss.hasPermi('system:advice:export')")
    @Log(title = "用户意见", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Advice advice)
    {
        List<Advice> list = adviceService.selectAdviceList(advice);
        ExcelUtil<Advice> util = new ExcelUtil<Advice>(Advice.class);
        util.exportExcel(response, list, "用户意见数据");
    }

    /**
     * 获取用户意见详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:advice:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(adviceService.selectAdviceById(id));
    }

    /**
     * 新增用户意见
     */
    @PreAuthorize("@ss.hasPermi('system:advice:add')")
    @Log(title = "用户意见", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Advice advice)
    {
        return toAjax(adviceService.insertAdvice(advice));
    }

    /**
     * 修改用户意见
     */
    @PreAuthorize("@ss.hasPermi('system:advice:edit')")
    @Log(title = "用户意见", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Advice advice)
    {
        return toAjax(adviceService.updateAdvice(advice));
    }

    /**
     * 删除用户意见
     */
    @PreAuthorize("@ss.hasPermi('system:advice:remove')")
    @Log(title = "用户意见", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(adviceService.deleteAdviceByIds(ids));
    }

    @PostMapping("/create")
    public AjaxResult addByUser(@RequestBody Advice advice,
                                HttpServletRequest request) {
        String address = request.getRemoteAddr();
        Advice has = adviceService.selectAdviceByIpAddress(address);
        if(has!=null){
            return AjaxResult.error("您今天已经反馈过了，请明日再来");
        }else {
            advice.setTime(new Date());
            advice.setIp(address);
            return toAjax(adviceService.insertAdvice(advice));
        }
    }
}
