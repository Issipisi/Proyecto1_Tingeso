package com.Proyecto1.tingeso;

import com.Proyecto1.tingeso.Entities.Estudiante;
import com.Proyecto1.tingeso.Services.EstudianteServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class EstudianteTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    EstudianteServices estudianteServices;

    @Test
     void IngresarEstudiante(){
        Estudiante estudiante = new Estudiante();
        estudiante.setNombres("María Jesús");
        estudiante.setApellidos("Romero Riquelme");
        estudiante.setRut("19.506.236-1");
        estudiante.setF_nacimiento(LocalDate.parse("2000-01-12"));
        estudiante.setNom_colegio("Nido de Águilas");
        estudiante.setAnyo_egreso_col(2021);
        estudiante.setTipo_colegio_p(1);
        estudiante.setTipo_pago(0);

        estudianteServices.insertEstudiante(estudiante);
        assertNotNull(estudianteServices.selectEstudiante("19.506.236-1"));
    }



}
