package com.App.APP.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.APP.DTO.Priv_RolDTO;
import com.App.APP.Entity.Priv_Rol;
import com.App.APP.Mapper.Priv_RolMapper;
import com.App.APP.Repositorio.Priv_RolRepositorio;

@Service

public class Priv_RolService {

    @Autowired
    private Priv_RolRepositorio priv_RolRepositorio;

    public List<Priv_RolDTO> SearchEntityPriv_Rol(){
        List<Priv_Rol> priv_RolList = priv_RolRepositorio.findAll();
        return priv_RolList.stream().map(Priv_RolMapper::DatosToDTO).collect(Collectors.toList());
    } 

    public Optional<Priv_RolDTO> SearchEntityOnePriv_Rol(int idPriv_Rol){
        Optional<Priv_Rol> priv_RolOne = priv_RolRepositorio.findById(idPriv_Rol);
        return priv_RolOne.map(Priv_RolMapper::DatosToDTO);
    }

    public Priv_RolDTO SaveEntityPriv_Rol(Priv_RolDTO priv_RolDTO){
        Priv_Rol priv_Rol = Priv_RolMapper.DatosToEntity(priv_RolDTO);
        Priv_Rol savePriv_Rol = priv_RolRepositorio.save(priv_Rol);
        return Priv_RolMapper.DatosToDTO(savePriv_Rol);
    }

    public void DeleteEntityPriv_Rol(int idPriv_Rol){
        priv_RolRepositorio.deleteById(idPriv_Rol);
    }

    public void EditEntityPriv_Rol(int idPriv_Rol, Priv_RolDTO priv_RolDTO){
        Priv_Rol priv_RolEncontrado = priv_RolRepositorio.findById(idPriv_Rol).orElseThrow(() -> new RuntimeException("Priv_Rol no encontrado"));


        priv_RolRepositorio.save(priv_RolEncontrado);
    }
}
