insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Gourmet', 10, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delivery', 0, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Tuk Tuk Comida Indiana', 15, 2);

insert into forma_pagamento (descricao) values ('Pix');

insert into permissao (nome, descricao) values ('Consultar', 'Consultar estoque de carnes');

insert into estado (id, nome) values (1, 'Pernambuco');
insert into estado (id, nome) values (2, 'São Paulo');

insert into cidade (nome, estado_id) values ('Paulista', 1);
insert into cidade (nome, estado_id) values ('Recife', 1);
insert into cidade (nome, estado_id) values ('Diadema', 2);

