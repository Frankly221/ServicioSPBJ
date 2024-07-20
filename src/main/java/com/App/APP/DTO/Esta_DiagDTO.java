package com.App.APP.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Esta_DiagDTO {

    private int id_esta_diag;
    
    private String estado;

    // List<DiagnosticoDTO> diagnosticoDTO;
    
}
