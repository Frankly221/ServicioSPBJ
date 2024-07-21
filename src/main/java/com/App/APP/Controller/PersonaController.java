package com.App.APP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.App.APP.DTO.PersonaDTO;
import com.App.APP.Service.PersonaService;

@RestController
@RequestMapping(value = "/api/v1/persona")
@CrossOrigin("/**")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<PersonaDTO>> getAllPacientes() {
        try {
            List<PersonaDTO> pacientes = personaService.SearchAllPaciente();
            return new ResponseEntity<>(pacientes, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener pacientes", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> getPacienteById(@PathVariable int id) {
        try {
            return personaService.SearchOnePersona(id)
                    .map(personaDTO -> new ResponseEntity<>(personaDTO, HttpStatus.OK))
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente no encontrado con id " + id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener paciente", e);
        }
    }

    @PostMapping
    public ResponseEntity<PersonaDTO> savePaciente(@RequestBody PersonaDTO personaDTO) {
        try {
            PersonaDTO savedPaciente = personaService.SavePerson(personaDTO);
            return new ResponseEntity<>(savedPaciente, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar paciente", e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaDTO> updatePaciente(@PathVariable int id, @RequestBody PersonaDTO personaDTO) {
        try {
            PersonaDTO updatedPaciente = personaService.PutPersona(id, personaDTO);
            return new ResponseEntity<>(updatedPaciente, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar paciente", e);
        }
    }

    //nuevo metodo
    @GetMapping("/perso/{id}")
    public PersonaDTO getPersona(@PathVariable int id) {
        return personaService.getPersonaWithActiveDiagnosticos(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con el id " + id));
    }
}
