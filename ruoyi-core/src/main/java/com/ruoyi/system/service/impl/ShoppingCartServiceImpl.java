package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ShoppingCartMapper;
import com.ruoyi.system.domain.ShoppingCart;
import com.ruoyi.system.service.IShoppingCartService;

/**
 * 购物车商品Service业务层处理
 *
 * @author ruoyi
 * @date 2024-12-04
 */
@Service
public class ShoppingCartServiceImpl implements IShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    /**
     * 查询购物车商品
     *
     * @param id 购物车商品主键
     * @return 购物车商品
     */
    @Override
    public ShoppingCart selectShoppingCartById(Integer id) {
        return shoppingCartMapper.selectShoppingCartById(id);
    }

    /**
     * 查询购物车商品总数
     *
     * @param userId 用户主键
     * @return 购物车商品数量
     */
    @Override
    public long countShoppingCartListByUid(Long userId) {
        List<ShoppingCart> shoppingCarts = shoppingCartMapper.selectShoppingCartListByUid(userId);
        Optional<Integer> reduce = shoppingCarts.stream().map(ShoppingCart::getCount).reduce(Integer::sum);
        return reduce.orElse(0);
    }

    @Override
    public List<ShoppingCart> selectShoppingCartListByUid(Long userId) {
        return shoppingCartMapper.selectShoppingCartListByUid(userId);
    }

    @Override
    public int deleteShoppingCarByIdAndUid(Integer id, Long userId) {
        return shoppingCartMapper.deleteShoppingCarByIdAndUid(id, userId);
    }

    /**
     * 查询购物车商品
     *
     * @param courseId 购物车商品主键
     * @param userId   用户主键
     * @return 购物车商品
     */
    @Override
    public ShoppingCart selectShoppingCartByUidAndCid(Integer courseId, Long userId) {
        return shoppingCartMapper.selectShoppingCartByUidAndCid(courseId, userId);
    }

    /**
     * 查询购物车商品列表
     *
     * @param shoppingCart 购物车商品
     * @return 购物车商品
     */

    @Override
    public List<ShoppingCart> selectShoppingCartList(ShoppingCart shoppingCart) {
        return shoppingCartMapper.selectShoppingCartList(shoppingCart);
    }

    /**
     * 新增购物车商品
     *
     * @param shoppingCart 购物车商品
     * @return 结果
     */
    @Override
    public int insertShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartMapper.insertShoppingCart(shoppingCart);
    }

    /**
     * 修改购物车商品
     *
     * @param shoppingCart 购物车商品
     * @return 结果
     */
    @Override
    public int updateShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartMapper.updateShoppingCart(shoppingCart);
    }

    /**
     * 批量删除购物车商品
     *
     * @param ids 需要删除的购物车商品主键
     * @return 结果
     */
    @Override
    public int deleteShoppingCartByIds(Integer[] ids) {
        return shoppingCartMapper.deleteShoppingCartByIds(ids);
    }

    /**
     * 删除购物车商品信息
     *
     * @param id 购物车商品主键
     * @return 结果
     */
    @Override
    public int deleteShoppingCartById(Integer id) {
        return shoppingCartMapper.deleteShoppingCartById(id);
    }
}
