package com.ifrn.biblioteca.repository;

import com.ifrn.biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNomeContainingIgnoreCase(String nome);
}
