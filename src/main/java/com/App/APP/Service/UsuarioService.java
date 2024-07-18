package com.App.APP.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.APP.DTO.UsuarioDTO;
import com.App.APP.Entity.Usuario;
import com.App.APP.Mapper.UsuarioMapper;
import com.App.APP.Repositorio.UsuarioRepositorio;

@Service

public class UsuarioService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;


    public List<UsuarioDTO> SearchEntityUsuario(){

        List<Usuario> usuarioList =usuarioRepositorio.findAll();

        return usuarioList.stream().map(UsuarioMapper::DatosToDTO).collect(Collectors.toList());

    } 

    public Optional<UsuarioDTO> SearchEntityOneUsuario(int idUsuario){

        Optional<Usuario> usuarioOne = usuarioRepositorio.findById(idUsuario);

        return usuarioOne.map(UsuarioMapper::DatosToDTO);
    }

    public UsuarioDTO SaveEntityUsuario(UsuarioDTO usuarioDTO){

        Usuario usuario = UsuarioMapper.DatosToEntity(usuarioDTO);
        Usuario saveUsuario = usuarioRepositorio.save(usuario);
        return UsuarioMapper.DatosToDTO(saveUsuario);
    }

    public void DeleteEntityUsuario(int idUsuario){
        usuarioRepositorio.deleteById(idUsuario);
    }

    public void EditEntityUsuario(int idUsuario ,UsuarioDTO usuarioDTO){

        Usuario usuarioEncontrado = usuarioRepositorio.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuarioEncontrado.setUsername(usuarioDTO.getUsername());
        usuarioEncontrado.setPassword(usuarioDTO.getPassword());

        usuarioRepositorio.save(usuarioEncontrado);
    }
    
}
