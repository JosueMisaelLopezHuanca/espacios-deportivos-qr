package com.espaciosdeportivos.service.impl;

import com.espaciosdeportivos.dto.ClienteDTO;
import com.espaciosdeportivos.model.Cliente;
import com.espaciosdeportivos.repository.ClienteRepository;
import com.espaciosdeportivos.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    private ClienteDTO mapToDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setIdCliente(cliente.getIdPersona());
        dto.setFechaNacimiento(cliente.getFechaNacimiento());
        dto.setNombre(cliente.getNombre());
        dto.setaPaterno(cliente.getaPaterno());
        dto.setaMaterno(cliente.getaMaterno());
        dto.setTelefono(cliente.getTelefono());
        dto.setEmail(cliente.getEmail());
        dto.setCi(cliente.getCi());
        dto.setEstadoCliente(cliente.getEstadoCliente());
        return dto;
    }

    private Cliente mapToEntity(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        if (dto.getIdCliente() != null) {
            cliente.setIdPersona(dto.getIdCliente());
        }
        cliente.setFechaNacimiento(dto.getFechaNacimiento());
        cliente.setNombre(dto.getNombre());
        cliente.setaPaterno(dto.getaPaterno());
        cliente.setaMaterno(dto.getaMaterno());
        cliente.setTelefono(dto.getTelefono());
        cliente.setEmail(dto.getEmail());
        cliente.setCi(dto.getCi());
        cliente.setEstadoCliente(dto.getEstadoCliente());
        return cliente;
    }

    @Override
    public ClienteDTO crear(ClienteDTO dto) {
        Cliente cliente = mapToEntity(dto);
        return mapToDTO(repository.save(cliente));
    }

    @Override
    public ClienteDTO actualizar(Long id, ClienteDTO dto) {
        Cliente clienteExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Cliente clienteActualizado = mapToEntity(dto);
        clienteActualizado.setIdPersona(id);
        return mapToDTO(repository.save(clienteActualizado));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ClienteDTO buscarPorId(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        return mapToDTO(cliente);
    }

    @Override
    public List<ClienteDTO> listarTodos() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ClienteDTO> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
