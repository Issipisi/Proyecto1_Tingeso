package com.Proyecto1.tingeso.Services;
import com.Proyecto1.tingeso.Entities.Estudiante;
import com.Proyecto1.tingeso.Repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServices {
    @Autowired
    EstudianteRepository estudianteRepository;
    public void insertEstudiante(Estudiante estudiante){
        estudianteRepository.insertEstudiante(estudiante.getRut(), estudiante.getApellidos(), estudiante.getNombres(),
                estudiante.getF_nacimiento(), estudiante.getTipo_colegio_p(), estudiante.getNom_colegio(),
                estudiante.getAnyo_egreso_col(), estudiante.getTipo_pago());
    }

    public Estudiante selectEstudiante(String rut){
        //EstudianteRepository  estudianteRepository1 = new EstudianteRepository();
        Estudiante estudiante = estudianteRepository.selectEstudiante(rut);
        return estudiante;
    }
}
