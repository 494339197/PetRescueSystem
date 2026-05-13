package com.petrescue.petrescuesystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.common.Result;
import com.petrescue.petrescuesystem.entity.VolunteerTask;
import com.petrescue.petrescuesystem.service.VolunteerTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/volunteer-task")
public class VolunteerTaskController {

    @Autowired
    private VolunteerTaskService volunteerTaskService;

    @GetMapping("/{taskId}")
    public Result<VolunteerTask> getById(@PathVariable Long taskId) {
        return Result.success(volunteerTaskService.getById(taskId));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody VolunteerTask volunteerTask) {
        return Result.success(volunteerTaskService.save(volunteerTask));
    }

    @PutMapping
    public Result<Boolean> updateById(@RequestBody VolunteerTask volunteerTask) {
        return Result.success(volunteerTaskService.updateById(volunteerTask));
    }

    @DeleteMapping("/{taskId}")
    public Result<Boolean> removeById(@PathVariable Long taskId) {
        return Result.success(volunteerTaskService.removeById(taskId));
    }

    @GetMapping("/shelter/{shelterId}")
    public Result<List<VolunteerTask>> selectByShelterId(@PathVariable Long shelterId) {
        return Result.success(volunteerTaskService.selectByShelterId(shelterId));
    }

    @GetMapping("/volunteer/{volunteerUserId}")
    public Result<List<VolunteerTask>> selectByVolunteerUserId(@PathVariable Long volunteerUserId) {
        return Result.success(volunteerTaskService.selectByVolunteerUserId(volunteerUserId));
    }

    @GetMapping("/status/{status}")
    public Result<List<VolunteerTask>> selectByStatus(@PathVariable Integer status) {
        return Result.success(volunteerTaskService.selectByStatus(status));
    }

    @GetMapping("/task-type/{taskType}")
    public Result<List<VolunteerTask>> selectByTaskType(@PathVariable Integer taskType) {
        return Result.success(volunteerTaskService.selectByTaskType(taskType));
    }

    @GetMapping("/page")
    public Result<IPage<VolunteerTask>> selectVolunteerTaskPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                                                @RequestParam(defaultValue = "10") Integer pageSize,
                                                                @RequestParam(required = false) Long shelterId,
                                                                @RequestParam(required = false) Long volunteerUserId,
                                                                @RequestParam(required = false) Integer status,
                                                                @RequestParam(required = false) Integer taskType) {
        Page<VolunteerTask> page = new Page<>(pageNum, pageSize);
        return Result.success(volunteerTaskService.selectVolunteerTaskPage(page, shelterId, volunteerUserId, status, taskType));
    }

    @GetMapping("/count/shelter/{shelterId}")
    public Result<Integer> countByShelterId(@PathVariable Long shelterId) {
        return Result.success(volunteerTaskService.countByShelterId(shelterId));
    }

    @GetMapping("/count/volunteer/{volunteerUserId}")
    public Result<Integer> countByVolunteerUserId(@PathVariable Long volunteerUserId) {
        return Result.success(volunteerTaskService.countByVolunteerUserId(volunteerUserId));
    }

    @GetMapping("/count/status/{status}")
    public Result<Integer> countByStatus(@PathVariable Integer status) {
        return Result.success(volunteerTaskService.countByStatus(status));
    }

    @PutMapping("/status")
    public Result<Boolean> updateStatus(@RequestParam Long taskId, @RequestParam Integer status) {
        return Result.success(volunteerTaskService.updateStatus(taskId, status));
    }

    @PutMapping("/assign")
    public Result<Boolean> assignVolunteer(@RequestParam Long taskId, @RequestParam Long volunteerUserId) {
        return Result.success(volunteerTaskService.assignVolunteer(taskId, volunteerUserId));
    }

    @PutMapping("/complete")
    public Result<Boolean> completeTask(@RequestParam Long taskId, @RequestParam String completionNotes) {
        return Result.success(volunteerTaskService.completeTask(taskId, completionNotes));
    }

    @GetMapping("/pending/{shelterId}")
    public Result<List<VolunteerTask>> selectPendingTasksByShelter(@PathVariable Long shelterId) {
        return Result.success(volunteerTaskService.selectPendingTasksByShelter(shelterId));
    }

    @GetMapping("/date-range")
    public Result<List<VolunteerTask>> selectTasksByDateRange(@RequestParam LocalDateTime startDate,
                                                               @RequestParam LocalDateTime endDate) {
        return Result.success(volunteerTaskService.selectTasksByDateRange(startDate, endDate));
    }

    @GetMapping("/my-tasks")
    public Result<List<VolunteerTask>> selectMyTasks(@RequestParam Long volunteerUserId,
                                                      @RequestParam(required = false) Integer status) {
        return Result.success(volunteerTaskService.selectMyTasks(volunteerUserId, status));
    }
}