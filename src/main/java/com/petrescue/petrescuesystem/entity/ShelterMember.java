package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@TableName("shelter_member")
public class ShelterMember {
    
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    
    @TableField("shelter_id")
    private Long shelterId;
    
    @TableField("user_id")
    private Long userId;
    
    @TableField("role")
    private Integer role;
    
    @TableField("join_date")
    private LocalDate joinDate;
    
    @TableField("status")
    private Integer status;
}