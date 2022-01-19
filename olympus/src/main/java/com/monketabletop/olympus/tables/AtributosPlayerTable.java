package com.monketabletop.olympus.tables;

import javax.persistence.*;

@Entity
@Table(name = "Atributos_Player")
public class AtributosPlayerTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atributo_player")
    private int idAtributoPlayer;

    @ManyToOne
    @JoinColumn(name = "fk_player")
    private PlayersTable fkPlayer;

    @ManyToOne
    @JoinColumn(name = "fk_atributo")
    private AtributosTable fkAtributo;

    @Column(name = "pontos")
    private int pontos;

    public AtributosPlayerTable(int idAtributoPlayer, PlayersTable fkPlayer, AtributosTable fkAtributo, int pontos) {
        this.idAtributoPlayer = idAtributoPlayer;
        this.fkPlayer = fkPlayer;
        this.fkAtributo = fkAtributo;
        this.pontos = pontos;
    }

    public AtributosPlayerTable() {
    }

    public int getIdAtributoPlayer() {
        return idAtributoPlayer;
    }

    public void setIdAtributoPlayer(int idAtributoPlayer) {
        this.idAtributoPlayer = idAtributoPlayer;
    }

    public PlayersTable getFkPlayer() {
        return fkPlayer;
    }

    public void setFkPlayer(PlayersTable fkPlayer) {
        this.fkPlayer = fkPlayer;
    }

    public AtributosTable getFkAtributo() {
        return fkAtributo;
    }

    public void setFkAtributo(AtributosTable fkAtributo) {
        this.fkAtributo = fkAtributo;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    @Override
    public String toString() {
        return "AtributosPlayerTable{" +
                "idAtributoPlayer=" + idAtributoPlayer +
                ", fkPlayer=" + fkPlayer +
                ", fkAtributo=" + fkAtributo +
                ", pontos=" + pontos +
                '}';
    }
}
