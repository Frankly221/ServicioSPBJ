package com.App.APP.Mapper;

import com.App.APP.DTO.PersonaDTO;
import com.App.APP.Entity.Persona;

public class PersonaMapper {

    public static PersonaDTO DatosToDTO(Persona persona){


        return PersonaDTO.builder()
        .idpersona(persona.getIdpersona())
        .apellido(persona.getApellido())
        .domicilio(persona.getDomicilio())
        .fecha_nac(persona.getFecha_nac())
        .lugar_nac(persona.getLugar_nac())
        .telefono(persona.getTelefono())
        .referencia(persona.getReferencia())
        .tipo_documento(persona.getTipo_documento())
        .ndoc_documento(persona.getNdoc_documento())
        .correo(persona.getCorreo())     
        .build();
        
    }


    public static Persona DatosToEntity(PersonaDTO personaDTO){


        return Persona.builder()
        .idpersona(personaDTO.getIdpersona())
        .apellido(personaDTO.getApellido())
        .domicilio(personaDTO.getDomicilio())
        .fecha_nac(personaDTO.getFecha_nac())
        .lugar_nac(personaDTO.getLugar_nac())
        .telefono(personaDTO.getTelefono())
        .referencia(personaDTO.getReferencia())
        .tipo_documento(personaDTO.getTipo_documento())
        .ndoc_documento(personaDTO.getNdoc_documento())
        .correo(personaDTO.getCorreo())     
        .build();
        
    }
    
}
