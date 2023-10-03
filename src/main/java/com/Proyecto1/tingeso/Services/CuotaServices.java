package com.Proyecto1.tingeso.Services;
import com.Proyecto1.tingeso.Entities.Estudiante;
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

    public void insertCuota(Cuota cuota){
        cuotaRepository.insertCuota(cuota.getValor(), cuota.getEstado(), cuota.getFecha_venc(), cuota.getRut(),
                cuota.getCant_cuotas());
    }

    //Tipo_colegio_p = 1 Municipal, 2 Subencionado, 3 Privado
    //tipo_pago = 0 al contado, 1 cuotas
    public void generarCuota(String rut){
        Estudiante estudiante = estudianteServices.selectEstudiante(rut);

        //Inicialización de variables
        int arancelAnual = 1500000;
        int matricula = 70000;
        int anyoActual = 2023;
        int maxCuotas = 0;

        //Llamado variables
        int tipoPago = estudiante.getTipo_pago();
        int tipoColegio = estudiante.getTipo_colegio_p();
        int anyoEgreso = estudiante.getAnyo_egreso_col();


        fddfdfd


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


    }
    public int cuotasMaximas(int arancelAnual, Estudiante estudiante, int maxCuotas){
        Estudiante alumno = estudiante;

        int tipoColegio = alumno.getTipo_colegio_p();
        //Maximo de Cuotas x Tipo de Colegio
        switch (tipoColegio) {
            case 1:
                maxCuotas = 10;
                break;
            case 2:
                maxCuotas = 7;
                break;

            case 3:
                maxCuotas = 4;
                break;
            default:
                break;
        }
        return maxCuotas;
    }

    public int descuentosPrincipales(int arancelAnual, Estudiante estudiante){
        Estudiante alumno = estudiante;

        int tipoPago = alumno.getTipo_pago();
        int tipoColegio = alumno.getTipo_colegio_p();

        //Descuento x pago al Contado
        int arancelActualizado = arancelAnual;

        if (tipoPago == 0) {
            arancelActualizado -= (arancelAnual * 0.5);
        }
        //Descuento x Tipo de Colegio
        else {
            if (tipoColegio == 1) {
                arancelActualizado -= (arancelAnual * 0.2);
            } else if (tipoColegio == 2) {
                arancelActualizado -= (arancelAnual * 0.1);
            }
        }
        return arancelActualizado;
    }

    public int descuentosAnyoIngreso( int arancelAnual, Estudiante estudiante, int anyoActual){
        Estudiante alumno = estudiante;

        int tipoPago = alumno.getTipo_pago();
        int tipoColegio = alumno.getTipo_colegio_p();

        int anyoEgreso = anyoActual - anyoEgreso;
        int descuento = 0;

        if(anyoEgreso >= 3 && anyoEgreso <= 4) {
            descuento = 40;
        } else if(anyoEgreso >= 1 && anyoEgreso <= 2) {
            descuento = 80;
        } else if(anyoEgreso < 1) {
            descuento = 15;
        }

        arancelAnual -= (arancelAnual * descuento / 100);
        System.out.println(arancelAnual);
    }

}
