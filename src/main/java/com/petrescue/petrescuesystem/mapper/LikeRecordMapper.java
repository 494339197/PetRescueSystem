package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petrescue.petrescuesystem.entity.LikeRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface LikeRecordMapper extends BaseMapper<LikeRecord> {

    List<LikeRecord> selectByUserId(@Param("userId") Long userId);

    List<LikeRecord> selectByTarget(
            @Param("targetType") Integer targetType,
            @Param("targetId") Long targetId
    );

    LikeRecord selectUserLike(
            @Param("userId") Long userId,
            @Param("targetType") Integer targetType,
            @Param("targetId") Long targetId
    );

    Integer countByTarget(
            @Param("targetType") Integer targetType,
            @Param("targetId") Long targetId
    );

    Integer countByUserId(@Param("userId") Long userId);

    Integer batchInsert(@Param("likeRecords") List<LikeRecord> likeRecords);

    Integer deleteByUserAndTarget(
            @Param("userId") Long userId,
            @Param("targetType") Integer targetType,
            @Param("targetId") Long targetId
    );

    Integer deleteByTarget(
            @Param("targetType") Integer targetType,
            @Param("targetId") Long targetId
    );

    List<LikeRecord> selectRecentLikesByUser(
            @Param("userId") Long userId,
            @Param("limit") Integer limit
    );

    List<Long> selectPopularTargets(
            @Param("targetType") Integer targetType,
            @Param("limit") Integer limit
    );

    List<TargetTypeCount> countByTargetType();

    class TargetTypeCount {
        private Integer targetType;
        private Long count;

        public TargetTypeCount() {}

        public TargetTypeCount(Integer targetType, Long count) {
            this.targetType = targetType;
            this.count = count;
        }

        public Integer getTargetType() { return targetType; }
        public void setTargetType(Integer targetType) { this.targetType = targetType; }
        public Long getCount() { return count; }
        public void setCount(Long count) { this.count = count; }
    }
}