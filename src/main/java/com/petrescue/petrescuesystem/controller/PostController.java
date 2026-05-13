package com.petrescue.petrescuesystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.common.Result;
import com.petrescue.petrescuesystem.entity.Post;
import com.petrescue.petrescuesystem.service.CommunityPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/community/post")
public class PostController {

    @Autowired
    private CommunityPostService communityPostService;

    @GetMapping("/{postId}")
    public Result<Post> getById(@PathVariable Long postId) {
        return Result.success(communityPostService.getById(postId));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody Post post) {
        return Result.success(communityPostService.save(post));
    }

    @PutMapping
    public Result<Boolean> updateById(@RequestBody Post post) {
        return Result.success(communityPostService.updateById(post));
    }

    @DeleteMapping("/{postId}")
    public Result<Boolean> removeById(@PathVariable Long postId) {
        return Result.success(communityPostService.removeById(postId));
    }

    @GetMapping("/user/{userId}")
    public Result<List<Post>> selectByUserId(@PathVariable Long userId) {
        return Result.success(communityPostService.selectByUserId(userId));
    }

    @GetMapping("/page")
    public Result<IPage<Post>> selectPostPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "10") Integer pageSize,
                                              @RequestParam(required = false) Long userId,
                                              @RequestParam(required = false) Integer status) {
        Page<Post> page = new Page<>(pageNum, pageSize);
        return Result.success(communityPostService.selectPostPage(page, userId, status));
    }

    @GetMapping("/popular")
    public Result<List<Post>> selectPopularPosts(@RequestParam(defaultValue = "10") Integer limit) {
        return Result.success(communityPostService.selectPopularPosts(limit));
    }

    @GetMapping("/recent")
    public Result<List<Post>> selectRecentPosts(@RequestParam(defaultValue = "10") Integer limit) {
        return Result.success(communityPostService.selectRecentPosts(limit));
    }

    @GetMapping("/search")
    public Result<List<Post>> searchPosts(@RequestParam String keyword) {
        return Result.success(communityPostService.searchPosts(keyword));
    }

    @GetMapping("/count/user/{userId}")
    public Result<Integer> countByUserId(@PathVariable Long userId) {
        return Result.success(communityPostService.countByUserId(userId));
    }

    @PutMapping("/view/{postId}")
    public Result<Boolean> incrementViewCount(@PathVariable Long postId) {
        return Result.success(communityPostService.incrementViewCount(postId));
    }

    @PutMapping("/like/{postId}")
    public Result<Boolean> incrementLikeCount(@PathVariable Long postId) {
        return Result.success(communityPostService.incrementLikeCount(postId));
    }

    @PutMapping("/unlike/{postId}")
    public Result<Boolean> decrementLikeCount(@PathVariable Long postId) {
        return Result.success(communityPostService.decrementLikeCount(postId));
    }

    @PutMapping("/comment/{postId}")
    public Result<Boolean> incrementCommentCount(@PathVariable Long postId) {
        return Result.success(communityPostService.incrementCommentCount(postId));
    }

    @PutMapping("/uncomment/{postId}")
    public Result<Boolean> decrementCommentCount(@PathVariable Long postId) {
        return Result.success(communityPostService.decrementCommentCount(postId));
    }

    @PutMapping("/status")
    public Result<Boolean> updateStatus(@RequestParam Long postId, @RequestParam Integer status) {
        return Result.success(communityPostService.updateStatus(postId, status));
    }

    @PutMapping("/batch-status")
    public Result<Boolean> batchUpdateStatus(@RequestParam List<Long> postIds, @RequestParam Integer status) {
        return Result.success(communityPostService.batchUpdateStatus(postIds, status));
    }

    @GetMapping("/date-range")
    public Result<List<Post>> selectByDateRange(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        return Result.success(communityPostService.selectByDateRange(startDate, endDate));
    }
}