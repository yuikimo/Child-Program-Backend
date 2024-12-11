package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Blog;

/**
 * 博客文章Service接口
 * 
 * @author ruoyi
 * @date 2024-12-06
 */
public interface IBlogService 
{
    /**
     * 查询博客文章
     * 
     * @param id 博客文章主键
     * @return 博客文章
     */
    public Blog selectBlogById(Long id);

    /**
     * 查询博客文章列表
     * 
     * @param blog 博客文章
     * @return 博客文章集合
     */
    public List<Blog> selectBlogList(Blog blog);

    /**
     * 新增博客文章
     * 
     * @param blog 博客文章
     * @return 结果
     */
    public int insertBlog(Blog blog);

    /**
     * 修改博客文章
     * 
     * @param blog 博客文章
     * @return 结果
     */
    public int updateBlog(Blog blog);

    /**
     * 批量删除博客文章
     * 
     * @param ids 需要删除的博客文章主键集合
     * @return 结果
     */
    public int deleteBlogByIds(Long[] ids);

    /**
     * 删除博客文章信息
     * 
     * @param id 博客文章主键
     * @return 结果
     */
    public int deleteBlogById(Long id);
}
