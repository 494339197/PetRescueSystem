package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("supply_inventory")
public class SupplyInventory {
    
    @TableId(value = "supply_id", type = IdType.AUTO)
    private Long supplyId;
    
    @TableField("shelter_id")
    private Long shelterId;
    
    @TableField("item_name")
    private String itemName;
    
    @TableField("category")
    private Integer category;
    
    @TableField("quantity")
    private Integer quantity;
    
    @TableField("unit")
    private String unit;
    
    @TableField("min_threshold")
    private Integer minThreshold;
    
    @TableField("last_updated")
    private LocalDateTime lastUpdated;
}