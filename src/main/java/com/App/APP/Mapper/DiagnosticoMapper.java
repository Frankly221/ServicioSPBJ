package com.App.APP.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.App.APP.DTO.DiagnosticoDTO;
import com.App.APP.DTO.PersonaDTO;
import com.App.APP.DTO.PagoDTO;
import com.App.APP.DTO.SesionesDTO;
import com.App.APP.Entity.Diagnostico;
import com.App.APP.Entity.Pago;
import com.App.APP.Entity.Persona;

public class DiagnosticoMapper {
    public static DiagnosticoDTO DatosSeguimientoYPagoToDTO(Diagnostico diagnostico) {
        DiagnosticoDTO diagnosticoDTO = DiagnosticoDTO.builder()
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
                .build();

        if (diagnostico.getPagos() != null && !diagnostico.getPagos().isEmpty()) {
            List<PagoDTO> pagos = diagnostico.getPagos().stream().map(PagoMapper::DatosToDTO)
                    .collect(Collectors.toList());
            diagnosticoDTO.setPagosDTOs(pagos);
        }
        if (diagnostico.getSesiones() != null && !diagnostico.getSesiones().isEmpty()) {
            List<SesionesDTO> sesiones = diagnostico.getSesiones().stream().map(SesionesMapper::DatosToDTO)
                    .collect(Collectors.toList());
            diagnosticoDTO.setSesionesDTOs(sesiones);
        }

        return diagnosticoDTO;
    }

    public static DiagnosticoDTO DatosToDTO(Diagnostico diagnostico) {
        DiagnosticoDTO diagnosticoDTO = DiagnosticoMapper.DatosSeguimientoYPagoToDTO(diagnostico);
        PersonaDTO persona = PersonaDTO.builder()
                .idpersona(diagnostico.getPersona().getIdpersona())
                .nombre(diagnostico.getPersona().getNombre())
                .apellido(diagnostico.getPersona().getApellido())
                .build();
        diagnosticoDTO.setPersonaDTO(persona);
        return diagnosticoDTO;
    }

    public static Diagnostico DatosToEntity(DiagnosticoDTO diagnosticoDTO) {
        Diagnostico diagnostico = Diagnostico.builder()
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

        if (diagnosticoDTO.getPagosDTOs() != null && !diagnosticoDTO.getPagosDTOs().isEmpty()) {
            List<Pago> pagos = diagnosticoDTO.getPagosDTOs().stream().map(PagoMapper::DatosToEntity)
                    .collect(Collectors.toList());
            diagnostico.setPagos(pagos);
        }

        Persona persona = Persona.builder().idpersona(diagnosticoDTO.getPersonaDTO().getIdpersona()).build();
        diagnostico.setPersona(persona);
        return diagnostico;
    }

}
