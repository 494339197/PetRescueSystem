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

    List<FollowUpVisit> selectByContractId(@Param("contractId") Long contractId);

    List<FollowUpVisit> selectByVisitorUserId(@Param("visitorUserId") Long visitorUserId);

    IPage<FollowUpVisit> selectFollowUpVisitPage(
            Page<FollowUpVisit> page,
            @Param("contractId") Long contractId,
            @Param("visitorUserId") Long visitorUserId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    List<FollowUpVisit> selectByVisitDateRange(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    Integer countByContractId(@Param("contractId") Long contractId);

    Integer countByVisitorUserId(@Param("visitorUserId") Long visitorUserId);

    List<FollowUpVisit> selectRecentFollowUpVisits(@Param("limit") Integer limit);

    List<FollowUpVisit> selectHighSatisfactionVisits(@Param("minSatisfaction") Integer minSatisfaction);

    Integer updatePhotos(
            @Param("followupId") Long followupId,
            @Param("photos") String photos
    );

    Integer updateSatisfaction(
            @Param("followupId") Long followupId,
            @Param("satisfaction") Integer satisfaction,
            @Param("notes") String notes
    );

    List<Long> selectContractsNeedFollowUp(@Param("days") Integer days);

    List<SatisfactionCount> countBySatisfaction();

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