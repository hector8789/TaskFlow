package com.TaskFlow.TaskFlow.Controller;

import com.TaskFlow.TaskFlow.Entidades.Puesto;
import com.TaskFlow.TaskFlow.Entidades.Usuario;
import com.TaskFlow.TaskFlow.Exception.EmptyErrorException;
import com.TaskFlow.TaskFlow.Servicios.IPuestoService;
import com.TaskFlow.TaskFlow.Servicios.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/TaskFlow/v0")
public class UsuarioController {

    Usuario usuario = new Usuario();
    List<Usuario> usuarios = new ArrayList<>();

    @Autowired
    IUsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<?> gUsuarios() throws EmptyErrorException {
        usuarios = new ArrayList<>();
        //
        try
        {
            usuarios = usuarioService.gUsuarios();
        }catch(EmptyErrorException exception)
        {
            throw new EmptyErrorException("There are no categories");
        }

        return ResponseEntity.ok(usuarios);
    };

    @GetMapping("/usuario/{Id}")
    public ResponseEntity<?> gUsuarioByID(@PathVariable Long Id) throws EmptyErrorException {
        usuario = new Usuario();
        try {
            usuario = usuarioService.gUsuarioByID(Id);
        }
        catch (EmptyErrorException exception)
        {
            throw new EmptyErrorException("Id not found!");
        }
        return ResponseEntity.ok(usuario);
    };

    @PostMapping("/usuario")
    public ResponseEntity<?> aUsuario(@RequestBody Usuario newUsuario, BindingResult result) throws EmptyErrorException {
        List<Usuario> usuarioList = new ArrayList<>();
        //
        if(result.hasErrors())
        {
            throw new EmptyErrorException("Error-Empty", "Error: 409", HttpStatus.BAD_REQUEST, result);
        }

        usuarioService.aUsuario(newUsuario);
        usuarioList = usuarioService.gUsuarios();

        return ResponseEntity.ok(usuarioList);
    };

    @PutMapping("/usuario/{Id}")
    public ResponseEntity<?> mUsuario(@PathVariable Long Id, @RequestBody Usuario newUsuario) throws EmptyErrorException{
        usuario = new Usuario();
        try {
            usuario = usuarioService.mUsuario(Id,newUsuario);
        }catch(EmptyErrorException e)
        {
            throw new EmptyErrorException("Id not found!");
        }
        return ResponseEntity.ok(usuario);
    };

    @DeleteMapping("/usuario/{Id}")
    public ResponseEntity<?> dUsuarioByID(@PathVariable Long Id) throws EmptyErrorException {
        List<Usuario> usuarioList = new ArrayList<>();
        try {
            usuarioService.dUsuarioByID(Id);
            usuarioList = usuarioService.gUsuarios();
        }
        catch (EmptyErrorException e)
        {
            throw new EmptyErrorException("Id not found!");
        }
        return ResponseEntity.ok(usuarioList);
    };
}
