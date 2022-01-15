package com.monketabletop.olympus.tables;

import javax.persistence.*;

@Entity
@Table(name = "Pericias_Player")
public class PericiasPlayerTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pericia_player")
    private int idPericiaPlayer;

    @Column(name = "pontos")
    private int pontos;

    @ManyToOne
    @JoinColumn(name = "fk_player")
    private PlayersTable fkPlayer;

    @ManyToOne
    @JoinColumn(name = "fk_pericia")
    private PericiasTable fkPericia;

    public PericiasPlayerTable(int idPericiaPlayer, int pontos, PlayersTable fkPlayer, PericiasTable fkPericia) {
        this.idPericiaPlayer = idPericiaPlayer;
        this.pontos = pontos;
        this.fkPlayer = fkPlayer;
        this.fkPericia = fkPericia;
    }

    public PericiasPlayerTable() {
    }

    public int getIdPericiaPlayer() {
        return idPericiaPlayer;
    }

    public void setIdPericiaPlayer(int idPericiaPlayer) {
        this.idPericiaPlayer = idPericiaPlayer;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public PlayersTable getFkPlayer() {
        return fkPlayer;
    }

    public void setFkPlayer(PlayersTable fkPlayer) {
        this.fkPlayer = fkPlayer;
    }

    public PericiasTable getFkPericia() {
        return fkPericia;
    }

    public void setFkPericia(PericiasTable fkPericia) {
        this.fkPericia = fkPericia;
    }

    @Override
    public String toString() {
        return "PericiaPlayerTable{" +
                "idPericiaPlayer=" + idPericiaPlayer +
                ", pontos=" + pontos +
                ", fkPlayer=" + fkPlayer +
                ", fkPericia=" + fkPericia +
                '}';
    }
}
