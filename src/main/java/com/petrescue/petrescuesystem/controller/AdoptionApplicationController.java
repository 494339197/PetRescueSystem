package com.petrescue.petrescuesystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.common.Result;
import com.petrescue.petrescuesystem.entity.AdoptionApplication;
import com.petrescue.petrescuesystem.service.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adoption/application")
public class AdoptionApplicationController {

    @Autowired
    private AdoptionService adoptionService;

    @GetMapping("/{applicationId}")
    public Result<AdoptionApplication> getById(@PathVariable Long applicationId) {
        return Result.success(adoptionService.getById(applicationId));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody AdoptionApplication application) {
        return Result.success(adoptionService.save(application));
    }

    @PutMapping
    public Result<Boolean> updateById(@RequestBody AdoptionApplication application) {
        return Result.success(adoptionService.updateById(application));
    }

    @DeleteMapping("/{applicationId}")
    public Result<Boolean> removeById(@PathVariable Long applicationId) {
        return Result.success(adoptionService.removeById(applicationId));
    }

    @GetMapping("/animal/{animalId}")
    public Result<List<AdoptionApplication>> selectByAnimalId(@PathVariable Long animalId) {
        return Result.success(adoptionService.selectByAnimalId(animalId));
    }

    @GetMapping("/applicant/{applicantUserId}")
    public Result<List<AdoptionApplication>> selectByApplicantUserId(@PathVariable Long applicantUserId) {
        return Result.success(adoptionService.selectByApplicantUserId(applicantUserId));
    }

    @GetMapping("/status/{status}")
    public Result<List<AdoptionApplication>> selectByStatus(@PathVariable Integer status) {
        return Result.success(adoptionService.selectByStatus(status));
    }

    @GetMapping("/page")
    public Result<IPage<AdoptionApplication>> selectApplicationPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                                                     @RequestParam(defaultValue = "10") Integer pageSize,
                                                                     @RequestParam(required = false) Long animalId,
                                                                     @RequestParam(required = false) Long applicantUserId,
                                                                     @RequestParam(required = false) Integer status) {
        Page<AdoptionApplication> page = new Page<>(pageNum, pageSize);
        return Result.success(adoptionService.selectApplicationPage(page, animalId, applicantUserId, status));
    }

    @GetMapping("/count/animal/{animalId}")
    public Result<Integer> countByAnimalId(@PathVariable Long animalId) {
        return Result.success(adoptionService.countByAnimalId(animalId));
    }

    @GetMapping("/count/applicant/{applicantUserId}")
    public Result<Integer> countByApplicantUserId(@PathVariable Long applicantUserId) {
        return Result.success(adoptionService.countByApplicantUserId(applicantUserId));
    }

    @PutMapping("/status")
    public Result<Boolean> updateStatus(@RequestParam Long applicationId,
                                        @RequestParam Integer status,
                                        @RequestParam(required = false) Long reviewedBy,
                                        @RequestParam(required = false) String reviewNotes) {
        return Result.success(adoptionService.updateStatus(applicationId, status, reviewedBy, reviewNotes));
    }

    @GetMapping("/pending/animal/{animalId}")
    public Result<List<AdoptionApplication>> selectPendingApplicationsByAnimalId(@PathVariable Long animalId) {
        return Result.success(adoptionService.selectPendingApplicationsByAnimalId(animalId));
    }

    @GetMapping("/recent/user/{applicantUserId}")
    public Result<List<AdoptionApplication>> selectRecentApplicationsByUser(@PathVariable Long applicantUserId,
                                                                             @RequestParam(defaultValue = "5") Integer limit) {
        return Result.success(adoptionService.selectRecentApplicationsByUser(applicantUserId, limit));
    }
}