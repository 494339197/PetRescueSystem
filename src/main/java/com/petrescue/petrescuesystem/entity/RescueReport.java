package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("rescue_report")
public class RescueReport {
    
    @TableId(value = "report_id", type = IdType.AUTO)
    private Long reportId;
    
    @TableField("animal_id")
    private Long animalId;
    
    @TableField("reporter_user_id")
    private Long reporterUserId;
    
    @TableField("reporter_name")
    private String reporterName;
    
    @TableField("reporter_phone")
    private String reporterPhone;
    
    @TableField("rescue_location")
    private String rescueLocation;
    
    @TableField("description")
    private String description;
    
    @TableField("urgent_level")
    private Integer urgentLevel;
    
    @TableField("status")
    private Integer status;
    
    @TableField("shelter_id")
    private Long shelterId;
    
    @TableField("reported_at")
    private LocalDateTime reportedAt;
    
    @TableField("handled_at")
    private LocalDateTime handledAt;
}