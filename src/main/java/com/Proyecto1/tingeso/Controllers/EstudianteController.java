package com.Proyecto1.tingeso.Controllers;
import com.Proyecto1.tingeso.Entities.Estudiante;
import com.Proyecto1.tingeso.Repositories.EstudianteRepository;
import com.Proyecto1.tingeso.Services.EstudianteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller @RequestMapping @CrossOrigin @RestController
public class EstudianteController {
    @Autowired
    EstudianteServices estudianteServices;
    @PostMapping("/estudiantes")

    public void insertEstudiante(@RequestBody Estudiante estudiante){
        estudianteServices.insertEstudiante(estudiante);
    }
}
