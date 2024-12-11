package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 会员等级对象 db_vip_item
 * 
 * @author ruoyi
 * @date 2024-12-06
 */
public class VipItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 会员商品ID */
    private Long id;

    /** 会员等级名称 */
    @Excel(name = "会员等级名称")
    private String title;

    /** 会员价格 */
    @Excel(name = "会员价格")
    private Double price;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setPrice(Double price) 
    {
        this.price = price;
    }

    public Double getPrice() 
    {
        return price;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("price", getPrice())
            .toString();
    }
}
