package com.TaskFlow.TaskFlow;

import com.TaskFlow.TaskFlow.Entidades.Puesto;
import com.TaskFlow.TaskFlow.Exception.EmptyErrorException;
import com.TaskFlow.TaskFlow.Repository.IPuestoRepository;
import com.TaskFlow.TaskFlow.Servicios.PuestoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class PuestoServiceTest {
    PuestoServiceTest() {
    }

    @Mock
    private IPuestoRepository puestoRepository;

    @InjectMocks
    private PuestoService puestoService;

    private Puesto puesto;


    @BeforeEach
    void setup(){
        puesto = new Puesto();
        puesto.setIdpuesto(5L);
        puesto.setNombrepuesto("Nueva Puesto");
        puesto.setEstatus(true);
    }

    @Test
    void testGetPuestoByID() throws EmptyErrorException {
        Puesto puestoActual = new Puesto();
        when(puestoRepository.findById(1L)).thenReturn(Optional.ofNullable(puesto));
        puestoActual = puestoService.gPuestoByID(1L);

        assertEquals(puesto,puestoActual);
    }

    @Test
    void testGetAllPuesto() throws EmptyErrorException {
        List<Puesto> result = puestoService.gPuestos();
        assertNotNull(result);
    }

}
