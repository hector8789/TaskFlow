package com.TaskFlow.TaskFlow.Controller;

import com.TaskFlow.TaskFlow.Entidades.Puesto;
import com.TaskFlow.TaskFlow.Exception.EmptyErrorException;
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
public class PuestoController {

    Puesto puesto = new Puesto();
    List<Puesto> puestos = new ArrayList<>();

    @Autowired
    IPuestoService puestoService;

    @GetMapping("/puestos")
    public ResponseEntity<?> gPuestos() throws EmptyErrorException {
        puestos = new ArrayList<>();
        //
        try
        {
            puestos = puestoService.gPuestos();
        }catch(EmptyErrorException exception)
        {
            throw new EmptyErrorException("There are no categories");
        }

        return ResponseEntity.ok(puestos);
    };

    @GetMapping("/puesto/{Id}")
    public ResponseEntity<?> gPuestoByID(@PathVariable Long Id) throws EmptyErrorException {
        puesto = new Puesto();
        try {
            puesto = puestoService.gPuestoByID(Id);
        }
        catch (EmptyErrorException exception)
        {
            throw new EmptyErrorException("Id not found!");
        }
        return ResponseEntity.ok(puesto);
    };

    @PostMapping("/puesto")
    public ResponseEntity<?> aPuesto(@RequestBody Puesto newPuesto, BindingResult result) throws EmptyErrorException {
        List<Puesto> puestoList = new ArrayList<>();
        //
        if(result.hasErrors())
        {
            throw new EmptyErrorException("Error-Empty", "Error: 409", HttpStatus.BAD_REQUEST, result);
        }

        puestoService.aPuesto(newPuesto);
        puestoList = puestoService.gPuestos();

        return ResponseEntity.ok(puestoList);
    };

    @PutMapping("/puesto/{Id}")
    public ResponseEntity<?> mPuesto(@PathVariable Long Id, @RequestBody Puesto newPuesto) throws EmptyErrorException{
        puesto = new Puesto();
        try {
            puesto = puestoService.mPuesto(Id,newPuesto);
        }catch(EmptyErrorException e)
        {
            throw new EmptyErrorException("Id not found!");
        }
        return ResponseEntity.ok(puesto);
    };

    @DeleteMapping("/puesto/{Id}")
    public ResponseEntity<?> dPuestoByID(@PathVariable Long Id) throws EmptyErrorException {
        List<Puesto> puestoList = new ArrayList<>();
        try {
            puestoService.dPuestoByID(Id);
            puestoList = puestoService.gPuestos();
        }
        catch (EmptyErrorException e)
        {
            throw new EmptyErrorException("Id not found!");
        }
        return ResponseEntity.ok(puestoList);
    };
}
