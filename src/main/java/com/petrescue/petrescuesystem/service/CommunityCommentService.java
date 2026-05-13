package com.petrescue.petrescuesystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.Comment;
import java.util.List;

public interface CommunityCommentService {

    Comment getById(Long commentId);

    boolean save(Comment comment);

    boolean updateById(Comment comment);

    boolean removeById(Long commentId);

    List<Comment> selectByPostId(Long postId);

    List<Comment> selectByUserId(Long userId);

    List<Comment> selectRootCommentsByPostId(Long postId);

    List<Comment> selectRepliesByParentId(Long parentId);

    IPage<Comment> selectCommentPage(Page<Comment> page, Long postId, Long userId);

    Integer countByPostId(Long postId);

    Integer countByUserId(Long userId);

    boolean updateLikeCount(Long commentId, Integer likeCount);

    boolean incrementLikeCount(Long commentId);

    boolean decrementLikeCount(Long commentId);

    List<Comment> selectPopularComments(Long postId, Integer limit);

    List<Comment> selectRecentComments(Integer limit);

    List<Comment> searchComments(String keyword);

    boolean deleteCommentAndReplies(Long commentId);

    List<Comment> selectRepliesToUser(Long replyToUserId);
}