package com.Proyecto1.tingeso;

import com.Proyecto1.tingeso.Entities.Cuota;
import com.Proyecto1.tingeso.Services.CuotaServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CuotasTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    CuotaServices cuotaServices;

    @Test
    void crearCuota(){
        Cuota cuota = new Cuota();

        cuotaServices.generarCuota("20.581.478-7");
        assertNotNull(cuotaServices.listarCuotas("20.581.478-7"));
    }

    @Test
    void crearCuota1(){
        Cuota cuota = new Cuota();

        cuotaServices.generarCuota("12.345.678-9");
        assertNotNull(cuotaServices.listarCuotas("12.345.678-9"));
    }

    @Test
    void crearCuota2(){
        Cuota cuota = new Cuota();

        cuotaServices.generarCuota("12.235.569-7");
        assertNotNull(cuotaServices.listarCuotas("12.235.569-7"));
    }

    @Test
    void descuentoCuota(){
        Cuota cuota = new Cuota();

        cuotaServices.descuentoPuntajeExamen(7, 2023,"20.581.478-7");
        assertNotNull(cuotaServices.listarCuotas("20.581.478-7"));
    }

    @Test
    void descuentoCuota1(){
        Cuota cuota = new Cuota();

        cuotaServices.descuentoPuntajeExamen(6, 2023,"20.581.478-7");
        assertNotNull(cuotaServices.listarCuotas("20.581.478-7"));
    }

    @Test
    void descuentoCuota2(){
        Cuota cuota = new Cuota();

        cuotaServices.descuentoPuntajeExamen(12, 2023,"20.581.478-7");
        assertNotNull(cuotaServices.listarCuotas("20.581.478-7"));
    }

    @Test
    void descuentoCuota3(){
        Cuota cuota = new Cuota();

        cuotaServices.descuentoPuntajeExamen(5, 2023,"20.581.478-7");
        assertNotNull(cuotaServices.listarCuotas("20.581.478-7"));
    }

    @Test
    void pagarCuota(){
        Cuota cuota = new Cuota();

        cuotaServices.pagarCuota(1L);
        assertNotNull(cuotaServices.listarCuotas("20.581.478-7"));
    }
}

