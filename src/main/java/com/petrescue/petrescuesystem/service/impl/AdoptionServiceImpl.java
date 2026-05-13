package com.petrescue.petrescuesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.AdoptionApplication;
import com.petrescue.petrescuesystem.mapper.AdoptionApplicationMapper;
import com.petrescue.petrescuesystem.service.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdoptionServiceImpl implements AdoptionService {

    @Autowired
    private AdoptionApplicationMapper adoptionApplicationMapper;

    @Override
    public AdoptionApplication getById(Long applicationId) {
        return adoptionApplicationMapper.selectById(applicationId);
    }

    @Override
    public boolean save(AdoptionApplication application) {
        return adoptionApplicationMapper.insert(application) > 0;
    }

    @Override
    public boolean updateById(AdoptionApplication application) {
        return adoptionApplicationMapper.updateById(application) > 0;
    }

    @Override
    public boolean removeById(Long applicationId) {
        return adoptionApplicationMapper.deleteById(applicationId) > 0;
    }

    @Override
    public List<AdoptionApplication> selectByAnimalId(Long animalId) {
        return adoptionApplicationMapper.selectByAnimalId(animalId);
    }

    @Override
    public List<AdoptionApplication> selectByApplicantUserId(Long applicantUserId) {
        return adoptionApplicationMapper.selectByApplicantUserId(applicantUserId);
    }

    @Override
    public List<AdoptionApplication> selectByStatus(Integer status) {
        return adoptionApplicationMapper.selectByStatus(status);
    }

    @Override
    public IPage<AdoptionApplication> selectApplicationPage(Page<AdoptionApplication> page, Long animalId, Long applicantUserId, Integer status) {
        return adoptionApplicationMapper.selectApplicationPage(page, animalId, applicantUserId, status);
    }

    @Override
    public Integer countByAnimalId(Long animalId) {
        return adoptionApplicationMapper.countByAnimalId(animalId);
    }

    @Override
    public Integer countByApplicantUserId(Long applicantUserId) {
        return adoptionApplicationMapper.countByApplicantUserId(applicantUserId);
    }

    @Override
    public boolean updateStatus(Long applicationId, Integer status, Long reviewedBy, String reviewNotes) {
        return adoptionApplicationMapper.updateStatus(applicationId, status, reviewedBy, reviewNotes) > 0;
    }

    @Override
    public List<AdoptionApplication> selectPendingApplicationsByAnimalId(Long animalId) {
        return adoptionApplicationMapper.selectPendingApplicationsByAnimalId(animalId);
    }

    @Override
    public List<AdoptionApplication> selectRecentApplicationsByUser(Long applicantUserId, Integer limit) {
        return adoptionApplicationMapper.selectRecentApplicationsByUser(applicantUserId, limit);
    }
}