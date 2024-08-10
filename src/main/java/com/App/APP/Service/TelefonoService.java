package com.App.APP.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.APP.Entity.Persona;
import com.App.APP.Entity.Telefono;
import com.App.APP.Repositorio.TelefonoRepository;

@Service
public class TelefonoService {
    @Autowired
    private TelefonoRepository repository;

    public Telefono save(Telefono telefono) {
        if (repository.existsById(telefono.getIdtf())) new RuntimeException("El Telefono ya existe con el id "+telefono.getIdtf());
        return repository.save(telefono);
    }
    
    public Telefono update(Telefono telefono) {
        if (!repository.existsById(telefono.getIdtf())) new RuntimeException("El Telefono no existe con el id "+telefono.getIdtf());
        return repository.save(telefono);
    }

    public void deleteById(int id) {
        if (!repository.existsById(id)) new RuntimeException("El Telefono no existe con el id "+ id);
        repository.deleteById(id);
    }

    public void actualizarListaTelefono(List<Telefono> telefonos, int idpersona) {
    // Obtener la lista original de teléfonos de la base de datos
    List<Telefono> listaOriginal = repository.findByPersonaId(idpersona);

    Set<Integer> originalIds = listaOriginal.stream().map(Telefono::getIdtf).collect(Collectors.toSet());

    for(Telefono telOriginal : listaOriginal) {
        if (telefonos.stream().noneMatch(t -> t.getIdtf() == telOriginal.getIdtf())) {
            repository.deleteById(telOriginal.getIdtf());
        }
    }

    for(Telefono tel : telefonos) {
        if (tel.getTelefono() != 0) {
            if (originalIds.contains(tel.getIdtf()) || tel.getIdtf() == 0) {
                Persona persona = Persona.builder().idpersona(idpersona).build();
                tel.setPersona(persona);
                repository.save(tel);
            }
        }
    }
}

}
