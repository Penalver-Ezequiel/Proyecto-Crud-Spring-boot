package com.irso.trabajopractico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irso.trabajopractico.entity.Alumno;

@Repository
public interface AlumnoRepositorio extends JpaRepository<Alumno,Integer> {
}
