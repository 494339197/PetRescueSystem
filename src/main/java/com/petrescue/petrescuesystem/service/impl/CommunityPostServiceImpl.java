package com.petrescue.petrescuesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.Post;
import com.petrescue.petrescuesystem.mapper.PostMapper;
import com.petrescue.petrescuesystem.service.CommunityPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommunityPostServiceImpl implements CommunityPostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public Post getById(Long postId) {
        return postMapper.selectById(postId);
    }

    @Override
    public boolean save(Post post) {
        return postMapper.insert(post) > 0;
    }

    @Override
    public boolean updateById(Post post) {
        return postMapper.updateById(post) > 0;
    }

    @Override
    public boolean removeById(Long postId) {
        return postMapper.deleteById(postId) > 0;
    }

    @Override
    public List<Post> selectByUserId(Long userId) {
        return postMapper.selectByUserId(userId);
    }

    @Override
    public IPage<Post> selectPostPage(Page<Post> page, Long userId, Integer status) {
        return postMapper.selectPostPage(page, userId, status);
    }

    @Override
    public List<Post> selectPopularPosts(Integer limit) {
        return postMapper.selectPopularPosts(limit);
    }

    @Override
    public List<Post> selectRecentPosts(Integer limit) {
        return postMapper.selectRecentPosts(limit);
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return postMapper.searchPosts(keyword);
    }

    @Override
    public Integer countByUserId(Long userId) {
        return postMapper.countByUserId(userId);
    }

    @Override
    public boolean incrementViewCount(Long postId) {
        return postMapper.incrementViewCount(postId) > 0;
    }

    @Override
    public boolean incrementLikeCount(Long postId) {
        return postMapper.incrementLikeCount(postId) > 0;
    }

    @Override
    public boolean decrementLikeCount(Long postId) {
        return postMapper.decrementLikeCount(postId) > 0;
    }

    @Override
    public boolean incrementCommentCount(Long postId) {
        return postMapper.incrementCommentCount(postId) > 0;
    }

    @Override
    public boolean decrementCommentCount(Long postId) {
        return postMapper.decrementCommentCount(postId) > 0;
    }

    @Override
    public boolean updateStatus(Long postId, Integer status) {
        return postMapper.updateStatus(postId, status) > 0;
    }

    @Override
    public boolean batchUpdateStatus(List<Long> postIds, Integer status) {
        return postMapper.batchUpdateStatus(postIds, status) > 0;
    }

    @Override
    public List<Post> selectByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return postMapper.selectByDateRange(startDate, endDate);
    }
}