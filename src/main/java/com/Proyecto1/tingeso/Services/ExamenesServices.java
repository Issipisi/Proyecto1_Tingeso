package com.Proyecto1.tingeso.Services;
import com.Proyecto1.tingeso.Entities.Estudiante;
import com.Proyecto1.tingeso.Entities.Examenes;
import com.Proyecto1.tingeso.Repositories.ExamenesRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.annotation.XmlType;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExamenesServices {
    @Autowired
    ExamenesRepository examenesRepository;

    public void insertExamenes(Examenes examenes){
        examenesRepository.insertExamenes(examenes.getPuntaje(), examenes.getFecha_exam(), examenes.getRut());
    }
    public List <Examenes> selectExamenes(String rut){
        return examenesRepository.selectExamenes(rut);
    }

    public void subirArchivoNotas(MultipartFile archivo) throws IOException{
        try(Reader reader = new BufferedReader(new InputStreamReader(archivo.getInputStream()));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())){
            Examenes examenes = new Examenes();
            for(CSVRecord csvrecord : csvParser){
                String rut = csvrecord.get("RUT");
                String fecha_examen = csvrecord.get("FechaExamen");
                LocalDate fecha_exam = LocalDate.parse(fecha_examen);
                int puntaje = Integer.parseInt(csvrecord.get("Puntaje"));


                examenes.setRut(rut);
                examenes.setPuntaje(puntaje);
                examenes.setFecha_exam(fecha_exam);

                insertExamenes(examenes);
            }
        }
    }
}
