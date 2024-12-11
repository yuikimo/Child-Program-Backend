package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.VipItemMapper;
import com.ruoyi.system.domain.VipItem;
import com.ruoyi.system.service.IVipItemService;

/**
 * 会员等级Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-06
 */
@Service
public class VipItemServiceImpl implements IVipItemService 
{
    @Autowired
    private VipItemMapper vipItemMapper;

    /**
     * 查询会员等级
     * 
     * @param id 会员等级主键
     * @return 会员等级
     */
    @Override
    public VipItem selectVipItemById(Long id)
    {
        return vipItemMapper.selectVipItemById(id);
    }

    /**
     * 查询会员等级列表
     * 
     * @param vipItem 会员等级
     * @return 会员等级
     */
    @Override
    public List<VipItem> selectVipItemList(VipItem vipItem)
    {
        return vipItemMapper.selectVipItemList(vipItem);
    }

    /**
     * 新增会员等级
     * 
     * @param vipItem 会员等级
     * @return 结果
     */
    @Override
    public int insertVipItem(VipItem vipItem)
    {
        return vipItemMapper.insertVipItem(vipItem);
    }

    /**
     * 修改会员等级
     * 
     * @param vipItem 会员等级
     * @return 结果
     */
    @Override
    public int updateVipItem(VipItem vipItem)
    {
        return vipItemMapper.updateVipItem(vipItem);
    }

    /**
     * 批量删除会员等级
     * 
     * @param ids 需要删除的会员等级主键
     * @return 结果
     */
    @Override
    public int deleteVipItemByIds(Long[] ids)
    {
        return vipItemMapper.deleteVipItemByIds(ids);
    }

    /**
     * 删除会员等级信息
     * 
     * @param id 会员等级主键
     * @return 结果
     */
    @Override
    public int deleteVipItemById(Long id)
    {
        return vipItemMapper.deleteVipItemById(id);
    }
}
