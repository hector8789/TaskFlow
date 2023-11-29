package com.TaskFlow.TaskFlow.Servicios;

import com.TaskFlow.TaskFlow.Entidades.Proyecto;
import com.TaskFlow.TaskFlow.Entidades.Puesto;
import com.TaskFlow.TaskFlow.Exception.EmptyErrorException;

import java.util.List;

public interface IProyectoService {
    List<Proyecto> gProyectos() throws EmptyErrorException;
    Proyecto gProyectoByID(Long Id) throws EmptyErrorException;
    Proyecto aProyecto(Proyecto proyecto) throws EmptyErrorException;
    Proyecto mProyecto(Long Id, Proyecto proyecto) throws EmptyErrorException;
    boolean dProyectoByID(Long Id) throws EmptyErrorException;
}
