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

import com.App.APP.DTO.Priv_RolDTO;
import com.App.APP.Service.Priv_RolService;

@RestController
@RequestMapping(value = "/api/v1/priv_rol")
@CrossOrigin("/**")
public class Priv_RolController {

    @Autowired
    private Priv_RolService priv_RolService;

    @GetMapping
    public ResponseEntity<List<Priv_RolDTO>> getAllPrivRoles() {
        try {
            List<Priv_RolDTO> privRoles = priv_RolService.SearchEntityPriv_Rol();
            return new ResponseEntity<>(privRoles, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener priv_rol", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Priv_RolDTO> getPrivRolById(@PathVariable int id) {
        try {
            return priv_RolService.SearchEntityOnePriv_Rol(id)
                    .map(privRolDTO -> new ResponseEntity<>(privRolDTO, HttpStatus.OK))
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "priv_rol no encontrado con id " + id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener priv_rol", e);
        }
    }

    @PostMapping
    public ResponseEntity<Priv_RolDTO> savePrivRol(@RequestBody Priv_RolDTO privRolDTO) {
        try {
            Priv_RolDTO savedPrivRol = priv_RolService.SaveEntityPriv_Rol(privRolDTO);
            return new ResponseEntity<>(savedPrivRol, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar priv_rol", e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Priv_RolDTO> updatePrivRol(@PathVariable int id, @RequestBody Priv_RolDTO privRolDTO) {
        try {
            priv_RolService.EditEntityPriv_Rol(id, privRolDTO);
            return new ResponseEntity<>(privRolDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar priv_rol", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrivRol(@PathVariable int id) {
        try {
            priv_RolService.DeleteEntityPriv_Rol(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar priv_rol", e);
        }
    }
}
