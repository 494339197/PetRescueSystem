package com.petrescue.petrescuesystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.common.Result;
import com.petrescue.petrescuesystem.entity.Shelter;
import com.petrescue.petrescuesystem.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shelter")
public class ShelterController {

    @Autowired
    private ShelterService shelterService;

    @GetMapping("/{shelterId}")
    public Result<Shelter> getById(@PathVariable Long shelterId) {
        return Result.success(shelterService.getById(shelterId));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody Shelter shelter) {
        return Result.success(shelterService.save(shelter));
    }

    @PutMapping
    public Result<Boolean> updateById(@RequestBody Shelter shelter) {
        return Result.success(shelterService.updateById(shelter));
    }

    @DeleteMapping("/{shelterId}")
    public Result<Boolean> removeById(@PathVariable Long shelterId) {
        return Result.success(shelterService.removeById(shelterId));
    }

    @GetMapping("/city/{city}")
    public Result<List<Shelter>> selectByCity(@PathVariable String city) {
        return Result.success(shelterService.selectByCity(city));
    }

    @GetMapping("/province/{province}")
    public Result<List<Shelter>> selectByProvince(@PathVariable String province) {
        return Result.success(shelterService.selectByProvince(province));
    }

    @GetMapping("/status/{status}")
    public Result<List<Shelter>> selectByStatus(@PathVariable Integer status) {
        return Result.success(shelterService.selectByStatus(status));
    }

    @GetMapping("/page")
    public Result<IPage<Shelter>> selectShelterPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                                    @RequestParam(required = false) String province,
                                                    @RequestParam(required = false) String city,
                                                    @RequestParam(required = false) Integer status) {
        Page<Shelter> page = new Page<>(pageNum, pageSize);
        return Result.success(shelterService.selectShelterPage(page, province, city, status));
    }

    @GetMapping("/count/city/{city}")
    public Result<Integer> countByCity(@PathVariable String city) {
        return Result.success(shelterService.countByCity(city));
    }

    @PutMapping("/current-count/{shelterId}")
    public Result<Boolean> updateCurrentCount(@PathVariable Long shelterId) {
        return Result.success(shelterService.updateCurrentCount(shelterId));
    }

    @PutMapping("/status")
    public Result<Boolean> updateStatus(@RequestParam Long shelterId, @RequestParam Integer status) {
        return Result.success(shelterService.updateStatus(shelterId, status));
    }

    @GetMapping("/search")
    public Result<List<Shelter>> searchShelters(@RequestParam String keyword) {
        return Result.success(shelterService.searchShelters(keyword));
    }

    @GetMapping("/active")
    public Result<List<Shelter>> selectActiveShelters() {
        return Result.success(shelterService.selectActiveShelters());
    }
}