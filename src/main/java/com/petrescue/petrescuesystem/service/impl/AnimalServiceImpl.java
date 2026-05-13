package com.petrescue.petrescuesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.Animal;
import com.petrescue.petrescuesystem.mapper.AnimalMapper;
import com.petrescue.petrescuesystem.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalMapper animalMapper;

    @Override
    public Animal getById(Long animalId) {
        return animalMapper.selectById(animalId);
    }

    @Override
    public boolean save(Animal animal) {
        return animalMapper.insert(animal) > 0;
    }

    @Override
    public boolean updateById(Animal animal) {
        return animalMapper.updateById(animal) > 0;
    }

    @Override
    public boolean removeById(Long animalId) {
        return animalMapper.deleteById(animalId) > 0;
    }

    @Override
    public List<Animal> selectByShelterId(Long shelterId) {
        return animalMapper.selectByShelterId(shelterId);
    }

    @Override
    public List<Animal> selectByAdoptionStatus(Integer adoptionStatus) {
        return animalMapper.selectByAdoptionStatus(adoptionStatus);
    }

    @Override
    public List<Animal> selectBySpecies(Integer species) {
        return animalMapper.selectBySpecies(species);
    }

    @Override
    public IPage<Animal> selectAnimalPage(Page<Animal> page, Long shelterId, Integer species, Integer adoptionStatus, Integer sterilized, Integer vaccinated) {
        return animalMapper.selectAnimalPage(page, shelterId, species, adoptionStatus, sterilized, vaccinated);
    }

    @Override
    public Animal selectByChipNumber(String chipNumber) {
        return animalMapper.selectByChipNumber(chipNumber);
    }

    @Override
    public List<Animal> selectAvailableForAdoption() {
        return animalMapper.selectAvailableForAdoption();
    }

    @Override
    public List<Animal> selectRecentlyRescued(Integer days) {
        return animalMapper.selectRecentlyRescued(days);
    }

    @Override
    public Integer countAvailableForAdoption() {
        return animalMapper.countAvailableForAdoption();
    }

    @Override
    public Integer countByShelterId(Long shelterId) {
        return animalMapper.countByShelterId(shelterId);
    }

    @Override
    public List<Animal> selectPopularAnimals(Integer limit) {
        return animalMapper.selectPopularAnimals(limit);
    }

    @Override
    public List<Animal> searchAnimals(String keyword) {
        return animalMapper.searchAnimals(keyword);
    }
}