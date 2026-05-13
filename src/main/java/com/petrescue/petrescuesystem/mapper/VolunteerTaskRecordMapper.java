package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.VolunteerTaskRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface VolunteerTaskRecordMapper extends BaseMapper<VolunteerTaskRecord> {

    List<VolunteerTaskRecord> selectByTaskId(@Param("taskId") Long taskId);

    List<VolunteerTaskRecord> selectByUserId(@Param("userId") Long userId);

    List<VolunteerTaskRecord> selectByStatus(@Param("status") Integer status);

    VolunteerTaskRecord selectByTaskAndUser(
            @Param("taskId") Long taskId,
            @Param("userId") Long userId
    );

    IPage<VolunteerTaskRecord> selectTaskRecordPage(
            Page<VolunteerTaskRecord> page,
            @Param("taskId") Long taskId,
            @Param("userId") Long userId,
            @Param("status") Integer status
    );

    Integer countByTaskId(@Param("taskId") Long taskId);

    Integer countByUserId(@Param("userId") Long userId);

    Integer countByStatus(@Param("status") Integer status);

    Integer updateStatus(
            @Param("recordId") Long recordId,
            @Param("status") Integer status
    );

    Integer updateCheckIn(@Param("recordId") Long recordId);

    Integer updateCheckOut(
            @Param("recordId") Long recordId,
            @Param("hours") java.math.BigDecimal hours
    );

    List<VolunteerTaskRecord> selectRecentByUserId(
            @Param("userId") Long userId,
            @Param("limit") Integer limit
    );
}