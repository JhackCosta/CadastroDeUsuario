package com.controleUsuario.services;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleUsuario.dto.mapper.UsuarioMapper;
import com.controleUsuario.dto.request.UsuarioDTO;
import com.controleUsuario.dto.response.MessageResponseDTO;
import com.controleUsuario.entities.Usuario;
import com.controleUsuario.exception.UsuarioNotFoundException;
import com.controleUsuario.repositories.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    public MessageResponseDTO create(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toModel(usuarioDTO);
        Usuario savedPerson = usuarioRepository.save(usuario);

        MessageResponseDTO messageResponse = createMessageResponse("Person successfully created with ID ", savedPerson.getId());

        return messageResponse;
    }

    public UsuarioDTO findById(Long id) throws UsuarioNotFoundException {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));

        return usuarioMapper.toDTO(usuario);
    }

    public List<UsuarioDTO> listAll() {
        List<Usuario> people = usuarioRepository.findAll();
        return people.stream()
                .map(usuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO update(Long id, UsuarioDTO usuarioDTO) throws UsuarioNotFoundException {
        usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));

        Usuario updatedPerson = usuarioMapper.toModel(usuarioDTO);
        Usuario savedPerson = usuarioRepository.save(updatedPerson);

        MessageResponseDTO messageResponse = createMessageResponse("Person successfully updated with ID ", savedPerson.getId());

        return messageResponse;
    }

    public void delete(Long id) throws UsuarioNotFoundException {
        usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));

        usuarioRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
    }
}
