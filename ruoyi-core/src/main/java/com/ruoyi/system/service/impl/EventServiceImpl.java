package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EventMapper;
import com.ruoyi.system.domain.Event;
import com.ruoyi.system.service.IEventService;

/**
 * 官网活动Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-06
 */
@Service
public class EventServiceImpl implements IEventService 
{
    @Autowired
    private EventMapper eventMapper;

    /**
     * 查询官网活动
     * 
     * @param id 官网活动主键
     * @return 官网活动
     */
    @Override
    public Event selectEventById(Long id)
    {
        return eventMapper.selectEventById(id);
    }

    /**
     * 查询官网活动列表
     * 
     * @param event 官网活动
     * @return 官网活动
     */
    @Override
    public List<Event> selectEventList(Event event)
    {
        return eventMapper.selectEventList(event);
    }

    /**
     * 新增官网活动
     * 
     * @param event 官网活动
     * @return 结果
     */
    @Override
    public int insertEvent(Event event)
    {
        return eventMapper.insertEvent(event);
    }

    /**
     * 修改官网活动
     * 
     * @param event 官网活动
     * @return 结果
     */
    @Override
    public int updateEvent(Event event)
    {
        return eventMapper.updateEvent(event);
    }

    /**
     * 批量删除官网活动
     * 
     * @param ids 需要删除的官网活动主键
     * @return 结果
     */
    @Override
    public int deleteEventByIds(Long[] ids)
    {
        return eventMapper.deleteEventByIds(ids);
    }

    /**
     * 删除官网活动信息
     * 
     * @param id 官网活动主键
     * @return 结果
     */
    @Override
    public int deleteEventById(Long id)
    {
        return eventMapper.deleteEventById(id);
    }
}
