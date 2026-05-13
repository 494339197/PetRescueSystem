package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("donation_record")
public class DonationRecord {
    
    @TableId(value = "donation_id", type = IdType.AUTO)
    private Long donationId;
    
    @TableField("user_id")
    private Long userId;
    
    @TableField("donor_name")
    private String donorName;
    
    @TableField("donor_phone")
    private String donorPhone;
    
    @TableField("donation_type")
    private Integer donationType;
    
    @TableField("amount")
    private BigDecimal amount;
    
    @TableField("goods_name")
    private String goodsName;
    
    @TableField("goods_quantity")
    private String goodsQuantity;
    
    @TableField("tracking_number")
    private String trackingNumber;
    
    @TableField("payment_method")
    private Integer paymentMethod;
    
    @TableField("is_anonymous")
    private Integer isAnonymous;
    
    @TableField("message")
    private String message;
    
    @TableField("donated_at")
    private LocalDateTime donatedAt;
}