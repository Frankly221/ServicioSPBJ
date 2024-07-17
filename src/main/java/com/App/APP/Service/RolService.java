package com.App.APP.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.APP.DTO.RolDTO;
import com.App.APP.Entity.Rol;
import com.App.APP.Mapper.RolMapper;
import com.App.APP.Repositorio.RolRepositorio;

@Service

public class RolService {

    @Autowired
    private RolRepositorio rolRepositorio;

    public List<RolDTO> SearchEntityRol(){
        List<Rol> rolList = rolRepositorio.findAll();
        return rolList.stream().map(RolMapper::DatosToDTO).collect(Collectors.toList());
    } 

    public Optional<RolDTO> SearchEntityOneRol(int idRol){
        Optional<Rol> rolOne = rolRepositorio.findById(idRol);
        return rolOne.map(RolMapper::DatosToDTO);
    }

    public RolDTO SaveEntityRol(RolDTO rolDTO){
        Rol rol = RolMapper.DatosToEntity(rolDTO);
        Rol saveRol = rolRepositorio.save(rol);
        return RolMapper.DatosToDTO(saveRol);
    }

    public void DeleteEntityRol(int idRol){
        rolRepositorio.deleteById(idRol);
    }

    public void EditEntityRol(int idRol, RolDTO rolDTO){
        Rol rolEncontrado = rolRepositorio.findById(idRol).orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        rolEncontrado.setNombre_rol(rolDTO.getNombre_rol());

        rolRepositorio.save(rolEncontrado);
    }
}
