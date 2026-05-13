package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.Animal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDate;
import java.util.List;

@Mapper
public interface AnimalMapper extends BaseMapper<Animal> {
    
    /**
     * 根据救助站ID查询动物列表
     * @param shelterId 救助站ID
     * @return 动物列表
     */
    List<Animal> selectByShelterId(@Param("shelterId") Long shelterId);
    
    /**
     * 根据领养状态查询动物列表
     * @param adoptionStatus 领养状态
     * @return 动物列表
     */
    List<Animal> selectByAdoptionStatus(@Param("adoptionStatus") Integer adoptionStatus);
    
    /**
     * 根据物种查询动物列表
     * @param species 物种类型
     * @return 动物列表
     */
    List<Animal> selectBySpecies(@Param("species") Integer species);
    
    /**
     * 分页查询动物列表
     * @param page 分页参数
     * @param shelterId 救助站ID（可选）
     * @param species 物种类型（可选）
     * @param adoptionStatus 领养状态（可选）
     * @param sterilized 绝育状态（可选）
     * @param vaccinated 疫苗接种状态（可选）
     * @return 分页结果
     */
    IPage<Animal> selectAnimalPage(
            Page<Animal> page,
            @Param("shelterId") Long shelterId,
            @Param("species") Integer species,
            @Param("adoptionStatus") Integer adoptionStatus,
            @Param("sterilized") Integer sterilized,
            @Param("vaccinated") Integer vaccinated
    );
    
    /**
     * 根据芯片号查询动物
     * @param chipNumber 芯片号
     * @return 动物信息
     */
    Animal selectByChipNumber(@Param("chipNumber") String chipNumber);
    
    /**
     * 查询可领养的动物列表
     * @return 可领养动物列表
     */
    List<Animal> selectAvailableForAdoption();
    
    /**
     * 查询最近救助的动物
     * @param days 最近天数
     * @return 最近救助的动物列表
     */
    List<Animal> selectRecentlyRescued(@Param("days") Integer days);
    
    /**
     * 查询待领养的动物数量
     * @return 待领养动物数量
     */
    Integer countAvailableForAdoption();
    
    /**
     * 统计救助站动物数量
     * @param shelterId 救助站ID
     * @return 动物数量
     */
    Integer countByShelterId(@Param("shelterId") Long shelterId);
    
    /**
     * 统计各领养状态的动物数量
     * @return 各状态动物数量统计
     */
    List<AnimalStatusCount> countByAdoptionStatus();
    
    /**
     * 更新动物领养状态
     * @param animalId 动物ID
     * @param adoptionStatus 领养状态
     * @return 影响行数
     */
    Integer updateAdoptionStatus(
            @Param("animalId") Long animalId,
            @Param("adoptionStatus") Integer adoptionStatus
    );
    
    /**
     * 更新动物健康状态
     * @param animalId 动物ID
     * @param healthStatus 健康状态
     * @return 影响行数
     */
    Integer updateHealthStatus(
            @Param("animalId") Long animalId,
            @Param("healthStatus") String healthStatus
    );
    
    /**
     * 查询热门动物（按申请数量排序）
     * @param limit 限制数量
     * @return 热门动物列表
     */
    List<Animal> selectPopularAnimals(@Param("limit") Integer limit);
    
    /**
     * 根据关键字搜索动物
     * @param keyword 搜索关键字
     * @return 搜索结果列表
     */
    List<Animal> searchAnimals(@Param("keyword") String keyword);
    
    /**
     * 统计结果类
     */
    class AnimalStatusCount {
        private Integer adoptionStatus;
        private Long count;
        
        public AnimalStatusCount() {}
        
        public AnimalStatusCount(Integer adoptionStatus, Long count) {
            this.adoptionStatus = adoptionStatus;
            this.count = count;
        }
        
        // getter和setter方法
        public Integer getAdoptionStatus() { return adoptionStatus; }
        public void setAdoptionStatus(Integer adoptionStatus) { this.adoptionStatus = adoptionStatus; }
        public Long getCount() { return count; }
        public void setCount(Long count) { this.count = count; }
    }
}