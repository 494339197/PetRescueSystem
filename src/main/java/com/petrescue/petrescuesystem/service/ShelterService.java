package com.petrescue.petrescuesystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.Shelter;
import java.util.List;

public interface ShelterService {

    Shelter getById(Long shelterId);

    boolean save(Shelter shelter);

    boolean updateById(Shelter shelter);

    boolean removeById(Long shelterId);

    List<Shelter> selectByCity(String city);

    List<Shelter> selectByProvince(String province);

    List<Shelter> selectByStatus(Integer status);

    IPage<Shelter> selectShelterPage(Page<Shelter> page, String province, String city, Integer status);

    Integer countByCity(String city);

    boolean updateCurrentCount(Long shelterId);

    boolean updateStatus(Long shelterId, Integer status);

    List<Shelter> searchShelters(String keyword);

    List<Shelter> selectActiveShelters();
}