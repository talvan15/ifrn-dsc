package com.ifrn.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "autor")
@Data
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    private String nacionalidade;

    @Column(columnDefinition = "TEXT")
    private String biografia;

}