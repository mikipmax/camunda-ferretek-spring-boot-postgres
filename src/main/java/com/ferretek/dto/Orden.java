package com.ferretek.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orde_id")
    private int ordeId;
    @ManyToOne
    @JoinColumn(name = "clien_id", referencedColumnName = "clien_id")
    private Cliente clienId;
    @Column(name = "orde_fecha")
    private LocalDate ordeFecha;
    @Column(name = "orde_direccion_env")
    private String ordeDireccionEnv;
    @Column(name = "orde_costo_env")
    private double ordeCostoEnv;

    public Orden(int ordeId, Cliente clienId, LocalDate ordeFecha, String ordeDireccionEnv, double ordeCostoEnv) {
        this.ordeId = ordeId;
        this.clienId = clienId;
        this.ordeFecha = ordeFecha;
        this.ordeDireccionEnv = ordeDireccionEnv;
        this.ordeCostoEnv = ordeCostoEnv;
    }

    public Orden(Cliente clienId, LocalDate ordeFecha, String ordeDireccionEnv, double ordeCostoEnv) {

        this.clienId = clienId;
        this.ordeFecha = ordeFecha;
        this.ordeDireccionEnv = ordeDireccionEnv;
        this.ordeCostoEnv = ordeCostoEnv;
    }
}
