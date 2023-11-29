package com.TaskFlow.TaskFlow.Servicios;

import com.TaskFlow.TaskFlow.Entidades.Puesto;
import com.TaskFlow.TaskFlow.Exception.EmptyErrorException;
import com.TaskFlow.TaskFlow.Repository.IPuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PuestoService implements IPuestoService {

    Puesto puesto = new Puesto();

    @Autowired
    IPuestoRepository puestoRepository;

    @Override
    public List<Puesto> gPuestos() {
        List<Puesto> puestosList = new ArrayList<>();
        puestosList = puestoRepository.findAll();
        return puestosList;
    }

    @Override
    public Puesto gPuestoByID(Long Id) throws EmptyErrorException {
        puesto = new Puesto();
        puesto = puestoRepository.findById(Id).orElse(null);

        if (puesto == null) throw new EmptyErrorException("Category not found!");

        return puesto;
    }

    @Override
    public Puesto aPuesto(Puesto puesto) throws EmptyErrorException {
        return puestoRepository.save(puesto);
    }

    @Override
    public Puesto mPuesto(Long Id, Puesto newPuesto) throws EmptyErrorException {
        puesto = new Puesto();
        puesto = puestoRepository.findById(Id).orElse(null);

        if(puesto!=null)
        {
            newPuesto.setIdpuesto(puesto.getIdpuesto());
        }
        else
        {
            throw new EmptyErrorException("Puesto not found!");
        }
        return puestoRepository.save(newPuesto);
    }

    @Override
    public boolean dPuestoByID(Long Id) throws EmptyErrorException {
        boolean ok = false;
        puesto = new Puesto();
        puesto = puestoRepository.findById(Id).orElse(null);
        if(puesto!=null)
        {
            puestoRepository.deleteById(Id);
            ok = true;
        }
        else
        {
            throw new EmptyErrorException("Puesto not found!");
        }
        return ok;
    }
}
