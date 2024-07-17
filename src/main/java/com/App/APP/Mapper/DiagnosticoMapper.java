package com.App.APP.Mapper;

import com.App.APP.DTO.DiagnosticoDTO;
import com.App.APP.Entity.Diagnostico;

public class DiagnosticoMapper {
    public static DiagnosticoDTO DatosToDTO(Diagnostico diagnostico) {
        return DiagnosticoDTO.builder()
                .idhc(diagnostico.getIdhc())
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
                .persona_idpersona(diagnostico.getPersona_idpersona())
                .build();
    }

    public static Diagnostico DatosToEntity(DiagnosticoDTO diagnosticoDTO) {
        return Diagnostico.builder()
                .idhc(diagnosticoDTO.getIdhc())
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
                .persona_idpersona(diagnosticoDTO.getPersona_idpersona())
                .build();
    }

}
