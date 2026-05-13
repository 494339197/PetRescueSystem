package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("supply_flow")
public class SupplyFlow {
    
    @TableId(value = "flow_id", type = IdType.AUTO)
    private Long flowId;
    
    @TableField("supply_id")
    private Long supplyId;
    
    @TableField("change_type")
    private Integer changeType;
    
    @TableField("quantity")
    private Integer quantity;
    
    @TableField("reason")
    private String reason;
    
    @TableField("related_donation_id")
    private Long relatedDonationId;
    
    @TableField("operator_user_id")
    private Long operatorUserId;
    
    @TableField("created_at")
    private LocalDateTime createdAt;
}