package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.VipItem;

/**
 * 会员等级Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-06
 */
public interface VipItemMapper 
{
    /**
     * 查询会员等级
     * 
     * @param id 会员等级主键
     * @return 会员等级
     */
    public VipItem selectVipItemById(Long id);

    /**
     * 查询会员等级列表
     * 
     * @param vipItem 会员等级
     * @return 会员等级集合
     */
    public List<VipItem> selectVipItemList(VipItem vipItem);

    /**
     * 新增会员等级
     * 
     * @param vipItem 会员等级
     * @return 结果
     */
    public int insertVipItem(VipItem vipItem);

    /**
     * 修改会员等级
     * 
     * @param vipItem 会员等级
     * @return 结果
     */
    public int updateVipItem(VipItem vipItem);

    /**
     * 删除会员等级
     * 
     * @param id 会员等级主键
     * @return 结果
     */
    public int deleteVipItemById(Long id);

    /**
     * 批量删除会员等级
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVipItemByIds(Long[] ids);
}
