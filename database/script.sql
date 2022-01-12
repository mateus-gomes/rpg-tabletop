CREATE DATABASE IF NOT EXISTS rpg;

USE rpg;

CREATE TABLE IF NOT EXISTS Eventos(
	id_evento INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS Usuarios(
	id_usuario INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    nickname VARCHAR(45) NOT NULL,
    senha VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS Players(
	id_player INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    progenitor VARCHAR(45),
    altura DECIMAL(3,2),
    nascimento DATE,
    nivel INT NOT NULL,
    dinheiro DECIMAL(8,2),
    vidaMaxima INT NOT NULL,
    vidaAtual INT NOT NULL,
    energiaMaxima INT NOT NULL,
    energiaAtual INT NOT NULL,
    fk_usuario INT NOT NULL,
    FOREIGN KEY(fk_usuario) REFERENCES Usuarios(id_usuario)
);

CREATE TABLE IF NOT EXISTS Historico(
	id_registro INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    motivo VARCHAR(45) NOT NULL,
    valorDado INT NOT NULL,
    nivelSucesso VARCHAR(45),
    fk_evento INT NOT NULL,
    fk_player INT NOT NULL,
    FOREIGN KEY(fk_evento) REFERENCES Eventos(id_evento),
    FOREIGN KEY(fk_player) REFERENCES Players(id_player)
);

CREATE TABLE IF NOT EXISTS Atributos(
	id_atributo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS Atributos_Player(
	id_atributo_player INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fk_player INT NOT NULL,
    fk_atributo INT NOT NULL,
    pontos INT NOT NULL,
    FOREIGN KEY(fk_player) REFERENCES Players(id_player),
    FOREIGN KEY(fk_atributo) REFERENCES Atributos(id_atributo)
);

CREATE TABLE IF NOT EXISTS Pericias(
	id_pericia INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS Pericias_Player(
	id_pericia_player INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fk_player INT NOT NULL,
    fk_pericia INT NOT NULL,
    pontos INT NOT NULL,
    FOREIGN KEY(fk_player) REFERENCES Players(id_player),
    FOREIGN KEY(fk_pericia) REFERENCES Pericias(id_pericia)
);

CREATE TABLE IF NOT EXISTS Inventarios(
	id_inventario INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    nota VARCHAR(400) NOT NULL,
    fk_player INT NOT NULL,
    FOREIGN KEY(fk_player) REFERENCES Players(id_player)
);

CREATE TABLE IF NOT EXISTS EfeitosArma(
	id_efeito_arma INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45),
    descricao VARCHAR(400)
);

CREATE TABLE IF NOT EXISTS EfeitosArmadura(
	id_efeito_armadura INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45),
    descricao VARCHAR(400)
);

CREATE TABLE IF NOT EXISTS Armas(
	id_arma INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    distancia VARCHAR(1) NOT NULL,
    dano VARCHAR(20) NOT NULL,
    maos INT NOT NULL,
    fk_player INT NOT NULL,
    FOREIGN KEY(fk_player) REFERENCES Players(id_player),
    fk_efeito_arma INT NOT NULL,
    FOREIGN KEY(fk_efeito_arma) REFERENCES EfeitosArma(id_efeito_arma)
);

CREATE TABLE IF NOT EXISTS Armaduras(
	id_armadura INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    bloqueio INT NOT NULL,
    maos INT NOT NULL,
    fk_player INT NOT NULL,
    FOREIGN KEY(fk_player) REFERENCES Players(id_player),
    fk_efeito_armadura INT NOT NULL,
    FOREIGN KEY(fk_efeito_armadura) REFERENCES EfeitosArmadura(id_efeito_armadura)
);

INSERT INTO Usuarios VALUES (null, "Castro", "castrao123", "therock<3");

INSERT INTO Players VALUES (null, "Ion", "?", 1.67, "2005-07-23", 1, 1200.00, 40, 40, 50, 50, 1);

INSERT INTO Pericias VALUES
(null, "Conjurar");

INSERT INTO Pericias_Player VALUES
(null, 1, 1, 11);

SELECT * FROM Pericias_Player WHERE fk_player = 1 AND fk_pericia = 1;

SELECT * FROM Players;

DROP DATABASE rpg;