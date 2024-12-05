package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CourseMapper;
import com.ruoyi.system.domain.Course;
import com.ruoyi.system.service.ICourseService;

/**
 * 课程Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-03
 */
@Service
public class CourseServiceImpl implements ICourseService 
{
    @Autowired
    private CourseMapper courseMapper;

    /**
     * 查询课程
     * 
     * @param id 课程主键
     * @return 课程
     */
    @Override
    public Course selectCourseById(Integer id)
    {
        return courseMapper.selectCourseById(id);
    }

    /**
     * 查询课程列表
     * 
     * @param course 课程
     * @return 课程
     */
    @Override
    public List<Course> selectCourseList(Course course)
    {
        return courseMapper.selectCourseList(course);
    }

    /**
     * 新增课程
     * 
     * @param course 课程
     * @return 结果
     */
    @Override
    public int insertCourse(Course course)
    {
        return courseMapper.insertCourse(course);
    }

    /**
     * 修改课程
     * 
     * @param course 课程
     * @return 结果
     */
    @Override
    public int updateCourse(Course course)
    {
        return courseMapper.updateCourse(course);
    }

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的课程主键
     * @return 结果
     */
    @Override
    public int deleteCourseByIds(Integer[] ids)
    {
        return courseMapper.deleteCourseByIds(ids);
    }

    /**
     * 删除课程信息
     * 
     * @param id 课程主键
     * @return 结果
     */
    @Override
    public int deleteCourseById(Integer id)
    {
        return courseMapper.deleteCourseById(id);
    }
}
