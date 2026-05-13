package com.petrescue.petrescuesystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.VolunteerTask;
import java.time.LocalDateTime;
import java.util.List;

public interface VolunteerTaskService {

    VolunteerTask getById(Long taskId);

    boolean save(VolunteerTask volunteerTask);

    boolean updateById(VolunteerTask volunteerTask);

    boolean removeById(Long taskId);

    List<VolunteerTask> selectByShelterId(Long shelterId);

    List<VolunteerTask> selectByVolunteerUserId(Long volunteerUserId);

    List<VolunteerTask> selectByStatus(Integer status);

    List<VolunteerTask> selectByTaskType(Integer taskType);

    IPage<VolunteerTask> selectVolunteerTaskPage(Page<VolunteerTask> page, Long shelterId, Long volunteerUserId, Integer status, Integer taskType);

    Integer countByShelterId(Long shelterId);

    Integer countByVolunteerUserId(Long volunteerUserId);

    Integer countByStatus(Integer status);

    boolean updateStatus(Long taskId, Integer status);

    boolean assignVolunteer(Long taskId, Long volunteerUserId);

    boolean completeTask(Long taskId, String completionNotes);

    List<VolunteerTask> selectPendingTasksByShelter(Long shelterId);

    List<VolunteerTask> selectTasksByDateRange(LocalDateTime startDate, LocalDateTime endDate);

    List<VolunteerTask> selectMyTasks(Long volunteerUserId, Integer status);
}