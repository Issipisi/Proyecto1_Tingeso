package com.Proyecto1.tingeso.Controllers;
import com.Proyecto1.tingeso.Entities.Cuota;
import com.Proyecto1.tingeso.Repositories.CuotaRepository;
import com.Proyecto1.tingeso.Services.CuotaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller @RequestMapping @CrossOrigin @RestController
public class CuotaController {

    @Autowired
    CuotaServices cuotaServices;

    @PostMapping("/cuotas")
    public void insertCuota(@RequestBody Cuota cuota){
        cuotaServices.insertCuota(cuota);
    }

    @PostMapping("/generarCuota")
    public ModelAndView generarCuota(@RequestParam(name = "rut") String rut){
        cuotaServices.generarCuota(rut);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Index");
        return modelAndView;
    }

    @GetMapping("/listarCuotas")
    public ModelAndView mostrarCuota(@RequestParam(name = "rut") String rut){
        cuotaServices.listarCuotas(rut);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("MostrarCuotas");
        modelAndView.getModel().put("cuota", cuotaServices.listarCuotas(rut));
        return modelAndView;
    }

    @PostMapping("/pagarCuota")
    public ModelAndView pagarCuota(@RequestParam Long cuotaId, Model model) {
        cuotaServices.pagarCuota(cuotaId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("MostrarCuotasRut");
        return modelAndView;
    }

}
