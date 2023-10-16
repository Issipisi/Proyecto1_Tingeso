package com.Proyecto1.tingeso.Repositories;
import com.Proyecto1.tingeso.Entities.Examenes;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

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
    public List<Examenes> selectExamenes(String rut);

    @Query(value = "select avg(puntaje) from examenes where rut = :rut and year(fecha_exam) =:anyo and month(fecha_exam)" +
            " = :mes group by rut", nativeQuery = true)
    public int getPromedio(String rut, int anyo, int mes);
}
