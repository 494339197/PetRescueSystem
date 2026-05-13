package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("comment")
public class Comment {
    
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Long commentId;
    
    @TableField("post_id")
    private Long postId;
    
    @TableField("user_id")
    private Long userId;
    
    @TableField("parent_id")
    private Long parentId;
    
    @TableField("reply_to_user_id")
    private Long replyToUserId;
    
    @TableField("content")
    private String content;
    
    @TableField("like_count")
    private Integer likeCount;
    
    @TableField("created_at")
    private LocalDateTime createdAt;
}