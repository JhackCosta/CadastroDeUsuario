package one.digitalinnovation.personapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import com.controleUsuario.dto.request.UsuarioDTO;
import com.controleUsuario.entities.Usuario;

public class PersonUtils {

    private static final String FIRST_NAME = "Rodrigo";
    private static final String LAST_NAME = "Peleias";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static UsuarioDTO createFakeDTO() {
        return UsuarioDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("04-04-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Usuario createFakeEntity() {
        return Usuario.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .telefones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }




}
