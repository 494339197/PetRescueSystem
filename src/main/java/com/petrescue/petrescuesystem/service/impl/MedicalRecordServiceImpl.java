package com.petrescue.petrescuesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.MedicalRecord;
import com.petrescue.petrescuesystem.mapper.MedicalRecordMapper;
import com.petrescue.petrescuesystem.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    @Autowired
    private MedicalRecordMapper medicalRecordMapper;

    @Override
    public MedicalRecord getById(Long recordId) {
        return medicalRecordMapper.selectById(recordId);
    }

    @Override
    public boolean save(MedicalRecord medicalRecord) {
        return medicalRecordMapper.insert(medicalRecord) > 0;
    }

    @Override
    public boolean updateById(MedicalRecord medicalRecord) {
        return medicalRecordMapper.updateById(medicalRecord) > 0;
    }

    @Override
    public boolean removeById(Long recordId) {
        return medicalRecordMapper.deleteById(recordId) > 0;
    }

    @Override
    public List<MedicalRecord> selectByAnimalId(Long animalId) {
        return medicalRecordMapper.selectByAnimalId(animalId);
    }

    @Override
    public IPage<MedicalRecord> selectMedicalRecordPage(Page<MedicalRecord> page, Long animalId, LocalDate startDate, LocalDate endDate) {
        return medicalRecordMapper.selectMedicalRecordPage(page, animalId, startDate, endDate);
    }

    @Override
    public List<MedicalRecord> selectByVisitDateRange(LocalDate startDate, LocalDate endDate) {
        return medicalRecordMapper.selectByVisitDateRange(startDate, endDate);
    }

    @Override
    public List<MedicalRecord> selectRecentByAnimalId(Long animalId, Integer limit) {
        return medicalRecordMapper.selectRecentByAnimalId(animalId, limit);
    }

    @Override
    public Integer countByAnimalId(Long animalId) {
        return medicalRecordMapper.countByAnimalId(animalId);
    }

    @Override
    public List<MedicalRecord> selectNeedFollowUp() {
        return medicalRecordMapper.selectNeedFollowUp();
    }

    @Override
    public List<MedicalRecord> selectByHospitalName(String hospitalName) {
        return medicalRecordMapper.selectByHospitalName(hospitalName);
    }

    @Override
    public List<MedicalRecord> selectByVetName(String vetName) {
        return medicalRecordMapper.selectByVetName(vetName);
    }

    @Override
    public List<MedicalRecord> searchByDiagnosis(String keyword) {
        return medicalRecordMapper.searchByDiagnosis(keyword);
    }

    @Override
    public List<MedicalRecord> searchByTreatment(String keyword) {
        return medicalRecordMapper.searchByTreatment(keyword);
    }

    @Override
    public boolean updateNextVisit(Long recordId, LocalDate nextVisit) {
        return medicalRecordMapper.updateNextVisit(recordId, nextVisit) > 0;
    }
}