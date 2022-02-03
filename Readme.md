# API de Gerenciamento de Restaurante

## Tecnologias utilizadas

## Java 16;
## Spring MVC;
## Spring Boot;
## Spring Data JPA;
## Hibernate;
## Maven;
## Plugin e biblioteca Lombok;
## Postman para fazer testes de requisições e respostas.

## Descrição: Projeto que estou desenvolvendo do Curso "Especialita Spring Rest" da AlgaWorks que ensina muito sobre o ecossistema Spring e APIs REST.  

# Andamento: O projeto ainda está em desenvolvimento, ainda estou no final do 4º módulo do curso, porém já consegui absorver muito conhecimento até onde estou, pois meu conhecimento em Java e outras tecnologias ajudam bastante. Estou indo um pouco mais longe nos desafios, tratando todos os possíveis erros em requisições e retornando o Status de cada resposta o mais coerente possível. Ao final desse curso e projeto, quero fazer um upgrade nesse projeto buscando ainda mais conhecimento sobre APIs, Spring e outras tecs.

# Documentação

### As informações de Cozinha já podem ser consumidas através de seus end-points localmente;
### Métodos existentes: Get, Post, Put, Patch e Delete;


##### GET /cozinhas/{id}: localhost:8080/cozinhas/1 - Buscar uma cozinha específica por id

##### GET /cozinhas: localhost:8080/cozinhas - Buscar uma lista de todas as cozinhas existentes no banco de dados

##### POST /cozinhas: localhost:8080/cozinhas - Adicionar uma nova cozinha

##### PUT /cozinhas/{id}: localhost:8080/cozinhas/2 - Atualizar uma cozinha existente

##### PATCH /cozinhas/{id}: localhost:8080/cozinhas/1 - Atualizar parcialmente uma cozinha existente

##### DELETE /cozinhas/{id}: localhost:8080/cozinhas/1 - Excluir uma cozinha existente

-------------------------------------------------------------------------------------------

### As informações de Restaurante já podem ser consumidas através de seus end-points localmente;
### Métodos existentes: Get, Post, Put, Patch e Delete;


##### GET /restaurantes/{id}: localhost:8080/restaurantes/1 - Buscar um restaurante específico por id

##### GET /restaurantes: localhost:8080/restaurantes - Buscar uma lista de todos os restaurantes existentes no banco de dados

##### POST /restaurantes: localhost:8080/restaurantes - Adicionar um novo restaurante

##### PUT /restaurantes/{id}: localhost:8080/restaurantes/2 - Atualizar um restaurante existente

##### PATCH /restaurantes/{id}: localhost:8080/restaurantes/1 - Atualizar parcialmente um restaurante existente

##### DELETE /restaurantes/{id}: localhost:8080/restaurantes/1 - Excluir um restaurante existente

-------------------------------------------------------------------------------------------

### As informações de Estado já podem ser consumidas através de seus end-points localmente;
### Métodos existentes: Get, Post, Put e Delete;


##### GET /estados/{id}: localhost:8080/estados/1 - Buscar um estado específico por id

##### GET /estados: localhost:8080/estados - Buscar uma lista de todos os estados existentes no banco de dados

##### POST /estados: localhost:8080/estados - Adicionar um novo estado

##### PUT /estados/{id}: localhost:8080/estados/2 - Atualizar um estado existente

##### DELETE /estados/{id}: localhost:8080/estados/1 - Excluir um estado existente

-------------------------------------------------------------------------------------------

### As informações de Cidade já podem ser consumidas através de seus end-points localmente;
### Métodos existentes: Get, Post, Put e Delete;


##### GET /cidades/{id}: localhost:8080/cidades/1 - Buscar uma cidade específica por id

##### GET /cidades: localhost:8080/cidades - Buscar uma lista de todas os cidades existentes no banco de dados

##### POST /cidades: localhost:8080/cidades - Adicionar uma nova cidade

##### PUT /cidades/{id}: localhost:8080/cidades/2 - Atualizar uma cidade existente

##### DELETE /cidades/{id}: localhost:8080/cidades/1 - Excluir uma cidade existente
