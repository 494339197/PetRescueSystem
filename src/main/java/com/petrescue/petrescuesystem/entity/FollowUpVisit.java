package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@TableName("follow_up_visit")
public class FollowUpVisit {
    
    @TableId(value = "followup_id", type = IdType.AUTO)
    private Long followupId;
    
    @TableField("contract_id")
    private Long contractId;
    
    @TableField("visitor_user_id")
    private Long visitorUserId;
    
    @TableField("visit_date")
    private LocalDate visitDate;
    
    @TableField("photos")
    private String photos;
    
    @TableField("satisfaction")
    private Integer satisfaction;
    
    @TableField("notes")
    private String notes;
}