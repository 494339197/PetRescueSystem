package com.petrescue.petrescuesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.DonationRecord;
import com.petrescue.petrescuesystem.mapper.DonationRecordMapper;
import com.petrescue.petrescuesystem.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    private DonationRecordMapper donationRecordMapper;

    @Override
    public DonationRecord getById(Long donationId) {
        return donationRecordMapper.selectById(donationId);
    }

    @Override
    public boolean save(DonationRecord donationRecord) {
        return donationRecordMapper.insert(donationRecord) > 0;
    }

    @Override
    public boolean updateById(DonationRecord donationRecord) {
        return donationRecordMapper.updateById(donationRecord) > 0;
    }

    @Override
    public boolean removeById(Long donationId) {
        return donationRecordMapper.deleteById(donationId) > 0;
    }

    @Override
    public List<DonationRecord> selectByUserId(Long userId) {
        return donationRecordMapper.selectByUserId(userId);
    }

    @Override
    public List<DonationRecord> selectByDonationType(Integer donationType) {
        return donationRecordMapper.selectByDonationType(donationType);
    }

    @Override
    public IPage<DonationRecord> selectDonationPage(Page<DonationRecord> page, Long userId, Integer donationType, LocalDateTime startDate, LocalDateTime endDate) {
        return donationRecordMapper.selectDonationPage(page, userId, donationType, startDate, endDate);
    }

    @Override
    public List<DonationRecord> selectByDonationDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return donationRecordMapper.selectByDonationDateRange(startDate, endDate);
    }

    @Override
    public BigDecimal sumAmountByUserId(Long userId) {
        return donationRecordMapper.sumAmountByUserId(userId);
    }

    @Override
    public BigDecimal sumAmountByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return donationRecordMapper.sumAmountByDateRange(startDate, endDate);
    }

    @Override
    public Integer countDonations(Long userId) {
        return donationRecordMapper.countDonations(userId);
    }

    @Override
    public List<DonationRecord> selectRecentDonations(Integer limit) {
        return donationRecordMapper.selectRecentDonations(limit);
    }

    @Override
    public List<DonationRecord> selectLargeDonations(BigDecimal minAmount) {
        return donationRecordMapper.selectLargeDonations(minAmount);
    }

    @Override
    public boolean updateTrackingNumber(Long donationId, String trackingNumber) {
        return donationRecordMapper.updateTrackingNumber(donationId, trackingNumber) > 0;
    }

    @Override
    public List<DonationRecord> selectAnonymousDonations() {
        return donationRecordMapper.selectAnonymousDonations();
    }
}