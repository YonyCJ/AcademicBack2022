package com.academic.app.academicback.repository;

import com.academic.app.academicback.entity.AcademicChargeEntity;
import com.academic.app.academicback.entity.AcademicPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AcademicPlanRepository extends JpaRepository<AcademicPlanEntity,Long> {

    public List<AcademicPlanEntity> findAllByName(String name);
}
