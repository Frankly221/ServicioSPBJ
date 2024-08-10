package com.App.APP.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.APP.DTO.DiagnosticoDTO;
import com.App.APP.DTO.PersonaConSesionesDTO;
import com.App.APP.DTO.PersonaDTO;
import com.App.APP.Entity.Persona;
import com.App.APP.Entity.Sesiones;
import com.App.APP.Mapper.PersonaMapper;
import com.App.APP.Repositorio.PersonaRepositorio;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepositorio personaRepository;
    @Autowired
    private TelefonoService telfonoService;

    public List<PersonaDTO> SearchAllPaciente(){
        List<Persona> personalist = personaRepository.findAll();
        return personalist.stream().map(PersonaMapper :: DatosPrimariosToDTO).collect(Collectors.toList());
    }


    public Optional<PersonaDTO> SearchOnePersona(int idpersona){
        Optional<Persona> personita = personaRepository.findById(idpersona);
        personita.get().getDiagnosticos().size();
        personita.get().getTelefonosecundario().size();
        return personita.map(PersonaMapper::DatosToDTO);
    }

    public PersonaDTO SavePerson(PersonaDTO personaDTO){
        if(personaRepository.existsById(personaDTO.getIdpersona())) new RuntimeException("Persona ya existe con el id "+ personaDTO.getIdpersona());
        Persona personita = PersonaMapper.DatosToEntity(personaDTO);

        if(personita.getTelefonosecundario() != null && !personita.getTelefonosecundario().isEmpty()){
            telfonoService.actualizarListaTelefono(personita.getTelefonosecundario(), personaDTO.getIdpersona());
        }

        Persona savePersona = personaRepository.save(personita);
        return PersonaMapper.DatosToDTO(savePersona);
    }

    public PersonaDTO PutPersona(int idpersona,PersonaDTO personaDTO){
        if(!personaRepository.existsById(idpersona)) new RuntimeException("Persona No encontrado con el id "+ idpersona);
        Persona persona = PersonaMapper.DatosToEntity(personaDTO);

        if(persona.getTelefonosecundario() != null && !persona.getTelefonosecundario().isEmpty()){
            telfonoService.actualizarListaTelefono(persona.getTelefonosecundario(), personaDTO.getIdpersona());
        }

        personaRepository.save(persona);
        return PersonaMapper.DatosToDTO(persona);
    }

    public void DeletePersona(int idpersona){
        personaRepository.deleteById(idpersona);
    }

    //nuevo metodo :
     public Optional<PersonaDTO> getPersonaWithActiveDiagnosticos(int idpersona) {
        Optional<Persona> personita = personaRepository.findById(idpersona);

        if (personita.isPresent()) {
            PersonaDTO personaDTO = PersonaMapper.DatosToDTO(personita.get());

            // Filtrar diagnósticos activos
            List<DiagnosticoDTO> activeDiagnosticos = personaDTO.getDiagnosticosDTO().stream()
                    .filter(diagnosticoDTO -> "Activo".equals(diagnosticoDTO.getEsta_DiagDTO().getEstado()))
                    .collect(Collectors.toList());

            personaDTO.setDiagnosticosDTO(activeDiagnosticos);
            return Optional.of(personaDTO);
        } else {
            return Optional.empty();
        }
    }
    

    //Logica para Obtener Personas con sesiones

     public List<PersonaConSesionesDTO> getPersonasConSesionesByFecha(LocalDate fecha) {
        Date sqlFecha = Date.valueOf(fecha); // Convertir LocalDate a java.sql.Date
        List<Persona> personas = personaRepository.findPersonasBySesionFecha(sqlFecha);
        
        return personas.stream()
                       .map(persona -> {
                           List<Sesiones> sesionesEnFecha = persona.getDiagnosticos().stream()
                               .flatMap(diagnostico -> diagnostico.getSesiones().stream())
                               .filter(sesion -> sesion.getFecha().toLocalDate().equals(fecha))
                               .collect(Collectors.toList());
                           return PersonaMapper.DatosToDTOWithSesion(persona, sesionesEnFecha);
                       })
                       .collect(Collectors.toList());
    }
    }
  




