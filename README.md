# 📚 Desafio Backend - CRUD

- Este Desafio foi feito para melhorar as habilidades com Java , Spring, além de aprender conceitos importantes como DTO, aplicação RESTful. Consiste em um controle de estoque com mínimo de duas entidades.

## 📌 Funcionalidades

- CRUD completo de produtos (Create, Read, Update, Delete).

- Movimentação de estoque (Entrada e Saída), com:

  - Validação de saldo ao efetuar saídas

  - Retorno de mensagem adequada caso não haja estoque suficiente

- Consulta de produtos por tipo, exibindo:

  - Quantidade total em estoque

  - Quantidade total de saídas

- Consulta de lucro por produto, incluindo:

  - Quantidade total de saídas

  - Valor de lucro (valor de venda – valor do fornecedor)

## 🛠️ Tecnologias utilizadas

- Java 17+

- Spring Boot

- Spring Data JPA

- H2 Database (banco em memória)

- Maven

- Postman (para testes)

## 📮 Exemplos de Requisições (Postman)

### 🔹 Criar Produto

```http
POST /produtos
```

```json
{
  "descricao": "Notebook",
  "tipo": "ELETRONICO",
  "valorFornecedor": 2500,
  "quantidadeEstoque": 10
}
```

### 🔹 Registrar Entrada no Estoque

```http
POST /movimentos
```

```json
{
  "produtoId": 1,
  "tipo": "ENTRADA",
  "valorVenda": 0,
  "quantidade": 5
}
```

### 🔹 Registrar Saída no Estoque

```http
POST /movimentos
```

```json
{
  "produtoId": 1,
  "tipo": "SAIDA",
  "valorVenda": 3200,
  "quantidade": 2
}
```

✅ Se não houver saldo suficiente:

```json
{
  "erro": "Quantidade insuficiente em estoque"
}
```

### 🔹 Consultar Produtos por Tipo

```http
GET /produtos/tipo/ELETRONICO
```

### 🔹 Consultar Lucro por Produto

```http
GET /produtos/lucro
```

## ▶️ Como executar o projeto

### 🔧 Passos para rodar localmente

1. **Clone o repositório:**

```bash
git clone https://github.com/fabianoqss/CRUD-Java-Spring.git
```

2. **Acesse o diretório do projeto:**

```bash
cd CRUD-Java-Spring
```

3. **Execute a aplicação:**

```bash
./mvnw spring-boot:run
```

Ou, se estiver usando uma IDE, rode a classe `Application.java`.

4. **Acesse o console do H2 (opcional):**

- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Password: _(deixe em branco)_

### ✅ Testando com Postman

Com a aplicação rodando, use os exemplos de requisições fornecidos na seção anterior para interagir com os endpoints da API.
