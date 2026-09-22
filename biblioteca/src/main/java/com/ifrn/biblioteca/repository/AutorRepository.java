package com.ifrn.biblioteca.repository;

import com.ifrn.biblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
