package com.TaskFlow.TaskFlow.Servicios;

import com.TaskFlow.TaskFlow.Entidades.Puesto;
import com.TaskFlow.TaskFlow.Exception.EmptyErrorException;

import java.util.List;

public interface IPuestoService {

    List<Puesto> gPuestos() throws EmptyErrorException;
    Puesto gPuestoByID(Long Id) throws EmptyErrorException;
    Puesto aPuesto(Puesto puesto) throws EmptyErrorException;
    Puesto mPuesto(Long Id, Puesto puesto) throws EmptyErrorException;
    boolean dPuestoByID(Long Id) throws EmptyErrorException;
}
