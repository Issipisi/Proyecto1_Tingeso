package com.Proyecto1.tingeso.Entities;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity @Data
public class Cuota {
    @Id
    private Long id;
    @Column(name="valor", nullable = false)
    private int valor;
    @Column(name="estado", nullable = false)
    private int estado;
    @Column(name="fecha_venc", nullable = false)
    private LocalDate fecha_venc;
    @Column(name="rut", nullable = false)
    private String rut;
    @Column(name = "cant_cuotas", nullable = false)
    private int cant_cuotas;
}
