package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petrescue.petrescuesystem.entity.AnimalMedia;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface AnimalMediaMapper extends BaseMapper<AnimalMedia> {
    
    /**
     * 根据动物ID查询媒体文件列表
     * @param animalId 动物ID
     * @return 媒体文件列表
     */
    List<AnimalMedia> selectByAnimalId(@Param("animalId") Long animalId);
    
    /**
     * 根据动物ID查询最新的媒体文件
     * @param animalId 动物ID
     * @param limit 限制数量
     * @return 最新的媒体文件列表
     */
    List<AnimalMedia> selectRecentByAnimalId(
            @Param("animalId") Long animalId,
            @Param("limit") Integer limit
    );
    
    /**
     * 统计指定动物的媒体文件数量
     * @param animalId 动物ID
     * @return 媒体文件数量
     */
    Integer countByAnimalId(@Param("animalId") Long animalId);
    
    /**
     * 删除指定动物的所有媒体文件
     * @param animalId 动物ID
     * @return 影响行数
     */
    Integer deleteByAnimalId(@Param("animalId") Long animalId);
    
    /**
     * 批量插入媒体文件
     * @param mediaList 媒体文件列表
     * @return 影响行数
     */
    Integer batchInsert(@Param("mediaList") List<AnimalMedia> mediaList);
    
    /**
     * 查询最近上传的媒体文件
     * @param limit 限制数量
     * @return 最近上传的媒体文件列表
     */
    List<AnimalMedia> selectRecentlyUploaded(@Param("limit") Integer limit);
    
    /**
     * 根据URL查询媒体文件
     * @param url 文件URL
     * @return 媒体文件
     */
    AnimalMedia selectByUrl(@Param("url") String url);
    
    /**
     * 更新媒体文件的URL
     * @param mediaId 媒体文件ID
     * @param newUrl 新的文件URL
     * @return 影响行数
     */
    Integer updateMediaUrl(
            @Param("mediaId") Long mediaId,
            @Param("newUrl") String newUrl
    );
}