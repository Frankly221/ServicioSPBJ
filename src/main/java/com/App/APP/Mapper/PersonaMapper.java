package com.App.APP.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.App.APP.DTO.DiagnosticoDTO;
import com.App.APP.DTO.PersonaDTO;
import com.App.APP.DTO.TelefonoDTO;
import com.App.APP.Entity.Persona;

public class PersonaMapper {



    public static PersonaDTO DatosToDTO(Persona persona){

        List<DiagnosticoDTO> diagnosticosDTO = persona.getDiagnosticos().stream().map(DiagnosticoMapper::DatosToDTO)
        .collect(Collectors.toList());

        List<TelefonoDTO> telefonosDTO = persona.getTelefonosecundario().stream().map(TelefonoMapper::DatosToDTO)
        .collect(Collectors.toList());


        return PersonaDTO.builder()
        .idpersona(persona.getIdpersona())
        .apellido(persona.getApellido())
        .domicilio(persona.getDomicilio())
        .fecha_nac(persona.getFecha_nac())
        .lugar_nac(persona.getLugar_nac())
        .referencia(persona.getReferencia())
        .tipo_documento(persona.getTipo_documento())
        .ndoc_documento(persona.getNdoc_documento())
        .correo(persona.getCorreo())
        .telefono(persona.getTelefono())
        .diagnosticosDTO(diagnosticosDTO)   
        .telefonoDTO(telefonosDTO)  
        .build();
        
    }


    public static Persona DatosToEntity(PersonaDTO personaDTO){



        return Persona.builder()
        .idpersona(personaDTO.getIdpersona())
        .apellido(personaDTO.getApellido())
        .domicilio(personaDTO.getDomicilio())
        .fecha_nac(personaDTO.getFecha_nac())
        .lugar_nac(personaDTO.getLugar_nac())
        .referencia(personaDTO.getReferencia())
        .tipo_documento(personaDTO.getTipo_documento())
        .ndoc_documento(personaDTO.getNdoc_documento())
        .correo(personaDTO.getCorreo())
        .telefono(personaDTO.getTelefono())     
        .build();
        
    }
    public static PersonaDTO DatosNameToDTO(Persona persona){

        return PersonaDTO.builder()
        .nombre(persona.getNombre())
        .build();

    }
    
}
