package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.Animal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface AnimalMapper extends BaseMapper<Animal> {

    List<Animal> selectByShelterId(@Param("shelterId") Long shelterId);

    List<Animal> selectByAdoptionStatus(@Param("adoptionStatus") Integer adoptionStatus);

    List<Animal> selectBySpecies(@Param("species") Integer species);

    IPage<Animal> selectAnimalPage(
            Page<Animal> page,
            @Param("shelterId") Long shelterId,
            @Param("species") Integer species,
            @Param("adoptionStatus") Integer adoptionStatus,
            @Param("sterilized") Integer sterilized,
            @Param("vaccinated") Integer vaccinated
    );

    Animal selectByChipNumber(@Param("chipNumber") String chipNumber);

    List<Animal> selectAvailableForAdoption();

    List<Animal> selectRecentlyRescued(@Param("days") Integer days);

    Integer countAvailableForAdoption();

    Integer countByShelterId(@Param("shelterId") Long shelterId);

    List<AnimalStatusCount> countByAdoptionStatus();

    Integer updateAdoptionStatus(
            @Param("animalId") Long animalId,
            @Param("adoptionStatus") Integer adoptionStatus
    );

    Integer updateHealthStatus(
            @Param("animalId") Long animalId,
            @Param("healthStatus") String healthStatus
    );

    List<Animal> selectPopularAnimals(@Param("limit") Integer limit);

    List<Animal> searchAnimals(@Param("keyword") String keyword);

    class AnimalStatusCount {
        private Integer adoptionStatus;
        private Long count;

        public AnimalStatusCount() {}

        public AnimalStatusCount(Integer adoptionStatus, Long count) {
            this.adoptionStatus = adoptionStatus;
            this.count = count;
        }

        public Integer getAdoptionStatus() { return adoptionStatus; }
        public void setAdoptionStatus(Integer adoptionStatus) { this.adoptionStatus = adoptionStatus; }
        public Long getCount() { return count; }
        public void setCount(Long count) { this.count = count; }
    }
}