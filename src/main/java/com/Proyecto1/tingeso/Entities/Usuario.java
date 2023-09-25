package com.Proyecto1.tingeso.Entities;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @Data
public class Usuario {
    @Id
    private Long id;
    @Column(name="rol", nullable = false)
    private int rol;
    @Column(name="rut", nullable = false)
    private String rut;
}
