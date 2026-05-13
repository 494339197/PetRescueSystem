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

    HomeVisit selectByApplicationId(@Param("applicationId") Long applicationId);

    List<HomeVisit> selectByVisitorUserId(@Param("visitorUserId") Long visitorUserId);

    IPage<HomeVisit> selectHomeVisitPage(
            Page<HomeVisit> page,
            @Param("applicationId") Long applicationId,
            @Param("visitorUserId") Long visitorUserId,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

    List<HomeVisit> selectByVisitDateRange(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

    Integer countByVisitorUserId(@Param("visitorUserId") Long visitorUserId);

    List<HomeVisit> selectRecentHomeVisits(@Param("limit") Integer limit);

    List<HomeVisit> selectHighScoreVisits(@Param("minScore") Integer minScore);

    Integer updatePhotos(
            @Param("visitId") Long visitId,
            @Param("photos") String photos
    );

    Integer updateEnvironmentScore(
            @Param("visitId") Long visitId,
            @Param("environmentScore") Integer environmentScore,
            @Param("impression") String impression
    );

    List<Long> selectApplicationsNeedHomeVisit(@Param("days") Integer days);

    List<EnvironmentScoreCount> countByEnvironmentScore();

    HomeVisitDetail selectHomeVisitDetail(@Param("visitId") Long visitId);

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