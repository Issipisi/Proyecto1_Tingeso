package com.Proyecto1.tingeso.Services;
import com.Proyecto1.tingeso.Entities.Usuario;
import com.Proyecto1.tingeso.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServices {
    @Autowired
    UsuarioRepository usuarioRepository;

    public void insertUsuario(Usuario usuario){
        usuarioRepository.insertUsuario(usuario.getRol(), usuario.getRut());
    }
}
