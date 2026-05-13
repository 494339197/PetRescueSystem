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

    List<Post> selectByUserId(@Param("userId") Long userId);

    IPage<Post> selectPostPage(
            Page<Post> page,
            @Param("userId") Long userId,
            @Param("status") Integer status
    );

    List<Post> selectPopularPosts(@Param("limit") Integer limit);

    List<Post> selectRecentPosts(@Param("limit") Integer limit);

    List<Post> searchPosts(@Param("keyword") String keyword);

    Integer countByUserId(@Param("userId") Long userId);

    Integer incrementViewCount(@Param("postId") Long postId);

    Integer incrementLikeCount(@Param("postId") Long postId);

    Integer decrementLikeCount(@Param("postId") Long postId);

    Integer incrementCommentCount(@Param("postId") Long postId);

    Integer decrementCommentCount(@Param("postId") Long postId);

    Integer updateStatus(
            @Param("postId") Long postId,
            @Param("status") Integer status
    );

    Integer batchUpdateStatus(
            @Param("postIds") List<Long> postIds,
            @Param("status") Integer status
    );

    PostDetail selectPostDetail(@Param("postId") Long postId);

    PostStats selectUserPostStats(@Param("userId") Long userId);

    List<Post> selectByDateRange(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

    List<StatusCount> countByStatus();

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