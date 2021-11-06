package com.controleUsuario.dto.mapper;

import com.controleUsuario.dto.request.UsuarioDTO;
import com.controleUsuario.dto.request.UsuarioDTO.UsuarioDTOBuilder;
import com.controleUsuario.entities.Usuario;
import com.controleUsuario.entities.Usuario.UsuarioBuilder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-05T23:35:36-0300",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.4.0.v20210708-0430, environment: Java 16.0.2 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toModel(UsuarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UsuarioBuilder usuario = Usuario.builder();

        if ( dto.getBirthDate() != null ) {
            usuario.birthDate( LocalDate.parse( dto.getBirthDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        usuario.cpf( dto.getCpf() );
        usuario.firstName( dto.getFirstName() );
        usuario.id( dto.getId() );
        usuario.lastName( dto.getLastName() );

        return usuario.build();
    }

    @Override
    public UsuarioDTO toDTO(Usuario dto) {
        if ( dto == null ) {
            return null;
        }

        UsuarioDTOBuilder usuarioDTO = UsuarioDTO.builder();

        if ( dto.getBirthDate() != null ) {
            usuarioDTO.birthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( dto.getBirthDate() ) );
        }
        usuarioDTO.cpf( dto.getCpf() );
        usuarioDTO.firstName( dto.getFirstName() );
        usuarioDTO.id( dto.getId() );
        usuarioDTO.lastName( dto.getLastName() );

        return usuarioDTO.build();
    }
}
