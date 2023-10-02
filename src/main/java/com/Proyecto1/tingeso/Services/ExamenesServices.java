package com.Proyecto1.tingeso.Services;
import com.Proyecto1.tingeso.Entities.Examenes;
import com.Proyecto1.tingeso.Repositories.ExamenesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamenesServices {
    @Autowired
    ExamenesRepository examenesRepository;
    public void insertExamenes(Examenes examenes){
        examenesRepository.insertExamenes(examenes.getPuntaje(), examenes.getFecha_exam(), examenes.getRut());
    }

    public Examenes selectExamenes(String rut){
        Examenes examenes = new Examenes();
        examenes = examenesRepository.selectExamenes(rut);
        return examenes;
    }
}
