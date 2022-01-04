CREATE DATABASE rpg;

USE rpg;

CREATE TABLE IF NOT EXISTS Players(
	idPlayer INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    jogador VARCHAR(45) NOT NULL,
    progenitor VARCHAR(45),
    altura DECIMAL(3,2),
    nascimento DATE,
    nivel INT,
    dinheiro DECIMAL(8,2)
);

CREATE TABLE IF NOT EXISTS Atributos(
	idAtributo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS Atributo_Player(
	idAtributoPlayer INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fkPlayer INT NOT NULL,
    fkAtributo INT NOT NULL,
    pontos INT NOT NULL,
    FOREIGN KEY(fkPlayer) REFERENCES Players(idPlayer),
    FOREIGN KEY(fkAtributo) REFERENCES Atributos(idAtributo)
);

CREATE TABLE IF NOT EXISTS Pericias(
	idPericia INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS Pericia_Player(
	idPericiaPlayer INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fkPlayer INT NOT NULL,
    fkPericia INT NOT NULL,
    pontos INT NOT NULL,
    FOREIGN KEY(fkPlayer) REFERENCES Players(idPlayer),
    FOREIGN KEY(fkPericia) REFERENCES Pericias(idPericia)
);

CREATE TABLE IF NOT EXISTS Inventarios(
	idInventario INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    nota VARCHAR(400) NOT NULL,
    fkPlayer INT NOT NULL,
    FOREIGN KEY(fkPlayer) REFERENCES Players(idPlayer)
);

CREATE TABLE IF NOT EXISTS EfeitosArma(
	idEfeitoArma INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS EfeitosArmadura(
	idEfeitoArmadura INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS Armas(
	idArma INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    distancia VARCHAR(1) NOT NULL,
    dano VARCHAR(20) NOT NULL,
    maos INT NOT NULL,
    fkPlayer INT NOT NULL,
    FOREIGN KEY(fkPlayer) REFERENCES Players(idPlayer),
    fkEfeitoArma INT NOT NULL,
    FOREIGN KEY(fkEfeitoArma) REFERENCES EfeitosArma(idEfeitoArma)
);

CREATE TABLE IF NOT EXISTS Armaduras(
	idArmadura INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    bloqueio INT NOT NULL,
    maos INT NOT NULL,
    fkPlayer INT NOT NULL,
    FOREIGN KEY(fkPlayer) REFERENCES Players(idPlayer),
    fkEfeitoArmadura INT NOT NULL,
    FOREIGN KEY(fkEfeitoArmadura) REFERENCES EfeitosArmadura(idEfeitoArmadura)
);
