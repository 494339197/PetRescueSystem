package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petrescue.petrescuesystem.entity.AnimalMedia;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface AnimalMediaMapper extends BaseMapper<AnimalMedia> {

    List<AnimalMedia> selectByAnimalId(@Param("animalId") Long animalId);

    List<AnimalMedia> selectRecentByAnimalId(
            @Param("animalId") Long animalId,
            @Param("limit") Integer limit
    );

    Integer countByAnimalId(@Param("animalId") Long animalId);

    Integer deleteByAnimalId(@Param("animalId") Long animalId);

    Integer batchInsert(@Param("mediaList") List<AnimalMedia> mediaList);

    List<AnimalMedia> selectRecentlyUploaded(@Param("limit") Integer limit);

    AnimalMedia selectByUrl(@Param("url") String url);

    Integer updateMediaUrl(
            @Param("mediaId") Long mediaId,
            @Param("newUrl") String newUrl
    );
}