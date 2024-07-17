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
import org.springframework.web.server.ResponseStatusException;

import com.App.APP.DTO.PrivilegiosDTO;
import com.App.APP.Service.PrivilegiosService;

@RestController
@RequestMapping(value = "/api/v1/privilegios")
@CrossOrigin("/**")
public class PrivilegiosController {

    @Autowired
    private PrivilegiosService privilegiosService;

    @GetMapping
    public ResponseEntity<List<PrivilegiosDTO>> getAllPrivilegios() {
        try {
            List<PrivilegiosDTO> privilegios = privilegiosService.SearchEntityPrivilegios();
            return new ResponseEntity<>(privilegios, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener privilegios", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrivilegiosDTO> getPrivilegiosById(@PathVariable int id) {
        try {
            return privilegiosService.SearchEntityOnePrivilegios(id)
                    .map(privilegiosDTO -> new ResponseEntity<>(privilegiosDTO, HttpStatus.OK))
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Privilegio no encontrado con id " + id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener privilegio", e);
        }
    }

    @PostMapping
    public ResponseEntity<PrivilegiosDTO> savePrivilegios(@RequestBody PrivilegiosDTO privilegiosDTO) {
        try {
            PrivilegiosDTO savedPrivilegios = privilegiosService.SaveEntityPrivilegios(privilegiosDTO);
            return new ResponseEntity<>(savedPrivilegios, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar privilegio", e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrivilegiosDTO> updatePrivilegios(@PathVariable int id, @RequestBody PrivilegiosDTO privilegiosDTO) {
        try {
            privilegiosService.EditEntityPrivilegios(id, privilegiosDTO);
            return new ResponseEntity<>(privilegiosDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar privilegio", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrivilegios(@PathVariable int id) {
        try {
            privilegiosService.DeleteEntityPrivilegios(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar privilegio", e);
        }
    }
}
