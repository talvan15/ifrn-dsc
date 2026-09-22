package com.ifrn.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "emprestimo")
@Data
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private LocalDate dataEmprestimo;

    private LocalDate dataDevolucaoPrevista;

    private LocalDate dataDevolucaoEfetiva;

    @Enumerated(EnumType.STRING)
    private StatusEmprestimo status;

    private BigDecimal valorMulta;

    @OneToMany(mappedBy = "emprestimo")
    private List<ItemEmprestimo> itens = new ArrayList<>();

}