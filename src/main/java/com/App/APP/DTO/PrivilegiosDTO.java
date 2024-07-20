package com.App.APP.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PrivilegiosDTO {

    private int id_privilegio;

    private String url;

    private String nombreprivi;

    // private List<Priv_RolDTO> priv_rolDTO;

    
}
