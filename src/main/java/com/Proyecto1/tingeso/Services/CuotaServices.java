package com.Proyecto1.tingeso.Services;
import com.Proyecto1.tingeso.Entities.Estudiante;
import com.Proyecto1.tingeso.Entities.Examenes;
import com.Proyecto1.tingeso.Repositories.CuotaRepository;
import com.Proyecto1.tingeso.Entities.Cuota;
import org.hibernate.cache.spi.support.AbstractNaturalIdDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
public class CuotaServices {
    @Autowired
    CuotaRepository cuotaRepository;
    @Autowired
    EstudianteServices estudianteServices;
    @Autowired
    ExamenesServices examenesServices;
    public void insertCuota(Cuota cuota){
        cuotaRepository.insertCuota(cuota.getValor(), cuota.getEstado(), cuota.getFecha_venc(), cuota.getRut(),
                cuota.getCant_cuotas());
    }

    //Tipo_colegio_p = 1 Municipal, 2 Subencionado, 3 Privado
    //tipo_pago = 0 al contado, 1 cuotas
    public void generarCuota(String rut){
        Estudiante estudiante = estudianteServices.selectEstudiante(rut);
        //Examenes examenes = examenesServices.selectExamenes(rut);

       // String rutt = examenes.getRut();
        //System.out.println(rutt);

        //Inicialización de variables
        int arancelAnual = 1500000;
        int matricula = 70000;
        int anyoActual = 2023;
        int maxCuotas = 0;

        //Llamado variables
        int tipoPago = estudiante.getTipo_pago();
        int tipoColegio = estudiante.getTipo_colegio_p();
        int anyoEgreso = estudiante.getAnyo_egreso_col();


        //Descuento x pago al Contado
        if(tipoPago == 0) {
            arancelAnual = (int) (arancelAnual - (arancelAnual * 0.5));
            System.out.println(arancelAnual);
        }
        //Descuento x Tipo de Colegio
        else{
            if (tipoColegio == 1){
                arancelAnual = (int) (arancelAnual - (arancelAnual * 0.2));
                System.out.println(arancelAnual);
            } else if (tipoColegio == 2) {
                arancelAnual = (int) (arancelAnual - (arancelAnual * 0.1));
                System.out.println(arancelAnual);
            }
        }

        //Descuento x Año de Egreso
        anyoEgreso = anyoActual - anyoEgreso;
        if(anyoEgreso < 1){
            arancelAnual = (int) (arancelAnual - (arancelAnual * 0.15));
            System.out.println(arancelAnual);
        } else if (anyoEgreso == 1 || anyoEgreso == 2) {
            arancelAnual = (int) (arancelAnual - (arancelAnual * 0.8));
            System.out.println(arancelAnual);
        } else if (anyoEgreso == 3 || anyoEgreso == 4) {
            arancelAnual = (int) (arancelAnual - (arancelAnual * 0.4));
            System.out.println(arancelAnual);
        }

        //Maximo de Cuotas x Tipo de Colegio
        if (tipoColegio == 1){
            maxCuotas = 10;
            System.out.println(maxCuotas);
        } else if (tipoColegio == 2) {
            maxCuotas = 7;
            System.out.println(maxCuotas);
        } else{
            maxCuotas = 4;
            System.out.println(maxCuotas);
        }
    }

}
