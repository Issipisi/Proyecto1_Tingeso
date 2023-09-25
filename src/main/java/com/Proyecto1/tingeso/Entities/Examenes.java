package com.Proyecto1.tingeso.Entities;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity @Data
public class Examenes {
    @Id
    private Long id;
    @Column(name="puntaje", nullable = false)
    private int puntaje;
    @Column(name="fecha_exam", nullable = false)
    private LocalDate fecha_exam;
    @Column(name="rut", nullable = false)
    private String rut;

}
