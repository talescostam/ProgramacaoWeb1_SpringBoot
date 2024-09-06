package com.senac.tales.gerenciamentosalas.controller;

import com.senac.tales.gerenciamentosalas.entity.Usuario;
import com.senac.tales.gerenciamentosalas.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> usuarios = service.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarPorId(@PathVariable Integer id) {
        Usuario usuario = service.listarPorId(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
        Usuario novoUsuario = service.salvarOuAtualizar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Integer id, @RequestBody Usuario usuario) {
        if (service.listarPorId(id) != null) {
            usuario.setUsuario_id(id);
            Usuario usuarioAtualizado = service.salvarOuAtualizar(usuario);
            return ResponseEntity.ok(usuarioAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Integer id) {
        if (service.listarPorId(id) != null) {
            service.apagar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/logico")
    public ResponseEntity<Void> apagarLogicamente(@PathVariable Integer id) {
        if (service.listarPorId(id) != null) {
            service.apagarLogicamente(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
