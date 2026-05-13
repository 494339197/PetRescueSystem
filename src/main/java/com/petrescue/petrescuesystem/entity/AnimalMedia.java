package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("animal_media")
public class AnimalMedia {
    
    @TableId(value = "media_id", type = IdType.AUTO)
    private Long mediaId;
    
    @TableField("animal_id")
    private Long animalId;
    
    @TableField("url")
    private String url;
    
    @TableField("uploaded_at")
    private LocalDateTime uploadedAt;
}