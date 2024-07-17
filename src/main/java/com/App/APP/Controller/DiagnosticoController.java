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

import com.App.APP.DTO.DiagnosticoDTO;
import com.App.APP.Service.DiagnosticoService;

@RestController
@RequestMapping(value = "/api/v1/diagnostico")
@CrossOrigin("/**")

public class DiagnosticoController {

    @Autowired
    private DiagnosticoService diagnosticoService;

    @GetMapping()
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<List<DiagnosticoDTO>> listAllDiagnosticoDTO() {
        List<DiagnosticoDTO> diagnosticoList = diagnosticoService.SearchAllDiagnostico();
        if (diagnosticoList == null) {
            return new ResponseEntity("Lista de Diagnósticos vacía", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(diagnosticoList, HttpStatus.OK);
    }

    @PostMapping
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<?> saveDiagnostico(DiagnosticoDTO diagnosticoDTO) {
        try {
            diagnosticoService.SaveDiagnostico(diagnosticoDTO);
            return new ResponseEntity("Diagnóstico guardado", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity("No se pudo guardar el diagnóstico", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<?> editDiagnostico(@PathVariable("id") int idDiagnostico, DiagnosticoDTO diagnosticoDTO) {
        try {
            diagnosticoService.editDiagnostico(idDiagnostico, diagnosticoDTO);
            return new ResponseEntity("Diagnóstico actualizado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("No se pudo actualizar el diagnóstico", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<?> deleteDiagnostico(@PathVariable("id") int idDiagnostico) {
        try {
            diagnosticoService.deleteDiagnostico(idDiagnostico);
            return new ResponseEntity("Diagnóstico eliminado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("No se pudo eliminar el diagnóstico", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
