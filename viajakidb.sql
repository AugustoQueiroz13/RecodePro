use viajakidb;
CREATE TABLE usuario (
id_usuario int PRIMARY KEY not null auto_increment,
nome_usuario varchar (20),
email varchar(20),
senha varchar(10)
);

CREATE TABLE cliente (
id_cliente int PRIMARY KEY not null auto_increment,
nome varchar(30),
cpf int(11),
telefone int(11),
id_usuario int, 
foreign key(id_usuario) references usuario (id_usuario)
);
CREATE TABLE endereco (
numero int(6),
bairro varchar(20),
cidade varchar(30),
uf varchar(2),
cep int(8),
rua varchar(50),
id_endereco int primary key not null auto_increment,
id_cliente int, 
foreign key (id_cliente) references cliente (id_cliente)
);

CREATE TABLE pedido (
id_pedido int(10) PRIMARY KEY not null auto_increment,
destino varchar(20),
data_viagem int(8),
qtde_dias int(3),
qtde_passagem int(3),
hotel varchar(20),
id_cliente int, 
foreign key (id_cliente) references cliente (id_cliente)
);