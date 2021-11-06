package com.controleUsuario.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.controleUsuario.dto.request.UsuarioDTO;
import com.controleUsuario.entities.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Usuario toModel(UsuarioDTO dto);

    UsuarioDTO toDTO(Usuario dto);
}
