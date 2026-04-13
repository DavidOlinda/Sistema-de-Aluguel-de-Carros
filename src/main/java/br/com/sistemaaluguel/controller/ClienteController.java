package br.com.sistemaaluguel.controller;

import br.com.sistemaaluguel.domain.Cliente;
import br.com.sistemaaluguel.domain.Rendimento;
import br.com.sistemaaluguel.repository.ClienteRepository;
import br.com.sistemaaluguel.repository.RendimentoRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.views.View;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final RendimentoRepository rendimentoRepository;

    public ClienteController(ClienteRepository clienteRepository, RendimentoRepository rendimentoRepository) {
        this.clienteRepository = clienteRepository;
        this.rendimentoRepository = rendimentoRepository;
    }

    @Get("/")
    @View("clientes/index")
    public Map<String, Object> index(@QueryValue(defaultValue = "") String busca) {
        List<Cliente> clientes;
        if (!busca.isBlank()) {
            clientes = clienteRepository.findByNomeContainsIgnoreCase(busca);
        } else {
            clientes = new ArrayList<>();
            clienteRepository.findAll().forEach(clientes::add);
        }
        Map<String, Object> model = new HashMap<>();
        model.put("clientes", clientes);
        model.put("busca", busca);
        return model;
    }

    @Get("/create")
    @View("clientes/create")
    public Map<String, Object> create() {
        return new HashMap<>();
    }

    @Post("/")
    public HttpResponse<?> save(@Body @Valid ClienteForm form) {
        Cliente cliente = new Cliente();
        preencherCliente(cliente, form);
        clienteRepository.save(cliente);
        salvarRendimentos(cliente, form);
        return HttpResponse.ok();
    }

    @Get("/{id}/edit")
    @View("clientes/edit")
    public Map<String, Object> edit(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        List<Rendimento> r = cliente.getRendimentos();

        Map<String, Object> model = new HashMap<>();
        model.put("cliente", cliente);
        model.put("fonte1", r.size() > 0 ? r.get(0).getFonte() : "");
        model.put("valor1", r.size() > 0 ? r.get(0).getValor() : "");
        model.put("fonte2", r.size() > 1 ? r.get(1).getFonte() : "");
        model.put("valor2", r.size() > 1 ? r.get(1).getValor() : "");
        model.put("fonte3", r.size() > 2 ? r.get(2).getFonte() : "");
        model.put("valor3", r.size() > 2 ? r.get(2).getValor() : "");
        return model;
    }

    @Put("/{id}")
    public HttpResponse<?> update(@PathVariable Long id, @Body @Valid ClienteForm form) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        preencherCliente(cliente, form);
        clienteRepository.update(cliente);
        rendimentoRepository.deleteByClienteId(id);
        salvarRendimentos(cliente, form);
        return HttpResponse.ok();
    }

    @Get("/{id}")
    @View("clientes/show")
    public Map<String, Object> show(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return Map.of("cliente", cliente);
    }

    @Delete("/{id}")
    public HttpResponse<?> delete(@PathVariable Long id) {
        rendimentoRepository.deleteByClienteId(id);
        clienteRepository.deleteById(id);
        return HttpResponse.ok();
    }

    private void preencherCliente(Cliente cliente, ClienteForm form) {
        cliente.setNome(form.getNome());
        cliente.setCpf(form.getCpf());
        cliente.setRg(form.getRg());
        cliente.setEndereco(form.getEndereco());
        cliente.setProfissao(form.getProfissao());
    }

    private void salvarRendimentos(Cliente cliente, ClienteForm form) {
        salvarRendimento(cliente, form.getFonte1(), form.getValor1());
        salvarRendimento(cliente, form.getFonte2(), form.getValor2());
        salvarRendimento(cliente, form.getFonte3(), form.getValor3());
    }

    private void salvarRendimento(Cliente cliente, String fonte, Double valor) {
        if (fonte != null && !fonte.isBlank()) {
            Rendimento r = new Rendimento();
            r.setFonte(fonte);
            r.setValor(valor);
            r.setCliente(cliente);
            rendimentoRepository.save(r);
        }
    }
}

