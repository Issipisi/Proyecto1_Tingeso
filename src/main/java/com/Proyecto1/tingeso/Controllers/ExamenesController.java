package com.Proyecto1.tingeso.Controllers;
import com.Proyecto1.tingeso.Entities.Examenes;
import com.Proyecto1.tingeso.Repositories.ExamenesRepository;
import com.Proyecto1.tingeso.Services.ExamenesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller @RequestMapping @CrossOrigin @RestController
public class ExamenesController {
    @Autowired
    ExamenesServices examenesServices;

    @PostMapping("/examenes")

    public void insertExamenes(@RequestBody Examenes examenes){
        examenesServices.insertExamenes(examenes);
    }
}
