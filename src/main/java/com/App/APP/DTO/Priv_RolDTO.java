package com.App.APP.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Priv_RolDTO {

    
    private int id_priv_rol;


    private PrivilegiosDTO privilegiosDTO;

    // private RolDTO rolDTO;

    
}
