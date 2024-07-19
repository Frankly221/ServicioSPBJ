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

import com.App.APP.DTO.TarifarioDTO;
import com.App.APP.Service.TarifarioService;

@RestController
@RequestMapping(value = "/api/v1/tarifario")
@CrossOrigin("/**")
public class TarifarioController {
    @Autowired
    private TarifarioService tarifarioService;

    @GetMapping()
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<List<TarifarioDTO>> listAllTarifarioDTO() {
        List<TarifarioDTO> tarifarioList = tarifarioService.SearchAllTarifario();
        if (tarifarioList == null) {
            return new ResponseEntity("Lista de tarifarios vacios", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(tarifarioList, HttpStatus.OK);
    }

    @PostMapping
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<?> saveTarifario(@RequestBody TarifarioDTO tarifarioDTO) {
        try {
            tarifarioService.SaveTarifario(tarifarioDTO);
            return new ResponseEntity("Tarifario guardado", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity("No se puedo guardar el tarifario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<?> editTarifario(@PathVariable("id") int idTarifario, @RequestBody TarifarioDTO tarifarioDTO) {
        try {
            tarifarioService.editTarifario(idTarifario, tarifarioDTO);
            return new ResponseEntity("Tarifario actualizado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("No se puedo actualizar el tarifario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<?> deleteTarifario(@PathVariable("id") int idTarifario) {
        try {
            tarifarioService.deleteTarifario(idTarifario);
            return new ResponseEntity("Tarifario eliminado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("No se puedo eliminar el tarifario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
