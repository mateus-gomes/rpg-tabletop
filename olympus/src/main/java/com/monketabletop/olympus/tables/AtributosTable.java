package com.monketabletop.olympus.tables;

import javax.persistence.*;

@Entity
@Table(name = "Atributos")
public class AtributosTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atributo")
    private int idAtributo;

    @Column(name = "nome")
    private String nome;

    public AtributosTable(int idAtributo, String nome) {
        this.idAtributo = idAtributo;
        this.nome = nome;
    }

    public AtributosTable() {
    }

    public int getIdAtributo() {
        return idAtributo;
    }

    public void setIdAtributo(int idAtributo) {
        this.idAtributo = idAtributo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "AtributosTable{" +
                "idAtributo=" + idAtributo +
                ", nome='" + nome + '\'' +
                '}';
    }
}
