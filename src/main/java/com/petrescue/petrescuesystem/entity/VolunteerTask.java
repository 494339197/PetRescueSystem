package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("volunteer_task")
public class VolunteerTask {
    
    @TableId(value = "task_id", type = IdType.AUTO)
    private Long taskId;
    
    @TableField("shelter_id")
    private Long shelterId;
    
    @TableField("title")
    private String title;
    
    @TableField("description")
    private String description;
    
    @TableField("task_type")
    private Integer taskType;
    
    @TableField("required_count")
    private Integer requiredCount;
    
    @TableField("current_count")
    private Integer currentCount;
    
    @TableField("start_time")
    private LocalDateTime startTime;
    
    @TableField("end_time")
    private LocalDateTime endTime;
    
    @TableField("location")
    private String location;
    
    @TableField("status")
    private Integer status;
    
    @TableField("created_by")
    private Long createdBy;
    
    @TableField("created_at")
    private LocalDateTime createdAt;
}