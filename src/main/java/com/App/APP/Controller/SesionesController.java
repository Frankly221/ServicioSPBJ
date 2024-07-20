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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.App.APP.DTO.SesionesDTO;
import com.App.APP.Service.SesionesService;


@RestController
@RequestMapping(value = "/api/v1/sesiones")
@CrossOrigin("/**")
public class SesionesController {

    @Autowired
    private SesionesService sesionesService;

    @GetMapping()
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<List<SesionesDTO>> listAllSesionesDTO() {
        List<SesionesDTO> sesionesList = sesionesService.SearchAllSesiones();
        if (sesionesList == null) {
            return new ResponseEntity("Lista de Sesiones vacías", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(sesionesList, HttpStatus.OK);
    }

    @PostMapping
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<?> saveSesiones(@RequestBody SesionesDTO sesionesDTO) {
        try {
            sesionesService.SaveSesiones(sesionesDTO);
            return new ResponseEntity("Sesión guardada", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity("No se pudo guardar la sesión", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<?> editSesiones(@PathVariable("id") int idSesiones,@RequestBody SesionesDTO sesionesDTO) {
        try {
            sesionesService.editSesiones(idSesiones, sesionesDTO);
            return new ResponseEntity("Sesión actualizada", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("No se pudo actualizar la sesión", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<?> deleteSesiones(@PathVariable("id") int idSesiones) {
        try {
            sesionesService.deleteSesiones(idSesiones);
            return new ResponseEntity("Sesión eliminada", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("No se pudo eliminar la sesión", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
