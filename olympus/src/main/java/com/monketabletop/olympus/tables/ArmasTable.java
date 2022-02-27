package com.monketabletop.olympus.tables;

import javax.persistence.*;

@Entity
@Table(name = "Armas")
public class ArmasTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arma")
    private int idArma;

    @Column(name = "nome")
    private String nome;

    @Column(name = "distancia")
    private String distancia;

    @Column(name = "dano")
    private String dano;

    @Column(name = "maos")
    private int maos;

    @ManyToOne
    @JoinColumn(name = "fk_player")
    private PlayersTable fkPlayer;

    @ManyToOne
    @JoinColumn(name = "fk_efeito_arma")
    private EfeitosArmaTable fkEfeitosArma;

    public ArmasTable(int idArma, String nome, String distancia, String dano, int maos, PlayersTable fkPlayer, EfeitosArmaTable fkEfeitosArma) {
        this.idArma = idArma;
        this.nome = nome;
        this.distancia = distancia;
        this.dano = dano;
        this.maos = maos;
        this.fkPlayer = fkPlayer;
        this.fkEfeitosArma = fkEfeitosArma;
    }

    public ArmasTable() {
    }

    public int getIdArma() {
        return idArma;
    }

    public void setIdArma(int idArma) {
        this.idArma = idArma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getDano() {
        return dano;
    }

    public void setDano(String dano) {
        this.dano = dano;
    }

    public int getMaos() {
        return maos;
    }

    public void setMaos(int maos) {
        this.maos = maos;
    }

    public PlayersTable getFkPlayer() {
        return fkPlayer;
    }

    public void setFkPlayer(PlayersTable fkPlayer) {
        this.fkPlayer = fkPlayer;
    }

    public EfeitosArmaTable getFkEfeitosArma() {
        return fkEfeitosArma;
    }

    public void setFkEfeitosArma(EfeitosArmaTable fkEfeitosArma) {
        this.fkEfeitosArma = fkEfeitosArma;
    }
}
