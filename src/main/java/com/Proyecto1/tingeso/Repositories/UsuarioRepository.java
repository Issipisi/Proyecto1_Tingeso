package com.Proyecto1.tingeso.Repositories;
import com.Proyecto1.tingeso.Entities.Usuario;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into usuario (rol, rut) values (:rol, :rut)", nativeQuery = true)

    public void insertUsuario(@Param("rol") int rol,
                              @Param("rut") String rut);
}
