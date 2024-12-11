package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Advice;

/**
 * 用户意见Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-06
 */
public interface AdviceMapper 
{
    /**
     * 查询用户意见
     * 
     * @param id 用户意见主键
     * @return 用户意见
     */
    public Advice selectAdviceById(Long id);

    /**
     * 查询用户意见列表
     * 
     * @param advice 用户意见
     * @return 用户意见集合
     */
    public List<Advice> selectAdviceList(Advice advice);

    /**
     * 新增用户意见
     * 
     * @param advice 用户意见
     * @return 结果
     */
    public int insertAdvice(Advice advice);

    /**
     * 修改用户意见
     * 
     * @param advice 用户意见
     * @return 结果
     */
    public int updateAdvice(Advice advice);

    /**
     * 删除用户意见
     * 
     * @param id 用户意见主键
     * @return 结果
     */
    public int deleteAdviceById(Long id);

    /**
     * 批量删除用户意见
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAdviceByIds(Long[] ids);

    public Advice selectAdviceByIpAddress(String ip);
}
