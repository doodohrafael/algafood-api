
# API de Delivery de Comida

API de Delivery de Comida feita para disponibilizar serviços de restaurantes.

## Stack utilizada

**Front-end:** JSF e PrimeFaces.

**Back-end:** Java, SpringBoot, SpringMVC, SpringFramework, Spring Data JPA, MySql com JPA e Hibernate.

**Outras stacks:** Lombok, FlyWay, Apache Commons Lang 3, REST Assured, Maven Failsafe Plugin e Jackson Dataformat XML.


## Autor

- [@doodohrafael](https://www.github.com/doodohrafael)


## Projeto em construção...
## Documentação da API de Delivery de Comida

### Serviços de Cozinha

#### RETORNA UMA COZINHA:

```http
  GET /cozinhas/{cozinhaId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cozinhaId`      | `Long` | **Obrigatório**. O ID da cozinha que você quer buscar |

#### Serviço: buscar(cozinhaId).

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
| `Cozinha`  | `json` | **Obrigatório**. Recebe um arquivo Json e adiciona no DB |

#### Serviço: adicionar(cozinha).

Adiciona uma nova cozinha e retorna a cozinha adicionada.


## 

#### ATUALIZA UMA COZINHA EXISTENTE:

```http
  PUT /cozinhas/{cozinhaId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cozinhaId`      | `string` | **Obrigatório**. O ID da cozinha que você quer atualizar |
| `Cozinha`  | `json` | **Obrigatório**. Recebe um arquivo Json e atualiza no DB |

#### Serviço: atualizar(cozinhaId, cozinha).

Recebe o id da cozinha e a cozinha em json, atualiza a cozinha existente e retorna a cozinha que foi atualizada.


## 

#### ATUALIZA UMA COZINHA EXISTENTE PARCIALMENTE:

```http
  PATCH /cozinhas/{cozinhaId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cozinhaId`      | `string` | **Obrigatório**. O ID da cozinha que você quer atualizar |
| `Cozinha`  | `json` | **Obrigatório**. Recebe um arquivo Json e atualiza no DB |

#### Serviço: atualizarParcial(cozinhaId, cozinha).

Recebe o id da cozinha e a cozinha em json, atualiza a cozinha existente e retorna a cozinha que foi atualizada.


## 

#### ATUALIZA UMA COZINHA EXISTENTE PARCIALMENTE:

```http
  DELETE /cozinhas/{cozinhaId}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cozinhaId`      | `string` | **Obrigatório**. O ID da cozinha que você quer deletar |

#### Serviço: remover(cozinhaId).

Recebe o id da cozinha, deleta a cozinha existente e retorna um "no content - 204".
