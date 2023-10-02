package com.Proyecto1.tingeso.Controllers;
import com.Proyecto1.tingeso.Entities.Examenes;
import com.Proyecto1.tingeso.Repositories.ExamenesRepository;
import com.Proyecto1.tingeso.Services.ExamenesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller @RequestMapping @CrossOrigin @RestController
public class ExamenesController {
    @Autowired
    ExamenesServices examenesServices;

    @PostMapping("/examenes")
    public ModelAndView insertExamenes(@RequestParam("puntaje") int puntaje,
                                       @RequestParam("fecha_exam") String fecha_exam,
                                       @RequestParam("rut") String rut){

        Examenes examenes = new Examenes();
        examenes.setPuntaje(puntaje);
        examenes.setFecha_exam(LocalDate.parse(fecha_exam));
        examenes.setRut(rut);

        examenesServices.insertExamenes(examenes);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("IndexAdmin");
        return modelAndView;
    }
}
