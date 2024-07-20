package com.App.APP.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RolDTO {
    private int idrol;

    private String nombre_rol;

    // private List<Priv_RolDTO> priv_rolDTO;

    
}
