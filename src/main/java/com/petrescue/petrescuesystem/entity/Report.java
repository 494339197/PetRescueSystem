package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("report")
public class Report {
    
    @TableId(value = "report_id", type = IdType.AUTO)
    private Long reportId;
    
    @TableField("user_id")
    private Long userId;
    
    @TableField("target_type")
    private Integer targetType;
    
    @TableField("target_id")
    private Long targetId;
    
    @TableField("reason")
    private String reason;
    
    @TableField("detail")
    private String detail;
    
    @TableField("status")
    private Integer status;
    
    @TableField("handler_user_id")
    private Long handlerUserId;
    
    @TableField("handle_notes")
    private String handleNotes;
    
    @TableField("handled_at")
    private LocalDateTime handledAt;
    
    @TableField("created_at")
    private LocalDateTime createdAt;
}