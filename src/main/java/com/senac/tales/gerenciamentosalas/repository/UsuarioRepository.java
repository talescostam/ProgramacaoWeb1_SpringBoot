package com.senac.tales.gerenciamentosalas.repository;

import com.senac.tales.gerenciamentosalas.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}

