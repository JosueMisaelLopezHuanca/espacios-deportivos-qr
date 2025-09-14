package com.espaciosdeportivos.service.impl;

import com.espaciosdeportivos.dto.AdministradorDTO;
import com.espaciosdeportivos.model.Administrador;
import com.espaciosdeportivos.repository.AdministradorRepository;
import com.espaciosdeportivos.service.AdministradorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    private final AdministradorRepository repository;

    public AdministradorServiceImpl(AdministradorRepository repository) {
        this.repository = repository;
    }

    private AdministradorDTO mapToDTO(Administrador admin) {
        AdministradorDTO dto = new AdministradorDTO();
        dto.setIdAdministrador(admin.getIdPersona());
        dto.setFechaNacimiento(admin.getFechaNacimiento());
        dto.setNombre(admin.getNombre());
        dto.setaPaterno(admin.getaPaterno());
        dto.setaMaterno(admin.getaMaterno());
        dto.setTelefono(admin.getTelefono());
        dto.setEmail(admin.getEmail());
        dto.setCi(admin.getCi());
        dto.setCargo(admin.getCargo());
        dto.setDireccion(admin.getDireccion());
        return dto;
    }

    private Administrador mapToEntity(AdministradorDTO dto) {
        Administrador admin = new Administrador();
        if (dto.getIdAdministrador() != null) {
            admin.setIdPersona(dto.getIdAdministrador());
        }
        admin.setFechaNacimiento(dto.getFechaNacimiento());
        admin.setNombre(dto.getNombre());
        admin.setaPaterno(dto.getaPaterno());
        admin.setaMaterno(dto.getaMaterno());
        admin.setTelefono(dto.getTelefono());
        admin.setEmail(dto.getEmail());
        admin.setCi(dto.getCi());
        admin.setCargo(dto.getCargo());
        admin.setDireccion(dto.getDireccion());
        return admin;
    }

    @Override
    public AdministradorDTO crear(AdministradorDTO dto) {
        return mapToDTO(repository.save(mapToEntity(dto)));
    }

    @Override
    public AdministradorDTO actualizar(Long id, AdministradorDTO dto) {
        Administrador existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrador no encontrado"));
        Administrador actualizado = mapToEntity(dto);
        actualizado.setIdPersona(id);
        return mapToDTO(repository.save(actualizado));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public AdministradorDTO buscarPorId(Long id) {
        Administrador admin = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrador no encontrado"));
        return mapToDTO(admin);
    }

    @Override
    public List<AdministradorDTO> listarTodos() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<AdministradorDTO> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
