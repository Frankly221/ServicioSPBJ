package com.App.APP.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.APP.DTO.DiagnosticoDTO;
import com.App.APP.DTO.PersonaDTO;
import com.App.APP.Entity.Persona;
import com.App.APP.Mapper.PersonaMapper;
import com.App.APP.Repositorio.PersonaRepositorio;



@Service
public class PersonaService {



    @Autowired
    private PersonaRepositorio personaRepository;

    public List<PersonaDTO> SearchAllPaciente(){

        List<Persona> personalist = personaRepository.findAll();

        return personalist.stream().map(PersonaMapper :: DatosToDTO).collect(Collectors.toList());
    }


    public Optional<PersonaDTO> SearchOnePersona(int idpersona){

        Optional<Persona> personita = personaRepository.findById(idpersona);

        return personita.map(PersonaMapper::DatosToDTO);
    }

    public PersonaDTO SavePerson(PersonaDTO personaDTO){

        Persona personita = PersonaMapper.DatosToEntity(personaDTO);

        Persona savePersona = personaRepository.save(personita);

        return PersonaMapper.DatosToDTO(savePersona);

    }

    public PersonaDTO PutPersona(int idpersona,PersonaDTO personaDTO){

        Persona existePerson = personaRepository.findById(idpersona).orElseThrow( ()-> new RuntimeException("Persona No encontrado con el id "+ idpersona)) ;

        existePerson.setNombre(personaDTO.getNombre());
        existePerson.setApellido(personaDTO.getApellido());
        existePerson.setDomicilio(personaDTO.getDomicilio());
        existePerson.setFecha_nac(personaDTO.getFecha_nac());
        existePerson.setLugar_nac(personaDTO.getLugar_nac());
        existePerson.setResidencia(personaDTO.getResidencia());
        existePerson.setEstado_civil(personaDTO.getEstado_civil());
        existePerson.setN_hijos(personaDTO.getN_hijos());
        existePerson.setReferencia(personaDTO.getReferencia());
        existePerson.setTipo_documento(personaDTO.getTipo_documento());
        existePerson.setNdoc_documento(personaDTO.getNdoc_documento());
        existePerson.setCorreo(personaDTO.getCorreo());


        personaRepository.save(existePerson);


        return PersonaMapper.DatosToDTO(existePerson);
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
    
    public void DeletePersona(int idpersona){
        personaRepository.deleteById(idpersona);
    }

    
}
