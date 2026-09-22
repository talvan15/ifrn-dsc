package com.ifrn.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    private LocalDate dataCadastro;

    private String endereco;

    private Boolean ativo;

}