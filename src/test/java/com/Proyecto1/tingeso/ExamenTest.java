package com.Proyecto1.tingeso;

import com.Proyecto1.tingeso.Entities.Examenes;
import com.Proyecto1.tingeso.Services.ExamenesServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ExamenTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    ExamenesServices examenesServices;

    @Test
    void crearExamen(){
        Examenes examenes = new Examenes();

        examenes.setRut("20.581.478-7");
        examenes.setPuntaje(960);
        examenes.setFecha_exam(LocalDate.parse("2023-03-12"));

        examenesServices.insertExamenes(examenes);
        assertNotNull(examenesServices.selectExamenes("20.581.478-7"));
    }


}
