package com.App.APP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.App.APP.DTO.PersonaDTO;
import com.App.APP.Service.PersonaService;


@RestController
@RequestMapping(value = "/api/v1/paciente")
@CrossOrigin("/**")

public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<PersonaDTO> CPacienteALL(){
        
        return personaService.SearchAllPaciente();

    }

  


    
}
