package com.Proyecto1.tingeso.Entities;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity @Data
public class Estudiante {
    @Id
    private Long id;
    @Column(name="rut", nullable = false)
    private String rut;
    @Column(name="apellidos", nullable = false)
    private String apellidos;
    @Column(name="nombres", nullable = false)
    private String nombres;
    @Column(name="f_nacimiento", nullable = false)
    private LocalDate f_nacimiento;
    @Column(name="tipo_colegio_p", nullable = false)
    private String tipo_colegio_p;
    @Column(name="nom_colegio", nullable = false)
    private String nom_colegio ;
    @Column(name="anyo_egreso_col", nullable = false)
    private int anyo_egreso_col;
    @Column(name="tipo_pago", nullable = false)
    private int tipo_pago;

}
