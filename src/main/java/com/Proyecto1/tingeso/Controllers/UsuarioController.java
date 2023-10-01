package com.Proyecto1.tingeso.Controllers;
import com.Proyecto1.tingeso.Entities.Usuario;
import com.Proyecto1.tingeso.Services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller @RequestMapping @CrossOrigin @RestController
public class UsuarioController {
    @Autowired
    UsuarioServices usuarioServices;
    @PostMapping("/usuarios")
    public void insertUsuario(@RequestBody Usuario usuario){
        usuarioServices.insertUsuario(usuario);
    }
}
