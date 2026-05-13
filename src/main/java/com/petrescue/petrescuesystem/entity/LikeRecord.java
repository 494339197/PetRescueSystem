package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("like_record")
public class LikeRecord {
    
    @TableId(value = "like_id", type = IdType.AUTO)
    private Long likeId;
    
    @TableField("user_id")
    private Long userId;
    
    @TableField("target_type")
    private Integer targetType;
    
    @TableField("target_id")
    private Long targetId;
    
    @TableField("created_at")
    private LocalDateTime createdAt;
}