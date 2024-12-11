package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.OrderItem;
import com.ruoyi.system.mapper.OrderMapper;
import com.ruoyi.system.domain.Order;
import com.ruoyi.system.service.IOrderService;

/**
 * 订单列表Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-05
 */
@Service
public class OrderServiceImpl implements IOrderService 
{
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 查询订单列表
     * 
     * @param id 订单列表主键
     * @return 订单列表
     */
    @Override
    public Order selectOrderById(Long id)
    {
        return orderMapper.selectOrderById(id);
    }

    /**
     * 查询订单列表列表
     * 
     * @param order 订单列表
     * @return 订单列表
     */
    @Override
    public List<Order> selectOrderList(Order order)
    {
        return orderMapper.selectOrderList(order);
    }

    /**
     * 新增订单列表
     * 
     * @param order 订单列表
     * @return 结果
     */
    @Transactional
    @Override
    public int insertOrder(Order order)
    {
        int rows = orderMapper.insertOrder(order);
        insertOrderItem(order);
        return rows;
    }

    /**
     * 修改订单列表
     * 
     * @param order 订单列表
     * @return 结果
     */
    @Transactional
    @Override
    public int updateOrder(Order order)
    {
        orderMapper.deleteOrderItemByOrderId(order.getId());
        insertOrderItem(order);
        return orderMapper.updateOrder(order);
    }

    /**
     * 批量删除订单列表
     * 
     * @param ids 需要删除的订单列表主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteOrderByIds(Long[] ids)
    {
        orderMapper.deleteOrderItemByOrderIds(ids);
        return orderMapper.deleteOrderByIds(ids);
    }

    /**
     * 删除订单列表信息
     * 
     * @param id 订单列表主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteOrderById(Long id)
    {
        orderMapper.deleteOrderItemByOrderId(id);
        return orderMapper.deleteOrderById(id);
    }

    /**
     * 新增订单商品列表信息
     * 
     * @param order 订单列表对象
     */
    public void insertOrderItem(Order order)
    {
        List<OrderItem> orderItemList = order.getOrderItemList();
        Long id = order.getId();
        if (StringUtils.isNotNull(orderItemList))
        {
            List<OrderItem> list = new ArrayList<OrderItem>();
            for (OrderItem orderItem : orderItemList)
            {
                orderItem.setOrderId(id);
                list.add(orderItem);
            }
            if (list.size() > 0)
            {
                orderMapper.batchOrderItem(list);
            }
        }
    }

    @Override
    public List<Order> selectOrderListByUid(Long userId) {
        return orderMapper.selectOrderListByUid(userId);
    }
}
