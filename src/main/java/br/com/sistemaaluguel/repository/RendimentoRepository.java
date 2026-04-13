package br.com.sistemaaluguel.repository;

import br.com.sistemaaluguel.domain.Rendimento;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface RendimentoRepository extends CrudRepository<Rendimento, Long> {
    void deleteByClienteId(Long clienteId);
}
