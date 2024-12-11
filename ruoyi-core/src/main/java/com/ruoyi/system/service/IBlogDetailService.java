package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BlogDetail;

/**
 * 博客文章详情Service接口
 * 
 * @author ruoyi
 * @date 2024-12-06
 */
public interface IBlogDetailService 
{
    /**
     * 查询博客文章详情
     * 
     * @param id 博客文章详情主键
     * @return 博客文章详情
     */
    public BlogDetail selectBlogDetailById(Long id);

    /**
     * 查询博客文章详情列表
     * 
     * @param blogDetail 博客文章详情
     * @return 博客文章详情集合
     */
    public List<BlogDetail> selectBlogDetailList(BlogDetail blogDetail);

    /**
     * 新增博客文章详情
     * 
     * @param blogDetail 博客文章详情
     * @return 结果
     */
    public int insertBlogDetail(BlogDetail blogDetail);

    /**
     * 修改博客文章详情
     * 
     * @param blogDetail 博客文章详情
     * @return 结果
     */
    public int updateBlogDetail(BlogDetail blogDetail);

    /**
     * 批量删除博客文章详情
     * 
     * @param ids 需要删除的博客文章详情主键集合
     * @return 结果
     */
    public int deleteBlogDetailByIds(Long[] ids);

    /**
     * 删除博客文章详情信息
     * 
     * @param id 博客文章详情主键
     * @return 结果
     */
    public int deleteBlogDetailById(Long id);
}
