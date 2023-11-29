package com.TaskFlow.TaskFlow;

import com.TaskFlow.TaskFlow.Entidades.Proyecto;
import com.TaskFlow.TaskFlow.Entidades.Puesto;
import com.TaskFlow.TaskFlow.Entidades.Usuario;
import com.TaskFlow.TaskFlow.Exception.EmptyErrorException;
import com.TaskFlow.TaskFlow.Repository.IProyectoRepository;
import com.TaskFlow.TaskFlow.Repository.IPuestoRepository;
import com.TaskFlow.TaskFlow.Servicios.ProyectoService;
import com.TaskFlow.TaskFlow.Servicios.PuestoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class ProyectoServiceTest {
    ProyectoServiceTest() {
    }

    @Mock
    private IProyectoRepository proyectoRepository;

    @InjectMocks
    private ProyectoService proyectoService;

    private Proyecto proyecto;


    @BeforeEach
    void setup(){
    }

    @Test
    void testGetProyectoByID() throws EmptyErrorException {
        Proyecto proyectoActual = new Proyecto();
        when(proyectoRepository.findById(1L)).thenReturn(Optional.ofNullable(proyecto));
        proyectoActual = proyectoService.gProyectoByID(1L);

        assertEquals(proyecto,proyectoActual);
    }

    @Test
    void testGetAllProyecto() throws EmptyErrorException {
        List<Proyecto> result = proyectoService.gProyectos();
        assertNotNull(result);
    }
}
