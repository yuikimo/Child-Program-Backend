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
import com.ruoyi.system.domain.BlogDetail;
import com.ruoyi.system.service.IBlogDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 博客文章详情Controller
 * 
 * @author ruoyi
 * @date 2024-12-06
 */
@RestController
@RequestMapping("/system/detail")
public class BlogDetailController extends BaseController
{
    @Autowired
    private IBlogDetailService blogDetailService;

    /**
     * 查询博客文章详情列表
     */
    @PreAuthorize("@ss.hasPermi('system:detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(BlogDetail blogDetail)
    {
        startPage();
        List<BlogDetail> list = blogDetailService.selectBlogDetailList(blogDetail);
        return getDataTable(list);
    }

    /**
     * 导出博客文章详情列表
     */
    @PreAuthorize("@ss.hasPermi('system:detail:export')")
    @Log(title = "博客文章详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BlogDetail blogDetail)
    {
        List<BlogDetail> list = blogDetailService.selectBlogDetailList(blogDetail);
        ExcelUtil<BlogDetail> util = new ExcelUtil<BlogDetail>(BlogDetail.class);
        util.exportExcel(response, list, "博客文章详情数据");
    }

    /**
     * 获取博客文章详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:detail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(blogDetailService.selectBlogDetailById(id));
    }

    /**
     * 新增博客文章详情
     */
    @PreAuthorize("@ss.hasPermi('system:detail:add')")
    @Log(title = "博客文章详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BlogDetail blogDetail)
    {
        return toAjax(blogDetailService.insertBlogDetail(blogDetail));
    }

    /**
     * 修改博客文章详情
     */
    @PreAuthorize("@ss.hasPermi('system:detail:edit')")
    @Log(title = "博客文章详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BlogDetail blogDetail)
    {
        return toAjax(blogDetailService.updateBlogDetail(blogDetail));
    }

    /**
     * 删除博客文章详情
     */
    @PreAuthorize("@ss.hasPermi('system:detail:remove')")
    @Log(title = "博客文章详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(blogDetailService.deleteBlogDetailByIds(ids));
    }
}
