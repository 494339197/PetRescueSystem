package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.AdoptionApplication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface AdoptionApplicationMapper extends BaseMapper<AdoptionApplication> {
    
    /**
     * 根据动物ID查询领养申请列表
     * @param animalId 动物ID
     * @return 领养申请列表
     */
    List<AdoptionApplication> selectByAnimalId(@Param("animalId") Long animalId);
    
    /**
     * 根据申请人ID查询领养申请列表
     * @param applicantUserId 申请人ID
     * @return 领养申请列表
     */
    List<AdoptionApplication> selectByApplicantUserId(@Param("applicantUserId") Long applicantUserId);
    
    /**
     * 根据状态查询领养申请列表
     * @param status 申请状态
     * @return 领养申请列表
     */
    List<AdoptionApplication> selectByStatus(@Param("status") Integer status);
    
    /**
     * 分页查询领养申请列表
     * @param page 分页参数
     * @param animalId 动物ID（可选）
     * @param applicantUserId 申请人ID（可选）
     * @param status 申请状态（可选）
     * @return 分页结果
     */
    IPage<AdoptionApplication> selectApplicationPage(
            Page<AdoptionApplication> page,
            @Param("animalId") Long animalId,
            @Param("applicantUserId") Long applicantUserId,
            @Param("status") Integer status
    );
    
    /**
     * 统计指定动物的申请数量
     * @param animalId 动物ID
     * @return 申请数量
     */
    Integer countByAnimalId(@Param("animalId") Long animalId);
    
    /**
     * 统计指定用户的申请数量
     * @param applicantUserId 申请人ID
     * @return 申请数量
     */
    Integer countByApplicantUserId(@Param("applicantUserId") Long applicantUserId);
    
    /**
     * 更新申请状态
     * @param applicationId 申请ID
     * @param status 新状态
     * @param reviewedBy 审核人ID
     * @param reviewNotes 审核备注
     * @return 影响行数
     */
    Integer updateStatus(
            @Param("applicationId") Long applicationId,
            @Param("status") Integer status,
            @Param("reviewedBy") Long reviewedBy,
            @Param("reviewNotes") String reviewNotes
    );
    
    /**
     * 查询指定动物的待处理申请
     * @param animalId 动物ID
     * @return 待处理申请列表
     */
    List<AdoptionApplication> selectPendingApplicationsByAnimalId(@Param("animalId") Long animalId);
    
    /**
     * 查询用户最近提交的申请
     * @param applicantUserId 申请人ID
     * @param limit 限制数量
     * @return 最近申请列表
     */
    List<AdoptionApplication> selectRecentApplicationsByUser(
            @Param("applicantUserId") Long applicantUserId,
            @Param("limit") Integer limit
    );
}