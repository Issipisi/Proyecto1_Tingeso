package com.Proyecto1.tingeso.Repositories;
import com.Proyecto1.tingeso.Entities.Examenes;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
public interface ExamenesRepository extends CrudRepository<Examenes,Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into examenes ( puntaje, fecha_exam, rut) values ( :puntaje, :fecha_exam, :rut)",
            nativeQuery = true)

    public void insertExamenes(@Param("puntaje") int puntaje,
                               @Param("fecha_exam")LocalDate fecha_exam,
                               @Param("rut") String rut);

    @Query(value = "select * from examenes WHERE rut = :rut ", nativeQuery = true)
    public Examenes selectExamenes(String rut);
}
