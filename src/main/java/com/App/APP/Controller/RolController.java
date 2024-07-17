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

import com.App.APP.DTO.RolDTO;
import com.App.APP.Service.RolService;

@RestController
@RequestMapping(value = "/api/v1/rol")
@CrossOrigin("/**")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<RolDTO>> getAllRoles() {
        try {
            List<RolDTO> roles = rolService.SearchEntityRol();
            return new ResponseEntity<>(roles, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener roles", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> getRolById(@PathVariable int id) {
        try {
            return rolService.SearchEntityOneRol(id)
                    .map(rolDTO -> new ResponseEntity<>(rolDTO, HttpStatus.OK))
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol no encontrado con id " + id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener rol", e);
        }
    }

    @PostMapping
    public ResponseEntity<RolDTO> saveRol(@RequestBody RolDTO rolDTO) {
        try {
            RolDTO savedRol = rolService.SaveEntityRol(rolDTO);
            return new ResponseEntity<>(savedRol, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar rol", e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> updateRol(@PathVariable int id, @RequestBody RolDTO rolDTO) {
        try {
            rolService.EditEntityRol(id, rolDTO);
            return new ResponseEntity<>(rolDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar rol", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable int id) {
        try {
            rolService.DeleteEntityRol(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar rol", e);
        }
    }
}
