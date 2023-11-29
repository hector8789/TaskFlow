package com.TaskFlow.TaskFlow.Entidades;

import javax.persistence.*;

@Entity
@Table(name = "Puestos")
public class Puesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpuesto;
    @Column(name = "nombrepuesto")
    private String nombrepuesto;
    @Column(name = "estatus")
    private Boolean estatus;

    //
    public Puesto() {
    }

    // Getters y setters
    public Long getIdpuesto() {
        return idpuesto;
    }

    public void setIdpuesto(Long idpuesto) {
        this.idpuesto = idpuesto;
    }

    public String getNombrepuesto() {
        return nombrepuesto;
    }

    public void setNombrepuesto(String nombrepuesto) {
        this.nombrepuesto = nombrepuesto;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }
}
