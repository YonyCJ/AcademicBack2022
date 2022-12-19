package com.academic.app.academicback.repository;

import com.academic.app.academicback.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CourseRepository extends JpaRepository<CourseEntity,Long> {

    public List<CourseEntity> findAllByName(String name);
}
