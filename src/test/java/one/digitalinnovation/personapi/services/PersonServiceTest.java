package one.digitalinnovation.personapi.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.controleUsuario.dto.mapper.UsuarioMapper;
import com.controleUsuario.dto.request.UsuarioDTO;
import com.controleUsuario.dto.response.MessageResponseDTO;
import com.controleUsuario.entities.Usuario;
import com.controleUsuario.repositories.UsuarioRepository;
import com.controleUsuario.services.UsuarioService;

import static one.digitalinnovation.personapi.utils.PersonUtils.createFakeDTO;
import static one.digitalinnovation.personapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private UsuarioMapper usuarioMapper;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        UsuarioDTO usuarioDTO = createFakeDTO();
        Usuario expectedSavedPerson = createFakeEntity();

        when(usuarioMapper.toModel(usuarioDTO)).thenReturn(expectedSavedPerson);
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
        MessageResponseDTO successMessage = usuarioService.create(usuarioDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
        return MessageResponseDTO.builder()
                .message("Person successfully created with ID " + savedPersonId)
                .build();
    }

}
