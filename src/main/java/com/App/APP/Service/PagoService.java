package com.App.APP.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.APP.DTO.PagoDTO;
import com.App.APP.Entity.Pago;
import com.App.APP.Mapper.PagoMapper;
import com.App.APP.Repositorio.PagoRepository;

@Service
public class PagoService {
     @Autowired
    private PagoRepository pagoRepository;

    public List<PagoDTO> SearchAllPago() {
        List<Pago> pagoList = pagoRepository.findAll();
        if (pagoList.isEmpty()) {
            return null;
        }
        return pagoList.stream().map(PagoMapper::DatosToDTO).collect(Collectors.toList());
    }

    public void SavePago(PagoDTO pagoDTO) {
        Pago Pago = PagoMapper.DatosToEntity(pagoDTO);
        pagoRepository.save(Pago);
    }

    public void editPago(int idPago, PagoDTO pagoDTO) {
        Pago pagoEncontrado = searchEntityPago(idPago);
        pagoEncontrado.setFecha(pagoDTO.getFecha());
        pagoEncontrado.setPago(pagoDTO.getPago());
        pagoEncontrado.setN_sesion(pagoDTO.getN_sesion());
        pagoEncontrado.setDiagnostico_idhc(pagoDTO.getDiagnostico_idhc());

        pagoRepository.save(pagoEncontrado);
    }

    public void deletePago(int idPago) {
        Pago PagoEncontrado = searchEntityPago(idPago);
        pagoRepository.delete(PagoEncontrado);
    }

    private Pago searchEntityPago(int idPago) {
        return pagoRepository.findById(idPago)
                .orElseThrow(() -> new RuntimeException("Pago No encontrado con el id " + idPago));
    }

}
