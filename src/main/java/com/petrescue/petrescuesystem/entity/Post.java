package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("post")
public class Post {
    
    @TableId(value = "post_id", type = IdType.AUTO)
    private Long postId;
    
    @TableField("user_id")
    private Long userId;
    
    @TableField("title")
    private String title;
    
    @TableField("content")
    private String content;
    
    @TableField("view_count")
    private Integer viewCount;
    
    @TableField("like_count")
    private Integer likeCount;
    
    @TableField("comment_count")
    private Integer commentCount;
    
    @TableField("status")
    private Integer status;
    
    @TableField("created_at")
    private LocalDateTime createdAt;
    
    @TableField("updated_at")
    private LocalDateTime updatedAt;
}