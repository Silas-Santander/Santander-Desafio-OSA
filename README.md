# API de Agências - Santander - Desafio OSA

## Visão Geral do Sistema

Criação de uma API REST em Spring Boot que realizará cadastramentos de Agências e sua posição, onde o usuário ao realizar uma consulta deverá retornar as distâncias das agências cadastradas.

### Principais Tecnologias
- **Java 17** - Linguagem de programação
- **Spring Boot 3.2.0** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **H2 Database** - Banco de dados em memória
- **Maven** - Gerenciamento de dependências
- **Swagger/OpenAPI 3** - Documentação da API

## Requisitos de Ambiente

### Versões Mínimas
- Java 17 ou superior
- Maven 3.8 ou superior

### Dependências Externas

- **H2 Database**: Iniciado automaticamente com a aplicação
- **Mocks**: Utilizados nos testes unitários (Mockito)

## Endpoints e Contratos

### Documentação

- **Swagger UI**: http://localhost:8080/swagger-ui.html

### Endpoints Principais

#### Cadastrar Agência
```http
POST /desafio/cadastrar
Content-Type: application/json

{
  "posX": 10.0,
  "posY": -5.0
}
```

**Validações:**
- `posX` e `posY` são obrigatórios
- Não é permitido cadastrar agências muito próximas (distância mínima: 1.0 unidade)

#### Buscar Agências Próximas
```http
GET /desafio/distancia?posX=-10&posY=5
```

## Testes

### Execução de Testes

```bash
mvn test
```


