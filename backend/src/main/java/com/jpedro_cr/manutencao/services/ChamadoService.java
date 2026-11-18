package com.jpedro_cr.manutencao.services;
import com.jpedro_cr.manutencao.models.*;
import com.jpedro_cr.manutencao.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoService {
    private final ChamadoRepository chamadoRepository;
    private final PrioridadeRepository prioridadeRepository;
    private final StatusChamadoRepository statusChamadoRepository;

    public ChamadoService(ChamadoRepository chamadoRepository,
                          PrioridadeRepository prioridadeRepository,
                          StatusChamadoRepository statusChamadoRepository) {
        this.chamadoRepository = chamadoRepository;
        this.prioridadeRepository = prioridadeRepository;
        this.statusChamadoRepository = statusChamadoRepository;
    }
    public Chamado criar(Chamado chamado,
                         long prioridadeId,
                         long statusId) {
        Prioridade prioridade = prioridadeRepository.findById(prioridadeId)
                .orElseThrow(() -> new IllegalArgumentException("Prioridade não encontrada"));
        StatusChamado status = statusChamadoRepository.findById(statusId)
                .orElseThrow(()-> new IllegalArgumentException("Staus não encontrado"));
        chamado.setPrioridade(prioridade);
        chamado.setStatus(status);

        return chamadoRepository.save(chamado);
    }
    public List<Chamado> listar(){
        return chamadoRepository.findAll();
    }
}
