package com.TaskFlow.TaskFlow.Servicios;

import com.TaskFlow.TaskFlow.Entidades.Puesto;
import com.TaskFlow.TaskFlow.Entidades.Usuario;
import com.TaskFlow.TaskFlow.Exception.EmptyErrorException;
import com.TaskFlow.TaskFlow.Repository.IPuestoRepository;
import com.TaskFlow.TaskFlow.Repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{

    Usuario usuario = new Usuario();

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> gUsuarios() {
        List<Usuario> usuariosList = new ArrayList<>();
        usuariosList = usuarioRepository.findAll();
        return usuariosList;
    }

    @Override
    public Usuario gUsuarioByID(Long Id) throws EmptyErrorException {
        usuario = new Usuario();
        usuario = usuarioRepository.findById(Id).orElse(null);

        if (usuario == null) throw new EmptyErrorException("Usuario not found!");

        return usuario;
    }

    @Override
    public Usuario aUsuario(Usuario usuario) throws EmptyErrorException {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario mUsuario(Long Id, Usuario newUsuario) throws EmptyErrorException {
        usuario = new Usuario();
        usuario = usuarioRepository.findById(Id).orElse(null);

        if(usuario!=null)
        {
            newUsuario.setIdUsuario(usuario.getIdUsuario());
        }
        else
        {
            throw new EmptyErrorException("Usuario not found!");
        }
        return usuarioRepository.save(newUsuario);
    }

    @Override
    public boolean dUsuarioByID(Long Id) throws EmptyErrorException {
        boolean ok = false;
        usuario = new Usuario();
        usuario = usuarioRepository.findById(Id).orElse(null);
        if(usuario!=null)
        {
            usuarioRepository.deleteById(Id);
            ok = true;
        }
        else
        {
            throw new EmptyErrorException("Usuario not found!");
        }
        return ok;
    }
}
