package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petrescue.petrescuesystem.entity.LikeRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface LikeRecordMapper extends BaseMapper<LikeRecord> {
    
    /**
     * 根据用户ID查询点赞记录
     * @param userId 用户ID
     * @return 点赞记录列表
     */
    List<LikeRecord> selectByUserId(@Param("userId") Long userId);
    
    /**
     * 根据目标类型和目标ID查询点赞记录
     * @param targetType 目标类型
     * @param targetId 目标ID
     * @return 点赞记录列表
     */
    List<LikeRecord> selectByTarget(
            @Param("targetType") Integer targetType,
            @Param("targetId") Long targetId
    );
    
    /**
     * 查询用户是否对某个目标点过赞
     * @param userId 用户ID
     * @param targetType 目标类型
     * @param targetId 目标ID
     * @return 点赞记录（如果存在）
     */
    LikeRecord selectUserLike(
            @Param("userId") Long userId,
            @Param("targetType") Integer targetType,
            @Param("targetId") Long targetId
    );
    
    /**
     * 统计目标的点赞数量
     * @param targetType 目标类型
     * @param targetId 目标ID
     * @return 点赞数量
     */
    Integer countByTarget(
            @Param("targetType") Integer targetType,
            @Param("targetId") Long targetId
    );
    
    /**
     * 统计用户的点赞数量
     * @param userId 用户ID
     * @return 点赞数量
     */
    Integer countByUserId(@Param("userId") Long userId);
    
    /**
     * 批量插入点赞记录
     * @param likeRecords 点赞记录列表
     * @return 影响行数
     */
    Integer batchInsert(@Param("likeRecords") List<LikeRecord> likeRecords);
    
    /**
     * 删除用户对某个目标的点赞
     * @param userId 用户ID
     * @param targetType 目标类型
     * @param targetId 目标ID
     * @return 影响行数
     */
    Integer deleteByUserAndTarget(
            @Param("userId") Long userId,
            @Param("targetType") Integer targetType,
            @Param("targetId") Long targetId
    );
    
    /**
     * 删除目标的所有点赞记录
     * @param targetType 目标类型
     * @param targetId 目标ID
     * @return 影响行数
     */
    Integer deleteByTarget(
            @Param("targetType") Integer targetType,
            @Param("targetId") Long targetId
    );
    
    /**
     * 查询用户最近点赞记录
     * @param userId 用户ID
     * @param limit 限制数量
     * @return 最近点赞记录列表
     */
    List<LikeRecord> selectRecentLikesByUser(
            @Param("userId") Long userId,
            @Param("limit") Integer limit
    );
    
    /**
     * 查询热门点赞目标（按点赞数量排序）
     * @param targetType 目标类型
     * @param limit 限制数量
     * @return 热门目标ID列表
     */
    List<Long> selectPopularTargets(
            @Param("targetType") Integer targetType,
            @Param("limit") Integer limit
    );
    
    /**
     * 统计各目标类型的点赞数量
     * @return 各类型点赞数量统计
     */
    List<TargetTypeCount> countByTargetType();
    
    /**
     * 目标类型统计结果类
     */
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