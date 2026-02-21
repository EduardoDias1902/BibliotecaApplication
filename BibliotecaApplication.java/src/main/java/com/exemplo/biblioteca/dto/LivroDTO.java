package com.exemplo.biblioteca.dto;

public record LivroDTO(
        Long id,
        String titulo,
        String autor,
        int anoPublicacao
) {}