package com.Proyecto1.tingeso.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping
public class RutasController {
    @GetMapping("/ingresoDatos")
    public String ingresoDatos(){
        return "IngresoDatos";
    }

    @GetMapping("/generarCuota")
    public String generarCuota(){
        return "GenerarCuota";
    }

    @GetMapping("/index")
    public String index(){
        return "Index";
    }

}
