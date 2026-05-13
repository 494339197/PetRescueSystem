package com.petrescue.petrescuesystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.AdoptionApplication;
import java.util.List;

public interface AdoptionService {

    AdoptionApplication getById(Long applicationId);

    boolean save(AdoptionApplication application);

    boolean updateById(AdoptionApplication application);

    boolean removeById(Long applicationId);

    List<AdoptionApplication> selectByAnimalId(Long animalId);

    List<AdoptionApplication> selectByApplicantUserId(Long applicantUserId);

    List<AdoptionApplication> selectByStatus(Integer status);

    IPage<AdoptionApplication> selectApplicationPage(Page<AdoptionApplication> page, Long animalId, Long applicantUserId, Integer status);

    Integer countByAnimalId(Long animalId);

    Integer countByApplicantUserId(Long applicantUserId);

    boolean updateStatus(Long applicationId, Integer status, Long reviewedBy, String reviewNotes);

    List<AdoptionApplication> selectPendingApplicationsByAnimalId(Long animalId);

    List<AdoptionApplication> selectRecentApplicationsByUser(Long applicantUserId, Integer limit);
}