package com.espaciosdeportivos.service.impl;

import com.espaciosdeportivos.dto.PersonaDTO;
import com.espaciosdeportivos.model.Persona;
import com.espaciosdeportivos.repository.PersonaRepository;
import com.espaciosdeportivos.service.PersonaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository repository;

    public PersonaServiceImpl(PersonaRepository repository) {
        this.repository = repository;
    }

    private PersonaDTO mapToDTO(Persona persona) {
        PersonaDTO dto = new PersonaDTO();
        dto.setIdPersona(persona.getIdPersona());
        dto.setFechaNacimiento(persona.getFechaNacimiento());
        dto.setNombre(persona.getNombre());
        dto.setaPaterno(persona.getaPaterno());
        dto.setaMaterno(persona.getaMaterno());
        dto.setTelefono(persona.getTelefono());
        dto.setEmail(persona.getEmail());
        dto.setCi(persona.getCi());
        return dto;
    }

    private Persona mapToEntity(PersonaDTO dto) {
        Persona persona = new Persona();
        persona.setIdPersona(dto.getIdPersona());
        persona.setFechaNacimiento(dto.getFechaNacimiento());
        persona.setNombre(dto.getNombre());
        persona.setaPaterno(dto.getaPaterno());
        persona.setaMaterno(dto.getaMaterno());
        persona.setTelefono(dto.getTelefono());
        persona.setEmail(dto.getEmail());
        persona.setCi(dto.getCi());
        return persona;
    }

    @Override
    public PersonaDTO crear(PersonaDTO personaDTO) {
        Persona saved = repository.save(mapToEntity(personaDTO));
        return mapToDTO(saved);
    }

    @Override
    public PersonaDTO actualizar(Long id, PersonaDTO personaDTO) {
        Persona existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        existente.setFechaNacimiento(personaDTO.getFechaNacimiento());
        existente.setNombre(personaDTO.getNombre());
        existente.setaPaterno(personaDTO.getaPaterno());
        existente.setaMaterno(personaDTO.getaMaterno());
        existente.setTelefono(personaDTO.getTelefono());
        existente.setEmail(personaDTO.getEmail());
        existente.setCi(personaDTO.getCi());
        Persona actualizado = repository.save(existente);
        return mapToDTO(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public PersonaDTO buscarPorId(Long id) {
        Persona persona = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        return mapToDTO(persona);
    }

    @Override
    public List<PersonaDTO> listarTodos() {
        return repository.findAll()
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<PersonaDTO> buscarPorNombre(String nombre) {
        return repository.findByNombreIgnoreCaseContaining(nombre)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
