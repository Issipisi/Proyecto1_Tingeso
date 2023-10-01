package com.Proyecto1.tingeso.Controllers;
import com.Proyecto1.tingeso.Entities.Estudiante;
import com.Proyecto1.tingeso.Services.EstudianteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller @RequestMapping @CrossOrigin @RestController
public class EstudianteController {
    @Autowired
    EstudianteServices estudianteServices;

    @PostMapping("/estudiantes")
    public ModelAndView insertEstudiante(@RequestParam("nombres") String nombres,
                                         @RequestParam("apellidos") String apellidos,
                                         @RequestParam("rut") String rut,
                                         @RequestParam("f_nacimiento") String f_nacimiento,
                                         @RequestParam("tipo_colegio_p") int tipo_colegio_p,
                                         @RequestParam("nom_colegio") String nom_colegio,
                                         @RequestParam("anyo_egreso_col") int anyo_egreso_col,
                                         @RequestParam("tipo_pago") int tipo_pago){

        Estudiante estudiante = new Estudiante();
        estudiante.setApellidos(apellidos);
        estudiante.setNombres(nombres);
        estudiante.setRut(rut);
        estudiante.setF_nacimiento(LocalDate.parse(f_nacimiento));
        estudiante.setNom_colegio(nom_colegio);
        estudiante.setTipo_colegio_p(tipo_colegio_p);
        estudiante.setTipo_pago(tipo_pago);
        estudiante.setAnyo_egreso_col(anyo_egreso_col);

        estudianteServices.insertEstudiante(estudiante);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Index");
        return modelAndView;
    }
}
