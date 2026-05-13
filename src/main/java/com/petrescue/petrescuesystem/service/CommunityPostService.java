package com.petrescue.petrescuesystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.Post;
import java.time.LocalDateTime;
import java.util.List;

public interface CommunityPostService {

    Post getById(Long postId);

    boolean save(Post post);

    boolean updateById(Post post);

    boolean removeById(Long postId);

    List<Post> selectByUserId(Long userId);

    IPage<Post> selectPostPage(Page<Post> page, Long userId, Integer status);

    List<Post> selectPopularPosts(Integer limit);

    List<Post> selectRecentPosts(Integer limit);

    List<Post> searchPosts(String keyword);

    Integer countByUserId(Long userId);

    boolean incrementViewCount(Long postId);

    boolean incrementLikeCount(Long postId);

    boolean decrementLikeCount(Long postId);

    boolean incrementCommentCount(Long postId);

    boolean decrementCommentCount(Long postId);

    boolean updateStatus(Long postId, Integer status);

    boolean batchUpdateStatus(List<Long> postIds, Integer status);

    List<Post> selectByDateRange(LocalDateTime startDate, LocalDateTime endDate);
}