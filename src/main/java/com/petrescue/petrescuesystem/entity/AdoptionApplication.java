package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("adoption_application")
public class AdoptionApplication {
    
    @TableId(value = "application_id", type = IdType.AUTO)
    private Long applicationId;
    
    @TableField("animal_id")
    private Long animalId;
    
    @TableField("applicant_user_id")
    private Long applicantUserId;
    
    @TableField("applicant_name")
    private String applicantName;
    
    @TableField("id_card")
    private String idCard;
    
    @TableField("phone")
    private String phone;
    
    @TableField("address")
    private String address;
    
    @TableField("housing_type")
    private Integer housingType;
    
    @TableField("has_fenced_yard")
    private Integer hasFencedYard;
    
    @TableField("family_agree")
    private Integer familyAgree;
    
    @TableField("pet_experience")
    private String petExperience;
    
    @TableField("status")
    private Integer status;
    
    @TableField("reviewed_by")
    private Long reviewedBy;
    
    @TableField("review_notes")
    private String reviewNotes;
    
    @TableField("applied_at")
    private LocalDateTime appliedAt;
    
    @TableField("updated_at")
    private LocalDateTime updatedAt;
}