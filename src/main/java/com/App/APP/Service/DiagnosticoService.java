package com.App.APP.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.APP.DTO.DiagnosticoDTO;
import com.App.APP.Entity.Diagnostico;
import com.App.APP.Mapper.DiagnosticoMapper;
import com.App.APP.Repositorio.DiagnosticoRepository;

@Service
public class DiagnosticoService {
    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    public List<DiagnosticoDTO> SearchAllDiagnostico() {
        List<Diagnostico> diagnosticoList = diagnosticoRepository.findAll();
        if (diagnosticoList.isEmpty()) {
            return null;
        }
        return diagnosticoList.stream().map(DiagnosticoMapper::DatosToDTO).collect(Collectors.toList());
    }

    public void SaveDiagnostico(DiagnosticoDTO diagnosticoDTO) {
        Diagnostico Diagnostico = DiagnosticoMapper.DatosToEntity(diagnosticoDTO);
        diagnosticoRepository.save(Diagnostico);
    }

    public void editDiagnostico(int idDiagnostico, DiagnosticoDTO diagnosticoDTO) {
        Diagnostico diagnosticoEncontrado = searchEntityDiagnostico(idDiagnostico);
        diagnosticoEncontrado.setInic_enferm(diagnosticoDTO.getInic_enferm());
        diagnosticoEncontrado.setEtiologia(diagnosticoDTO.getEtiologia());
        diagnosticoEncontrado.setDiagnostico(diagnosticoDTO.getDiagnostico());
        diagnosticoEncontrado.setObservacion(diagnosticoDTO.getObservacion());
        diagnosticoEncontrado.setFecha_eval(diagnosticoDTO.getFecha_eval());
        diagnosticoEncontrado.setPeso(diagnosticoDTO.getPeso());
        diagnosticoEncontrado.setTalla(diagnosticoDTO.getTalla());
        diagnosticoEncontrado.setEnf_cronica(diagnosticoDTO.getEnf_cronica());
        diagnosticoEncontrado.setN_sesion(diagnosticoDTO.getN_sesion());
        diagnosticoEncontrado.setPlan_pago(diagnosticoDTO.getPlan_pago());
        diagnosticoEncontrado.setMonto_total(diagnosticoDTO.getMonto_total());
        diagnosticoEncontrado.setEdad(diagnosticoDTO.getEdad());

        diagnosticoRepository.save(diagnosticoEncontrado);
    }

    public void deleteDiagnostico(int idDiagnostico) {
        Diagnostico DiagnosticoEncontrado = searchEntityDiagnostico(idDiagnostico);
        diagnosticoRepository.delete(DiagnosticoEncontrado);
    }

    private Diagnostico searchEntityDiagnostico(int idDiagnostico) {
        return diagnosticoRepository.findById(idDiagnostico)
                .orElseThrow(() -> new RuntimeException("Diagnostico No encontrado con el id " + idDiagnostico));
    }

}
