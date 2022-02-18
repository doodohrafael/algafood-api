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

##### GET /cozinhas/unica-por-nome: - Buscar uma cozinha específica por nome
##### KEYS: nome; VALUES: String;

##### GET /cozinhas/por-nome: - Buscar uma lista de cozinhas existentes no banco de dados por nome
##### KEYS: nome; VALUES: String;



-------------------------------------------------------------------------------------------

### As informações de Restaurante já podem ser consumidas através de seus end-points localmente;
### Métodos existentes: Get, Post, Put, Patch e Delete;


##### GET /restaurantes/{id}: - Buscar um restaurante específico por id

##### GET /restaurantes: - Buscar uma lista de todos os restaurantes existentes no banco de dados

##### POST /restaurantes: - Adicionar um novo restaurante

##### PUT /restaurantes/{id}: - Atualizar um restaurante existente

##### PATCH /restaurantes/{id}: - Atualizar parcialmente um restaurante existente

##### DELETE /restaurantes/{id}: - Excluir um restaurante existente

##### GET /restaurantes/por-taxa-frete: - Buscar uma lista de restaurantes existentes no banco de dados filtrando entre taxa frete inicial e taxa frete final
##### KEYS: taxaInicial; taxaFinal; VALUES: Long;

##### GET /restaurantes/por-nome: - Buscar uma lista de restaurantes filtrando por nome
##### KEYS: nome;  VALUES: String;

##### GET /restaurantes/por-nome-e-cozinha: - Buscar uma lista de restaurantes filtrando por nome e id de cozinha
##### KEYS: nome; cozinhaId; VALUES: String; Long;

##### GET /restaurantes/por-taxa-frete-ordenado-por-nome: - Buscar uma lista de restaurantes filtrando por taxa frete inicial e taxa frete final
##### KEYS: taxaInicial; taxaFinal; VALUES: Long;

##### GET /restaurantes/por-nome-e-cozinha-orm: - Buscar uma lista de restaurantes filtrando por nome e id de cozinha
##### KEYS: nome; cozinhaId; VALUES: String; Long;

##### GET /restaurantes/por-nome-e-frete: - Buscar uma lista de restaurantes filtrando por nome e por taxa frete inicial e taxa frete final
##### KEYS: nome; taxaInicial; taxaFinal; VALUES: String; Long;

##### GET /restaurantes/por-nome-e-frete-dinamico: - Buscar uma lista de restaurantes filtrando por nome e por taxa frete inicial e taxa frete final
##### KEYS: nome; taxaInicial; taxaFinal; VALUES: String; Long;

##### GET /restaurantes/por-taxa-frete: - Buscar uma lista de restaurantes filtrando por taxa frete inicial e taxa frete final
##### KEYS: taxaInicial; taxaFinal; VALUES: Long;

##### GET /restaurantes/existe: - Saber se um restaurante existe filtrando pelo nome
##### KEYS: nome; VALUES: String;

##### GET /restaurantes/dois-primeiros: - Buscar uma lista de restaurantes trazendo somente os 2 primeiros resultados filtrando por nome
##### KEYS: nome; VALUES: String;

##### GET /restaurantes/por-nome-e-frete-criteria: - Buscar uma lista de restaurantes filtrando por nome e por taxa frete inicial e taxa frete final
##### KEYS: nome; taxaInicial; taxaFinal; VALUES: String; Long;

##### GET /restaurantes/por-nome-com-frete-gratis: - Buscar uma lista de restaurantes filtrando por nome e por taxa frete grátis
##### KEYS: nome; VALUES: String;

##### GET /restaurantes/primeiro-por-nome: - Buscar primeiro restaurante encontrado filtrando por nome
##### KEYS: nome; VALUES: String;

##### GET /restaurantes/cozinhas: - Buscar quantidades de restaurantes que uma cozinha tem filtrando pelo id da cozinha
##### KEYS: cozinhaId; VALUES: Long;

##### GET /restaurantes/primeiro: - Buscar primeiro restaurante encontrado
##### KEYS: nome; VALUES: String;


-------------------------------------------------------------------------------------------

### As informações de Estado já podem ser consumidas através de seus end-points localmente;
### Métodos existentes: Get, Post, Put, Patch e Delete;


##### GET /estados/{id}: localhost:8080/estados/1 - Buscar um estado específico por id

##### GET /estados: localhost:8080/estados - Buscar uma lista de todos os estados existentes no banco de dados

##### POST /estados: localhost:8080/estados - Adicionar um novo estado

##### PUT /estados/{id}: localhost:8080/estados/2 - Atualizar um estado existente

##### PATCH /estados/{id}: localhost:8080/estados/1 - Atualizar parcialmente um estado existente

##### DELETE /estados/{id}: localhost:8080/estados/1 - Excluir um estado existente

-------------------------------------------------------------------------------------------

### As informações de Cidade já podem ser consumidas através de seus end-points localmente;
### Métodos existentes: Get, Post, Put, Patch e Delete;


##### GET /cidades/{id}: localhost:8080/cidades/1 - Buscar uma cidade específica por id

##### GET /cidades: localhost:8080/cidades - Buscar uma lista de todas os cidades existentes no banco de dados

##### POST /cidades: localhost:8080/cidades - Adicionar uma nova cidade

##### PUT /cidades/{id}: localhost:8080/cidades/2 - Atualizar uma cidade existente

##### PATCH /cidades/{id}: localhost:8080/cidades/1 - Atualizar parcialmente uma cidade existente

##### DELETE /cidades/{id}: localhost:8080/cidades/1 - Excluir uma cidade existente
