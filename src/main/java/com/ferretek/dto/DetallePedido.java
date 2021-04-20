package com.ferretek.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "depe_id")
    private int depe_id;
    @ManyToOne
    @JoinColumn(name = "orde_id", referencedColumnName = "orde_id")
    private Orden ordeId;
    @ManyToOne
    @JoinColumn(name = "prod_id", referencedColumnName = "prod_id")
    private Producto prodId;
    @Column(name = "depe_cantidad")
    private int depeCantidad;

    public DetallePedido(Orden ordeId, Producto prodId, int depeCantidad) {
        this.ordeId = ordeId;
        this.prodId = prodId;
        this.depeCantidad = depeCantidad;
    }
}
