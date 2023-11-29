package com.TaskFlow.TaskFlow.Controller;

import com.TaskFlow.TaskFlow.Entidades.Proyecto;
import com.TaskFlow.TaskFlow.Entidades.Puesto;
import com.TaskFlow.TaskFlow.Exception.EmptyErrorException;
import com.TaskFlow.TaskFlow.Servicios.IProyectoService;
import com.TaskFlow.TaskFlow.Servicios.IPuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/TaskFlow/v0")
public class ProyectoController {

    Proyecto proyecto = new Proyecto();
    List<Proyecto> proyectos = new ArrayList<>();

    @Autowired
    IProyectoService proyectoService;

    @GetMapping("/proyecto")
    public ResponseEntity<?> gProyecto() throws EmptyErrorException {
        proyectos = new ArrayList<>();
        //
        try
        {
            proyectos = proyectoService.gProyectos();
        }catch(EmptyErrorException exception)
        {
            throw new EmptyErrorException("There are no categories");
        }

        return ResponseEntity.ok(proyectos);
    };

    @GetMapping("/proyecto/{Id}")
    public ResponseEntity<?> gProyectoByID(@PathVariable Long Id) throws EmptyErrorException {
        proyecto = new Proyecto();
        try {
            proyecto = proyectoService.gProyectoByID(Id);
        }
        catch (EmptyErrorException exception)
        {
            throw new EmptyErrorException("Id not found!");
        }
        return ResponseEntity.ok(proyecto);
    };

    @PostMapping("/proyecto")
    public ResponseEntity<?> aProyecto(@RequestBody Proyecto newProyecto, BindingResult result) throws EmptyErrorException {
        List<Proyecto> proyectoList = new ArrayList<>();
        //
        if(result.hasErrors())
        {
            throw new EmptyErrorException("Error-Empty", "Error: 409", HttpStatus.BAD_REQUEST, result);
        }

        proyectoService.aProyecto(newProyecto);
        proyectoList = proyectoService.gProyectos();

        return ResponseEntity.ok(proyectoList);
    };

    @PutMapping("/proyecto/{Id}")
    public ResponseEntity<?> mProyecto(@PathVariable Long Id, @RequestBody Proyecto newProyecto) throws EmptyErrorException{
        proyecto = new Proyecto();
        try {
            proyecto = proyectoService.mProyecto(Id,newProyecto);
        }catch(EmptyErrorException e)
        {
            throw new EmptyErrorException("Id not found!");
        }
        return ResponseEntity.ok(proyecto);
    };

    @DeleteMapping("/proyecto/{Id}")
    public ResponseEntity<?> dProyectoByID(@PathVariable Long Id) throws EmptyErrorException {
        List<Proyecto> proyectoList = new ArrayList<>();
        try {
            proyectoService.dProyectoByID(Id);
            proyectoList = proyectoService.gProyectos();
        }
        catch (EmptyErrorException e)
        {
            throw new EmptyErrorException("Id not found!");
        }
        return ResponseEntity.ok(proyectoList);
    };
}
