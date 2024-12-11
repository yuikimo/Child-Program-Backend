package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ShoppingCart;

/**
 * 购物车商品Service接口
 * 
 * @author ruoyi
 * @date 2024-12-04
 */
public interface IShoppingCartService
{
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
     * @param cartId 购物车商品主键
     * @param userId   用户主键
     * @return 购物车商品
     */
    public ShoppingCart selectShoppingCartByUidAndCid(Integer cartId, Long userId);

    /**
     * 查询购物车商品总数
     *
     * @param userId 用户主键
     * @return 购物车商品数量
     */
    public long countShoppingCartListByUid(Long userId);

    /**
     * 删除购物车商品信息
     *
     * @param id 购物车商品主键
     * @param userId 用户主键
     * @return 结果
     */
    public int deleteShoppingCarByIdAndUid(Integer id, Long userId);

    /**
     * 查询用户购物车商品列表
     *
     * @param userId 用户主键
     * @return 用户购物车商品集合
     */
    public List<ShoppingCart> selectShoppingCartListByUid(Long userId);

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
     * 批量删除购物车商品
     * 
     * @param ids 需要删除的购物车商品主键集合
     * @return 结果
     */
    public int deleteShoppingCartByIds(Integer[] ids);

    /**
     * 删除购物车商品信息
     * 
     * @param id 购物车商品主键
     * @return 结果
     */
    public int deleteShoppingCartById(Integer id);
}
