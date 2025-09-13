package com.espaciosdeportivos.service.impl;

import com.espaciosdeportivos.dto.UsuarioControlDTO;
import com.espaciosdeportivos.model.UsuarioControl;
import com.espaciosdeportivos.repository.UsuarioControlRepository;
import com.espaciosdeportivos.service.UsuarioControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioControlServiceImpl implements UsuarioControlService {

    @Autowired
    private UsuarioControlRepository repository;

    private UsuarioControlDTO mapToDTO(UsuarioControl uc) {
        UsuarioControlDTO dto = new UsuarioControlDTO();
        dto.setIdUsControl(uc.getIdPersona());
        dto.setFechaNacimiento(uc.getFechaNacimiento());
        dto.setNombre(uc.getNombre());
        dto.setaPaterno(uc.getaPaterno());
        dto.setaMaterno(uc.getaMaterno());
        dto.setTelefono(uc.getTelefono());
        dto.setEmail(uc.getEmail());
        dto.setCi(uc.getCi());
        dto.setEstadoOperativo(uc.getEstadoOperativo());
        dto.setHoraInicioTurno(uc.getHoraInicioTurno());
        dto.setHoraFinTurno(uc.getHoraFinTurno());
        dto.setDireccion(uc.getDireccion());
        return dto;
    }

    private UsuarioControl mapToEntity(UsuarioControlDTO dto) {
        UsuarioControl uc = new UsuarioControl();
        if (dto.getIdUsControl() != null) {
            uc.setIdPersona(dto.getIdUsControl());
        }
        uc.setFechaNacimiento(dto.getFechaNacimiento());
        uc.setNombre(dto.getNombre());
        uc.setaPaterno(dto.getaPaterno());
        uc.setaMaterno(dto.getaMaterno());
        uc.setTelefono(dto.getTelefono());
        uc.setEmail(dto.getEmail());
        uc.setCi(dto.getCi());
        uc.setEstadoOperativo(dto.getEstadoOperativo());
        uc.setHoraInicioTurno(dto.getHoraInicioTurno());
        uc.setHoraFinTurno(dto.getHoraFinTurno());
        uc.setDireccion(dto.getDireccion());
        return uc;
    }

    @Override
    public UsuarioControlDTO crear(UsuarioControlDTO dto) {
        UsuarioControl uc = mapToEntity(dto);
        return mapToDTO(repository.save(uc));
    }

    @Override
    public UsuarioControlDTO actualizar(Long id, UsuarioControlDTO dto) {
        Optional<UsuarioControl> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("UsuarioControl no encontrado");
        }
        UsuarioControl uc = mapToEntity(dto);
        uc.setIdPersona(id);
        return mapToDTO(repository.save(uc));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UsuarioControlDTO buscarPorId(Long id) {
        UsuarioControl uc = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("UsuarioControl no encontrado"));
        return mapToDTO(uc);
    }

    @Override
    public List<UsuarioControlDTO> listarTodos() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<UsuarioControlDTO> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
