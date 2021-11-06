package one.digitalinnovation.personapi.mapper;

import one.digitalinnovation.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.controleUsuario.dto.mapper.UsuarioMapper;
import com.controleUsuario.dto.request.UsuarioDTO;
import com.controleUsuario.dto.request.TelefoneDTO;
import com.controleUsuario.entities.Usuario;
import com.controleUsuario.entities.Telefone;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonMapperTest {

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Test
    void testGivenPersonDTOThenReturnPersonEntity() {
        UsuarioDTO usuarioDTO = PersonUtils.createFakeDTO();
        Usuario usuario = usuarioMapper.toModel(usuarioDTO);

        assertEquals(usuarioDTO.getFirstName(), usuario.getFirstName());
        assertEquals(usuarioDTO.getLastName(), usuario.getLastName());
        assertEquals(usuarioDTO.getCpf(), usuario.getCpf());

        Telefone telefone = usuario.getTelefones().get(0);
        TelefoneDTO telefoneDTO = usuarioDTO.getPhones().get(0);

        assertEquals(telefoneDTO.getType(), telefone.getType());
        assertEquals(telefoneDTO.getNumber(), telefone.getNumber());
    }

    @Test
    void testGivenPersonEntityThenReturnPersonDTO() {
        Usuario usuario = PersonUtils.createFakeEntity();
        UsuarioDTO usuarioDTO = usuarioMapper.toDTO(usuario);

        assertEquals(usuario.getFirstName(), usuarioDTO.getFirstName());
        assertEquals(usuario.getLastName(), usuarioDTO.getLastName());
        assertEquals(usuario.getCpf(), usuarioDTO.getCpf());

        Telefone telefone = usuario.getTelefones().get(0);
        TelefoneDTO telefoneDTO = usuarioDTO.getPhones().get(0);

        assertEquals(telefone.getType(), telefoneDTO.getType());
        assertEquals(telefone.getNumber(), telefoneDTO.getNumber());
    }
}
