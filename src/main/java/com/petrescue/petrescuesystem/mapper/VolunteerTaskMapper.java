package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.VolunteerTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface VolunteerTaskMapper extends BaseMapper<VolunteerTask> {

    List<VolunteerTask> selectByShelterId(@Param("shelterId") Long shelterId);

    List<VolunteerTask> selectByTaskType(@Param("taskType") Integer taskType);

    List<VolunteerTask> selectByStatus(@Param("status") Integer status);

    List<VolunteerTask> selectByCreatedBy(@Param("createdBy") Long createdBy);

    IPage<VolunteerTask> selectTaskPage(
            Page<VolunteerTask> page,
            @Param("shelterId") Long shelterId,
            @Param("taskType") Integer taskType,
            @Param("status") Integer status
    );

    Integer countByShelterId(@Param("shelterId") Long shelterId);

    Integer countByStatus(@Param("status") Integer status);

    Integer updateStatus(
            @Param("taskId") Long taskId,
            @Param("status") Integer status
    );

    Integer updateCurrentCount(@Param("taskId") Long taskId);

    List<VolunteerTask> selectUpcomingTasks();

    List<VolunteerTask> selectRecentTasks(@Param("limit") Integer limit);

    List<VolunteerTask> selectByVolunteerUserId(@Param("volunteerUserId") Long volunteerUserId);

    Integer countByVolunteerUserId(@Param("volunteerUserId") Long volunteerUserId);

    IPage<VolunteerTask> selectVolunteerTaskPage(
            Page<VolunteerTask> page,
            @Param("shelterId") Long shelterId,
            @Param("volunteerUserId") Long volunteerUserId,
            @Param("status") Integer status,
            @Param("taskType") Integer taskType
    );

    Integer assignVolunteer(
            @Param("taskId") Long taskId,
            @Param("volunteerUserId") Long volunteerUserId
    );

    Integer completeTask(
            @Param("taskId") Long taskId,
            @Param("completionNotes") String completionNotes
    );

    List<VolunteerTask> selectPendingTasksByShelter(@Param("shelterId") Long shelterId);

    List<VolunteerTask> selectTasksByDateRange(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

    List<VolunteerTask> selectMyTasks(
            @Param("volunteerUserId") Long volunteerUserId,
            @Param("status") Integer status
    );
}