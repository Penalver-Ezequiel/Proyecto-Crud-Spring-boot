package com.irso.trabajopractico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.irso.trabajopractico.entity.Alumno;
import com.irso.trabajopractico.service.AlumnoService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AlumnoControlador {

    @Autowired
    AlumnoService alumnoService;

    @RequestMapping("/alumno") 
    public String verAlumno(Model model) {
        //Al objeto de la lista de alumnos lista le asignamos el metodo para traer todos los alumnos
        List<Alumno> lista = alumnoService.listAll();
        //"lista": Es la clave, un identificador de string que usaremos en la vista para acceder al objeto Alumno, 
        // lista : Es el objeto que estás pasando a la vista para recorrer los alumnos.
        model.addAttribute("lista", lista);
        return "index"; //Retorna en la vista index
    }

    @RequestMapping("/nuevo")
    public String agregarAlumno(Model model){
        //Creamos un objeto alumno con la clase Alumno
        Alumno alumno = new Alumno();
        //"alumno": Es la clave, un identificador de string que usaremos en la vista para acceder al objeto Alumno 
        // alumno : Es el objeto que estás pasando a la vista.
        model.addAttribute("alumno", alumno);
        return "nuevo_alumno"; //retorna en la vista nuevo_alumno
    }
    //Solicitudes POST: Enviar datos al servidor para crear o actualizar un recurso.
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    //@ModelAttribute: Esta anotación vincula el objeto Alumno del modelo a los datos del formulario enviados en la solicitud. 
    //El nombre "alumno" se utiliza para encontrar los datos en el formulario.
    //Se crea un objeto alumno de la Clase Alumno para guardar
    public String guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {        
    //utiliza el metodo guardar y el objeto alumno  
        alumnoService.save(alumno);
        return "redirect:/alumno"; //nos redirige a alumno
    }
    
    @RequestMapping("/editar/{id}")
    //el model and view propociona una vista en base a parametros de id
    public ModelAndView editarAlumno(@PathVariable(name="id") int id){
    // Crear una nueva instancia de ModelAndView, especificando la vista "editar_alumno"
    ModelAndView model = new ModelAndView("editar_alumno");
    // Obtener el alumno con el ID especificado
    Alumno alumno = alumnoService.getAlumnoId(id);
    // Añadir el objeto Alumno al modelo
    model.addObject("alumno",alumno);
    // Retornar el ModelAndView
    return model;
    }
    
    @RequestMapping("/eliminar/{id}")
    //el metodo eliminarAlumno utiliza parametros id para eliminar el alumno deseado
    public String eliminarAlumno(@PathVariable(name="id") int id) {
    //utiliza el metodo deleteById del servicio con parametro id
    alumnoService.deleteById(id);
    return "redirect:/alumno"; //Nos redirige a la vista alumno 
    }
    
}
