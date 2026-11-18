package com.jpedro_cr.manutencao.repository;
import com.jpedro_cr.manutencao.models.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
}
