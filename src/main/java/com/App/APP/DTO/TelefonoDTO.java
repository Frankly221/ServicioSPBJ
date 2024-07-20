package com.App.APP.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TelefonoDTO {

    private int idtf;
    private int telefono;

    // private PersonaDTO personaDTO;
    
}
