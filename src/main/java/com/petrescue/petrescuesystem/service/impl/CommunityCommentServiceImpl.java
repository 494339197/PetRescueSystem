package com.petrescue.petrescuesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.Comment;
import com.petrescue.petrescuesystem.mapper.CommentMapper;
import com.petrescue.petrescuesystem.service.CommunityCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommunityCommentServiceImpl implements CommunityCommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Comment getById(Long commentId) {
        return commentMapper.selectById(commentId);
    }

    @Override
    public boolean save(Comment comment) {
        return commentMapper.insert(comment) > 0;
    }

    @Override
    public boolean updateById(Comment comment) {
        return commentMapper.updateById(comment) > 0;
    }

    @Override
    public boolean removeById(Long commentId) {
        return commentMapper.deleteById(commentId) > 0;
    }

    @Override
    public List<Comment> selectByPostId(Long postId) {
        return commentMapper.selectByPostId(postId);
    }

    @Override
    public List<Comment> selectByUserId(Long userId) {
        return commentMapper.selectByUserId(userId);
    }

    @Override
    public List<Comment> selectRootCommentsByPostId(Long postId) {
        return commentMapper.selectRootCommentsByPostId(postId);
    }

    @Override
    public List<Comment> selectRepliesByParentId(Long parentId) {
        return commentMapper.selectRepliesByParentId(parentId);
    }

    @Override
    public IPage<Comment> selectCommentPage(Page<Comment> page, Long postId, Long userId) {
        return commentMapper.selectCommentPage(page, postId, userId);
    }

    @Override
    public Integer countByPostId(Long postId) {
        return commentMapper.countByPostId(postId);
    }

    @Override
    public Integer countByUserId(Long userId) {
        return commentMapper.countByUserId(userId);
    }

    @Override
    public boolean updateLikeCount(Long commentId, Integer likeCount) {
        return commentMapper.updateLikeCount(commentId, likeCount) > 0;
    }

    @Override
    public boolean incrementLikeCount(Long commentId) {
        return commentMapper.incrementLikeCount(commentId) > 0;
    }

    @Override
    public boolean decrementLikeCount(Long commentId) {
        return commentMapper.decrementLikeCount(commentId) > 0;
    }

    @Override
    public List<Comment> selectPopularComments(Long postId, Integer limit) {
        return commentMapper.selectPopularComments(postId, limit);
    }

    @Override
    public List<Comment> selectRecentComments(Integer limit) {
        return commentMapper.selectRecentComments(limit);
    }

    @Override
    public List<Comment> searchComments(String keyword) {
        return commentMapper.searchComments(keyword);
    }

    @Override
    public boolean deleteCommentAndReplies(Long commentId) {
        return commentMapper.deleteCommentAndReplies(commentId) > 0;
    }

    @Override
    public List<Comment> selectRepliesToUser(Long replyToUserId) {
        return commentMapper.selectRepliesToUser(replyToUserId);
    }
}