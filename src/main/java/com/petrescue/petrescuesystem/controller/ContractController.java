package com.petrescue.petrescuesystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.common.Result;
import com.petrescue.petrescuesystem.entity.AdoptionContract;
import com.petrescue.petrescuesystem.mapper.AdoptionContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/adoption/contract")
public class ContractController {

    @Autowired
    private AdoptionContractMapper adoptionContractMapper;

    @GetMapping("/{contractId}")
    public Result<AdoptionContract> getById(@PathVariable Long contractId) {
        return Result.success(adoptionContractMapper.selectById(contractId));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody AdoptionContract contract) {
        return Result.success(adoptionContractMapper.insert(contract) > 0);
    }

    @PutMapping
    public Result<Boolean> updateById(@RequestBody AdoptionContract contract) {
        return Result.success(adoptionContractMapper.updateById(contract) > 0);
    }

    @DeleteMapping("/{contractId}")
    public Result<Boolean> removeById(@PathVariable Long contractId) {
        return Result.success(adoptionContractMapper.deleteById(contractId) > 0);
    }

    @GetMapping("/application/{applicationId}")
    public Result<AdoptionContract> selectByApplicationId(@PathVariable Long applicationId) {
        return Result.success(adoptionContractMapper.selectByApplicationId(applicationId));
    }

    @GetMapping("/contract-no/{contractNo}")
    public Result<AdoptionContract> selectByContractNo(@PathVariable String contractNo) {
        return Result.success(adoptionContractMapper.selectByContractNo(contractNo));
    }

    @GetMapping("/page")
    public Result<IPage<AdoptionContract>> selectContractPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                                               @RequestParam(defaultValue = "10") Integer pageSize,
                                                               @RequestParam(required = false) String contractNo,
                                                               @RequestParam(required = false) LocalDate startDate,
                                                               @RequestParam(required = false) LocalDate endDate) {
        Page<AdoptionContract> page = new Page<>(pageNum, pageSize);
        return Result.success(adoptionContractMapper.selectContractPage(page, contractNo, startDate, endDate));
    }

    @GetMapping("/date-range")
    public Result<List<AdoptionContract>> selectBySignDateRange(@RequestParam LocalDate startDate,
                                                                 @RequestParam LocalDate endDate) {
        return Result.success(adoptionContractMapper.selectBySignDateRange(startDate, endDate));
    }

    @GetMapping("/trial-ending")
    public Result<List<AdoptionContract>> selectTrialEndingContracts(@RequestParam(defaultValue = "7") Integer days) {
        return Result.success(adoptionContractMapper.selectTrialEndingContracts(days));
    }

    @GetMapping("/expired-trial")
    public Result<List<AdoptionContract>> selectExpiredTrialContracts() {
        return Result.success(adoptionContractMapper.selectExpiredTrialContracts());
    }

    @PutMapping("/file-url")
    public Result<Boolean> updateFileUrl(@RequestParam Long contractId, @RequestParam String fileUrl) {
        return Result.success(adoptionContractMapper.updateFileUrl(contractId, fileUrl) > 0);
    }

    @PutMapping("/adopter-sign-url")
    public Result<Boolean> updateAdopterSignUrl(@RequestParam Long contractId, @RequestParam String adopterSignUrl) {
        return Result.success(adoptionContractMapper.updateAdopterSignUrl(contractId, adopterSignUrl) > 0);
    }

    @PutMapping("/shelter-sign-url")
    public Result<Boolean> updateShelterSignUrl(@RequestParam Long contractId, @RequestParam String shelterSignUrl) {
        return Result.success(adoptionContractMapper.updateShelterSignUrl(contractId, shelterSignUrl) > 0);
    }

    @GetMapping("/count/date-range")
    public Result<Integer> countBySignDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return Result.success(adoptionContractMapper.countBySignDateRange(startDate, endDate));
    }

    @GetMapping("/recent")
    public Result<List<AdoptionContract>> selectRecentContracts(@RequestParam(defaultValue = "10") Integer limit) {
        return Result.success(adoptionContractMapper.selectRecentContracts(limit));
    }
}