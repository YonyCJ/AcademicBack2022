package com.academic.app.academicback.repository;

import com.academic.app.academicback.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TeacherRepository extends JpaRepository<TeacherEntity,Long> {

    public List<TeacherEntity> findAllByPersonName(String name);
}
