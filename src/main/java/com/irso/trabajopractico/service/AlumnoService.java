package com.irso.trabajopractico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irso.trabajopractico.entity.Alumno;
import com.irso.trabajopractico.repository.AlumnoRepositorio;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepositorio alumnoRepositorio;

    public List<Alumno> listAll(){
        return alumnoRepositorio.findAll();
    }

    public void save(Alumno alumno){
        alumnoRepositorio.save(alumno);
    }

    public Alumno getAlumnoId(int id){
        return alumnoRepositorio.findById(id).get();
    }

    public void deleteById(int id){
        alumnoRepositorio.deleteById(id);
    }
}
