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

    List<MedicalRecord> selectByAnimalId(@Param("animalId") Long animalId);

    IPage<MedicalRecord> selectMedicalRecordPage(
            Page<MedicalRecord> page,
            @Param("animalId") Long animalId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    List<MedicalRecord> selectByVisitDateRange(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    List<MedicalRecord> selectRecentByAnimalId(
            @Param("animalId") Long animalId,
            @Param("limit") Integer limit
    );

    Integer countByAnimalId(@Param("animalId") Long animalId);

    List<MedicalRecord> selectNeedFollowUp();

    List<MedicalRecord> selectByHospitalName(@Param("hospitalName") String hospitalName);

    List<MedicalRecord> selectByVetName(@Param("vetName") String vetName);

    List<MedicalRecord> searchByDiagnosis(@Param("keyword") String keyword);

    List<MedicalRecord> searchByTreatment(@Param("keyword") String keyword);

    Integer updateNextVisit(
            @Param("recordId") Long recordId,
            @Param("nextVisit") LocalDate nextVisit
    );

    Integer batchInsert(@Param("medicalRecords") List<MedicalRecord> medicalRecords);

    List<HospitalCount> countByHospital();

    List<VetCount> countByVet();

    MedicalRecordDetail selectMedicalRecordDetail(@Param("recordId") Long recordId);

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