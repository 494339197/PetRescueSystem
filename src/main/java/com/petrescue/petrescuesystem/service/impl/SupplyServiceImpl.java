package com.petrescue.petrescuesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.SupplyInventory;
import com.petrescue.petrescuesystem.entity.SupplyFlow;
import com.petrescue.petrescuesystem.mapper.SupplyInventoryMapper;
import com.petrescue.petrescuesystem.mapper.SupplyFlowMapper;
import com.petrescue.petrescuesystem.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SupplyServiceImpl implements SupplyService {

    @Autowired
    private SupplyInventoryMapper supplyInventoryMapper;

    @Autowired
    private SupplyFlowMapper supplyFlowMapper;

    @Override
    public SupplyInventory getSupplyById(Long supplyId) {
        return supplyInventoryMapper.selectById(supplyId);
    }

    @Override
    public boolean saveSupply(SupplyInventory supply) {
        return supplyInventoryMapper.insert(supply) > 0;
    }

    @Override
    public boolean updateSupplyById(SupplyInventory supply) {
        return supplyInventoryMapper.updateById(supply) > 0;
    }

    @Override
    public boolean removeSupplyById(Long supplyId) {
        return supplyInventoryMapper.deleteById(supplyId) > 0;
    }

    @Override
    public List<SupplyInventory> selectByShelterId(Long shelterId) {
        return supplyInventoryMapper.selectByShelterId(shelterId);
    }

    @Override
    public List<SupplyInventory> selectByCategory(Integer category) {
        return supplyInventoryMapper.selectByCategory(category);
    }

    @Override
    public List<SupplyInventory> selectLowStockItems(Long shelterId) {
        return supplyInventoryMapper.selectLowStockItems(shelterId);
    }

    @Override
    public IPage<SupplyInventory> selectSupplyPage(Page<SupplyInventory> page, Long shelterId, Integer category) {
        return supplyInventoryMapper.selectSupplyPage(page, shelterId, category);
    }

    @Override
    public Integer countByShelterId(Long shelterId) {
        return supplyInventoryMapper.countByShelterId(shelterId);
    }

    @Override
    public Integer countByCategory(Integer category) {
        return supplyInventoryMapper.countByCategory(category);
    }

    @Override
    public boolean updateQuantity(Long supplyId, Integer quantity) {
        return supplyInventoryMapper.updateQuantity(supplyId, quantity) > 0;
    }

    @Override
    public List<SupplyInventory> searchSupplies(String keyword) {
        return supplyInventoryMapper.searchSupplies(keyword);
    }

    @Override
    public List<SupplyInventory> selectByShelterIdAndCategory(Long shelterId, Integer category) {
        return supplyInventoryMapper.selectByShelterIdAndCategory(shelterId, category);
    }

    @Override
    public SupplyFlow getFlowById(Long flowId) {
        return supplyFlowMapper.selectById(flowId);
    }

    @Override
    public boolean saveFlow(SupplyFlow flow) {
        return supplyFlowMapper.insert(flow) > 0;
    }

    @Override
    public List<SupplyFlow> selectFlowBySupplyId(Long supplyId) {
        return supplyFlowMapper.selectBySupplyId(supplyId);
    }

    @Override
    public List<SupplyFlow> selectFlowByChangeType(Integer changeType) {
        return supplyFlowMapper.selectByChangeType(changeType);
    }

    @Override
    public IPage<SupplyFlow> selectSupplyFlowPage(Page<SupplyFlow> page, Long supplyId, Integer changeType, LocalDateTime startDate, LocalDateTime endDate) {
        return supplyFlowMapper.selectSupplyFlowPage(page, supplyId, changeType, startDate, endDate);
    }

    @Override
    public List<SupplyFlow> selectRecentFlows(Integer limit) {
        return supplyFlowMapper.selectRecentFlows(limit);
    }
}