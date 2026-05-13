package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("home_visit")
public class HomeVisit {
    
    @TableId(value = "visit_id", type = IdType.AUTO)
    private Long visitId;
    
    @TableField("application_id")
    private Long applicationId;
    
    @TableField("visitor_user_id")
    private Long visitorUserId;
    
    @TableField("visit_date")
    private LocalDateTime visitDate;
    
    @TableField("environment_score")
    private Integer environmentScore;
    
    @TableField("impression")
    private String impression;
    
    @TableField("photos")
    private String photos;
    
    @TableField("passed")
    private Integer passed;
    
    @TableField("notes")
    private String notes;
}