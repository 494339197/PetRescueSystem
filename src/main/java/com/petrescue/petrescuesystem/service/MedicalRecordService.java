package com.petrescue.petrescuesystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.MedicalRecord;
import java.time.LocalDate;
import java.util.List;

public interface MedicalRecordService {

    MedicalRecord getById(Long recordId);

    boolean save(MedicalRecord medicalRecord);

    boolean updateById(MedicalRecord medicalRecord);

    boolean removeById(Long recordId);

    List<MedicalRecord> selectByAnimalId(Long animalId);

    IPage<MedicalRecord> selectMedicalRecordPage(Page<MedicalRecord> page, Long animalId, LocalDate startDate, LocalDate endDate);

    List<MedicalRecord> selectByVisitDateRange(LocalDate startDate, LocalDate endDate);

    List<MedicalRecord> selectRecentByAnimalId(Long animalId, Integer limit);

    Integer countByAnimalId(Long animalId);

    List<MedicalRecord> selectNeedFollowUp();

    List<MedicalRecord> selectByHospitalName(String hospitalName);

    List<MedicalRecord> selectByVetName(String vetName);

    List<MedicalRecord> searchByDiagnosis(String keyword);

    List<MedicalRecord> searchByTreatment(String keyword);

    boolean updateNextVisit(Long recordId, LocalDate nextVisit);
}