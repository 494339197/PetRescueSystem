package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("report_audit_log")
public class ReportAuditLog {
    
    @TableId(value = "log_id", type = IdType.AUTO)
    private Long logId;
    
    @TableField("report_id")
    private Long reportId;
    
    @TableField("operator_user_id")
    private Long operatorUserId;
    
    @TableField("action")
    private Integer action;
    
    @TableField("notes")
    private String notes;
    
    @TableField("created_at")
    private LocalDateTime createdAt;
}