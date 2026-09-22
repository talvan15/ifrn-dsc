package com.ifrn.biblioteca.repository;

import com.ifrn.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {


    List<Livro> findByQuantidadeDisponivelGreaterThanOrderByTituloAsc(
            Integer quantidade
    );

    // 2. Buscar livros por categoria
    List<Livro> findByCategoriaNomeIgnoreCase(
            String nome
    );

    // 5. Encontrar livros de um autor específico
    List<Livro> findByAutoresNomeIgnoreCaseOrderByAnoPublicacaoAsc(
            String nome
    );
}