package com.monketabletop.olympus.tables;

import javax.persistence.*;

@Entity
@Table(name = "EfeitosArma")
public class EfeitosArmaTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_efeito_arma")
    private int idEfeitoArma;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    public EfeitosArmaTable(int idEfeitoArma, String nome, String descricao) {
        this.idEfeitoArma = idEfeitoArma;
        this.nome = nome;
        this.descricao = descricao;
    }

    public EfeitosArmaTable() {
    }

    public int getIdEfeitoArma() {
        return idEfeitoArma;
    }

    public void setIdEfeitoArma(int idEfeitoArma) {
        this.idEfeitoArma = idEfeitoArma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
