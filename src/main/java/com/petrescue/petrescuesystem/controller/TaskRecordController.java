package com.petrescue.petrescuesystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.common.Result;
import com.petrescue.petrescuesystem.entity.VolunteerTaskRecord;
import com.petrescue.petrescuesystem.mapper.VolunteerTaskRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/task-record")
public class TaskRecordController {

    @Autowired
    private VolunteerTaskRecordMapper volunteerTaskRecordMapper;

    @GetMapping("/{recordId}")
    public Result<VolunteerTaskRecord> getById(@PathVariable Long recordId) {
        return Result.success(volunteerTaskRecordMapper.selectById(recordId));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody VolunteerTaskRecord record) {
        return Result.success(volunteerTaskRecordMapper.insert(record) > 0);
    }

    @PutMapping
    public Result<Boolean> updateById(@RequestBody VolunteerTaskRecord record) {
        return Result.success(volunteerTaskRecordMapper.updateById(record) > 0);
    }

    @DeleteMapping("/{recordId}")
    public Result<Boolean> removeById(@PathVariable Long recordId) {
        return Result.success(volunteerTaskRecordMapper.deleteById(recordId) > 0);
    }

    @GetMapping("/task/{taskId}")
    public Result<List<VolunteerTaskRecord>> selectByTaskId(@PathVariable Long taskId) {
        return Result.success(volunteerTaskRecordMapper.selectByTaskId(taskId));
    }

    @GetMapping("/user/{userId}")
    public Result<List<VolunteerTaskRecord>> selectByUserId(@PathVariable Long userId) {
        return Result.success(volunteerTaskRecordMapper.selectByUserId(userId));
    }

    @GetMapping("/status/{status}")
    public Result<List<VolunteerTaskRecord>> selectByStatus(@PathVariable Integer status) {
        return Result.success(volunteerTaskRecordMapper.selectByStatus(status));
    }

    @GetMapping("/task-user")
    public Result<VolunteerTaskRecord> selectByTaskAndUser(@RequestParam Long taskId, @RequestParam Long userId) {
        return Result.success(volunteerTaskRecordMapper.selectByTaskAndUser(taskId, userId));
    }

    @GetMapping("/page")
    public Result<IPage<VolunteerTaskRecord>> selectTaskRecordPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(required = false) Long taskId,
                                                                    @RequestParam(required = false) Long userId,
                                                                    @RequestParam(required = false) Integer status) {
        Page<VolunteerTaskRecord> page = new Page<>(pageNum, pageSize);
        return Result.success(volunteerTaskRecordMapper.selectTaskRecordPage(page, taskId, userId, status));
    }

    @GetMapping("/count/task/{taskId}")
    public Result<Integer> countByTaskId(@PathVariable Long taskId) {
        return Result.success(volunteerTaskRecordMapper.countByTaskId(taskId));
    }

    @GetMapping("/count/user/{userId}")
    public Result<Integer> countByUserId(@PathVariable Long userId) {
        return Result.success(volunteerTaskRecordMapper.countByUserId(userId));
    }

    @GetMapping("/count/status/{status}")
    public Result<Integer> countByStatus(@PathVariable Integer status) {
        return Result.success(volunteerTaskRecordMapper.countByStatus(status));
    }

    @PutMapping("/status")
    public Result<Boolean> updateStatus(@RequestParam Long recordId, @RequestParam Integer status) {
        return Result.success(volunteerTaskRecordMapper.updateStatus(recordId, status) > 0);
    }

    @PutMapping("/check-in/{recordId}")
    public Result<Boolean> updateCheckIn(@PathVariable Long recordId) {
        return Result.success(volunteerTaskRecordMapper.updateCheckIn(recordId) > 0);
    }

    @PutMapping("/check-out")
    public Result<Boolean> updateCheckOut(@RequestParam Long recordId, @RequestParam BigDecimal hours) {
        return Result.success(volunteerTaskRecordMapper.updateCheckOut(recordId, hours) > 0);
    }

    @GetMapping("/recent/{userId}")
    public Result<List<VolunteerTaskRecord>> selectRecentByUserId(@PathVariable Long userId,
                                                                   @RequestParam(defaultValue = "5") Integer limit) {
        return Result.success(volunteerTaskRecordMapper.selectRecentByUserId(userId, limit));
    }
}