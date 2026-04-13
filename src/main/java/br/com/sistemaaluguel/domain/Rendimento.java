package br.com.sistemaaluguel.domain;

import io.micronaut.core.annotation.Introspected;
import jakarta.persistence.*;

@Entity
@Table(name = "rendimentos")
@Introspected
public class Rendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fonte;
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFonte() { return fonte; }
    public void setFonte(String fonte) { this.fonte = fonte; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}
