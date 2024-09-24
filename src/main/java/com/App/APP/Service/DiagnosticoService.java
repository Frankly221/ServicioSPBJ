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

    @Autowired
    private PagoService pagoService;

    public List<DiagnosticoDTO> SearchAllDiagnostico() {
        List<Diagnostico> diagnosticoList = diagnosticoRepository.findAll();
        for (Diagnostico diagnostico : diagnosticoList) {
            diagnostico.getPagos();
            diagnostico.getSesiones();
        }
        return diagnosticoList.stream().map(DiagnosticoMapper::DatosSeguimientoYPagoToDTO).collect(Collectors.toList());
    }

    public DiagnosticoDTO getDiagnosticoById(int idDiagnostico) {
        Diagnostico diagnostico = diagnosticoRepository.findById(idDiagnostico)
                .orElseThrow(() -> new RuntimeException("Diagnostico ya existe con el id " + idDiagnostico));
        diagnostico.getPagos();
        diagnostico.getSesiones();
        diagnostico.getPersona();
        return DiagnosticoMapper.DatosToDTO(diagnostico);
    }

    public void SaveDiagnostico(DiagnosticoDTO diagnosticoDTO) {
        if (diagnosticoRepository.existsById(diagnosticoDTO.getIdhc()))
            new RuntimeException("Diagnostico ya existe con el id " + diagnosticoDTO.getIdhc());
        Diagnostico diagnostico = DiagnosticoMapper.DatosToEntity(diagnosticoDTO);
        Diagnostico diagnosticoGuardado = diagnosticoRepository.save(diagnostico);

        if (diagnostico.getPagos() != null && !diagnostico.getPagos().isEmpty()) {
            pagoService.actualizarListaPagos(diagnostico.getPagos(), diagnosticoGuardado.getIdhc());
        }
    }

    public DiagnosticoDTO editDiagnostico(int idDiagnostico, DiagnosticoDTO diagnosticoDTO) {
        if (!diagnosticoRepository.existsById(idDiagnostico))
            new RuntimeException("Diagnostico no encontrado con el id " + idDiagnostico);
        Diagnostico diagnostico = DiagnosticoMapper.DatosToEntity(diagnosticoDTO);
        if (diagnostico.getPagos() != null && !diagnostico.getPagos().isEmpty()) {
            pagoService.actualizarListaPagos(diagnostico.getPagos(), idDiagnostico);
        }
        diagnosticoRepository.save(diagnostico);
        return DiagnosticoMapper.DatosToDTO(diagnostico);
    }

    public void deleteDiagnostico(int idDiagnostico) {
        diagnosticoRepository.deleteById(idDiagnostico);
    }
}
