package com.petrescue.petrescuesystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.common.Result;
import com.petrescue.petrescuesystem.entity.MedicalRecord;
import com.petrescue.petrescuesystem.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/medical-record")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping("/{recordId}")
    public Result<MedicalRecord> getById(@PathVariable Long recordId) {
        return Result.success(medicalRecordService.getById(recordId));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody MedicalRecord medicalRecord) {
        return Result.success(medicalRecordService.save(medicalRecord));
    }

    @PutMapping
    public Result<Boolean> updateById(@RequestBody MedicalRecord medicalRecord) {
        return Result.success(medicalRecordService.updateById(medicalRecord));
    }

    @DeleteMapping("/{recordId}")
    public Result<Boolean> removeById(@PathVariable Long recordId) {
        return Result.success(medicalRecordService.removeById(recordId));
    }

    @GetMapping("/animal/{animalId}")
    public Result<List<MedicalRecord>> selectByAnimalId(@PathVariable Long animalId) {
        return Result.success(medicalRecordService.selectByAnimalId(animalId));
    }

    @GetMapping("/page")
    public Result<IPage<MedicalRecord>> selectMedicalRecordPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                                                @RequestParam(defaultValue = "10") Integer pageSize,
                                                                @RequestParam(required = false) Long animalId,
                                                                @RequestParam(required = false) LocalDate startDate,
                                                                @RequestParam(required = false) LocalDate endDate) {
        Page<MedicalRecord> page = new Page<>(pageNum, pageSize);
        return Result.success(medicalRecordService.selectMedicalRecordPage(page, animalId, startDate, endDate));
    }

    @GetMapping("/date-range")
    public Result<List<MedicalRecord>> selectByVisitDateRange(@RequestParam LocalDate startDate,
                                                               @RequestParam LocalDate endDate) {
        return Result.success(medicalRecordService.selectByVisitDateRange(startDate, endDate));
    }

    @GetMapping("/recent/animal/{animalId}")
    public Result<List<MedicalRecord>> selectRecentByAnimalId(@PathVariable Long animalId,
                                                               @RequestParam(defaultValue = "5") Integer limit) {
        return Result.success(medicalRecordService.selectRecentByAnimalId(animalId, limit));
    }

    @GetMapping("/count/animal/{animalId}")
    public Result<Integer> countByAnimalId(@PathVariable Long animalId) {
        return Result.success(medicalRecordService.countByAnimalId(animalId));
    }

    @GetMapping("/need-follow-up")
    public Result<List<MedicalRecord>> selectNeedFollowUp() {
        return Result.success(medicalRecordService.selectNeedFollowUp());
    }

    @GetMapping("/hospital")
    public Result<List<MedicalRecord>> selectByHospitalName(@RequestParam String hospitalName) {
        return Result.success(medicalRecordService.selectByHospitalName(hospitalName));
    }

    @GetMapping("/vet")
    public Result<List<MedicalRecord>> selectByVetName(@RequestParam String vetName) {
        return Result.success(medicalRecordService.selectByVetName(vetName));
    }

    @GetMapping("/search/diagnosis")
    public Result<List<MedicalRecord>> searchByDiagnosis(@RequestParam String keyword) {
        return Result.success(medicalRecordService.searchByDiagnosis(keyword));
    }

    @GetMapping("/search/treatment")
    public Result<List<MedicalRecord>> searchByTreatment(@RequestParam String keyword) {
        return Result.success(medicalRecordService.searchByTreatment(keyword));
    }

    @PutMapping("/next-visit")
    public Result<Boolean> updateNextVisit(@RequestParam Long recordId, @RequestParam LocalDate nextVisit) {
        return Result.success(medicalRecordService.updateNextVisit(recordId, nextVisit));
    }
}