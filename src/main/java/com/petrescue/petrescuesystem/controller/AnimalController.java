package com.petrescue.petrescuesystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.common.Result;
import com.petrescue.petrescuesystem.entity.Animal;
import com.petrescue.petrescuesystem.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/{animalId}")
    public Result<Animal> getById(@PathVariable Long animalId) {
        return Result.success(animalService.getById(animalId));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody Animal animal) {
        return Result.success(animalService.save(animal));
    }

    @PutMapping
    public Result<Boolean> updateById(@RequestBody Animal animal) {
        return Result.success(animalService.updateById(animal));
    }

    @DeleteMapping("/{animalId}")
    public Result<Boolean> removeById(@PathVariable Long animalId) {
        return Result.success(animalService.removeById(animalId));
    }

    @GetMapping("/shelter/{shelterId}")
    public Result<List<Animal>> selectByShelterId(@PathVariable Long shelterId) {
        return Result.success(animalService.selectByShelterId(shelterId));
    }

    @GetMapping("/status/{adoptionStatus}")
    public Result<List<Animal>> selectByAdoptionStatus(@PathVariable Integer adoptionStatus) {
        return Result.success(animalService.selectByAdoptionStatus(adoptionStatus));
    }

    @GetMapping("/species/{species}")
    public Result<List<Animal>> selectBySpecies(@PathVariable Integer species) {
        return Result.success(animalService.selectBySpecies(species));
    }

    @GetMapping("/page")
    public Result<IPage<Animal>> selectAnimalPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                                  @RequestParam(required = false) Long shelterId,
                                                  @RequestParam(required = false) Integer species,
                                                  @RequestParam(required = false) Integer adoptionStatus,
                                                  @RequestParam(required = false) Integer sterilized,
                                                  @RequestParam(required = false) Integer vaccinated) {
        Page<Animal> page = new Page<>(pageNum, pageSize);
        return Result.success(animalService.selectAnimalPage(page, shelterId, species, adoptionStatus, sterilized, vaccinated));
    }

    @GetMapping("/chip/{chipNumber}")
    public Result<Animal> selectByChipNumber(@PathVariable String chipNumber) {
        return Result.success(animalService.selectByChipNumber(chipNumber));
    }

    @GetMapping("/available")
    public Result<List<Animal>> selectAvailableForAdoption() {
        return Result.success(animalService.selectAvailableForAdoption());
    }

    @GetMapping("/recently-rescued")
    public Result<List<Animal>> selectRecentlyRescued(@RequestParam(defaultValue = "30") Integer days) {
        return Result.success(animalService.selectRecentlyRescued(days));
    }

    @GetMapping("/count/available")
    public Result<Integer> countAvailableForAdoption() {
        return Result.success(animalService.countAvailableForAdoption());
    }

    @GetMapping("/count/shelter/{shelterId}")
    public Result<Integer> countByShelterId(@PathVariable Long shelterId) {
        return Result.success(animalService.countByShelterId(shelterId));
    }

    @GetMapping("/popular")
    public Result<List<Animal>> selectPopularAnimals(@RequestParam(defaultValue = "10") Integer limit) {
        return Result.success(animalService.selectPopularAnimals(limit));
    }

    @GetMapping("/search")
    public Result<List<Animal>> searchAnimals(@RequestParam String keyword) {
        return Result.success(animalService.searchAnimals(keyword));
    }
}