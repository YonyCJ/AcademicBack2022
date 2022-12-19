package com.academic.app.academicback.repository;

import com.academic.app.academicback.entity.CourseEntity;
import com.academic.app.academicback.entity.PeriodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PeriodRepository extends JpaRepository<PeriodEntity,Long> {

    public List<PeriodEntity> findAllByName(String name);
}
