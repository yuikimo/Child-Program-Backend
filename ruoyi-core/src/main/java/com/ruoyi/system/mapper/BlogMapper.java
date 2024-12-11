package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Blog;
import com.ruoyi.system.domain.BlogDetail;

/**
 * 博客文章Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-06
 */
public interface BlogMapper 
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
     * 删除博客文章
     * 
     * @param id 博客文章主键
     * @return 结果
     */
    public int deleteBlogById(Long id);

    /**
     * 批量删除博客文章
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBlogByIds(Long[] ids);

    /**
     * 批量删除博客文章详情
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBlogDetailByIds(Long[] ids);
    
    /**
     * 批量新增博客文章详情
     * 
     * @param blogDetailList 博客文章详情列表
     * @return 结果
     */
    public int batchBlogDetail(List<BlogDetail> blogDetailList);
    

    /**
     * 通过博客文章主键删除博客文章详情信息
     * 
     * @param id 博客文章ID
     * @return 结果
     */
    public int deleteBlogDetailById(Long id);
}
