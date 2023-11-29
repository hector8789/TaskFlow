package com.TaskFlow.TaskFlow.Servicios;

import com.TaskFlow.TaskFlow.Entidades.Puesto;
import com.TaskFlow.TaskFlow.Entidades.Usuario;
import com.TaskFlow.TaskFlow.Exception.EmptyErrorException;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> gUsuarios() throws EmptyErrorException;
    Usuario gUsuarioByID(Long Id) throws EmptyErrorException;
    Usuario aUsuario(Usuario usuario) throws EmptyErrorException;
    Usuario mUsuario(Long Id, Usuario usuario) throws EmptyErrorException;
    boolean dUsuarioByID(Long Id) throws EmptyErrorException;
}
