package com.App.APP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.App.APP.DTO.DescuentoDTO;
import com.App.APP.Service.DescuentoService;

@RestController
@RequestMapping(value = "/api/v1/descuento")
@CrossOrigin("/**")
public class DescuentoController {
    @Autowired
    private DescuentoService descuentoService;

    @GetMapping()
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<List<DescuentoDTO>> listAllDescuentoDTO() {
        List<DescuentoDTO> descuentoList = descuentoService.SearchAllDescuento();
        if (descuentoList == null) {
            return new ResponseEntity("Lista de Descuentos vacios", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(descuentoList, HttpStatus.OK);
    }

    @PostMapping
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<?> saveDescuento(DescuentoDTO descuentoDTO) {
        try {
            descuentoService.SaveDescuento(descuentoDTO);
            return new ResponseEntity("Descuento guardado", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity("No se puedo guardar el descuento", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<?> editDescuento(@PathVariable("id") int idDescuento, DescuentoDTO descuentoDTO) {
        try {
            descuentoService.editDescuento(idDescuento, descuentoDTO);
            return new ResponseEntity("Descuento actualizado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("No se puedo actualizar el descuento", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<?> deleteDescuento(@PathVariable("id") int idDescuento) {
        try {
            descuentoService.deleteDescuento(idDescuento);
            return new ResponseEntity("Descuento eliminado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("No se puedo eliminar el descuento", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
