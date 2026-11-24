package com.jpedro_cr.manutencao.controllers;

import com.jpedro_cr.manutencao.dtos.CriarChamadoRequest;
import com.jpedro_cr.manutencao.models.Chamado;
import com.jpedro_cr.manutencao.services.ChamadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/chamados")
public class ChamadoController {
    private final ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    @PostMapping
    public ResponseEntity<Chamado> criar(
            @RequestBody CriarChamadoRequest request) {
        Chamado chamado = new Chamado();
        chamado.setTitulo(request.titulo());
        chamado.setDescricao(request.descricao());
        chamado.setLocal(request.local());
        chamado.setCriadoEm(request.criadoEm());

        Chamado salvo = chamadoService.criar(
                chamado, request.prioridadeId(), request.statusId()
        );
        return ResponseEntity.created(URI.create("/api/chamados" + salvo.getId()))
                .body(salvo);
    }

    @GetMapping
    public List<Chamado> listar() {
        return chamadoService.listar();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> tratarArgumentoInvalido(
            IllegalArgumentException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}



