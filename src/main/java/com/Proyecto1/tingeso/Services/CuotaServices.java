package com.Proyecto1.tingeso.Services;
import com.Proyecto1.tingeso.Entities.Estudiante;
import com.Proyecto1.tingeso.Repositories.CuotaRepository;
import com.Proyecto1.tingeso.Entities.Cuota;
import com.Proyecto1.tingeso.Repositories.ExamenesRepository;
import org.hibernate.cache.spi.support.AbstractNaturalIdDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;

@Service
public class CuotaServices {
    @Autowired
    CuotaRepository cuotaRepository;
    @Autowired
    ExamenesRepository examenesRepository;
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
        Cuota cuota = new Cuota();
        int mes = 3;
        int cuotasMax = cuotasMaximas(estudiante, 0);
        int descPrincipales = descuentosPrincipales(1500000, estudiante);
        int descAnyoIngreso = descuentosAnyoIngreso(descPrincipales, estudiante, 2023);
        int valorCuota = (int)(descAnyoIngreso/cuotasMax);
        int descPuntajeExam = descuentoPuntajeExamen(mes,2023, rut);


        cuota.setValor(valorCuota);
        cuota.setEstado(0);     // 0 No pagado - 1 Pagado
        cuota.setCant_cuotas(cuotasMax);
        cuota.setRut(rut);

        for (int i = 0; i < cuotasMax; i++){
            cuota.setFecha_venc(LocalDate.of(2023,mes,10));
            insertCuota(cuota);
            mes++;
            if(mes>12){
                mes = 3;
            }
        }
    }

    public int actualizarCuota(int valor, Long id){
        return 1;
    }

    //public int interesCuotas(Estudiante estudiante){}

    public int descuentoPuntajeExamen(int mes, int anyo, String rut){
        int promedio = examenesRepository.getPromedio(rut, anyo, mes);
        if (promedio >= 950 || 1000 >= promedio){
            return 10;
        }else if (promedio >= 900 || promedio < 949) {
            return 5;
        } else if (promedio >= 850 || promedio < 899) {
            return 2;
        }else{
            return 0;
        }
    }


    public int cuotasMaximas( Estudiante estudiante, int maxCuotas){
        int tipoColegio = estudiante.getTipo_colegio_p();
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
        int tipoPago = estudiante.getTipo_pago();
        int tipoColegio = estudiante.getTipo_colegio_p();

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
        int tipoPago = estudiante.getTipo_pago();
        int anyoEgreso = estudiante.getAnyo_egreso_col();

        anyoEgreso = anyoActual - anyoEgreso;
        int descuento = 0;

        if(tipoPago == 0){
            return arancelAnual;
        }else {
            if(anyoEgreso == 3 || anyoEgreso == 4) {
                descuento = 40;
            } else if(anyoEgreso == 1 || anyoEgreso == 2) {
                descuento = 80;
            } else if(anyoEgreso < 1) {
                descuento = 15;
            }
            arancelAnual -= (arancelAnual * descuento / 100);
            return arancelAnual;
        }

    }

    public List<Cuota> listarCuotas(String rut){
        return cuotaRepository.getCuota(rut);
    }
    public void pagarCuota( Long id){
        cuotaRepository.pagarCuota( id);
    }
}
