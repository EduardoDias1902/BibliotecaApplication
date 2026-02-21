package com.exemplo.biblioteca.mapper;

import com.exemplo.biblioteca.dto.UsuarioDTO;
import com.exemplo.biblioteca.model.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }

    public static Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.id());
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        return usuario;
    }
}
