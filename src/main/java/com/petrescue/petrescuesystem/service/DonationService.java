package com.petrescue.petrescuesystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.DonationRecord;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface DonationService {

    DonationRecord getById(Long donationId);

    boolean save(DonationRecord donationRecord);

    boolean updateById(DonationRecord donationRecord);

    boolean removeById(Long donationId);

    List<DonationRecord> selectByUserId(Long userId);

    List<DonationRecord> selectByDonationType(Integer donationType);

    IPage<DonationRecord> selectDonationPage(Page<DonationRecord> page, Long userId, Integer donationType, LocalDateTime startDate, LocalDateTime endDate);

    List<DonationRecord> selectByDonationDateRange(LocalDateTime startDate, LocalDateTime endDate);

    BigDecimal sumAmountByUserId(Long userId);

    BigDecimal sumAmountByDateRange(LocalDateTime startDate, LocalDateTime endDate);

    Integer countDonations(Long userId);

    List<DonationRecord> selectRecentDonations(Integer limit);

    List<DonationRecord> selectLargeDonations(BigDecimal minAmount);

    boolean updateTrackingNumber(Long donationId, String trackingNumber);

    List<DonationRecord> selectAnonymousDonations();
}