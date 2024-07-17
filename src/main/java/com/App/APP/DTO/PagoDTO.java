package com.App.APP.DTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagoDTO {

    private int id_pago;
    private Date fecha;
    private Double pago;
    private int n_sesion;
    private int diagnostico_idhc;

}
