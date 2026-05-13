package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("user")
public class User {
    
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;
    
    @TableField("username")
    private String username;
    
    @TableField("password_hash")
    private String passwordHash;
    
    @TableField("real_name")
    private String realName;
    
    @TableField("phone")
    private String phone;
    
    @TableField("email")
    private String email;
    
    @TableField("avatar_url")
    private String avatarUrl;
    
    @TableField("gender")
    private Integer gender;
    
    @TableField("address")
    private String address;
    
    @TableField("user_type")
    private Integer userType;
    
    @TableField("status")
    private Integer status;
    
    @TableField("created_at")
    private LocalDateTime createdAt;
    
    @TableField("updated_at")
    private LocalDateTime updatedAt;
}