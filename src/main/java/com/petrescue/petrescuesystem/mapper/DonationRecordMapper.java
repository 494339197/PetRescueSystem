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
    
    /**
     * 根据用户ID查询捐赠记录
     * @param userId 用户ID
     * @return 捐赠记录列表
     */
    List<DonationRecord> selectByUserId(@Param("userId") Long userId);
    
    /**
     * 根据捐赠类型查询捐赠记录
     * @param donationType 捐赠类型
     * @return 捐赠记录列表
     */
    List<DonationRecord> selectByDonationType(@Param("donationType") Integer donationType);
    
    /**
     * 分页查询捐赠记录
     * @param page 分页参数
     * @param userId 用户ID（可选）
     * @param donationType 捐赠类型（可选）
     * @param startDate 开始日期（可选）
     * @param endDate 结束日期（可选）
     * @return 分页结果
     */
    IPage<DonationRecord> selectDonationPage(
            Page<DonationRecord> page,
            @Param("userId") Long userId,
            @Param("donationType") Integer donationType,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );
    
    /**
     * 查询指定日期范围内的捐赠记录
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 捐赠记录列表
     */
    List<DonationRecord> selectByDonationDateRange(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );
    
    /**
     * 统计用户捐赠总额
     * @param userId 用户ID
     * @return 捐赠总额
     */
    BigDecimal sumAmountByUserId(@Param("userId") Long userId);
    
    /**
     * 统计指定日期范围内的捐赠总额
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 捐赠总额
     */
    BigDecimal sumAmountByDateRange(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );
    
    /**
     * 统计各捐赠类型的捐赠总额
     * @return 各类型捐赠总额统计
     */
    List<DonationTypeSum> sumAmountByDonationType();
    
    /**
     * 统计捐赠记录数量
     * @param userId 用户ID（可选）
     * @return 捐赠记录数量
     */
    Integer countDonations(@Param("userId") Long userId);
    
    /**
     * 查询最近捐赠记录
     * @param limit 限制数量
     * @return 最近捐赠记录列表
     */
    List<DonationRecord> selectRecentDonations(@Param("limit") Integer limit);
    
    /**
     * 查询大额捐赠记录（超过指定金额）
     * @param minAmount 最小金额
     * @return 大额捐赠记录列表
     */
    List<DonationRecord> selectLargeDonations(@Param("minAmount") BigDecimal minAmount);
    
    /**
     * 更新捐赠记录状态
     * @param donationId 捐赠ID
     * @param trackingNumber 物流单号
     * @return 影响行数
     */
    Integer updateTrackingNumber(
            @Param("donationId") Long donationId,
            @Param("trackingNumber") String trackingNumber
    );
    
    /**
     * 查询匿名捐赠记录
     * @return 匿名捐赠记录列表
     */
    List<DonationRecord> selectAnonymousDonations();
    
    /**
     * 捐赠类型统计结果类
     */
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