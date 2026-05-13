package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.SupplyFlow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface SupplyFlowMapper extends BaseMapper<SupplyFlow> {

    List<SupplyFlow> selectBySupplyId(@Param("supplyId") Long supplyId);

    List<SupplyFlow> selectByChangeType(@Param("changeType") Integer changeType);

    List<SupplyFlow> selectByOperatorUserId(@Param("operatorUserId") Long operatorUserId);

    IPage<SupplyFlow> selectSupplyFlowPage(
            Page<SupplyFlow> page,
            @Param("supplyId") Long supplyId,
            @Param("changeType") Integer changeType,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

    List<SupplyFlow> selectByDateRange(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

    Integer countBySupplyId(@Param("supplyId") Long supplyId);

    List<SupplyFlow> selectRecentFlows(@Param("limit") Integer limit);
}