package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface PostMapper extends BaseMapper<Post> {
    
    /**
     * 根据用户ID查询帖子列表
     * @param userId 用户ID
     * @return 帖子列表
     */
    List<Post> selectByUserId(@Param("userId") Long userId);
    
    /**
     * 分页查询帖子列表
     * @param page 分页参数
     * @param userId 用户ID（可选）
     * @param status 帖子状态（可选）
     * @return 分页结果
     */
    IPage<Post> selectPostPage(
            Page<Post> page,
            @Param("userId") Long userId,
            @Param("status") Integer status
    );
    
    /**
     * 查询热门帖子（按浏览量排序）
     * @param limit 限制数量
     * @return 热门帖子列表
     */
    List<Post> selectPopularPosts(@Param("limit") Integer limit);
    
    /**
     * 查询最新帖子
     * @param limit 限制数量
     * @return 最新帖子列表
     */
    List<Post> selectRecentPosts(@Param("limit") Integer limit);
    
    /**
     * 根据关键字搜索帖子
     * @param keyword 搜索关键字
     * @return 搜索结果列表
     */
    List<Post> searchPosts(@Param("keyword") String keyword);
    
    /**
     * 统计用户的帖子数量
     * @param userId 用户ID
     * @return 帖子数量
     */
    Integer countByUserId(@Param("userId") Long userId);
    
    /**
     * 增加帖子浏览量
     * @param postId 帖子ID
     * @return 影响行数
     */
    Integer incrementViewCount(@Param("postId") Long postId);
    
    /**
     * 增加帖子点赞数
     * @param postId 帖子ID
     * @return 影响行数
     */
    Integer incrementLikeCount(@Param("postId") Long postId);
    
    /**
     * 减少帖子点赞数
     * @param postId 帖子ID
     * @return 影响行数
     */
    Integer decrementLikeCount(@Param("postId") Long postId);
    
    /**
     * 增加帖子评论数
     * @param postId 帖子ID
     * @return 影响行数
     */
    Integer incrementCommentCount(@Param("postId") Long postId);
    
    /**
     * 减少帖子评论数
     * @param postId 帖子ID
     * @return 影响行数
     */
    Integer decrementCommentCount(@Param("postId") Long postId);
    
    /**
     * 更新帖子状态
     * @param postId 帖子ID
     * @param status 新状态
     * @return 影响行数
     */
    Integer updateStatus(
            @Param("postId") Long postId,
            @Param("status") Integer status
    );
    
    /**
     * 批量更新帖子状态
     * @param postIds 帖子ID列表
     * @param status 新状态
     * @return 影响行数
     */
    Integer batchUpdateStatus(
            @Param("postIds") List<Long> postIds,
            @Param("status") Integer status
    );
    
    /**
     * 查询帖子详情（包含用户信息）
     * @param postId 帖子ID
     * @return 帖子详情
     */
    PostDetail selectPostDetail(@Param("postId") Long postId);
    
    /**
     * 查询用户发布的帖子统计信息
     * @param userId 用户ID
     * @return 帖子统计信息
     */
    PostStats selectUserPostStats(@Param("userId") Long userId);
    
    /**
     * 查询指定日期范围内的帖子
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 帖子列表
     */
    List<Post> selectByDateRange(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );
    
    /**
     * 统计各状态帖子的数量
     * @return 各状态帖子数量统计
     */
    List<StatusCount> countByStatus();
    
    /**
     * 帖子详情类（包含用户信息）
     */
    class PostDetail extends Post {
        private String username;
        private String avatar;
        private Integer userPostCount;
        
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getAvatar() { return avatar; }
        public void setAvatar(String avatar) { this.avatar = avatar; }
        public Integer getUserPostCount() { return userPostCount; }
        public void setUserPostCount(Integer userPostCount) { this.userPostCount = userPostCount; }
    }
    
    /**
     * 帖子统计信息类
     */
    class PostStats {
        private Long totalPosts;
        private Long totalViews;
        private Long totalLikes;
        private Long totalComments;
        private Long avgViews;
        
        public Long getTotalPosts() { return totalPosts; }
        public void setTotalPosts(Long totalPosts) { this.totalPosts = totalPosts; }
        public Long getTotalViews() { return totalViews; }
        public void setTotalViews(Long totalViews) { this.totalViews = totalViews; }
        public Long getTotalLikes() { return totalLikes; }
        public void setTotalLikes(Long totalLikes) { this.totalLikes = totalLikes; }
        public Long getTotalComments() { return totalComments; }
        public void setTotalComments(Long totalComments) { this.totalComments = totalComments; }
        public Long getAvgViews() { return avgViews; }
        public void setAvgViews(Long avgViews) { this.avgViews = avgViews; }
    }
    
    /**
     * 状态统计结果类
     */
    class StatusCount {
        private Integer status;
        private Long count;
        
        public StatusCount() {}
        
        public StatusCount(Integer status, Long count) {
            this.status = status;
            this.count = count;
        }
        
        public Integer getStatus() { return status; }
        public void setStatus(Integer status) { this.status = status; }
        public Long getCount() { return count; }
        public void setCount(Long count) { this.count = count; }
    }
}