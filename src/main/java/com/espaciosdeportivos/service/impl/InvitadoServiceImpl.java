package com.espaciosdeportivos.service.impl;

import com.espaciosdeportivos.dto.InvitadoDTO;
import com.espaciosdeportivos.model.Invitado;
import com.espaciosdeportivos.repository.InvitadoRepository;
import com.espaciosdeportivos.service.InvitadoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvitadoServiceImpl implements InvitadoService {

    private final InvitadoRepository repository;

    public InvitadoServiceImpl(InvitadoRepository repository) {
        this.repository = repository;
    }

    private InvitadoDTO mapToDTO(Invitado invitado) {
        InvitadoDTO dto = new InvitadoDTO();
        dto.setIdInvitado(invitado.getIdPersona());
        dto.setFechaNacimiento(invitado.getFechaNacimiento());
        dto.setNombre(invitado.getNombre());
        dto.setaPaterno(invitado.getaPaterno());
        dto.setaMaterno(invitado.getaMaterno());
        dto.setTelefono(invitado.getTelefono());
        dto.setEmail(invitado.getEmail());
        dto.setCi(invitado.getCi());
        dto.setVerificado(invitado.getVerificado());
        return dto;
    }

    private Invitado mapToEntity(InvitadoDTO dto) {
        Invitado invitado = new Invitado();
        if (dto.getIdInvitado() != null) {
            invitado.setIdPersona(dto.getIdInvitado());
        }
        invitado.setFechaNacimiento(dto.getFechaNacimiento());
        invitado.setNombre(dto.getNombre());
        invitado.setaPaterno(dto.getaPaterno());
        invitado.setaMaterno(dto.getaMaterno());
        invitado.setTelefono(dto.getTelefono());
        invitado.setEmail(dto.getEmail());
        invitado.setCi(dto.getCi());
        invitado.setVerificado(dto.getVerificado());
        return invitado;
    }

    @Override
    public InvitadoDTO crear(InvitadoDTO dto) {
        return mapToDTO(repository.save(mapToEntity(dto)));
    }

    @Override
    public InvitadoDTO actualizar(Long id, InvitadoDTO dto) {
        Invitado existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invitado no encontrado"));
        Invitado actualizado = mapToEntity(dto);
        actualizado.setIdPersona(id);
        return mapToDTO(repository.save(actualizado));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public InvitadoDTO buscarPorId(Long id) {
        Invitado invitado = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invitado no encontrado"));
        return mapToDTO(invitado);
    }

    @Override
    public List<InvitadoDTO> listarTodos() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<InvitadoDTO> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
