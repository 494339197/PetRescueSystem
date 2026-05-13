package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@TableName("vaccination_record")
public class VaccinationRecord {
    
    @TableId(value = "record_id", type = IdType.AUTO)
    private Long recordId;
    
    @TableField("animal_id")
    private Long animalId;
    
    @TableField("vaccine_type")
    private String vaccineType;
    
    @TableField("admin_date")
    private LocalDate adminDate;
    
    @TableField("next_due_date")
    private LocalDate nextDueDate;
    
    @TableField("vet_name")
    private String vetName;
    
    @TableField("clinic")
    private String clinic;
    
    @TableField("notes")
    private String notes;
}