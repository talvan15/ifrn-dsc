package com.ifrn.biblioteca.repository;

import com.ifrn.biblioteca.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository
        extends JpaRepository<Categoria, Long> {

    // 7. Contar quantidade de livros por categoria
    @Query("""
        SELECT c.nome, COUNT(l)
        FROM Categoria c
        LEFT JOIN c.livros l
        GROUP BY c.id, c.nome
        ORDER BY COUNT(l) DESC
    """)
    List<Object[]> contarLivrosPorCategoria();
}