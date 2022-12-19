package com.academic.app.academicback.repository;

import com.academic.app.academicback.entity.AcademicChargeDetailEntity;
import com.academic.app.academicback.entity.AcademicChargeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AcademicChargeDetailRepository extends JpaRepository<AcademicChargeDetailEntity,Long> {

    public List<AcademicChargeDetailEntity> findAllByCourseName(String name);
}
