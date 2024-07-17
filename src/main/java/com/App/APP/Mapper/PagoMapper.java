package com.App.APP.Mapper;

import com.App.APP.DTO.PagoDTO;
import com.App.APP.Entity.Pago;

public class PagoMapper {

    public static PagoDTO DatosToDTO(Pago pago) {
        return PagoDTO.builder()
                .id_pago(pago.getId_pago())
                .fecha(pago.getFecha())
                .pago(pago.getPago())
                .n_sesion(pago.getN_sesion())
                .diagnostico_idhc(pago.getDiagnostico_idhc())
                .build();
    }

    public static Pago DatosToEntity(PagoDTO pagoDTO) {
        return Pago.builder()
                .id_pago(pagoDTO.getId_pago())
                .fecha(pagoDTO.getFecha())
                .pago(pagoDTO.getPago())
                .n_sesion(pagoDTO.getN_sesion())
                .diagnostico_idhc(pagoDTO.getDiagnostico_idhc())
                .build();
    }

}
