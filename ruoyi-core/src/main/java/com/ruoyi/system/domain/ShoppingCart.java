package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 购物车商品对象 shopping_cart
 * 
 * @author ruoyi
 * @date 2024-12-04
 */
public class ShoppingCart extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 购物车ID */
    private Integer id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Integer uid;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Integer courseId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String title;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private BigDecimal price;

    /** 商品数量 */
    @Excel(name = "商品数量")
    private Integer count;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setUid(Integer uid) 
    {
        this.uid = uid;
    }

    public Integer getUid() 
    {
        return uid;
    }
    public void setCourseId(Integer courseId) 
    {
        this.courseId = courseId;
    }

    public Integer getCourseId() 
    {
        return courseId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setCount(Integer count) 
    {
        this.count = count;
    }

    public Integer getCount() 
    {
        return count;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("courseId", getCourseId())
            .append("title", getTitle())
            .append("price", getPrice())
            .append("count", getCount())
            .toString();
    }
}
