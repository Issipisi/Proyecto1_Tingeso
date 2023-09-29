package com.Proyecto1.tingeso.Services;
import com.Proyecto1.tingeso.Entities.Estudiante;
import com.Proyecto1.tingeso.Repositories.CuotaRepository;
import com.Proyecto1.tingeso.Entities.Cuota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
public class CuotaServices {
    @Autowired
    CuotaRepository cuotaRepository;

    public void insertCuota(Cuota cuota){
        cuotaRepository.insertCuota(cuota.getValor(), cuota.getEstado(), cuota.getFecha_venc(), cuota.getRut());
    }

    //Tipo_colegio_p = 1 Municipal, 2 Subencionado, 3 Privado
    //tipo_pago = 0 al contado, 1 cuotas
    public void generarCuota(String rut){
        EstudianteServices estudianteServices = new EstudianteServices();
        Estudiante estudiante = estudianteServices.selectEstudiante(rut);
        System.out.println(estudiante.getNombres());



    }

}
