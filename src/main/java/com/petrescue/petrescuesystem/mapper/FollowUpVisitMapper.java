package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.FollowUpVisit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDate;
import java.util.List;

@Mapper
public interface FollowUpVisitMapper extends BaseMapper<FollowUpVisit> {
    
    /**
     * 根据合同ID查询回访记录
     * @param contractId 合同ID
     * @return 回访记录列表
     */
    List<FollowUpVisit> selectByContractId(@Param("contractId") Long contractId);
    
    /**
     * 根据回访人ID查询回访记录
     * @param visitorUserId 回访人ID
     * @return 回访记录列表
     */
    List<FollowUpVisit> selectByVisitorUserId(@Param("visitorUserId") Long visitorUserId);
    
    /**
     * 分页查询回访记录
     * @param page 分页参数
     * @param contractId 合同ID（可选）
     * @param visitorUserId 回访人ID（可选）
     * @param startDate 开始日期（可选）
     * @param endDate 结束日期（可选）
     * @return 分页结果
     */
    IPage<FollowUpVisit> selectFollowUpVisitPage(
            Page<FollowUpVisit> page,
            @Param("contractId") Long contractId,
            @Param("visitorUserId") Long visitorUserId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
    
    /**
     * 查询指定日期范围内的回访记录
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 回访记录列表
     */
    List<FollowUpVisit> selectByVisitDateRange(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
    
    /**
     * 统计合同的回访次数
     * @param contractId 合同ID
     * @return 回访次数
     */
    Integer countByContractId(@Param("contractId") Long contractId);
    
    /**
     * 统计回访人的回访次数
     * @param visitorUserId 回访人ID
     * @return 回访次数
     */
    Integer countByVisitorUserId(@Param("visitorUserId") Long visitorUserId);
    
    /**
     * 查询最近的回访记录
     * @param limit 限制数量
     * @return 最近回访记录列表
     */
    List<FollowUpVisit> selectRecentFollowUpVisits(@Param("limit") Integer limit);
    
    /**
     * 查询满意度高的回访记录
     * @param minSatisfaction 最小满意度
     * @return 高满意度回访记录列表
     */
    List<FollowUpVisit> selectHighSatisfactionVisits(@Param("minSatisfaction") Integer minSatisfaction);
    
    /**
     * 更新回访照片
     * @param followupId 回访ID
     * @param photos 照片URL
     * @return 影响行数
     */
    Integer updatePhotos(
            @Param("followupId") Long followupId,
            @Param("photos") String photos
    );
    
    /**
     * 更新回访满意度
     * @param followupId 回访ID
     * @param satisfaction 满意度
     * @param notes 备注
     * @return 影响行数
     */
    Integer updateSatisfaction(
            @Param("followupId") Long followupId,
            @Param("satisfaction") Integer satisfaction,
            @Param("notes") String notes
    );
    
    /**
     * 查询需要回访的合同（最近N天内没有回访）
     * @param days 天数限制
     * @return 需要回访的合同ID列表
     */
    List<Long> selectContractsNeedFollowUp(@Param("days") Integer days);
    
    /**
     * 统计各满意度的回访数量
     * @return 各满意度回访数量统计
     */
    List<SatisfactionCount> countBySatisfaction();
    
    /**
     * 满意度统计结果类
     */
    class SatisfactionCount {
        private Integer satisfaction;
        private Long count;
        
        public SatisfactionCount() {}
        
        public SatisfactionCount(Integer satisfaction, Long count) {
            this.satisfaction = satisfaction;
            this.count = count;
        }
        
        public Integer getSatisfaction() { return satisfaction; }
        public void setSatisfaction(Integer satisfaction) { this.satisfaction = satisfaction; }
        public Long getCount() { return count; }
        public void setCount(Long count) { this.count = count; }
    }
}