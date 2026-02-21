package com.exemplo.biblioteca.dto;

import java.time.LocalDate;

public record EmprestimoRespostaDTO(
        Long id,
        LocalDate dataEmprestimo,
        LocalDate dataDevolucao,
        Long livroId,
        Long usuarioId
) {}