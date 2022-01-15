package com.monketabletop.olympus.tables;

import javax.persistence.*;

@Entity
@Table(name = "Pericias")
public class PericiasTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pericia")
    private int idPericia;

    @Column(name = "nome")
    private String nome;

    public PericiasTable(int idPericia, String nome) {
        this.idPericia = idPericia;
        this.nome = nome;
    }

    public PericiasTable() {
    }

    public int getIdPericia() {
        return idPericia;
    }

    public void setIdPericia(int idPericia) {
        this.idPericia = idPericia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "PericiasTable{" +
                "idPericia=" + idPericia +
                ", nome='" + nome + '\'' +
                '}';
    }
}
