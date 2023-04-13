
# API de Delivery de Comida

API de Delivery de Comida criada para disponibilizar serviços de restaurantes.

## Stack utilizada

**Front-end:** JSF e PrimeFaces.

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

### Serviços de Cozinha

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

