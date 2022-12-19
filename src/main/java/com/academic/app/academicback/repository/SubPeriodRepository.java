package com.academic.app.academicback.repository;

import com.academic.app.academicback.entity.PeriodEntity;
import com.academic.app.academicback.entity.SubPeriodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SubPeriodRepository extends JpaRepository<SubPeriodEntity,Long> {

    public List<SubPeriodEntity> findAllByName(String name);
}
