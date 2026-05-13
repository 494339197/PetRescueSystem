package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("animal")
public class Animal {
    
    @TableId(value = "animal_id", type = IdType.AUTO)
    private Long animalId;
    
    @TableField("chip_number")
    private String chipNumber;
    
    @TableField("name")
    private String name;
    
    @TableField("species")
    private Integer species;
    
    @TableField("breed")
    private String breed;
    
    @TableField("gender")
    private Integer gender;
    
    @TableField("age")
    private String age;
    
    @TableField("weight")
    private BigDecimal weight;
    
    @TableField("size")
    private Integer size;
    
    @TableField("sterilized")
    private Integer sterilized;
    
    @TableField("vaccinated")
    private Integer vaccinated;
    
    @TableField("health_status")
    private String healthStatus;
    
    @TableField("personality")
    private String personality;
    
    @TableField("rescue_story")
    private String rescueStory;
    
    @TableField("shelter_id")
    private Long shelterId;
    
    @TableField("rescue_date")
    private LocalDate rescueDate;
    
    @TableField("adoption_status")
    private Integer adoptionStatus;
    
    @TableField("created_by")
    private Long createdBy;
    
    @TableField("created_at")
    private LocalDateTime createdAt;
    
    @TableField("updated_at")
    private LocalDateTime updatedAt;
}