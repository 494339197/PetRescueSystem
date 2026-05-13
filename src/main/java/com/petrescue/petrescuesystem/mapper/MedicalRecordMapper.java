package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.MedicalRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDate;
import java.util.List;

@Mapper
public interface MedicalRecordMapper extends BaseMapper<MedicalRecord> {
    
    /**
     * 根据动物ID查询医疗记录
     * @param animalId 动物ID
     * @return 医疗记录列表
     */
    List<MedicalRecord> selectByAnimalId(@Param("animalId") Long animalId);
    
    /**
     * 分页查询医疗记录
     * @param page 分页参数
     * @param animalId 动物ID（可选）
     * @param startDate 开始日期（可选）
     * @param endDate 结束日期（可选）
     * @return 分页结果
     */
    IPage<MedicalRecord> selectMedicalRecordPage(
            Page<MedicalRecord> page,
            @Param("animalId") Long animalId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
    
    /**
     * 查询指定日期范围内的医疗记录
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 医疗记录列表
     */
    List<MedicalRecord> selectByVisitDateRange(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
    
    /**
     * 查询动物的最近医疗记录
     * @param animalId 动物ID
     * @param limit 限制数量
     * @return 最近医疗记录列表
     */
    List<MedicalRecord> selectRecentByAnimalId(
            @Param("animalId") Long animalId,
            @Param("limit") Integer limit
    );
    
    /**
     * 统计动物的医疗记录数量
     * @param animalId 动物ID
     * @return 医疗记录数量
     */
    Integer countByAnimalId(@Param("animalId") Long animalId);
    
    /**
     * 查询需要复诊的医疗记录
     * @return 需要复诊的医疗记录列表
     */
    List<MedicalRecord> selectNeedFollowUp();
    
    /**
     * 查询指定医院的所有医疗记录
     * @param hospitalName 医院名称
     * @return 医疗记录列表
     */
    List<MedicalRecord> selectByHospitalName(@Param("hospitalName") String hospitalName);
    
    /**
     * 查询指定兽医的所有医疗记录
     * @param vetName 兽医名称
     * @return 医疗记录列表
     */
    List<MedicalRecord> selectByVetName(@Param("vetName") String vetName);
    
    /**
     * 根据诊断关键词搜索医疗记录
     * @param keyword 关键词
     * @return 医疗记录列表
     */
    List<MedicalRecord> searchByDiagnosis(@Param("keyword") String keyword);
    
    /**
     * 根据治疗关键词搜索医疗记录
     * @param keyword 关键词
     * @return 医疗记录列表
     */
    List<MedicalRecord> searchByTreatment(@Param("keyword") String keyword);
    
    /**
     * 更新复诊日期
     * @param recordId 记录ID
     * @param nextVisit 复诊日期
     * @return 影响行数
     */
    Integer updateNextVisit(
            @Param("recordId") Long recordId,
            @Param("nextVisit") LocalDate nextVisit
    );
    
    /**
     * 批量插入医疗记录
     * @param medicalRecords 医疗记录列表
     * @return 影响行数
     */
    Integer batchInsert(@Param("medicalRecords") List<MedicalRecord> medicalRecords);
    
    /**
     * 统计各医院的医疗记录数量
     * @return 各医院医疗记录数量统计
     */
    List<HospitalCount> countByHospital();
    
    /**
     * 统计各兽医的医疗记录数量
     * @return 各兽医医疗记录数量统计
     */
    List<VetCount> countByVet();
    
    /**
     * 查询医疗记录详情（包含动物信息）
     * @param recordId 记录ID
     * @return 医疗记录详情
     */
    MedicalRecordDetail selectMedicalRecordDetail(@Param("recordId") Long recordId);
    
    /**
     * 医院统计结果类
     */
    class HospitalCount {
        private String hospitalName;
        private Long count;
        
        public HospitalCount() {}
        
        public HospitalCount(String hospitalName, Long count) {
            this.hospitalName = hospitalName;
            this.count = count;
        }
        
        public String getHospitalName() { return hospitalName; }
        public void setHospitalName(String hospitalName) { this.hospitalName = hospitalName; }
        public Long getCount() { return count; }
        public void setCount(Long count) { this.count = count; }
    }
    
    /**
     * 兽医统计结果类
     */
    class VetCount {
        private String vetName;
        private Long count;
        
        public VetCount() {}
        
        public VetCount(String vetName, Long count) {
            this.vetName = vetName;
            this.count = count;
        }
        
        public String getVetName() { return vetName; }
        public void setVetName(String vetName) { this.vetName = vetName; }
        public Long getCount() { return count; }
        public void setCount(Long count) { this.count = count; }
    }
    
    /**
     * 医疗记录详情类（包含动物信息）
     */
    class MedicalRecordDetail extends MedicalRecord {
        private String animalName;
        private String species;
        private String breed;
        
        public String getAnimalName() { return animalName; }
        public void setAnimalName(String animalName) { this.animalName = animalName; }
        public String getSpecies() { return species; }
        public void setSpecies(String species) { this.species = species; }
        public String getBreed() { return breed; }
        public void setBreed(String breed) { this.breed = breed; }
    }
}