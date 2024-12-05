package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Course;

/**
 * 课程Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-03
 */
public interface CourseMapper 
{
    /**
     * 查询课程
     * 
     * @param id 课程主键
     * @return 课程
     */
    public Course selectCourseById(Integer id);

    /**
     * 查询课程列表
     * 
     * @param course 课程
     * @return 课程集合
     */
    public List<Course> selectCourseList(Course course);

    /**
     * 新增课程
     * 
     * @param course 课程
     * @return 结果
     */
    public int insertCourse(Course course);

    /**
     * 修改课程
     * 
     * @param course 课程
     * @return 结果
     */
    public int updateCourse(Course course);

    /**
     * 删除课程
     * 
     * @param id 课程主键
     * @return 结果
     */
    public int deleteCourseById(Integer id);

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCourseByIds(Integer[] ids);
}
