package com.petrescue.petrescuesystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.Animal;
import java.util.List;

public interface AnimalService {

    Animal getById(Long animalId);

    boolean save(Animal animal);

    boolean updateById(Animal animal);

    boolean removeById(Long animalId);

    List<Animal> selectByShelterId(Long shelterId);

    List<Animal> selectByAdoptionStatus(Integer adoptionStatus);

    List<Animal> selectBySpecies(Integer species);

    IPage<Animal> selectAnimalPage(Page<Animal> page, Long shelterId, Integer species, Integer adoptionStatus, Integer sterilized, Integer vaccinated);

    Animal selectByChipNumber(String chipNumber);

    List<Animal> selectAvailableForAdoption();

    List<Animal> selectRecentlyRescued(Integer days);

    Integer countAvailableForAdoption();

    Integer countByShelterId(Long shelterId);

    List<Animal> selectPopularAnimals(Integer limit);

    List<Animal> searchAnimals(String keyword);
}