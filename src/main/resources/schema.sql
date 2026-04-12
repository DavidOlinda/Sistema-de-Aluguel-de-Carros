CREATE TABLE IF NOT EXISTS clientes (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    rg VARCHAR(20) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(200) NOT NULL,
    profissao VARCHAR(100) NOT NULL,
    renda_principal DECIMAL(10,2) NOT NULL,
    renda_secundaria DECIMAL(10,2)
);