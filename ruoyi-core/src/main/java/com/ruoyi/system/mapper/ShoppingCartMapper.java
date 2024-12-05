package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.ShoppingCart;

/**
 * 购物车商品Mapper接口
 *
 * @author ruoyi
 * @date 2024-12-04
 */
public interface ShoppingCartMapper {
    /**
     * 查询购物车商品
     *
     * @param id 购物车商品主键
     * @return 购物车商品
     */
    public ShoppingCart selectShoppingCartById(Integer id);

    /**
     * 查询购物车商品
     *
     * @param courseId 购物车商品主键
     * @param userId   用户主键
     * @return 购物车商品
     */
    public ShoppingCart selectShoppingCartByUidAndCid(Integer courseId, Long userId);

    /**
     * 查询用户购物车商品列表
     *
     * @param userId 用户主键
     * @return 用户购物车商品集合
     */
    public List<ShoppingCart> selectShoppingCartListByUid(Long userId);

    public int deleteShoppingCarByIdAndUid(Integer id, Long userId);

    /**
     * 查询购物车商品列表
     *
     * @param shoppingCart 购物车商品
     * @return 购物车商品集合
     */
    public List<ShoppingCart> selectShoppingCartList(ShoppingCart shoppingCart);

    /**
     * 新增购物车商品
     *
     * @param shoppingCart 购物车商品
     * @return 结果
     */
    public int insertShoppingCart(ShoppingCart shoppingCart);

    /**
     * 修改购物车商品
     *
     * @param shoppingCart 购物车商品
     * @return 结果
     */
    public int updateShoppingCart(ShoppingCart shoppingCart);

    /**
     * 删除购物车商品
     *
     * @param id 购物车商品主键
     * @return 结果
     */
    public int deleteShoppingCartById(Integer id);

    /**
     * 批量删除购物车商品
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShoppingCartByIds(Integer[] ids);
}

