package com.petrescue.petrescuesystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.common.Result;
import com.petrescue.petrescuesystem.entity.SupplyInventory;
import com.petrescue.petrescuesystem.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supply/inventory")
public class SupplyInventoryController {

    @Autowired
    private SupplyService supplyService;

    @GetMapping("/{supplyId}")
    public Result<SupplyInventory> getSupplyById(@PathVariable Long supplyId) {
        return Result.success(supplyService.getSupplyById(supplyId));
    }

    @PostMapping
    public Result<Boolean> saveSupply(@RequestBody SupplyInventory supply) {
        return Result.success(supplyService.saveSupply(supply));
    }

    @PutMapping
    public Result<Boolean> updateSupplyById(@RequestBody SupplyInventory supply) {
        return Result.success(supplyService.updateSupplyById(supply));
    }

    @DeleteMapping("/{supplyId}")
    public Result<Boolean> removeSupplyById(@PathVariable Long supplyId) {
        return Result.success(supplyService.removeSupplyById(supplyId));
    }

    @GetMapping("/shelter/{shelterId}")
    public Result<List<SupplyInventory>> selectByShelterId(@PathVariable Long shelterId) {
        return Result.success(supplyService.selectByShelterId(shelterId));
    }

    @GetMapping("/category/{category}")
    public Result<List<SupplyInventory>> selectByCategory(@PathVariable Integer category) {
        return Result.success(supplyService.selectByCategory(category));
    }

    @GetMapping("/low-stock/{shelterId}")
    public Result<List<SupplyInventory>> selectLowStockItems(@PathVariable Long shelterId) {
        return Result.success(supplyService.selectLowStockItems(shelterId));
    }

    @GetMapping("/page")
    public Result<IPage<SupplyInventory>> selectSupplyPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                                           @RequestParam(required = false) Long shelterId,
                                                           @RequestParam(required = false) Integer category) {
        Page<SupplyInventory> page = new Page<>(pageNum, pageSize);
        return Result.success(supplyService.selectSupplyPage(page, shelterId, category));
    }

    @GetMapping("/count/shelter/{shelterId}")
    public Result<Integer> countByShelterId(@PathVariable Long shelterId) {
        return Result.success(supplyService.countByShelterId(shelterId));
    }

    @GetMapping("/count/category/{category}")
    public Result<Integer> countByCategory(@PathVariable Integer category) {
        return Result.success(supplyService.countByCategory(category));
    }

    @PutMapping("/quantity")
    public Result<Boolean> updateQuantity(@RequestParam Long supplyId, @RequestParam Integer quantity) {
        return Result.success(supplyService.updateQuantity(supplyId, quantity));
    }

    @GetMapping("/search")
    public Result<List<SupplyInventory>> searchSupplies(@RequestParam String keyword) {
        return Result.success(supplyService.searchSupplies(keyword));
    }

    @GetMapping("/shelter-category")
    public Result<List<SupplyInventory>> selectByShelterIdAndCategory(@RequestParam Long shelterId, @RequestParam Integer category) {
        return Result.success(supplyService.selectByShelterIdAndCategory(shelterId, category));
    }
}