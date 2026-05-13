package com.petrescue.petrescuesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.Shelter;
import com.petrescue.petrescuesystem.mapper.ShelterMapper;
import com.petrescue.petrescuesystem.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShelterServiceImpl implements ShelterService {

    @Autowired
    private ShelterMapper shelterMapper;

    @Override
    public Shelter getById(Long shelterId) {
        return shelterMapper.selectById(shelterId);
    }

    @Override
    public boolean save(Shelter shelter) {
        return shelterMapper.insert(shelter) > 0;
    }

    @Override
    public boolean updateById(Shelter shelter) {
        return shelterMapper.updateById(shelter) > 0;
    }

    @Override
    public boolean removeById(Long shelterId) {
        return shelterMapper.deleteById(shelterId) > 0;
    }

    @Override
    public List<Shelter> selectByCity(String city) {
        return shelterMapper.selectByCity(city);
    }

    @Override
    public List<Shelter> selectByProvince(String province) {
        return shelterMapper.selectByProvince(province);
    }

    @Override
    public List<Shelter> selectByStatus(Integer status) {
        return shelterMapper.selectByStatus(status);
    }

    @Override
    public IPage<Shelter> selectShelterPage(Page<Shelter> page, String province, String city, Integer status) {
        return shelterMapper.selectShelterPage(page, province, city, status);
    }

    @Override
    public Integer countByCity(String city) {
        return shelterMapper.countByCity(city);
    }

    @Override
    public boolean updateCurrentCount(Long shelterId) {
        return shelterMapper.updateCurrentCount(shelterId) > 0;
    }

    @Override
    public boolean updateStatus(Long shelterId, Integer status) {
        return shelterMapper.updateStatus(shelterId, status) > 0;
    }

    @Override
    public List<Shelter> searchShelters(String keyword) {
        return shelterMapper.searchShelters(keyword);
    }

    @Override
    public List<Shelter> selectActiveShelters() {
        return shelterMapper.selectActiveShelters();
    }
}