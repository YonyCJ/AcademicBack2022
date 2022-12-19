package com.academic.app.academicback.repository;

import com.academic.app.academicback.entity.GradeEntity;
import com.academic.app.academicback.entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RegisterRepository extends JpaRepository<RegisterEntity,Long> {

    public List<RegisterEntity> findAllByStudentCode(String code);
}
