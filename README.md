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
* **Administrador**

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

## 🛠️ Tecnologias Utilizadas

| Camada | Tecnologia |
|---|---|
| Linguagem | Java 21 |
| Framework | Micronaut 4.10 |
| Persistência | Micronaut Data + Hibernate ORM 6.6 |
| Banco de Dados | SQLite 3.45 |
| Templates | Thymeleaf |
| Build | Maven 3 |

---

## ▶️ Como Executar

**Pré-requisito:** Java 21 e Maven instalados.

```bash
mvn mn:run
```

Acesse: [http://localhost:8080/clientes/](http://localhost:8080/clientes/)

---

## 📁 Estrutura do Projeto

```
src/main/java/br/com/sistemaaluguel/
├── ClienteApplication.java         # Ponto de entrada
├── controller/
│   ├── ClienteController.java      # Rotas HTTP (GET/POST/PUT/DELETE)
│   └── ClienteForm.java            # DTO com validação (@NotBlank)
├── domain/
│   ├── Cliente.java                # Entidade JPA
│   └── Rendimento.java             # Entidade JPA (fonte + valor)
└── repository/
    ├── ClienteRepository.java
    └── RendimentoRepository.java

src/main/resources/
├── application.properties          # Configuração da aplicação
└── templates/clientes/
    ├── index.html                  # Listagem + busca
    ├── create.html                 # Cadastro
    ├── edit.html                   # Edição
    └── show.html                   # Detalhes
```

---

## 🌐 Rotas Disponíveis (Módulo Cliente)

| Método | Rota | Descrição |
|---|---|---|
| GET | `/clientes/` | Lista clientes (com busca por nome) |
| GET | `/clientes/create` | Formulário de cadastro |
| POST | `/clientes/` | Salva novo cliente (JSON) |
| GET | `/clientes/{id}` | Exibe detalhes do cliente |
| GET | `/clientes/{id}/edit` | Formulário de edição |
| PUT | `/clientes/{id}` | Atualiza cliente (JSON) |
| DELETE | `/clientes/{id}` | Remove cliente |

---

## Autores

- David Olinda Pomine
- Jonas Martins
