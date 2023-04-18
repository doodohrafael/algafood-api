
# API de Delivery de Comida

API de Delivery de Comida criada para disponibilizar serviços de restaurantes.

## Stack utilizada

**Front-end:** XML e Json.

**Back-end:** Java, SpringBoot, SpringMVC, SpringFramework, Spring Data JPA, MySql com JPA e Hibernate.

**Outras stacks:** Lombok, FlyWay, Apache Commons Lang 3, REST Assured, Maven Failsafe Plugin e Jackson Dataformat XML.


## Autor

- [@doodohrafael](https://www.github.com/doodohrafael)


## Projeto em construção...
## Documentação da API de Delivery de Comida

### Serviços de Cozinha

#### RETORNA UMA COZINHA EXISTENTE POR ID:

```http
  GET /cozinhas/{cozinhaId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cozinhaId`      | `Long` | **É Obrigatório** informar o ID da cozinha que você quer buscar |

#### Serviço: buscar(Long cozinhaId).

Recebe o id da cozinha e retorna uma cozinha específica de acordo com o ID.


## 

#### RETORNA TODAS AS COZINHAS:

```http
  GET /cozinhas
```

| `sem parâmetro` |


#### Serviço: listar().

Retorna todas as cozinhas.


## 

#### ADICIONA UMA NOVA COZINHA:

```http
  POST /cozinhas
```

| Parâmetro   | Tipo  | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `Cozinha`  | `Json` | **É Obrigatório** informar o arquivo Json. |

#### Serviço: adicionar(Cozinha cozinha).

Adiciona uma nova cozinha e retorna a cozinha adicionada.


## 

#### ATUALIZA UMA COZINHA EXISTENTE:

```http
  PUT /cozinhas/{cozinhaId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cozinhaId`      | `Long` | **É Obrigatório** informar o ID da cozinha que você quer atualizar |
| `Cozinha`  | `Json` | **É Obrigatório** informar o arquivo Json.  |

#### Serviço: atualizar(Long cozinhaId, Cozinha cozinha).

Recebe o id da cozinha e a cozinha em json, atualiza a cozinha existente e retorna a cozinha que foi atualizada.


## 

#### ATUALIZA UMA COZINHA EXISTENTE PARCIALMENTE:

```http
  PATCH /cozinhas/{cozinhaId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cozinhaId`      | `Long` | **É Obrigatório** informar o ID da cozinha que você quer atualizar |
| `Cozinha`  | `Json` | **É Obrigatório** informar o arquivo Json. |

#### Serviço: atualizarParcial(Long cozinhaId, Cozinha cozinha).

Recebe o id da cozinha e a cozinha em json, atualiza a cozinha existente e retorna a cozinha que foi atualizada.


## 

#### REMOVE UMA COZINHA EXISTENTE :

```http
  DELETE /cozinhas/{cozinhaId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cozinhaId`      | `Long` | **É Obrigatório** informar o ID da cozinha que você quer deletar |

#### Serviço: remover(Long cozinhaId).

Recebe o id da cozinha, deleta a cozinha existente e retorna um "no content - 204".


## 

#### RETORNA UMA COZINHA EXISTENTE POR NOME:

```http
  GET /cozinhas/por-nome
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar o nome da cozinha que você quer buscar |

#### Serviço: cozinhasPorNome(String nome).

Recebe o nome da cozinha e retorna uma ou várias cozinhas de acordo com o nome.


## 

#### RETORNA UMA COZINHA EXISTENTE POR NOME:

```http
  GET /cozinhas/por-nome-customizada
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar o nome da cozinha que você quer buscar |

#### Serviço: cozinhaPorNomeCustomizada(String nome).

Recebe o nome da cozinha e retorna uma ou várias cozinhas de acordo com o nome.


## 

#### RETORNA UMA COZINHA EXISTENTE POR NOME:

```http
  GET /cozinhas/por-nome-orm
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar o nome da cozinha que você quer buscar |

#### Serviço: cozinhaPorNomeOrm(String nome).

Recebe o nome da cozinha e retorna uma ou várias cozinhas de acordo com o nome.


## 

#### RETORNA UMA COZINHA EXISTENTE POR NOME:

```http
  GET /cozinhas/por-nome-jpql
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar o nome da cozinha que você quer buscar |

#### Serviço: cozinhaPorNomeJpql(String nome).

Recebe o nome da cozinha e retorna uma ou várias cozinhas de acordo com o nome.


## 

#### RETORNA UMA COZINHA EXISTENTE POR NOME:

```http
  GET /cozinhas/por-nome-dinamico
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **Não é Obrigatório** informar o nome da cozinha que você quer buscar. Caso não informe, serão retornadas todas as cozinhas.  |

#### Serviço: cozinhaPorNomeDinamico(String nome).

Recebe o nome da cozinha e retorna uma ou várias cozinhas de acordo com o nome.


## 

#### RETORNA AS DUAS PRIMEIRAS COZINHAS EXISTENTES:

```http
  GET /cozinhas/por-nome-dois-primeiros
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar o nome da cozinha que você quer buscar |

#### Serviço: cozinhaPorNomeDoisPrimeiros(String nome).

Recebe o nome da cozinha e retorna as duas primeiras cozinhas do DB de acordo com o nome informado.


## 

#### RETORNA UMA COZINHA EXISTENTE POR NOME:

```http
  GET /cozinhas/por-nome-primeiro
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar nome da cozinha que você quer buscar |

#### Serviço: cozinhaPorNomePrimeiro(String nome).

Recebe o nome da cozinha e retorna a primeira cozinha específica de acordo com o nome informado.


## 

#### RETORNA UMA OU VÁRIAS COZINHAS EXISTENTES POR NOME:

```http
  GET /cozinhas/por-nome-criteria
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` |  **Não é Obrigatório** informar o nome da cozinha que você quer buscar. Caso não informe, serão retornadas todas as cozinhas. |

#### Serviço: cozinhaPorNomeCriteria(String nome).

Recebe o nome da cozinha e retorna uma ou várias cozinhas de acordo com o nome.


## 

#### RETORNA DUAS COZINHAS EXISTENTES:

```http
  GET /cozinhas/duas-primeiras-custom
```

| `sem parâmetro` |

#### Serviço: duasPrimeirasCozinhasCustom().

Retorna as duas primeiras cozinhas do DB.


## 

#### RETORNA UMA OU VÁRIAS COZINHAS EXISTENTES POR NOME:

```http
  GET /cozinhas/nomes-semelhantes
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar o nome da cozinha que você quer buscar |

#### Serviço: cozinhasNomesSemelhantes(String nome).

Recebe o nome da cozinha e retorna uma ou várias cozinhas de acordo com o nome.


# | --------------------------------------------------- |

### Serviços de Restaurante

#### RETORNA UM RESTAURANTE EXISTENTE POR ID:

```http
  GET /restaurantes/{restauranteId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `restauranteId`| `Long` | **É Obrigatório** informar o ID do restaurante que você quer buscar |

#### Serviço: buscar(Long restauranteId).

Recebe o id da cozinha e retorna uma cozinha específica de acordo com o ID.

## 

#### RETORNA TODOS OS RESTAURANTES:

```http
  GET /restaurantes
```

| `sem parâmetro` |

#### Serviço: listar().

Retorna todos os restaurantes.


## 

#### ADICIONA UM NOVO RESTAURANTE:

```http
  POST /restaurantes
```

| Parâmetro   | Tipo  | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `Restaurante`  | `Json` | **É Obrigatório** informar o arquivo Json. |

#### Serviço: adicionar(Restaurante restaurante).

Adiciona um novo restaurante e retorna o restaurante adicionado.


## 

#### ATUALIZA UM RESTAURANTE EXISTENTE:

```http
  PUT /restaurantes/{restauranteId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `restauranteId`      | `Long` | **É Obrigatório** informar o ID do restaurante que você quer atualizar |
| `Restaurante` | `Json` | **É Obrigatório** informar o arquivo Json.  |

#### Serviço: atualizar(Long restauranteId, Restaurante restaurante).

Recebe o id do restaurante e o restaurante em json, atualiza o restaurante existente e retorna o restaurante que foi atualizado.


## 

#### REMOVE UM RESTAURANTE EXISTENTE :

```http
  DELETE /restaurantes/{restauranteId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `restauranteId` | `Long` | **É Obrigatório** informar o ID do restaurante que você quer deletar |

#### Serviço: remover(Long restauranteId).

Recebe o id do restaurante, deleta o restaurante existente e retorna um "no content - 204".


## 

#### ATUALIZA UM RESTAURANTE EXISTENTE PARCIALMENTE:

```http
  PATCH /restaurantes/{restauranteId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `restauranteId`      | `Long` | **É Obrigatório** informar o ID do restaurante que você quer atualizar |
| `Restaurante`  | `Json` | **É Obrigatório** informar o arquivo Json. |

#### Serviço: atualizarParcial(Long restauranteId, Restaurante restaurante).

Recebe o id do restaurante e o restaurante em json, atualiza o restaurante existente e retorna o restaurante que foi atualizado.


## 

#### RETORNA UM RESTAURANTE EXISTENTE POR NOME:

```http
  GET /restaurantes/por-nome
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar o nome do restaurante que você quer buscar |

#### Serviço: restaurantePorNome(String nome).

Recebe o nome do restaurante e retorna um ou vários restaurantes de acordo com o nome.


## 

#### RETORNA UM RESTAURANTE POR NOME DO RESTAUTANTE E ID DA COZINHA:

```http
  GET /restaurantes/por-nome-e-cozinha
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar o nome do restaurante que você quer buscar |
| `cozinhaId`      | `Long` | **É Obrigatório** informar o ID da cozinha do restaurante que você quer buscar |

#### Serviço: restaurantePorNomeECozinha(String nome, Long cozinhaId).

Recebe o nome do restaurante e o id da cozinha e retorna um restaurante específico de acordo com o nome e o ID.


## 

#### RETORNA UM RESTAURANTE POR TAXA INICIAL E TAXA FINAL. ESSES VALORES SÃO REFERENTE AOS VALORES DE TAXA DE FRETE:

```http
  GET /restaurantes/por-taxa-frete-ordenado-por-nome
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `taxaInicial`  | `BigDecimal` | **É Obrigatório** informar o valor numérico (Ex: 04.22) da taxaInicial do restaurante que você quer buscar |
| `taxaFinal`    | `BigDecimal` | **É Obrigatório** informar o valor numérico (Ex: 04.22) da taxaFinal do restaurante que você quer buscar |

#### Serviço: restaurantesPorTaxaFreteOrdenadosPorNome(BigDecimal taxaInicial, BigDecimal taxaFinal).

Recebe os valores numéricos da taxaInicial e taxaFinal do restaurante e retorna um ou mais restaurantes de acordo com a taxaInicial e taxaFinal.


## 

#### RETORNA UM RESTAURANTE POR NOME DO RESTAUTANTE E ID DA COZINHA:

```http
  GET /restaurantes/por-nome-e-cozinha-orm
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar o nome do restaurante que você quer buscar |
| `cozinhaId`      | `Long` | **É Obrigatório** informar o ID da cozinha do restaurante que você quer buscar |

#### Serviço: restaurantePorNomeECozinhaOrm(String nome, Long cozinhaId).

Recebe o nome do restaurante e o id da cozinha e retorna um restaurante específico de acordo com o nome e o ID.


## 

#### RETORNA UM RESTAURANTE POR NOME, TAXA INICIAL E TAXA FINAL. ESSES VALORES SÃO REFERENTE AOS VALORES DE TAXA DE FRETE:

```http
  GET /restaurantes/por-nome-e-frete
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar o nome do restaurante que você quer buscar |
| `taxaInicial`  | `BigDecimal` | **É Obrigatório** informar o valor numérico (Ex: 04.22) da taxaInicial do restaurante que você quer buscar |
| `taxaFinal`    | `BigDecimal` | **É Obrigatório** informar o valor numérico (Ex: 04.22) da taxaFinal do restaurante que você quer buscar |

#### Serviço: restaurantesPorNomeFrete(String nome, BigDecimal taxaInicial, BigDecimal taxaFinal).

Recebe o nome do restaurante e os valores numéricos da taxaInicial e taxaFinal do restaurante e retorna um ou mais restaurantes de acordo com o nome, a taxaInicial e taxaFinal.


## 

#### RETORNA UM RESTAURANTE POR NOME, TAXA INICIAL E TAXA FINAL. ESSES VALORES SÃO REFERENTE AOS VALORES DE TAXA DE FRETE:

```http
  GET /restaurantes/por-nome-e-frete-dinamico
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **Não É Obrigatório** informar o nome do restaurante que você quer buscar |
| `taxaInicial`  | `BigDecimal` | **Não É Obrigatório** informar o valor numérico (Ex: 04.22) da taxaInicial do restaurante que você quer buscar |
| `taxaFinal`    | `BigDecimal` | **Não É Obrigatório** informar o valor numérico (Ex: 04.22) da taxaFinal do restaurante que você quer buscar |

#### Serviço: restaurantesPorNomeFreteDinamico(String nome, BigDecimal taxaInicial, BigDecimal taxaFinal).

Recebe o nome do restaurante e os valores numéricos da taxaInicial e taxaFinal do restaurante e retorna um ou mais restaurantes de acordo com o nome, a taxaInicial e taxaFinal.
Caso não informe nenhum parâmetro, serão retornas todos os restaurantes.
Você pode usar nenhum, um, dois ou todos os parâmetros.


## 

#### RETORNA UM RESTAURANTE POR TAXA INICIAL E TAXA FINAL. ESSES VALORES SÃO REFERENTE AOS VALORES DE TAXA DE FRETE:

```http
  GET /restaurantes/por-taxa-frete
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `taxaInicial`  | `BigDecimal` | **É Obrigatório** informar o valor numérico (Ex: 04.22) da taxaInicial do restaurante que você quer buscar |
| `taxaFinal`    | `BigDecimal` | **É Obrigatório** informar o valor numérico (Ex: 04.22) da taxaFinal do restaurante que você quer buscar |

#### Serviço: restaurantePorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal).

Recebe os valores numéricos da taxaInicial e taxaFinal do restaurante e retorna um ou mais restaurantes de acordo com a taxaInicial e taxaFinal.


## 

#### RETORNA SE UM RESTAURANTE EXISTE POR NOME:

```http
  GET /restaurantes/existe
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar o nome do restaurante que você quer buscar |

#### Serviço: restauranteExiste(String nome).

Recebe o nome do restaurante e retorna um restaurante existente de acordo com o nome.


## 

#### RETORNA OS DOIS PRIMEIROS RESTAURANTES EXISTENTES:

```http
  GET /restaurantes/dois-primeiros
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar o nome dO restaurante que você quer buscar |

#### Serviço: cozinhaPorNomeDoisPrimeiros(String nome).

Recebe o nome do restaurante e retorna os dois primeiros restaurantes do DB de acordo com o nome informado.


## 

#### RETORNA UM RESTAURANTE POR NOME, TAXA INICIAL E TAXA FINAL. ESSES VALORES SÃO REFERENTE AOS VALORES DE TAXA DE FRETE:

```http
  GET /restaurantes/por-nome-e-frete-criteria
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **Não É Obrigatório** informar o nome do restaurante que você quer buscar |
| `taxaInicial`  | `BigDecimal` | **Não É Obrigatório** informar o valor numérico (Ex: 04.22) da taxaInicial do restaurante que você quer buscar |
| `taxaFinal`    | `BigDecimal` | **Não É Obrigatório** informar o valor numérico (Ex: 04.22) da taxaFinal do restaurante que você quer buscar |

#### Serviço: restaurantesPorNomeFreteCriteria(String nome, BigDecimal taxaInicial, BigDecimal taxaFinal).

Recebe o nome do restaurante e os valores numéricos da taxaInicial e taxaFinal do restaurante e retorna um ou mais restaurantes de acordo com o nome, a taxaInicial e taxaFinal.
Caso não informe nenhum parâmetro, serão retornas todos os restaurantes.
Você pode usar nenhum, um, dois ou todos os parâmetros.


## 

#### RETORNA UM OU MAIS RESTAURANTES EXISTENTES:

```http
  GET /restaurantes/por-nome-com-frete-gratis
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar o nome dO restaurante que você quer buscar |

#### Serviço: restaurantesComFreteGratis(String nome).

Recebe o nome do restaurante e retorna um ou mais restaurantes de acordo com o nome e que possuam a taxa de frete grátis (0.00).


## 

#### RETORNA UM RESTAURANTE EXISTENTE POR NOME:

```http
  GET /restaurantes/primeiro-por-nome
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar nome do restaurante que você quer buscar |

#### Serviço: primeiroRestaurante(String nome).

Recebe o nome do restaurante e retorna o primeiro restaurante específico de acordo com o nome informado.


## 

#### RETORNA A QUANTIDADE DE RESTAURANTES EM QUE A COZINHA BUSCADA ESTÁ CADASTRADA:

```http
  GET /restaurantes/cozinhas
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cozinhaId`      | `Long` | **É Obrigatório** informar o ID da cozinha que você quer buscar |

#### Serviço: cozinhasRestaurante(Long cozinhaId).

Retorna a quantidade de restaurantes em que a cozinha buscada está cadastrada. 


## 

#### RETORNA O PRIMEIRO RESTAUTANTE:

```http
  GET /restaurantes/primeiro
```

| `sem parâmetro` |


#### Serviço: primeiroRestaurante().

Retorna o primeiro restaurante cadastrado.


## 

#### RETORNA DOIS RESTAURANTES EXISTENTES:

```http
  GET /restaurantes/dois-primeiros-custom
```

| `sem parâmetro` |

#### Serviço: doisPrimeirosRestaurantesCustom().

Retorna os dois primeiros restaurantes cadastrados.

# | --------------------------------------------------- |

### Serviços de Estado

#### RETORNA UM ESTADO EXISTENTE POR ID:

```http
  GET /estados/{estadoId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `estadoId`      | `Long` | **É Obrigatório** informar o ID do estado que você quer buscar |

#### Serviço: buscar(Long estadoId).

Recebe o id do estado e retorna um estado específico de acordo com o ID.


## 

#### RETORNA TODOS OS ESTADO:

```http
  GET /estados
```

| `sem parâmetro` |


#### Serviço: listar().

Retorna todos os estados.


## 

#### ADICIONA UM NOVO ESTADO:

```http
  POST /estados
```

| Parâmetro   | Tipo  | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `Estado`  | `Json` | **É Obrigatório** informar o arquivo Json. |

#### Serviço: adicionar(Estado estado).

Adiciona um novo estado e retorna o estado adicionado.


## 

#### ATUALIZA UM ESTADO EXISTENTE:

```http
  PUT /estados/{estadoId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `estadoId`      | `Long` | **É Obrigatório** informar o ID do estado que você quer atualizar |
| `Estado`  | `Json` | **É Obrigatório** informar o arquivo Json.  |

#### Serviço: atualizar(Long estadoId, Estado estado).

Recebe o id do estado e o estado em json, atualiza o estado existente e retorna o estado que foi atualizado.


## 

#### ATUALIZA UM ESTADO EXISTENTE PARCIALMENTE:

```http
  PATCH /estados/{estadoId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `estadoId`      | `Long` | **É Obrigatório** informar o ID do estado que você quer atualizar |
| `Estado`  | `Json` | **É Obrigatório** informar o arquivo Json. |

#### Serviço: atualizarParcial(Long estadoId, Estado estado).

Recebe o id do estado e o estado em json, atualiza o estado existente e retorna o estado que foi atualizado.


## 

#### REMOVE UM ESTADO EXISTENTE :

```http
  DELETE /estados/{estadoId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `estadoId`      | `Long` | **É Obrigatório** informar o ID do estado que você quer deletar |

#### Serviço: excluir(Long estadoId).

Recebe o id do estado, deleta o estado existente e retorna um "no content - 204".


## 

#### RETORNA A QUANTIDADE DE ESTADOS EXISTENTES:

```http
  GET /estados/quantidade
```

| `sem parâmetro` |

#### Serviço: quantidade().

Retorna a quantidade de estados existentes.

## 

#### RETORNA UM ESTADO EXISTENTE POR NOME:

```http
  GET /estados/por-nome
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar o nome do estado que você quer buscar |

#### Serviço: nomesIguais(String nome).

Recebe o nome do estado e retorna um ou vários estados de acordo com o nome.


## 

#### RETORNA O PRIMEIRO ESTADO ENCONTRADO POR NOME:

```http
  GET /estados/primeiro
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar nome do estado que você quer buscar |

#### Serviço: primeiroEstado(String nome).

Recebe o nome do estado e retorna o primeiro estado específico de acordo com o nome informado.


## 

#### RETORNA UM ESTADO EXISTENTE POR NOME:

```http
  GET /estados/por-nome-comecando-por
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar nome do estado que você quer buscar |

#### Serviço: estadoPorNomeComecandoPor(String nome).

Recebe o nome do estado e retorna o primeiro estado específico de acordo com o nome informado.

# | --------------------------------------------------- |

### Serviços de Cidade

#### RETORNA UM CIDADE EXISTENTE POR ID:

```http
  GET /cidades/{cidadeId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cidadeId`      | `Long` | **É Obrigatório** informar o ID da cidade que você quer buscar |

#### Serviço: buscar(Long cidadeId).

Recebe o id da cidade e retorna uma cidade específica de acordo com o ID.


## 

#### RETORNA TODAS AS CIDADES:

```http
  GET /cidades
```

| `sem parâmetro` |


#### Serviço: listar().

Retorna todas as cidades.


## 

#### ADICIONA UMA NOVA CIDADE:

```http
  POST /cidades
```

| Parâmetro   | Tipo  | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `Cidade`  | `Json` | **É Obrigatório** informar o arquivo Json. |

#### Serviço: adicionar(Cidade cidade).

Adiciona uma nova cidade e retorna a cidade adicionada.


## 

#### ATUALIZA UMA CIDADE EXISTENTE:

```http
  PUT /cidades/{cidadeId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cidadeId`      | `Long` | **É Obrigatório** informar o ID da cidade que você quer atualizar |
| `Cidade`  | `Json` | **É Obrigatório** informar o arquivo Json.  |

#### Serviço: atualizar(Long cidadeId, Cidade cidade).

Recebe o id da cidade e a cidade em json, atualiza a cidade existente e retorna a cidade que foi atualizada.


## 

#### ATUALIZA UMA CIDADE EXISTENTE PARCIALMENTE:

```http
  PATCH /cidades/{cidadeId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cidadeId`      | `Long` | **É Obrigatório** informar o ID da cidade que você quer atualizar |
| `Cidade`  | `Json` | **É Obrigatório** informar o arquivo Json. |

#### Serviço: atualizarParcial(Long estadoId, Estado estado).

Recebe o id da cidade e a cidade em json, atualiza a cidade existente e retorna a cidade que foi atualizada.


## 

#### REMOVE UMA CIDADE EXISTENTE :

```http
  DELETE /cidades/{cidadeId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cidadeId`      | `Long` | **É Obrigatório** informar o ID da cidade que você quer deletar |

#### Serviço: excluir(Long cidadeId).

Recebe o id da cidade, deleta a cidade existente e retorna um "no content - 204".


## 

#### RETORNA UMA CIDADE EXISTENTE POR NOME:

```http
  GET /cidades/por-nome
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar o nome da cidade que você quer buscar |

#### Serviço: cidadePorNome(String nome).

Recebe o nome da cidade e retorna uma ou várias cidades de acordo com o nome.


## 

#### RETORNA A PRIMEIRA CIDADE ENCONTRADA POR NOME:

```http
  GET /cidades/primeira
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar nome da cidade que você quer buscar |

#### Serviço: primeiraCidade(String nome).

Recebe o nome da cidade e retorna a primeira cidade específica de acordo com o nome informado.
## 

#### RETORNA UMA OU VÁRIAS COZINHAS POR NOME DA CIDADE E ID DO ESTADO:

```http
  GET /cidades/por-nome-e-estado
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **É Obrigatório** informar o nome da cidade que você quer buscar |
| `estadoId`      | `Long` | **É Obrigatório** informar o ID do estado do estado que você quer buscar |

#### Serviço: cidadePorNomeEEstado(String nome, Long estadoId).

Recebe o nome da cidade e o id do estado e retorna uma cidade específica de acordo com o nome e o ID.


## 

#### RETORNA A QUANTIDADE DE CIDADES EXISTENTES EM QUE O ESTADO BUSCADO ESTÁ CADASTRADO:


```http
  GET /cidades/estados
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `estadoId`      | `Long` | **É Obrigatório** informar o ID do estado que você quer buscar |

#### Serviço: cidadePorEstado(Long estadoId).

Retorna a quantidade de cidades em que o estado buscado está cadastrado.