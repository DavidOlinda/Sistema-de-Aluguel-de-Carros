package br.com.sistemaaluguel.domain;

import io.micronaut.data.annotation.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@MappedEntity("clientes")
public class Cliente {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @NotBlank
    private String rg;

    private String endereco;
    private String profissao;

    private BigDecimal renda1Valor;
    private BigDecimal renda2Valor;
    private BigDecimal renda3Valor;

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getRg() { return rg; }
    public void setRg(String rg) { this.rg = rg; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getProfissao() { return profissao; }
    public void setProfissao(String profissao) { this.profissao = profissao; }

    public BigDecimal getRenda1Valor() { return renda1Valor; }
    public void setRenda1Valor(BigDecimal renda1Valor) { this.renda1Valor = renda1Valor; }

    public BigDecimal getRenda2Valor() { return renda2Valor; }
    public void setRenda2Valor(BigDecimal renda2Valor) { this.renda2Valor = renda2Valor; }

    public BigDecimal getRenda3Valor() { return renda3Valor; }
    public void setRenda3Valor(BigDecimal renda3Valor) { this.renda3Valor = renda3Valor; }
}