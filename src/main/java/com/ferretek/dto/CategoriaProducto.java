package com.ferretek.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CategoriaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "capr_id")
    private int caprId;
    @Column(name = "capr_nombre")
    private String caprNombre;

}
