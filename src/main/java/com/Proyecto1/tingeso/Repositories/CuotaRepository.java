package com.Proyecto1.tingeso.Repositories;
import com.Proyecto1.tingeso.Entities.Cuota;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
public interface CuotaRepository extends CrudRepository<Cuota,Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into cuota (valor, estado, fecha_venc, rut) values (:valor, :estado, :fecha_venc, :rut)",
            nativeQuery = true)

    public void insertCuota(@Param("valor")int valor,
                            @Param("estado") String estado,
                            @Param("fecha_venc")LocalDate fecha_venc,
                            @Param("rut") String rut);
}
