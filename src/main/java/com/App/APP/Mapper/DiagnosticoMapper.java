package com.App.APP.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.App.APP.DTO.DiagnosticoDTO;
import com.App.APP.DTO.PagoDTO;
import com.App.APP.DTO.SesionesDTO;
import com.App.APP.Entity.Diagnostico;

public class DiagnosticoMapper {
    public static DiagnosticoDTO DatosToDTO(Diagnostico diagnostico) {

        List<SesionesDTO> sesionesDTO = diagnostico.getSesiones().stream().map(SesionesMapper::DatosToDTO).collect(Collectors.toList());
        List<PagoDTO> pagoDTO = diagnostico.getPagos().stream().map(PagoMapper::DatosToDTO).collect(Collectors.toList());

        // Persona persona = diagnostico.getPersona();
        //  PersonaDTO personasDTO = persona != null ? PersonaMapper.DatosNameToDTO(persona) : null;

        return DiagnosticoDTO.builder()
                .idhc(diagnostico.getIdhc())
                .inic_enferm(diagnostico.getInic_enferm())
                .etiologia(diagnostico.getEtiologia())
                .diagnostico(diagnostico.getDiagnostico())
                .observacion(diagnostico.getObservacion())
                .fecha_eval(diagnostico.getFecha_eval())
                .peso(diagnostico.getPeso())
                .talla(diagnostico.getTalla())
                .enf_cronica(diagnostico.getEnf_cronica())
                .n_sesion(diagnostico.getN_sesion())
                .plan_pago(diagnostico.getPlan_pago())
                .monto_total(diagnostico.getMonto_total())
                .edad(diagnostico.getEdad())
                // .personaDTO(personasDTO)
                .sesionesDTOS(sesionesDTO)
                .pagosDTOS(pagoDTO)
                .build();
    }

    public static Diagnostico DatosToEntity(DiagnosticoDTO diagnosticoDTO) {
        return Diagnostico.builder()
                .idhc(diagnosticoDTO.getIdhc())
                .inic_enferm(diagnosticoDTO.getInic_enferm())
                .etiologia(diagnosticoDTO.getEtiologia())
                .diagnostico(diagnosticoDTO.getDiagnostico())
                .observacion(diagnosticoDTO.getObservacion())
                .fecha_eval(diagnosticoDTO.getFecha_eval())
                .peso(diagnosticoDTO.getPeso())
                .talla(diagnosticoDTO.getTalla())
                .enf_cronica(diagnosticoDTO.getEnf_cronica())
                .n_sesion(diagnosticoDTO.getN_sesion())
                .plan_pago(diagnosticoDTO.getPlan_pago())
                .monto_total(diagnosticoDTO.getMonto_total())
                .edad(diagnosticoDTO.getEdad())
                .build();
    }

}
