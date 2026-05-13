package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@TableName("medical_record")
public class MedicalRecord {
    
    @TableId(value = "record_id", type = IdType.AUTO)
    private Long recordId;
    
    @TableField("animal_id")
    private Long animalId;
    
    @TableField("visit_date")
    private LocalDate visitDate;
    
    @TableField("hospital_name")
    private String hospitalName;
    
    @TableField("vet_name")
    private String vetName;
    
    @TableField("diagnosis")
    private String diagnosis;
    
    @TableField("treatment")
    private String treatment;
    
    @TableField("medication")
    private String medication;
    
    @TableField("next_visit")
    private LocalDate nextVisit;
    
    @TableField("notes")
    private String notes;
}