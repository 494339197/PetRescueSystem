package com.petrescue.petrescuesystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@TableName("adoption_contract")
public class AdoptionContract {
    
    @TableId(value = "contract_id", type = IdType.AUTO)
    private Long contractId;
    
    @TableField("application_id")
    private Long applicationId;
    
    @TableField("contract_no")
    private String contractNo;
    
    @TableField("sign_date")
    private LocalDate signDate;
    
    @TableField("adopter_sign_url")
    private String adopterSignUrl;
    
    @TableField("shelter_sign_url")
    private String shelterSignUrl;
    
    @TableField("file_url")
    private String fileUrl;
    
    @TableField("trial_period_days")
    private Integer trialPeriodDays;
    
    @TableField("trial_end_date")
    private LocalDate trialEndDate;
}