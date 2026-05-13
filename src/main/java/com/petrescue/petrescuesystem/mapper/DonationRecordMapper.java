package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.DonationRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DonationRecordMapper extends BaseMapper<DonationRecord> {

    List<DonationRecord> selectByUserId(@Param("userId") Long userId);

    List<DonationRecord> selectByDonationType(@Param("donationType") Integer donationType);

    IPage<DonationRecord> selectDonationPage(
            Page<DonationRecord> page,
            @Param("userId") Long userId,
            @Param("donationType") Integer donationType,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

    List<DonationRecord> selectByDonationDateRange(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

    BigDecimal sumAmountByUserId(@Param("userId") Long userId);

    BigDecimal sumAmountByDateRange(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

    List<DonationTypeSum> sumAmountByDonationType();

    Integer countDonations(@Param("userId") Long userId);

    List<DonationRecord> selectRecentDonations(@Param("limit") Integer limit);

    List<DonationRecord> selectLargeDonations(@Param("minAmount") BigDecimal minAmount);

    Integer updateTrackingNumber(
            @Param("donationId") Long donationId,
            @Param("trackingNumber") String trackingNumber
    );

    List<DonationRecord> selectAnonymousDonations();

    class DonationTypeSum {
        private Integer donationType;
        private BigDecimal totalAmount;

        public DonationTypeSum() {}

        public DonationTypeSum(Integer donationType, BigDecimal totalAmount) {
            this.donationType = donationType;
            this.totalAmount = totalAmount;
        }

        public Integer getDonationType() { return donationType; }
        public void setDonationType(Integer donationType) { this.donationType = donationType; }
        public BigDecimal getTotalAmount() { return totalAmount; }
        public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    }
}