package com.petrescue.petrescuesystem.controller;

import com.petrescue.petrescuesystem.common.Result;
import com.petrescue.petrescuesystem.entity.LikeRecord;
import com.petrescue.petrescuesystem.mapper.LikeRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/like")
public class LikeController {

    @Autowired
    private LikeRecordMapper likeRecordMapper;

    @PostMapping
    public Result<Boolean> save(@RequestBody LikeRecord likeRecord) {
        return Result.success(likeRecordMapper.insert(likeRecord) > 0);
    }

    @DeleteMapping("/{likeId}")
    public Result<Boolean> removeById(@PathVariable Long likeId) {
        return Result.success(likeRecordMapper.deleteById(likeId) > 0);
    }

    @GetMapping("/user/{userId}")
    public Result<List<LikeRecord>> selectByUserId(@PathVariable Long userId) {
        return Result.success(likeRecordMapper.selectByUserId(userId));
    }

    @GetMapping("/target")
    public Result<List<LikeRecord>> selectByTarget(@RequestParam Integer targetType,
                                                   @RequestParam Long targetId) {
        return Result.success(likeRecordMapper.selectByTarget(targetType, targetId));
    }

    @GetMapping("/check")
    public Result<LikeRecord> selectUserLike(@RequestParam Long userId, @RequestParam Integer targetType,
                                             @RequestParam Long targetId) {
        return Result.success(likeRecordMapper.selectUserLike(userId, targetType, targetId));
    }

    @GetMapping("/count/target")
    public Result<Integer> countByTarget(@RequestParam Integer targetType, @RequestParam Long targetId) {
        return Result.success(likeRecordMapper.countByTarget(targetType, targetId));
    }

    @GetMapping("/count/user/{userId}")
    public Result<Integer> countByUserId(@PathVariable Long userId) {
        return Result.success(likeRecordMapper.countByUserId(userId));
    }

    @DeleteMapping("/cancel")
    public Result<Boolean> deleteByUserAndTarget(@RequestParam Long userId, @RequestParam Integer targetType,
                                                 @RequestParam Long targetId) {
        return Result.success(likeRecordMapper.deleteByUserAndTarget(userId, targetType, targetId) > 0);
    }

    @GetMapping("/recent")
    public Result<List<LikeRecord>> selectRecentLikesByUser(@RequestParam Long userId,
                                                            @RequestParam(defaultValue = "10") Integer limit) {
        return Result.success(likeRecordMapper.selectRecentLikesByUser(userId, limit));
    }
}