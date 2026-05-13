package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.HomeVisit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface HomeVisitMapper extends BaseMapper<HomeVisit> {
    
    /**
     * 根据申请ID查询家访记录
     * @param applicationId 申请ID
     * @return 家访记录
     */
    HomeVisit selectByApplicationId(@Param("applicationId") Long applicationId);
    
    /**
     * 根据家访人ID查询家访记录
     * @param visitorUserId 家访人ID
     * @return 家访记录列表
     */
    List<HomeVisit> selectByVisitorUserId(@Param("visitorUserId") Long visitorUserId);
    
    /**
     * 分页查询家访记录
     * @param page 分页参数
     * @param applicationId 申请ID（可选）
     * @param visitorUserId 家访人ID（可选）
     * @param startDate 开始日期（可选）
     * @param endDate 结束日期（可选）
     * @return 分页结果
     */
    IPage<HomeVisit> selectHomeVisitPage(
            Page<HomeVisit> page,
            @Param("applicationId") Long applicationId,
            @Param("visitorUserId") Long visitorUserId,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );
    
    /**
     * 查询指定日期范围内的家访记录
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 家访记录列表
     */
    List<HomeVisit> selectByVisitDateRange(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );
    
    /**
     * 统计家访人的家访次数
     * @param visitorUserId 家访人ID
     * @return 家访次数
     */
    Integer countByVisitorUserId(@Param("visitorUserId") Long visitorUserId);
    
    /**
     * 查询最近的家访记录
     * @param limit 限制数量
     * @return 最近家访记录列表
     */
    List<HomeVisit> selectRecentHomeVisits(@Param("limit") Integer limit);
    
    /**
     * 查询环境评分高的家访记录
     * @param minScore 最小评分
     * @return 高评分家访记录列表
     */
    List<HomeVisit> selectHighScoreVisits(@Param("minScore") Integer minScore);
    
    /**
     * 更新家访照片
     * @param visitId 家访ID
     * @param photos 照片URL
     * @return 影响行数
     */
    Integer updatePhotos(
            @Param("visitId") Long visitId,
            @Param("photos") String photos
    );
    
    /**
     * 更新家访环境评分
     * @param visitId 家访ID
     * @param environmentScore 环境评分
     * @param impression 印象描述
     * @return 影响行数
     */
    Integer updateEnvironmentScore(
            @Param("visitId") Long visitId,
            @Param("environmentScore") Integer environmentScore,
            @Param("impression") String impression
    );
    
    /**
     * 查询需要家访的申请（申请提交后N天内没有家访）
     * @param days 天数限制
     * @return 需要家访的申请ID列表
     */
    List<Long> selectApplicationsNeedHomeVisit(@Param("days") Integer days);
    
    /**
     * 统计各环境评分的家访数量
     * @return 各评分家访数量统计
     */
    List<EnvironmentScoreCount> countByEnvironmentScore();
    
    /**
     * 查询家访记录及其关联的申请信息
     * @param visitId 家访ID
     * @return 家访记录详情
     */
    HomeVisitDetail selectHomeVisitDetail(@Param("visitId") Long visitId);
    
    /**
     * 环境评分统计结果类
     */
    class EnvironmentScoreCount {
        private Integer environmentScore;
        private Long count;
        
        public EnvironmentScoreCount() {}
        
        public EnvironmentScoreCount(Integer environmentScore, Long count) {
            this.environmentScore = environmentScore;
            this.count = count;
        }
        
        public Integer getEnvironmentScore() { return environmentScore; }
        public void setEnvironmentScore(Integer environmentScore) { this.environmentScore = environmentScore; }
        public Long getCount() { return count; }
        public void setCount(Long count) { this.count = count; }
    }
    
    /**
     * 家访记录详情类（包含关联信息）
     */
    class HomeVisitDetail extends HomeVisit {
        private String applicantName;
        private String animalName;
        private String visitorName;
        
        public String getApplicantName() { return applicantName; }
        public void setApplicantName(String applicantName) { this.applicantName = applicantName; }
        public String getAnimalName() { return animalName; }
        public void setAnimalName(String animalName) { this.animalName = animalName; }
        public String getVisitorName() { return visitorName; }
        public void setVisitorName(String visitorName) { this.visitorName = visitorName; }
    }
}