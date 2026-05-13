package com.petrescue.petrescuesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.VolunteerTask;
import com.petrescue.petrescuesystem.mapper.VolunteerTaskMapper;
import com.petrescue.petrescuesystem.service.VolunteerTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VolunteerTaskServiceImpl implements VolunteerTaskService {

    @Autowired
    private VolunteerTaskMapper volunteerTaskMapper;

    @Override
    public VolunteerTask getById(Long taskId) {
        return volunteerTaskMapper.selectById(taskId);
    }

    @Override
    public boolean save(VolunteerTask volunteerTask) {
        return volunteerTaskMapper.insert(volunteerTask) > 0;
    }

    @Override
    public boolean updateById(VolunteerTask volunteerTask) {
        return volunteerTaskMapper.updateById(volunteerTask) > 0;
    }

    @Override
    public boolean removeById(Long taskId) {
        return volunteerTaskMapper.deleteById(taskId) > 0;
    }

    @Override
    public List<VolunteerTask> selectByShelterId(Long shelterId) {
        return volunteerTaskMapper.selectByShelterId(shelterId);
    }

    @Override
    public List<VolunteerTask> selectByVolunteerUserId(Long volunteerUserId) {
        return volunteerTaskMapper.selectByVolunteerUserId(volunteerUserId);
    }

    @Override
    public List<VolunteerTask> selectByStatus(Integer status) {
        return volunteerTaskMapper.selectByStatus(status);
    }

    @Override
    public List<VolunteerTask> selectByTaskType(Integer taskType) {
        return volunteerTaskMapper.selectByTaskType(taskType);
    }

    @Override
    public IPage<VolunteerTask> selectVolunteerTaskPage(Page<VolunteerTask> page, Long shelterId, Long volunteerUserId, Integer status, Integer taskType) {
        return volunteerTaskMapper.selectVolunteerTaskPage(page, shelterId, volunteerUserId, status, taskType);
    }

    @Override
    public Integer countByShelterId(Long shelterId) {
        return volunteerTaskMapper.countByShelterId(shelterId);
    }

    @Override
    public Integer countByVolunteerUserId(Long volunteerUserId) {
        return volunteerTaskMapper.countByVolunteerUserId(volunteerUserId);
    }

    @Override
    public Integer countByStatus(Integer status) {
        return volunteerTaskMapper.countByStatus(status);
    }

    @Override
    public boolean updateStatus(Long taskId, Integer status) {
        return volunteerTaskMapper.updateStatus(taskId, status) > 0;
    }

    @Override
    public boolean assignVolunteer(Long taskId, Long volunteerUserId) {
        return volunteerTaskMapper.assignVolunteer(taskId, volunteerUserId) > 0;
    }

    @Override
    public boolean completeTask(Long taskId, String completionNotes) {
        return volunteerTaskMapper.completeTask(taskId, completionNotes) > 0;
    }

    @Override
    public List<VolunteerTask> selectPendingTasksByShelter(Long shelterId) {
        return volunteerTaskMapper.selectPendingTasksByShelter(shelterId);
    }

    @Override
    public List<VolunteerTask> selectTasksByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return volunteerTaskMapper.selectTasksByDateRange(startDate, endDate);
    }

    @Override
    public List<VolunteerTask> selectMyTasks(Long volunteerUserId, Integer status) {
        return volunteerTaskMapper.selectMyTasks(volunteerUserId, status);
    }
}