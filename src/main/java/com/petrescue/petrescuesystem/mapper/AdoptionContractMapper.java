package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.AdoptionContract;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDate;
import java.util.List;

@Mapper
public interface AdoptionContractMapper extends BaseMapper<AdoptionContract> {
    
    /**
     * 根据申请ID查询领养合同
     * @param applicationId 申请ID
     * @return 领养合同
     */
    AdoptionContract selectByApplicationId(@Param("applicationId") Long applicationId);
    
    /**
     * 根据合同编号查询领养合同
     * @param contractNo 合同编号
     * @return 领养合同
     */
    AdoptionContract selectByContractNo(@Param("contractNo") String contractNo);
    
    /**
     * 分页查询领养合同列表
     * @param page 分页参数
     * @param contractNo 合同编号（可选）
     * @param startDate 开始日期（可选）
     * @param endDate 结束日期（可选）
     * @return 分页结果
     */
    IPage<AdoptionContract> selectContractPage(
            Page<AdoptionContract> page,
            @Param("contractNo") String contractNo,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
    
    /**
     * 查询指定日期范围内的领养合同
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 领养合同列表
     */
    List<AdoptionContract> selectBySignDateRange(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
    
    /**
     * 查询试用期即将结束的合同
     * @param days 剩余天数
     * @return 试用期即将结束的合同列表
     */
    List<AdoptionContract> selectTrialEndingContracts(@Param("days") Integer days);
    
    /**
     * 查询已过试用期的合同
     * @return 已过试用期的合同列表
     */
    List<AdoptionContract> selectExpiredTrialContracts();
    
    /**
     * 更新合同文件URL
     * @param contractId 合同ID
     * @param fileUrl 文件URL
     * @return 影响行数
     */
    Integer updateFileUrl(
            @Param("contractId") Long contractId,
            @Param("fileUrl") String fileUrl
    );
    
    /**
     * 更新领养人签名URL
     * @param contractId 合同ID
     * @param adopterSignUrl 领养人签名URL
     * @return 影响行数
     */
    Integer updateAdopterSignUrl(
            @Param("contractId") Long contractId,
            @Param("adopterSignUrl") String adopterSignUrl
    );
    
    /**
     * 更新救助站签名URL
     * @param contractId 合同ID
     * @param shelterSignUrl 救助站签名URL
     * @return 影响行数
     */
    Integer updateShelterSignUrl(
            @Param("contractId") Long contractId,
            @Param("shelterSignUrl") String shelterSignUrl
    );
    
    /**
     * 统计指定日期范围内的合同数量
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 合同数量
     */
    Integer countBySignDateRange(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
    
    /**
     * 查询最近签订的合同
     * @param limit 限制数量
     * @return 最近签订的合同列表
     */
    List<AdoptionContract> selectRecentContracts(@Param("limit") Integer limit);
}