package com.App.APP.Mapper;

import com.App.APP.DTO.DiagnosticoDTO;
import com.App.APP.DTO.Esta_DiagDTO;
import com.App.APP.Entity.Diagnostico;
import com.App.APP.Entity.Esta_Diag;

public class DiagnosticoMapper {
    public static DiagnosticoDTO DatosToDTO(Diagnostico diagnostico) {

        // List<SesionesDTO> sesionesDTO = diagnostico.getSesiones().stream().map(SesionesMapper::DatosToDTO).collect(Collectors.toList());
        // List<PagoDTO> pagoDTO = diagnostico.getPagos().stream().map(PagoMapper::DatosToDTO).collect(Collectors.toList());

        // Persona persona = diagnostico.getPersona();
        //  PersonaDTO personasDTO = persona != null ? PersonaMapper.DatosNameToDTO(persona) : null;
        
        Esta_Diag esta_Diag = diagnostico.getEsta_diag();
        Esta_DiagDTO esta_DiagDTOss = Esta_DiagMapper.DatosToDTO(esta_Diag);


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
                .esta_DiagDTO(esta_DiagDTOss)
                // .personaDTO(personasDTO)
                // .sesionesDTOS(sesionesDTO)
                // .pagosDTOS(pagoDTO)
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
