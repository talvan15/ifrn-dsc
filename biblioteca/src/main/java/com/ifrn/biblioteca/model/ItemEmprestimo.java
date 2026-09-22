package com.ifrn.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "item_emprestimo")
@Data
public class ItemEmprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "emprestimo_id")
    private Emprestimo emprestimo;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

}