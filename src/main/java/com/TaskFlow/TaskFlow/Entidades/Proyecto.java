package com.TaskFlow.TaskFlow.Entidades;

import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Proyectos")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProyecto;

    @NotNull(message = "Nombre del Proyecto Vacio")
    @NotEmpty(message = "Nombre del Proyecto Vacio")
    @Column(name = "nombreproyecto")
    private String nombreproyecto;

    @NotNull(message = "Descripción del Proyecto Vacio")
    @NotEmpty(message = "Descripción del Proyecto Vacio")
    @Column(name = "descripcionproyecto")
    private String descripcionproyecto;

    @NotNull(message = "Fecha Inicio del Proyecto Vacio")
    @NotEmpty(message = "Fecha Inicio del Proyecto Vacio")
    @Column(name = "fechainicio")
    private Date fechainicio;

    @NotNull(message = "Fecha Fin del Proyecto Vacio")
    @NotEmpty(message = "Fecha Fin del Proyecto Vacio")
    @Column(name = "fechafin")
    private Date fechafin;

    @NotNull(message = "Usuario Responsable del Proyecto Vacio")
    @NotEmpty(message = "Usuario Responsable del Proyecto Vacio")
    @ManyToOne
    @JoinColumn(name = "idUsuarioresponsable")
    private Usuario usuarioresponsable;

    @Column(name = "estatus")
    private Boolean estatus;

    // Getters y setters

    public Long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreproyecto() {
        return nombreproyecto;
    }

    public void setNombreproyecto(String nombreproyecto) {
        this.nombreproyecto = nombreproyecto;
    }

    public String getDescripcionproyecto() {
        return descripcionproyecto;
    }

    public void setDescripcionproyecto(String descripcionproyecto) {
        this.descripcionproyecto = descripcionproyecto;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Usuario getUsuarioresponsable() {
        return usuarioresponsable;
    }

    public void setUsuarioresponsable(Usuario usuarioresponsable) {
        this.usuarioresponsable = usuarioresponsable;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }
}

