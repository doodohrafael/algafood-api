
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
| `cozinhaId`      | `Long` | É **Obrigatório** informar o ID da cozinha que você quer buscar |

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
| `Cozinha`  | `json` | É **Obrigatório** informar o arquivo Json. |

#### Serviço: adicionar(Cozinha cozinha).

Adiciona uma nova cozinha e retorna a cozinha adicionada.


## 

#### ATUALIZA UMA COZINHA EXISTENTE:

```http
  PUT /cozinhas/{cozinhaId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cozinhaId`      | `Long` | *É **Obrigatório** informar o ID da cozinha que você quer atualizar |
| `Cozinha`  | `json` | *É **Obrigatório** informar o arquivo Json.  |

#### Serviço: atualizar(Long cozinhaId, Cozinha cozinha).

Recebe o id da cozinha e a cozinha em json, atualiza a cozinha existente e retorna a cozinha que foi atualizada.


## 

#### ATUALIZA UMA COZINHA EXISTENTE PARCIALMENTE:

```http
  PATCH /cozinhas/{cozinhaId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cozinhaId`      | `Long` | *É **Obrigatório** informar o ID da cozinha que você quer atualizar |
| `Cozinha`  | `json` | *É **Obrigatório** informar o arquivo Json. |

#### Serviço: atualizarParcial(Long cozinhaId, Cozinha cozinha).

Recebe o id da cozinha e a cozinha em json, atualiza a cozinha existente e retorna a cozinha que foi atualizada.


## 

#### REMOVE UMA COZINHA EXISTENTE :

```http
  DELETE /cozinhas/{cozinhaId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cozinhaId`      | `Long` | *É **Obrigatório** informar o ID da cozinha que você quer deletar |

#### Serviço: remover(Long cozinhaId).

Recebe o id da cozinha, deleta a cozinha existente e retorna um "no content - 204".


## 

#### RETORNA UMA COZINHA EXISTENTE POR NOME:

```http
  GET /cozinhas/por-nome
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `string` | *É **Obrigatório** informar o nome da cozinha que você quer buscar |

#### Serviço: cozinhasPorNome(String nome).

Recebe o nome da cozinha e retorna uma ou várias cozinhas de acordo com o nome.


## 

#### RETORNA UMA COZINHA EXISTENTE POR NOME:

```http
  GET /cozinhas/por-nome-customizada
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `string` | *É **Obrigatório** informar o nome da cozinha que você quer buscar |

#### Serviço: cozinhaPorNomeCustomizada(String nome).

Recebe o nome da cozinha e retorna uma ou várias cozinhas de acordo com o nome.


## 

#### RETORNA UMA COZINHA EXISTENTE POR NOME:

```http
  GET /cozinhas/por-nome-orm
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `string` | *É **Obrigatório** informar o nome da cozinha que você quer buscar |

#### Serviço: cozinhaPorNomeOrm(String nome).

Recebe o nome da cozinha e retorna uma ou várias cozinhas de acordo com o nome.


## 

#### RETORNA UMA COZINHA EXISTENTE POR NOME:

```http
  GET /cozinhas/por-nome-jpql
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `string` | *É **Obrigatório** informar o nome da cozinha que você quer buscar |

#### Serviço: cozinhaPorNomeJpql(String nome).

Recebe o nome da cozinha e retorna uma ou várias cozinhas de acordo com o nome.


## 

#### RETORNA UMA COZINHA EXISTENTE POR NOME:

```http
  GET /cozinhas/por-nome-dinamico
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `string` | **Não é Obrigatório** informar o nome da cozinha que você quer buscar. Caso não informe, serão retornadas todas as cozinhas.  |

#### Serviço: cozinhaPorNomeDinamico(String nome).

Recebe o nome da cozinha e retorna uma ou várias cozinhas de acordo com o nome.


## 

#### RETORNA AS DUAS PRIMEIRAS COZINHAS EXISTENTES:

```http
  GET /cozinhas/por-nome-dois-primeiros
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `string` | **Obrigatório**. O nome da cozinha que você quer buscar |

#### Serviço: cozinhaPorNomeDoisPrimeiros(String nome).

Recebe o nome da cozinha e retorna as duas primeiras cozinhas do DB de acordo com o nome informado.


## 

#### RETORNA UMA COZINHA EXISTENTE POR NOME:

```http
  GET /cozinhas/por-nome-primeiro
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `string` | **É Obrigatório** informar nome da cozinha que você quer buscar |

#### Serviço: cozinhaPorNomePrimeiro(String nome).

Recebe o nome da cozinha e retorna a primeira cozinha específica de acordo com o nome informado.


## 

#### RETORNA UMA OU VÁRIAS COZINHAS EXISTENTES POR NOME:

```http
  GET /cozinhas/por-nome-criteria
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `string` |  **Não é Obrigatório** informar o nome da cozinha que você quer buscar. Caso não informe, serão retornadas todas as cozinhas. |

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
| `nome`      | `string` | **É Obrigatório** informar o nome da cozinha que você quer buscar |

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

