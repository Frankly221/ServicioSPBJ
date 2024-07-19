package com.App.APP.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.App.APP.DTO.PersonaDTO;
import com.App.APP.DTO.Tip_DocDTO;
import com.App.APP.Entity.Tip_Doc;

public class Tip_DocMapper {

    public static Tip_DocDTO DatosToDTO(Tip_Doc tip_Doc){

            List<PersonaDTO> personasDTO = tip_Doc.getPersona().stream().map(
                PersonaMapper::DatosToDTO
            ).collect(Collectors.toList());


        return Tip_DocDTO.builder()
        .id_doc(tip_Doc.getId_doc())
        .nombre_doc(tip_Doc.getNombre_doc())
        .personaDTO(personasDTO)
        .build();
    }

    public static Tip_Doc DatosToEntity(Tip_DocDTO tip_DocDTO){

    return Tip_Doc.builder()
    .id_doc(tip_DocDTO.getId_doc())
    .nombre_doc(tip_DocDTO.getNombre_doc())
    .build();
}


    
}
