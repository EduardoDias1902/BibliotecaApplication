package com.exemplo.biblioteca.mapper;

import com.exemplo.biblioteca.dto.LivroDTO;
import com.exemplo.biblioteca.model.Livro;

public class LivroMapper {

    public static LivroDTO toDTO(Livro livro) {
        return new LivroDTO(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getAnoPublicacao()
        );
    }

    public static Livro toEntity(LivroDTO dto) {
        Livro livro = new Livro();
        livro.setId(dto.id());
        livro.setTitulo(dto.titulo());
        livro.setAutor(dto.autor());
        livro.setAnoPublicacao(dto.anoPublicacao());
        return livro;
    }
}
