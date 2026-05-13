package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("volunteer_task_record")
public class VolunteerTaskRecord {
    
    @TableId(value = "record_id", type = IdType.AUTO)
    private Long recordId;
    
    @TableField("task_id")
    private Long taskId;
    
    @TableField("user_id")
    private Long userId;
    
    @TableField("signup_time")
    private LocalDateTime signupTime;
    
    @TableField("status")
    private Integer status;
    
    @TableField("check_in_time")
    private LocalDateTime checkInTime;
    
    @TableField("check_out_time")
    private LocalDateTime checkOutTime;
    
    @TableField("hours")
    private BigDecimal hours;
    
    @TableField("feedback")
    private String feedback;
}