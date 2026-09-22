package com.ifrn.biblioteca.repository;

import com.ifrn.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {


    List<Livro> findByQuantidadeDisponivelGreaterThanOrderByTituloAsc(
            Integer quantidade
    );

    List<Livro> findByCategoriaNomeIgnoreCase(
            String nome
    );

    List<Livro> findByAutoresNomeIgnoreCaseOrderByAnoPublicacaoAsc(
            String nome
    );
}