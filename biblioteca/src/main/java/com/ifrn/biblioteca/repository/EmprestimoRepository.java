package com.ifrn.biblioteca.repository;

import com.ifrn.biblioteca.model.Emprestimo;
import com.ifrn.biblioteca.model.StatusEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    // 4. Listar empréstimos ativos de um usuário
    List<Emprestimo> findByUsuarioIdAndStatus(
            Long usuarioId,
            StatusEmprestimo status
    );

    // 6. Listar empréstimos atrasados
    List<Emprestimo> findByDataDevolucaoPrevistaBeforeAndStatus(
            LocalDate data,
            StatusEmprestimo status
    );
}
