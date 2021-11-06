package com.controleUsuario.controllers;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.controleUsuario.dto.request.UsuarioDTO;
import com.controleUsuario.dto.response.MessageResponseDTO;
import com.controleUsuario.exception.UsuarioNotFoundException;
import com.controleUsuario.services.UsuarioService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("usuario")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        return usuarioService.create(usuarioDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDTO findById(@PathVariable Long id) throws UsuarioNotFoundException {
        return usuarioService.findById(id);
    }

    @GetMapping
    public List<UsuarioDTO> listAll() {
        return usuarioService.listAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid UsuarioDTO usuarioDTO) throws UsuarioNotFoundException {
        return usuarioService.update(id, usuarioDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws UsuarioNotFoundException {
        usuarioService.delete(id);
    }
}
