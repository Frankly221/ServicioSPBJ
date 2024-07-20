package com.App.APP.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tip_DocDTO {
    private int id_doc;
    private String nombre_doc;

    // List<PersonaDTO> personaDTO;
}
