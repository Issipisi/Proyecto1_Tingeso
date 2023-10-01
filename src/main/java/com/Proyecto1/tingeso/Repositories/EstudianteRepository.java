package com.Proyecto1.tingeso.Repositories;
import com.Proyecto1.tingeso.Entities.Estudiante;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
public interface EstudianteRepository extends CrudRepository <Estudiante,Long>{
    @Modifying
    @Transactional
    @Query(value = "insert into estudiante (rut, apellidos, nombres, f_nacimiento, tipo_colegio_p, nom_colegio, " +
            "anyo_egreso_col, tipo_pago) values(:rut, :apellidos, :nombres, :f_nacimiento, :tipo_colegio_p, " +
            ":nom_colegio, :anyo_egreso_col, :tipo_pago)", nativeQuery = true)

    public void insertEstudiante(@Param("rut") String rut,
                                 @Param("apellidos") String apellidos,
                                 @Param("nombres") String nombres,
                                 @Param("f_nacimiento")LocalDate f_nacimiento,
                                 @Param("tipo_colegio_p") int tipo_colegio_p,
                                 @Param("nom_colegio") String nom_colegio,
                                 @Param("anyo_egreso_col") int anyo_egreso_col,
                                 @Param("tipo_pago") int tipo_pago);

    @Query(value = "select * from estudiante WHERE rut = :rut ", nativeQuery = true)
    public Estudiante selectEstudiante(String rut);

}
