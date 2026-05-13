package com.petrescue.petrescuesystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.common.Result;
import com.petrescue.petrescuesystem.entity.Comment;
import com.petrescue.petrescuesystem.service.CommunityCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/community/comment")
public class CommentController {

    @Autowired
    private CommunityCommentService communityCommentService;

    @GetMapping("/{commentId}")
    public Result<Comment> getById(@PathVariable Long commentId) {
        return Result.success(communityCommentService.getById(commentId));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody Comment comment) {
        return Result.success(communityCommentService.save(comment));
    }

    @PutMapping
    public Result<Boolean> updateById(@RequestBody Comment comment) {
        return Result.success(communityCommentService.updateById(comment));
    }

    @DeleteMapping("/{commentId}")
    public Result<Boolean> removeById(@PathVariable Long commentId) {
        return Result.success(communityCommentService.removeById(commentId));
    }

    @GetMapping("/post/{postId}")
    public Result<List<Comment>> selectByPostId(@PathVariable Long postId) {
        return Result.success(communityCommentService.selectByPostId(postId));
    }

    @GetMapping("/user/{userId}")
    public Result<List<Comment>> selectByUserId(@PathVariable Long userId) {
        return Result.success(communityCommentService.selectByUserId(userId));
    }

    @GetMapping("/root/{postId}")
    public Result<List<Comment>> selectRootCommentsByPostId(@PathVariable Long postId) {
        return Result.success(communityCommentService.selectRootCommentsByPostId(postId));
    }

    @GetMapping("/replies/{parentId}")
    public Result<List<Comment>> selectRepliesByParentId(@PathVariable Long parentId) {
        return Result.success(communityCommentService.selectRepliesByParentId(parentId));
    }

    @GetMapping("/page")
    public Result<IPage<Comment>> selectCommentPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                                    @RequestParam(required = false) Long postId,
                                                    @RequestParam(required = false) Long userId) {
        Page<Comment> page = new Page<>(pageNum, pageSize);
        return Result.success(communityCommentService.selectCommentPage(page, postId, userId));
    }

    @GetMapping("/count/post/{postId}")
    public Result<Integer> countByPostId(@PathVariable Long postId) {
        return Result.success(communityCommentService.countByPostId(postId));
    }

    @GetMapping("/count/user/{userId}")
    public Result<Integer> countByUserId(@PathVariable Long userId) {
        return Result.success(communityCommentService.countByUserId(userId));
    }

    @PutMapping("/like-count")
    public Result<Boolean> updateLikeCount(@RequestParam Long commentId, @RequestParam Integer likeCount) {
        return Result.success(communityCommentService.updateLikeCount(commentId, likeCount));
    }

    @PutMapping("/like/{commentId}")
    public Result<Boolean> incrementLikeCount(@PathVariable Long commentId) {
        return Result.success(communityCommentService.incrementLikeCount(commentId));
    }

    @PutMapping("/unlike/{commentId}")
    public Result<Boolean> decrementLikeCount(@PathVariable Long commentId) {
        return Result.success(communityCommentService.decrementLikeCount(commentId));
    }

    @GetMapping("/popular/{postId}")
    public Result<List<Comment>> selectPopularComments(@PathVariable Long postId, @RequestParam(defaultValue = "5") Integer limit) {
        return Result.success(communityCommentService.selectPopularComments(postId, limit));
    }

    @GetMapping("/recent")
    public Result<List<Comment>> selectRecentComments(@RequestParam(defaultValue = "10") Integer limit) {
        return Result.success(communityCommentService.selectRecentComments(limit));
    }

    @GetMapping("/search")
    public Result<List<Comment>> searchComments(@RequestParam String keyword) {
        return Result.success(communityCommentService.searchComments(keyword));
    }

    @DeleteMapping("/recursive/{commentId}")
    public Result<Boolean> deleteCommentAndReplies(@PathVariable Long commentId) {
        return Result.success(communityCommentService.deleteCommentAndReplies(commentId));
    }

    @GetMapping("/replies-to/{replyToUserId}")
    public Result<List<Comment>> selectRepliesToUser(@PathVariable Long replyToUserId) {
        return Result.success(communityCommentService.selectRepliesToUser(replyToUserId));
    }
}