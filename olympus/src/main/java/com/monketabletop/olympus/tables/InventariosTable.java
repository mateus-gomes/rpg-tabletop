package com.monketabletop.olympus.tables;

import javax.persistence.*;

@Entity
@Table(name = "Inventarios")
public class InventariosTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private int idInventario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "nota")
    private String nota;

    @ManyToOne
    @JoinColumn(name = "fk_player")
    private PlayersTable fkPlayer;

    public InventariosTable(int idInventario, String nome, String nota, PlayersTable fkPlayer) {
        this.idInventario = idInventario;
        this.nome = nome;
        this.nota = nota;
        this.fkPlayer = fkPlayer;
    }

    public InventariosTable() {
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public PlayersTable getFkPlayer() {
        return fkPlayer;
    }

    public void setFkPlayer(PlayersTable fkPlayer) {
        this.fkPlayer = fkPlayer;
    }

    @Override
    public String toString() {
        return "InventariosTable{" +
                "idInventario=" + idInventario +
                ", nome='" + nome + '\'' +
                ", nota=" + nota +
                ", playersTable=" + fkPlayer +
                '}';
    }
}
