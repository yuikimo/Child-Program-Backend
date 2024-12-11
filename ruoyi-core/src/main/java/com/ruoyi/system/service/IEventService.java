package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Event;

/**
 * 官网活动Service接口
 * 
 * @author ruoyi
 * @date 2024-12-06
 */
public interface IEventService 
{
    /**
     * 查询官网活动
     * 
     * @param id 官网活动主键
     * @return 官网活动
     */
    public Event selectEventById(Long id);

    /**
     * 查询官网活动列表
     * 
     * @param event 官网活动
     * @return 官网活动集合
     */
    public List<Event> selectEventList(Event event);

    /**
     * 新增官网活动
     * 
     * @param event 官网活动
     * @return 结果
     */
    public int insertEvent(Event event);

    /**
     * 修改官网活动
     * 
     * @param event 官网活动
     * @return 结果
     */
    public int updateEvent(Event event);

    /**
     * 批量删除官网活动
     * 
     * @param ids 需要删除的官网活动主键集合
     * @return 结果
     */
    public int deleteEventByIds(Long[] ids);

    /**
     * 删除官网活动信息
     * 
     * @param id 官网活动主键
     * @return 结果
     */
    public int deleteEventById(Long id);
}
