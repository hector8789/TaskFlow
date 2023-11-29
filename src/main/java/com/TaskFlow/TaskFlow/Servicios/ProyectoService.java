package com.TaskFlow.TaskFlow.Servicios;

import com.TaskFlow.TaskFlow.Entidades.Proyecto;
import com.TaskFlow.TaskFlow.Entidades.Puesto;
import com.TaskFlow.TaskFlow.Exception.EmptyErrorException;
import com.TaskFlow.TaskFlow.Repository.IProyectoRepository;
import com.TaskFlow.TaskFlow.Repository.IPuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProyectoService implements IProyectoService{
    Proyecto proyecto = new Proyecto();

    @Autowired
    IProyectoRepository proyectoRepository;

    @Override
    public List<Proyecto> gProyectos() {
        List<Proyecto> proyectosList = new ArrayList<>();
        proyectosList = proyectoRepository.findAll();
        return proyectosList;
    }

    @Override
    public Proyecto gProyectoByID(Long Id) throws EmptyErrorException {
        proyecto = new Proyecto();
        proyecto = proyectoRepository.findById(Id).orElse(null);

        if (proyecto == null) throw new EmptyErrorException("Proyecto not found!");

        return proyecto;
    }

    @Override
    public Proyecto aProyecto(Proyecto proyecto) throws EmptyErrorException {
        return proyectoRepository.save(proyecto);
    }

    @Override
    public Proyecto mProyecto(Long Id, Proyecto newProyecto) throws EmptyErrorException {
        proyecto = new Proyecto();
        proyecto = proyectoRepository.findById(Id).orElse(null);

        if(proyecto!=null)
        {
            newProyecto.setIdProyecto(proyecto.getIdProyecto());
        }
        else
        {
            throw new EmptyErrorException("Proyecto not found!");
        }
        return proyectoRepository.save(newProyecto);
    }

    @Override
    public boolean dProyectoByID(Long Id) throws EmptyErrorException {
        boolean ok = false;
        proyecto = new Proyecto();
        proyecto = proyectoRepository.findById(Id).orElse(null);
        if(proyecto!=null)
        {
            proyectoRepository.deleteById(Id);
            ok = true;
        }
        else
        {
            throw new EmptyErrorException("Proyecto not found!");
        }
        return ok;
    }
}
