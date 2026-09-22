package com.ifrn.biblioteca.repository;

import com.ifrn.biblioteca.model.ItemEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemEmprestimoRepository extends JpaRepository<ItemEmprestimo, Long> {
}
