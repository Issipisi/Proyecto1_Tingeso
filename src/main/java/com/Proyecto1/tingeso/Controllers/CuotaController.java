package com.Proyecto1.tingeso.Controllers;
import com.Proyecto1.tingeso.Entities.Cuota;
import com.Proyecto1.tingeso.Repositories.CuotaRepository;
import com.Proyecto1.tingeso.Services.CuotaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller @RequestMapping @CrossOrigin @RestController
public class CuotaController {

    @Autowired
    CuotaServices cuotaServices;

    @PostMapping("/cuotas")
    public void insertCuota(@RequestBody Cuota cuota){
        cuotaServices.insertCuota(cuota);
    }
}
