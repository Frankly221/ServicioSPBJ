package com.App.APP.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.APP.DTO.TarifarioDTO;
import com.App.APP.Entity.Tarifario;
import com.App.APP.Mapper.TarifarioMapper;
import com.App.APP.Repositorio.TarifarioRepository;

@Service
public class TarifarioService {
    @Autowired
    private TarifarioRepository tarifarioRepository;

    public List<TarifarioDTO> SearchAllTarifario() {
        List<Tarifario> tarifarioList = tarifarioRepository.findAll();
        if (tarifarioList.isEmpty()) {
            return null;
        }
        return tarifarioList.stream().map(TarifarioMapper::DatosToDTO).collect(Collectors.toList());
    }

    public void SaveTarifario(TarifarioDTO tarifarioDTO) {
        Tarifario tarifario = TarifarioMapper.DatosToEntity(tarifarioDTO);
        tarifarioRepository.save(tarifario);
    }

    public void editTarifario(int idTarifario, TarifarioDTO tarifarioDTO) {
        Tarifario tarifarioEncontrado = searchEntityTarifario(idTarifario);
        tarifarioEncontrado.setPrecio(tarifarioDTO.getPrecio());

        tarifarioRepository.save(tarifarioEncontrado);
    }

    public void deleteTarifario(int idTarifario) {
        Tarifario tarifarioEncontrado = searchEntityTarifario(idTarifario);
        tarifarioRepository.delete(tarifarioEncontrado);
    }

    private Tarifario searchEntityTarifario(int idTarifario) {
        return tarifarioRepository.findById(idTarifario)
                .orElseThrow(() -> new RuntimeException("Tarifario No encontrado con el id " + idTarifario));
    }
}
