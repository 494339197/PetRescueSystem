package com.petrescue.petrescuesystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.common.Result;
import com.petrescue.petrescuesystem.entity.HomeVisit;
import com.petrescue.petrescuesystem.mapper.HomeVisitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/home-visit")
public class HomeVisitController {

    @Autowired
    private HomeVisitMapper homeVisitMapper;

    @GetMapping("/{visitId}")
    public Result<HomeVisit> getById(@PathVariable Long visitId) {
        return Result.success(homeVisitMapper.selectById(visitId));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody HomeVisit homeVisit) {
        return Result.success(homeVisitMapper.insert(homeVisit) > 0);
    }

    @PutMapping
    public Result<Boolean> updateById(@RequestBody HomeVisit homeVisit) {
        return Result.success(homeVisitMapper.updateById(homeVisit) > 0);
    }

    @DeleteMapping("/{visitId}")
    public Result<Boolean> removeById(@PathVariable Long visitId) {
        return Result.success(homeVisitMapper.deleteById(visitId) > 0);
    }

    @GetMapping("/application/{applicationId}")
    public Result<HomeVisit> selectByApplicationId(@PathVariable Long applicationId) {
        return Result.success(homeVisitMapper.selectByApplicationId(applicationId));
    }

    @GetMapping("/visitor/{visitorUserId}")
    public Result<List<HomeVisit>> selectByVisitorUserId(@PathVariable Long visitorUserId) {
        return Result.success(homeVisitMapper.selectByVisitorUserId(visitorUserId));
    }

    @GetMapping("/page")
    public Result<IPage<HomeVisit>> selectHomeVisitPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                                        @RequestParam(required = false) Long applicationId,
                                                        @RequestParam(required = false) Long visitorUserId,
                                                        @RequestParam(required = false) LocalDateTime startDate,
                                                        @RequestParam(required = false) LocalDateTime endDate) {
        Page<HomeVisit> page = new Page<>(pageNum, pageSize);
        return Result.success(homeVisitMapper.selectHomeVisitPage(page, applicationId, visitorUserId, startDate, endDate));
    }

    @GetMapping("/date-range")
    public Result<List<HomeVisit>> selectByVisitDateRange(@RequestParam LocalDateTime startDate,
                                                           @RequestParam LocalDateTime endDate) {
        return Result.success(homeVisitMapper.selectByVisitDateRange(startDate, endDate));
    }

    @GetMapping("/count/visitor/{visitorUserId}")
    public Result<Integer> countByVisitorUserId(@PathVariable Long visitorUserId) {
        return Result.success(homeVisitMapper.countByVisitorUserId(visitorUserId));
    }

    @GetMapping("/recent")
    public Result<List<HomeVisit>> selectRecentHomeVisits(@RequestParam(defaultValue = "10") Integer limit) {
        return Result.success(homeVisitMapper.selectRecentHomeVisits(limit));
    }

    @GetMapping("/high-score")
    public Result<List<HomeVisit>> selectHighScoreVisits(@RequestParam(defaultValue = "4") Integer minScore) {
        return Result.success(homeVisitMapper.selectHighScoreVisits(minScore));
    }

    @PutMapping("/photos")
    public Result<Boolean> updatePhotos(@RequestParam Long visitId, @RequestParam String photos) {
        return Result.success(homeVisitMapper.updatePhotos(visitId, photos) > 0);
    }

    @PutMapping("/environment-score")
    public Result<Boolean> updateEnvironmentScore(@RequestParam Long visitId,
                                                  @RequestParam Integer environmentScore,
                                                  @RequestParam(required = false) String impression) {
        return Result.success(homeVisitMapper.updateEnvironmentScore(visitId, environmentScore, impression) > 0);
    }
}