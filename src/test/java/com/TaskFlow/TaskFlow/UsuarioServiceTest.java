package com.TaskFlow.TaskFlow;

import com.TaskFlow.TaskFlow.Entidades.Usuario;
import com.TaskFlow.TaskFlow.Exception.EmptyErrorException;
import com.TaskFlow.TaskFlow.Repository.IUsuarioRepository;
import com.TaskFlow.TaskFlow.Servicios.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class UsuarioServiceTest {

    UsuarioServiceTest() {
    }

    @Mock
    private IUsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private Usuario usuario;


    @BeforeEach
    void setup(){
        usuario = new Usuario();
        usuario.setIdUsuario(5L);
        usuario.setNombreusuario("Hector Venegas");
        usuario.setCorreoelectronico("hector.bernardo8789");
        usuario.setContrasena("123456");
        usuario.setEstatus(true);
    }

    @Test
    void testGetUsuarioByID() throws EmptyErrorException {
        Usuario usuarioActual = new Usuario();
        when(usuarioRepository.findById(1L)).thenReturn(Optional.ofNullable(usuario));
        usuarioActual = usuarioService.gUsuarioByID(1L);

        assertEquals(usuario,usuarioActual);
    }

    @Test
    void testGetAllUsuario() throws EmptyErrorException {
        List<Usuario> result = usuarioService.gUsuarios();
        assertNotNull(result);
    }
}
