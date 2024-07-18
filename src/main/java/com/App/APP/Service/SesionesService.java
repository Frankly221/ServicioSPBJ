package com.App.APP.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.APP.DTO.SesionesDTO;
import com.App.APP.Entity.Sesiones;
import com.App.APP.Mapper.SesionesMapper;
import com.App.APP.Repositorio.SesionesRepository;

@Service
public class SesionesService {

    @Autowired
    private SesionesRepository sesionesRepository;

    public List<SesionesDTO> SearchAllSesiones() {
        List<Sesiones> sesionesList = sesionesRepository.findAll();
        if (sesionesList.isEmpty()) {
            return null;
        }
        return sesionesList.stream().map(SesionesMapper::DatosToDTO).collect(Collectors.toList());
    }

    public void SaveSesiones(SesionesDTO sesionesDTO) {
        Sesiones Sesiones = SesionesMapper.DatosToEntity(sesionesDTO);
        sesionesRepository.save(Sesiones);
    }

    public void editSesiones(int idSesiones, SesionesDTO sesionesDTO) {
        Sesiones sesionesEncontrado = searchEntitySesiones(idSesiones);
        sesionesEncontrado.setFecha(sesionesDTO.getFecha());
        sesionesEncontrado.setDescripcion(sesionesDTO.getDescripcion());
        sesionesEncontrado.setTipo(sesionesDTO.getTipo());
        sesionesEncontrado.setHora(sesionesDTO.getHora());
        sesionesEncontrado.setAsistio(sesionesDTO.getAsistio());
        sesionesRepository.save(sesionesEncontrado);
    }

    public void deleteSesiones(int idSesiones) {
        Sesiones SesionesEncontrado = searchEntitySesiones(idSesiones);
        sesionesRepository.delete(SesionesEncontrado);
    }

    private Sesiones searchEntitySesiones(int idSesiones) {
        return sesionesRepository.findById(idSesiones)
                .orElseThrow(() -> new RuntimeException("Sesiones No encontrado con el id " + idSesiones));
    }
}
