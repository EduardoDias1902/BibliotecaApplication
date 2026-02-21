package com.exemplo.biblioteca.dto;

import java.time.LocalDate;

public record EmprestimoRequisicaoDTO(
        LocalDate dataEmprestimo,
        LocalDate dataDevolucao,
        Long livroId,
        Long usuarioId
) {
}
