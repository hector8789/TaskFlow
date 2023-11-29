package com.TaskFlow.TaskFlow.Entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SeguimientoProgreso")
public class SeguimientoProgreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeguimiento;

    @ManyToOne
    @JoinColumn(name = "idTarea")
    private Tarea tarea;

    @Column(name = "porcentajeCompletado")
    private int porcentajeCompletado;

    @Column(name = "comentarios")
    private String comentarios;

    @Column(name = "fechaSeguimiento")
    private Date fechaSeguimiento;

    @Column(name = "estatus")
    private Boolean estatus;

    // Getters y setters
    public Long getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(Long idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public int getPorcentajeCompletado() {
        return porcentajeCompletado;
    }

    public void setPorcentajeCompletado(int porcentajeCompletado) {
        this.porcentajeCompletado = porcentajeCompletado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Date getFechaSeguimiento() {
        return fechaSeguimiento;
    }

    public void setFechaSeguimiento(Date fechaSeguimiento) {
        this.fechaSeguimiento = fechaSeguimiento;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }
}
