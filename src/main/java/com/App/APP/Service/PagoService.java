package com.App.APP.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.APP.DTO.PagoDTO;
import com.App.APP.Entity.Diagnostico;
import com.App.APP.Entity.Pago;
import com.App.APP.Mapper.PagoMapper;
import com.App.APP.Repositorio.PagoRepository;

@Service
public class PagoService {
    @Autowired
    private PagoRepository pagoRepository;

    public void SavePago(PagoDTO pagoDTO) {
        Pago Pago = PagoMapper.DatosToEntity(pagoDTO);
        pagoRepository.save(Pago);
    }

    public void editPago(int idPago, PagoDTO pagoDTO) {
        Pago pagoEncontrado = searchEntityPago(idPago);
        pagoEncontrado.setFecha(pagoDTO.getFecha());
        pagoEncontrado.setPago(pagoDTO.getPago());
        pagoEncontrado.setN_sesion(pagoDTO.getN_sesion());
        pagoRepository.save(pagoEncontrado);
    }

    public void deletePago(int idPago) {
        Pago PagoEncontrado = searchEntityPago(idPago);
        pagoRepository.delete(PagoEncontrado);
    }

    private Pago searchEntityPago(int idPago) {
        Pago PagoEncontrado = pagoRepository.findById(idPago).orElse(null);
        if (PagoEncontrado == null) {
            throw new RuntimeException("El pago no existe");
        }
        return PagoEncontrado;
    }

    public void actualizarListaPagos(List<Pago> pagos, int idDiagnostico) {
        List<Pago> listaOriginal = pagoRepository.findByDiagnosticoId(idDiagnostico);
        Set<Integer> originalIds = listaOriginal.stream().map(Pago::getId_pago).collect(Collectors.toSet());

        for (Pago pagOriginal : listaOriginal) {
            if (pagos.stream().noneMatch(p -> p.getId_pago() == pagOriginal.getId_pago())) {
                pagoRepository.deleteById(pagOriginal.getId_pago());
            }
        }

        for (Pago pago : pagos) {
            if (pago.getPago() > 0) {
                if (originalIds.contains(pago.getId_pago()) || pago.getId_pago() == 0) {
                    Diagnostico diag = Diagnostico.builder().idhc(idDiagnostico).build();
                    pago.setDiagnostico(diag);
                    pagoRepository.save(pago);
                }
            }
        }
    }

}
