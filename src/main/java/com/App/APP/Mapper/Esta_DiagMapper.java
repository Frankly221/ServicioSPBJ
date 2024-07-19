package com.App.APP.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.App.APP.DTO.DiagnosticoDTO;
import com.App.APP.DTO.Esta_DiagDTO;
import com.App.APP.Entity.Esta_Diag;

public class Esta_DiagMapper {

    public static Esta_DiagDTO DatosToDTO(Esta_Diag esta_Diag){

            List<DiagnosticoDTO> diagnosticosDTO = esta_Diag.getDiagnosticos().stream().map(DiagnosticoMapper::DatosToDTO).collect(Collectors.toList());


        return Esta_DiagDTO.builder()
        .estado(esta_Diag.getEstado())
        .diagnosticoDTO(diagnosticosDTO)
                .build();


    }

    
    public static Esta_Diag DatosToEntity(Esta_DiagDTO esta_DiagDTO){


    return Esta_Diag.builder()
    .estado(esta_DiagDTO.getEstado())
            .build();


}


    
}
