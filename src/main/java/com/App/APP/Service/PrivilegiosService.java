package com.App.APP.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.APP.DTO.PrivilegiosDTO;
import com.App.APP.Entity.Privilegios;
import com.App.APP.Mapper.PrivilegiosMapper;
import com.App.APP.Repositorio.PrivilegiosRepositorio;

@Service

public class PrivilegiosService {

    @Autowired
    private PrivilegiosRepositorio privilegiosRepositorio;

    public List<PrivilegiosDTO> SearchEntityPrivilegios(){
        List<Privilegios> privilegiosList = privilegiosRepositorio.findAll();
        return privilegiosList.stream().map(PrivilegiosMapper::DatosToDTO).collect(Collectors.toList());
    } 

    public Optional<PrivilegiosDTO> SearchEntityOnePrivilegios(int idPrivilegio){
        Optional<Privilegios> privilegiosOne = privilegiosRepositorio.findById(idPrivilegio);
        return privilegiosOne.map(PrivilegiosMapper::DatosToDTO);
    }

    public PrivilegiosDTO SaveEntityPrivilegios(PrivilegiosDTO privilegiosDTO){
        Privilegios privilegios = PrivilegiosMapper.DatosToEntity(privilegiosDTO);
        Privilegios savePrivilegios = privilegiosRepositorio.save(privilegios);
        return PrivilegiosMapper.DatosToDTO(savePrivilegios);
    }

    public void DeleteEntityPrivilegios(int idPrivilegio){
        privilegiosRepositorio.deleteById(idPrivilegio);
    }

    public void EditEntityPrivilegios(int idPrivilegio, PrivilegiosDTO privilegiosDTO){
        Privilegios privilegiosEncontrado = privilegiosRepositorio.findById(idPrivilegio).orElseThrow(() -> new RuntimeException("Privilegios no encontrado"));

        privilegiosEncontrado.setUrl(privilegiosDTO.getUrl());
        privilegiosEncontrado.setNombreprivi(privilegiosDTO.getNombreprivi());

        privilegiosRepositorio.save(privilegiosEncontrado);
    }
}
