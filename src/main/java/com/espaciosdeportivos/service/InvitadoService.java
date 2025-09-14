package com.espaciosdeportivos.service;

import com.espaciosdeportivos.dto.InvitadoDTO;
import java.util.List;

public interface InvitadoService {

    InvitadoDTO crear(InvitadoDTO dto);

    InvitadoDTO actualizar(Long id, InvitadoDTO dto);

    void eliminar(Long id);

    InvitadoDTO buscarPorId(Long id);

    List<InvitadoDTO> listarTodos();

    List<InvitadoDTO> buscarPorNombre(String nombre);
}
