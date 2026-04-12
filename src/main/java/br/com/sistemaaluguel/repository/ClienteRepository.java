package br.com.sistemaaluguel.repository;

import br.com.sistemaaluguel.domain.Cliente;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    List<Cliente> findByNomeContainsIgnoreCase(String nome);
}