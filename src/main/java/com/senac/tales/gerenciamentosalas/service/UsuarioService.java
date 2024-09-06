package com.senac.tales.gerenciamentosalas.service;

import com.senac.tales.gerenciamentosalas.entity.Usuario;
import com.senac.tales.gerenciamentosalas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Usuario listarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario salvarOuAtualizar(Usuario usuario) {
        usuario.setLogDataCriacao(LocalDateTime.now());
        return repository.save(usuario);
    }

    public void apagar(Integer id) {
        repository.deleteById(id);
    }

    public void apagarLogicamente(Integer id) {
        Usuario usuario = listarPorId(id);
        if (usuario != null) {
            usuario.setUsuario_status(0);
            repository.save(usuario);
        }
    }
}

