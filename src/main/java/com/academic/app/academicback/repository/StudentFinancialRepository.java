package com.academic.app.academicback.repository;

import com.academic.app.academicback.entity.StudentEntity;
import com.academic.app.academicback.entity.StudentFinancialManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentFinancialRepository extends JpaRepository<StudentFinancialManagerEntity,Long> {

    public List<StudentFinancialManagerEntity> findAllById (Long id);


}
