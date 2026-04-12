package br.com.sistemaaluguel.controller;

import br.com.sistemaaluguel.domain.Cliente;
import br.com.sistemaaluguel.repository.ClienteRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.views.View;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.*;

@Controller("/clientes")
public class ClienteController {

    private final ClienteRepository repository;

    @Inject
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @Get("/")
    @View("clientes/index")
    public Map<String, Object> index(@QueryValue Optional<String> busca) {
        List<Cliente> clientes = busca.filter(b -> !b.isBlank())
                .map(repository::findByNomeContainsIgnoreCase)
                .orElseGet(this::toList);

        Map<String, Object> model = new HashMap<>();
        model.put("clientes", clientes);
        model.put("busca", busca.orElse(""));
        return model;
    }

    @Get("/create")
    @View("clientes/create")
    public Map<String, Object> create() {
        return Map.of("cliente", new Cliente());
    }

    @Post("/")
    public HttpResponse<?> save(@Valid Cliente cliente) {
        repository.save(cliente);
        return HttpResponse.redirect(URI.create("/clientes/"));
    }

    @Get("/{id}/edit")
    @View("clientes/edit")
    public Map<String, Object> edit(@PathVariable Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return Map.of("cliente", cliente);
    }

    @Post("/{id}")
    public HttpResponse<?> update(@PathVariable Long id, @Valid Cliente cliente) {
        cliente.setId(id);
        repository.save(cliente);
        return HttpResponse.redirect(URI.create("/clientes/"));
    }

    @Get("/{id}")
    @View("clientes/show")
    public Map<String, Object> show(@PathVariable Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return Map.of("cliente", cliente);
    }

    @Get("/{id}/delete")
    public HttpResponse<?> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return HttpResponse.redirect(URI.create("/clientes/"));
    }

    private List<Cliente> toList() {
        List<Cliente> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }
}