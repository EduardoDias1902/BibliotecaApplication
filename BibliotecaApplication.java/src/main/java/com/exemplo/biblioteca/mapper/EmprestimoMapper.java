package com.exemplo.biblioteca.mapper;

import com.exemplo.biblioteca.dto.EmprestimoRequisicaoDTO;
import com.exemplo.biblioteca.dto.EmprestimoRespostaDTO;
import com.exemplo.biblioteca.model.Emprestimo;

public class EmprestimoMapper {

    public static Emprestimo toDTO(EmprestimoRequisicaoDTO emprestimoRequisicaoDTO) {
        return new Emprestimo(
                emprestimoRequisicaoDTO.livroId(),
                emprestimoRequisicaoDTO.usuarioId(),
                emprestimoRequisicaoDTO.dataEmprestimo(),
                emprestimoRequisicaoDTO.dataDevolucao());
    }

    public static EmprestimoRespostaDTO toEntity(Emprestimo emprestimo) {
        return new EmprestimoRespostaDTO(emprestimo.getLivroId(),
                emprestimo.getDataEmprestimo(),
                emprestimo.getDataDevolucao(),
                emprestimo.getUsuarioId(),
                emprestimo.getId());
    }
}