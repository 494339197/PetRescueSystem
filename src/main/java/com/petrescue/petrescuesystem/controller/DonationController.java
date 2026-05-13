package com.petrescue.petrescuesystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.common.Result;
import com.petrescue.petrescuesystem.entity.DonationRecord;
import com.petrescue.petrescuesystem.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/donation")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @GetMapping("/{donationId}")
    public Result<DonationRecord> getById(@PathVariable Long donationId) {
        return Result.success(donationService.getById(donationId));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody DonationRecord donationRecord) {
        return Result.success(donationService.save(donationRecord));
    }

    @PutMapping
    public Result<Boolean> updateById(@RequestBody DonationRecord donationRecord) {
        return Result.success(donationService.updateById(donationRecord));
    }

    @DeleteMapping("/{donationId}")
    public Result<Boolean> removeById(@PathVariable Long donationId) {
        return Result.success(donationService.removeById(donationId));
    }

    @GetMapping("/user/{userId}")
    public Result<List<DonationRecord>> selectByUserId(@PathVariable Long userId) {
        return Result.success(donationService.selectByUserId(userId));
    }

    @GetMapping("/type/{donationType}")
    public Result<List<DonationRecord>> selectByDonationType(@PathVariable Integer donationType) {
        return Result.success(donationService.selectByDonationType(donationType));
    }

    @GetMapping("/page")
    public Result<IPage<DonationRecord>> selectDonationPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                                            @RequestParam(defaultValue = "10") Integer pageSize,
                                                            @RequestParam(required = false) Long userId,
                                                            @RequestParam(required = false) Integer donationType,
                                                            @RequestParam(required = false) LocalDateTime startDate,
                                                            @RequestParam(required = false) LocalDateTime endDate) {
        Page<DonationRecord> page = new Page<>(pageNum, pageSize);
        return Result.success(donationService.selectDonationPage(page, userId, donationType, startDate, endDate));
    }

    @GetMapping("/date-range")
    public Result<List<DonationRecord>> selectByDonationDateRange(@RequestParam LocalDateTime startDate,
                                                                   @RequestParam LocalDateTime endDate) {
        return Result.success(donationService.selectByDonationDateRange(startDate, endDate));
    }

    @GetMapping("/sum/user/{userId}")
    public Result<BigDecimal> sumAmountByUserId(@PathVariable Long userId) {
        return Result.success(donationService.sumAmountByUserId(userId));
    }

    @GetMapping("/sum/date-range")
    public Result<BigDecimal> sumAmountByDateRange(@RequestParam LocalDateTime startDate,
                                                   @RequestParam LocalDateTime endDate) {
        return Result.success(donationService.sumAmountByDateRange(startDate, endDate));
    }

    @GetMapping("/count/{userId}")
    public Result<Integer> countDonations(@PathVariable Long userId) {
        return Result.success(donationService.countDonations(userId));
    }

    @GetMapping("/recent")
    public Result<List<DonationRecord>> selectRecentDonations(@RequestParam(defaultValue = "10") Integer limit) {
        return Result.success(donationService.selectRecentDonations(limit));
    }

    @GetMapping("/large")
    public Result<List<DonationRecord>> selectLargeDonations(@RequestParam BigDecimal minAmount) {
        return Result.success(donationService.selectLargeDonations(minAmount));
    }

    @PutMapping("/tracking-number")
    public Result<Boolean> updateTrackingNumber(@RequestParam Long donationId, @RequestParam String trackingNumber) {
        return Result.success(donationService.updateTrackingNumber(donationId, trackingNumber));
    }

    @GetMapping("/anonymous")
    public Result<List<DonationRecord>> selectAnonymousDonations() {
        return Result.success(donationService.selectAnonymousDonations());
    }
}