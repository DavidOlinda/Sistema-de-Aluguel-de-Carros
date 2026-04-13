package br.com.sistemaaluguel.controller;

import io.micronaut.core.annotation.Introspected;
import jakarta.validation.constraints.NotBlank;

@Introspected
public class ClienteForm {

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @NotBlank
    private String rg;
    private String endereco;
    private String profissao;

    private String fonte1;
    private Double valor1;

    private String fonte2;
    private Double valor2;

    private String fonte3;
    private Double valor3;

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

    public String getFonte1() { return fonte1; }
    public void setFonte1(String fonte1) { this.fonte1 = fonte1; }

    public Double getValor1() { return valor1; }
    public void setValor1(Double valor1) { this.valor1 = valor1; }

    public String getFonte2() { return fonte2; }
    public void setFonte2(String fonte2) { this.fonte2 = fonte2; }

    public Double getValor2() { return valor2; }
    public void setValor2(Double valor2) { this.valor2 = valor2; }

    public String getFonte3() { return fonte3; }
    public void setFonte3(String fonte3) { this.fonte3 = fonte3; }

    public Double getValor3() { return valor3; }
    public void setValor3(Double valor3) { this.valor3 = valor3; }
}
