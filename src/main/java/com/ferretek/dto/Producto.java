package com.ferretek.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private int prodId;
    @Column(name = "prod_nombre")
    private String prodNombre;
    @Column(name = "prod_precio")
    private double prodPrecio;
    @Column(name = "prod_stock")
    private int prodStock;
    @ManyToOne
    @JoinColumn(name = "capr_id", referencedColumnName = "capr_id")
    private CategoriaProducto caprId;

    public Producto(int prodId) {
        this.prodId = prodId;
    }
}
