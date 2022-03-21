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

# Andamento: O projeto ainda está em desenvolvimento, ainda estou no início do 7º módulo do curso, porém já consegui absorver muito conhecimento até onde estou, pois meu conhecimento em Java e outras tecnologias ajudam bastante. Estou indo um pouco mais longe nos desafios, tratando todos os possíveis erros em requisições e retornando o Status de cada resposta o mais coerente possível. Ao final desse curso e projeto, quero fazer um upgrade nesse projeto buscando ainda mais conhecimento sobre APIs, Spring e outras tecs.

# Documentação

### As informações de Cozinha já podem ser consumidas através de seus end-points localmente;


##### GET /cozinhas/{id}: - Buscar uma cozinha específica por id

##### GET /cozinhas: - Buscar uma lista de todas as cozinhas existentes no banco de dados

##### POST /cozinhas: - Adicionar uma nova cozinha

##### PUT /cozinhas/{id}: - Atualizar uma cozinha existente

##### PATCH /cozinhas/{id}: - Atualizar parcialmente uma cozinha existente

##### DELETE /cozinhas/{id}: - Excluir uma cozinha existente

##### GET /cozinhas/por-nome: - Buscar uma lista de cozinhas existentes filtrando por nome
##### KEYS: nome; VALUES: String;

##### GET /cozinhas/por-nome-customizada: - Buscar uma lista de cozinhas existentes filtrando por nome
##### KEYS: nome; VALUES: String;.

##### GET /cozinhas/por-nome-orm: - Buscar uma lista de cozinhas existentes filtrando por nome
##### KEYS: nome; VALUES: String;

##### GET /cozinhas/por-nome-jpql: - Buscar uma lista de cozinhas existentes filtrando por nome
##### KEYS: nome; VALUES: String;

##### GET /cozinhas/por-nome-dinamico: - Buscar uma lista de cozinhas existentes filtrando por nome
##### KEYS: nome; VALUES: String;

##### GET /cozinhas/por-nome-dinamico: - Buscar uma lista de cozinhas existentes filtrando por nome trazendo somente os dois primeiros resultados
##### KEYS: nome; VALUES: String;

##### GET /cozinhas/por-nome-dinamico: - Buscar uma lista de cozinhas existentes filtrando por nome trazendo somente o primeiro resultado
##### KEYS: nome; VALUES: String;

##### GET /cozinhas/por-nome-criteria: - Buscar uma lista de cozinhas existentes filtrando por nome
##### KEYS: nome; VALUES: String;

##### GET /cozinhas/por-nome-dinamico: - Buscar uma lista de cozinhas existentes trazendo somente os dois primeiros resultados

-------------------------------------------------------------------------------------------

### As informações de Restaurante já podem ser consumidas através de seus end-points localmente;


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

##### GET /restaurantes/cozinhas: - Buscar quantidade de restaurantes que uma cozinha tem filtrando pelo id da cozinha
##### KEYS: cozinhaId; VALUES: Long;

##### GET /restaurantes/primeiro: - Buscar primeiro restaurante encontrado

##### GET /restaurantes/dois-primeiros-custom: - Buscar uma lista de restaurantes trazendo somente os 2 primeiros resultados




-------------------------------------------------------------------------------------------

### As informações de Estado já podem ser consumidas através de seus end-points localmente;


##### GET /estados/{id}: - Buscar um estado específico por id

##### GET /estados: - Buscar uma lista de todos os estados existentes no banco de dados

##### POST /estados: - Adicionar um novo estado

##### PUT /estados/{id}: - Atualizar um estado existente

##### PATCH /estados/{id}: - Atualizar parcialmente um estado existente

##### DELETE /estados/{id}: - Excluir um estado existente

##### GET /estados/quantidade: - Buscar a quantidade de estados existentes no banco

##### GET /estados/primeiro: - Buscar uma lista de estados existentes filtrando por nome trazendo somente o primeiro resultado


-------------------------------------------------------------------------------------------

### As informações de Cidade já podem ser consumidas através de seus end-points localmente;


##### GET /cidades/{id}: - Buscar uma cidade específica por id

##### GET /cidades: - Buscar uma lista de todas os cidades existentes no banco de dados

##### POST /cidades: - Adicionar uma nova cidade

##### PUT /cidades/{id}: - Atualizar uma cidade existente

##### PATCH /cidades/{id}: - Atualizar parcialmente uma cidade existente

##### DELETE /cidades/{id}: - Excluir uma cidade existente

##### GET /cidades/por-nome-e-estado: - Buscar uma lista de cidades filtrando por nome
##### KEYS: nome; VALUES: String;

##### GET /cidades/por-nome-e-estado: - Buscar uma lista de cidades filtrando por nome e id de estado
##### KEYS: nome; estadoId; VALUES: String; Long;

##### GET /cidades/quantidade: - Buscar a quantidade de cidades que um estado cadastrado tem
