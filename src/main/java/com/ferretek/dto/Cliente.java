package com.ferretek.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clien_id")
    private int clienId;
    @Column(name = "clien_cedula")
    private String clienCedula;
    @Column(name = "clien_nombres")
    private String clienNombres;
    @Column(name = "clien_apellidos")
    private String clienApellidos;
    @Column(name = "clien_correo")
    private String clienCorreo;
    @Column(name = "clien_telef")
    private String clienTelef;

    public Cliente(String clienCedula, String clienNombres, String clienApellidos, String clienCorreo, String clienTelef) {
        this.clienCedula = clienCedula;
        this.clienNombres = clienNombres;
        this.clienApellidos = clienApellidos;
        this.clienCorreo = clienCorreo;
        this.clienTelef = clienTelef;
    }

    public Cliente(int clienId, String clienCedula, String clienNombres, String clienApellidos, String clienCorreo, String clienTelef) {
        this.clienId = clienId;
        this.clienCedula = clienCedula;
        this.clienNombres = clienNombres;
        this.clienApellidos = clienApellidos;
        this.clienCorreo = clienCorreo;
        this.clienTelef = clienTelef;
    }
}
