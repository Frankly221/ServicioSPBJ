package com.App.APP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.App.APP.DTO.PagoDTO;
import com.App.APP.Service.PagoService;

public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping()
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<List<PagoDTO>> listAllPagoDTO() {
        List<PagoDTO> pagoList = pagoService.SearchAllPago();
        if (pagoList == null) {
            return new ResponseEntity("Lista de Pagos vacía", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(pagoList, HttpStatus.OK);
    }

    @PostMapping
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<?> savePago(PagoDTO pagoDTO) {
        try {
            pagoService.SavePago(pagoDTO);
            return new ResponseEntity("Pago guardado", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity("No se pudo guardar el pago", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<?> editPago(@PathVariable("id") int idPago, PagoDTO pagoDTO) {
        try {
            pagoService.editPago(idPago, pagoDTO);
            return new ResponseEntity("Pago actualizado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("No se pudo actualizar el pago", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<?> deletePago(@PathVariable("id") int idPago) {
        try {
            pagoService.deletePago(idPago);
            return new ResponseEntity("Pago eliminado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("No se pudo eliminar el pago", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
