package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AdviceMapper;
import com.ruoyi.system.domain.Advice;
import com.ruoyi.system.service.IAdviceService;

/**
 * 用户意见Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-06
 */
@Service
public class AdviceServiceImpl implements IAdviceService 
{
    @Autowired
    private AdviceMapper adviceMapper;

    /**
     * 查询用户意见
     * 
     * @param id 用户意见主键
     * @return 用户意见
     */
    @Override
    public Advice selectAdviceById(Long id)
    {
        return adviceMapper.selectAdviceById(id);
    }

    /**
     * 查询用户意见列表
     * 
     * @param advice 用户意见
     * @return 用户意见
     */
    @Override
    public List<Advice> selectAdviceList(Advice advice)
    {
        return adviceMapper.selectAdviceList(advice);
    }

    /**
     * 新增用户意见
     * 
     * @param advice 用户意见
     * @return 结果
     */
    @Override
    public int insertAdvice(Advice advice)
    {
        return adviceMapper.insertAdvice(advice);
    }

    /**
     * 修改用户意见
     * 
     * @param advice 用户意见
     * @return 结果
     */
    @Override
    public int updateAdvice(Advice advice)
    {
        return adviceMapper.updateAdvice(advice);
    }

    /**
     * 批量删除用户意见
     * 
     * @param ids 需要删除的用户意见主键
     * @return 结果
     */
    @Override
    public int deleteAdviceByIds(Long[] ids)
    {
        return adviceMapper.deleteAdviceByIds(ids);
    }

    /**
     * 删除用户意见信息
     * 
     * @param id 用户意见主键
     * @return 结果
     */
    @Override
    public int deleteAdviceById(Long id)
    {
        return adviceMapper.deleteAdviceById(id);
    }

    @Override public Advice selectAdviceByIpAddress(String ip) {
        return adviceMapper.selectAdviceByIpAddress(ip);
    }
}
