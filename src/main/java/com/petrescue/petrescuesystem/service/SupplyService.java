package com.petrescue.petrescuesystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.SupplyInventory;
import com.petrescue.petrescuesystem.entity.SupplyFlow;
import java.time.LocalDateTime;
import java.util.List;

public interface SupplyService {

    SupplyInventory getSupplyById(Long supplyId);

    boolean saveSupply(SupplyInventory supply);

    boolean updateSupplyById(SupplyInventory supply);

    boolean removeSupplyById(Long supplyId);

    List<SupplyInventory> selectByShelterId(Long shelterId);

    List<SupplyInventory> selectByCategory(Integer category);

    List<SupplyInventory> selectLowStockItems(Long shelterId);

    IPage<SupplyInventory> selectSupplyPage(Page<SupplyInventory> page, Long shelterId, Integer category);

    Integer countByShelterId(Long shelterId);

    Integer countByCategory(Integer category);

    boolean updateQuantity(Long supplyId, Integer quantity);

    List<SupplyInventory> searchSupplies(String keyword);

    List<SupplyInventory> selectByShelterIdAndCategory(Long shelterId, Integer category);

    SupplyFlow getFlowById(Long flowId);

    boolean saveFlow(SupplyFlow flow);

    List<SupplyFlow> selectFlowBySupplyId(Long supplyId);

    List<SupplyFlow> selectFlowByChangeType(Integer changeType);

    IPage<SupplyFlow> selectSupplyFlowPage(Page<SupplyFlow> page, Long supplyId, Integer changeType, LocalDateTime startDate, LocalDateTime endDate);

    List<SupplyFlow> selectRecentFlows(Integer limit);
}