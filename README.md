# 🚗 Sistema de Gestão de Aluguel de Automóveis

## 📌 Descrição

Este projeto tem como objetivo modelar um sistema de gestão de pedidos de aluguel de automóveis, incluindo análise financeira, gestão de contratos e integração entre clientes e agentes (empresas e bancos).

O sistema é acessado via internet e permite que clientes realizem pedidos de aluguel, enquanto agentes analisam e aprovam contratos.

---

## 🧩 Estrutura do Sistema

O sistema é dividido em dois subsistemas principais:

### 🔹 1. Gestão de Pedidos e Contratos

Responsável por:

* Cadastro de usuários
* Criação e gerenciamento de pedidos de aluguel
* Análise financeira dos pedidos
* Gestão de contratos de aluguel e crédito

### 🔹 2. Construção Dinâmica de Páginas Web

Responsável por:

* Interface do usuário
* Interação entre clientes e agentes
* Exibição dinâmica de informações

---

## 👥 Atores do Sistema

* **Cliente (Usuário Individual)**
* **Agente (Empresas e Bancos)**
* **Sistema Central**

---

## ⚙️ Funcionalidades

### 📌 Cliente

* Realizar cadastro no sistema
* Fazer login
* Introduzir pedidos de aluguel
* Modificar pedidos
* Consultar pedidos
* Cancelar pedidos

### 📌 Agentes (Empresas e Bancos)

* Modificar pedidos
* Avaliar pedidos do ponto de vista financeiro
* Aprovar ou reprovar pedidos
* Conceder contratos de crédito

### 📌 Sistema

* Validar acesso (login e senha)
* Gerenciar pedidos e contratos
* Integrar clientes e agentes via internet
* Associar contratos de crédito aos aluguéis

---

## 🔄 Fluxo do Processo

1. O cliente realiza cadastro no sistema.
2. O cliente cria um pedido de aluguel.
3. O pedido é analisado financeiramente pelos agentes.
4. Caso aprovado:

   * O pedido é disponibilizado para execução do contrato.
   * Pode ser associado a um contrato de crédito.
5. O contrato é formalizado.

---

## 📊 Regras de Negócio

* O sistema só pode ser utilizado após cadastro prévio.
* Clientes podem:

  * Criar, modificar, consultar e cancelar pedidos.
* Agentes podem:

  * Modificar e avaliar pedidos.
* Um pedido aprovado pode gerar um contrato.
* Um aluguel pode estar associado a um contrato de crédito.
* Um contrato de crédito é concedido por um banco agente.

---

## 🧾 Dados dos Contratantes

Para cada cliente, o sistema armazena:

* RG
* CPF
* Nome
* Endereço
* Profissão
* Até 3 fontes de rendimento:

  * Entidade empregadora
  * Valor do rendimento

---

## 🚘 Dados dos Automóveis

O sistema registra:

* Matrícula
* Ano
* Marca
* Modelo
* Placa

### 📌 Propriedade dos veículos

Dependendo do contrato, o automóvel pode pertencer a:

* Cliente
* Empresa
* Banco

---

## 🛠️ Tecnologias (Sugestão)

* Backend:
* Frontend: 
* Banco de Dados: 
* Modelagem: UML

---

## 📌 Autor

David Olinda Pomine 
Jonas 
