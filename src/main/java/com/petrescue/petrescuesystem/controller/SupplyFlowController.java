package com.petrescue.petrescuesystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.common.Result;
import com.petrescue.petrescuesystem.entity.SupplyFlow;
import com.petrescue.petrescuesystem.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/supply/flow")
public class SupplyFlowController {

    @Autowired
    private SupplyService supplyService;

    @GetMapping("/{flowId}")
    public Result<SupplyFlow> getFlowById(@PathVariable Long flowId) {
        return Result.success(supplyService.getFlowById(flowId));
    }

    @PostMapping
    public Result<Boolean> saveFlow(@RequestBody SupplyFlow flow) {
        return Result.success(supplyService.saveFlow(flow));
    }

    @GetMapping("/supply/{supplyId}")
    public Result<List<SupplyFlow>> selectFlowBySupplyId(@PathVariable Long supplyId) {
        return Result.success(supplyService.selectFlowBySupplyId(supplyId));
    }

    @GetMapping("/change-type/{changeType}")
    public Result<List<SupplyFlow>> selectFlowByChangeType(@PathVariable Integer changeType) {
        return Result.success(supplyService.selectFlowByChangeType(changeType));
    }

    @GetMapping("/page")
    public Result<IPage<SupplyFlow>> selectSupplyFlowPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                                          @RequestParam(defaultValue = "10") Integer pageSize,
                                                          @RequestParam(required = false) Long supplyId,
                                                          @RequestParam(required = false) Integer changeType,
                                                          @RequestParam(required = false) LocalDateTime startDate,
                                                          @RequestParam(required = false) LocalDateTime endDate) {
        Page<SupplyFlow> page = new Page<>(pageNum, pageSize);
        return Result.success(supplyService.selectSupplyFlowPage(page, supplyId, changeType, startDate, endDate));
    }

    @GetMapping("/recent")
    public Result<List<SupplyFlow>> selectRecentFlows(@RequestParam(defaultValue = "10") Integer limit) {
        return Result.success(supplyService.selectRecentFlows(limit));
    }
}