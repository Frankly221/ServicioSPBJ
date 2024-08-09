package com.App.APP.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.App.APP.DTO.DiagnosticoDTO;
import com.App.APP.DTO.PersonaConSesionesDTO;
import com.App.APP.DTO.PersonaDTO;
import com.App.APP.DTO.SesionesDTO;
import com.App.APP.Entity.Persona;
import com.App.APP.Entity.Sesiones;

public class PersonaMapper {

    public static PersonaDTO DatosPrimariosToDTO(Persona persona) {
        return PersonaDTO.builder()
                .nombre(persona.getNombre())
                .idpersona(persona.getIdpersona())
                .apellido(persona.getApellido())
                .domicilio(persona.getDomicilio())
                .fecha_nac(persona.getFecha_nac())
                .lugar_nac(persona.getLugar_nac())
                .referencia(persona.getReferencia())
                .estado_civil(persona.getEstado_civil())
                .n_hijos(persona.getN_hijos())
                .residencia(persona.getResidencia())
                .tipo_documento(persona.getTipo_documento())
                .ndoc_documento(persona.getNdoc_documento())
                .correo(persona.getCorreo())
                .genero(persona.getGenero())
                .telefono(persona.getTelefono())
                .build();
    }

    public static PersonaDTO DatosToDTO(Persona persona) {
        PersonaDTO personaDTO = DatosPrimariosToDTO(persona);

        if (persona.getDiagnosticos() != null && !persona.getDiagnosticos().isEmpty()) {
            List<DiagnosticoDTO> diagnosticosDTO = persona.getDiagnosticos().stream().map(DiagnosticoMapper::DatosToDTO)
                    .collect(Collectors.toList());
            personaDTO.setDiagnosticosDTO(diagnosticosDTO);
        }

        return personaDTO;
    }

    public static Persona DatosPrimariosToEntity(PersonaDTO personaDTO) {
        return Persona.builder()
                .idpersona(personaDTO.getIdpersona())
                .nombre(personaDTO.getNombre())
                .apellido(personaDTO.getApellido())
                .estado_civil(personaDTO.getEstado_civil())
                .n_hijos(personaDTO.getN_hijos())
                .residencia(personaDTO.getResidencia())
                .domicilio(personaDTO.getDomicilio())
                .fecha_nac(personaDTO.getFecha_nac())
                .lugar_nac(personaDTO.getLugar_nac())
                .referencia(personaDTO.getReferencia())
                .tipo_documento(personaDTO.getTipo_documento())
                .ndoc_documento(personaDTO.getNdoc_documento())
                .correo(personaDTO.getCorreo())
                .genero(personaDTO.getGenero())
                .telefono(personaDTO.getTelefono())
                .build();
    }

    public static Persona DatosToEntity(PersonaDTO personaDTO) {
        Persona persona = DatosPrimariosToEntity(personaDTO);
        return persona;
    }




    //lOGICA PARA PERSONA CON SESIONES

    public static PersonaConSesionesDTO DatosToDTOWithSesion(Persona persona, List<Sesiones> sesiones){

        List<SesionesDTO> sesionesDTOs = sesiones.stream()
                                                        .map(SesionesMapper::DatosToDTO).collect(Collectors.toList());


        return PersonaConSesionesDTO.builder()
        .nombre(persona.getNombre())
        .idpersona(persona.getIdpersona())
        .apellido(persona.getApellido())
        .domicilio(persona.getDomicilio())
        .fecha_nac(persona.getFecha_nac())
        .lugar_nac(persona.getLugar_nac())
        .referencia(persona.getReferencia())
        .estado_civil(persona.getEstado_civil())
        .n_hijos(persona.getN_hijos())
        .residencia(persona.getResidencia())
        .tipo_documento(persona.getTipo_documento())
        .ndoc_documento(persona.getNdoc_documento())
        .correo(persona.getCorreo())
        .sesionesDTO(sesionesDTOs)
        .build();

    }

   
}
