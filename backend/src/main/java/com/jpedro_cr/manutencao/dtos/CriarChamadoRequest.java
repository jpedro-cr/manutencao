package com.jpedro_cr.manutencao.dtos;

import java.time.LocalDateTime;

public record CriarChamadoRequest(
        String titulo,
        String descricao,
        String local,
        long prioridadeId,
        long statusId,
        LocalDateTime criadoEm
) {
}
