package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.SupplyInventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface SupplyInventoryMapper extends BaseMapper<SupplyInventory> {

    List<SupplyInventory> selectByShelterId(@Param("shelterId") Long shelterId);

    List<SupplyInventory> selectByCategory(@Param("category") Integer category);

    List<SupplyInventory> selectLowStockItems(@Param("shelterId") Long shelterId);

    IPage<SupplyInventory> selectSupplyPage(
            Page<SupplyInventory> page,
            @Param("shelterId") Long shelterId,
            @Param("category") Integer category
    );

    Integer countByShelterId(@Param("shelterId") Long shelterId);

    Integer countByCategory(@Param("category") Integer category);

    Integer updateQuantity(
            @Param("supplyId") Long supplyId,
            @Param("quantity") Integer quantity
    );

    List<SupplyInventory> searchSupplies(@Param("keyword") String keyword);

    List<SupplyInventory> selectByShelterIdAndCategory(
            @Param("shelterId") Long shelterId,
            @Param("category") Integer category
    );
}