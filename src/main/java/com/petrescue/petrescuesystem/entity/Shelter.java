package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("shelter")
public class Shelter {
    
    @TableId(value = "shelter_id", type = IdType.AUTO)
    private Long shelterId;
    
    @TableField("name")
    private String name;
    
    @TableField("logo_url")
    private String logoUrl;
    
    @TableField("province")
    private String province;
    
    @TableField("city")
    private String city;
    
    @TableField("district")
    private String district;
    
    @TableField("detail_address")
    private String detailAddress;
    
    @TableField("contact_phone")
    private String contactPhone;
    
    @TableField("contact_person")
    private String contactPerson;
    
    @TableField("description")
    private String description;
    
    @TableField("capacity")
    private Integer capacity;
    
    @TableField("current_count")
    private Integer currentCount;
    
    @TableField("longitude")
    private BigDecimal longitude;
    
    @TableField("latitude")
    private BigDecimal latitude;
    
    @TableField("status")
    private Integer status;
    
    @TableField("created_at")
    private LocalDateTime createdAt;
}