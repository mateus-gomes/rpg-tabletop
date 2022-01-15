package com.monketabletop.olympus.tables;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Players")
public class PlayersTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_player")
    private int idPlayer;

    @Column(name = "nome")
    private String nome;

    @Column(name = "progenitor")
    private String progenitor;

    @Column(name = "altura")
    private Double altura;

    @Column(name = "nascimento")
    private LocalDateTime nascimento;

    @Column(name = "nivel")
    private int nivel;

    @Column(name = "dinheiro")
    private double dinheiro;

    @Column(name = "vidaMaxima")
    private int vidaMaxima;

    @Column(name = "vidaAtual")
    private int vidaAtual;

    @Column(name = "energiaMaxima")
    private int energiaMaxima;

    @Column(name = "energiaAtual")
    private int energiaAtual;

    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private UsuariosTable fkUsuario;

    public PlayersTable(
            int idPlayer,
            String nome,
            String progenitor,
            Double altura,
            LocalDateTime nascimento,
            int nivel,
            double dinheiro,
            int vidaMaxima,
            int vidaAtual,
            int energiaMaxima,
            int energiaAtual,
            UsuariosTable fkUsuario
    ) {
        this.idPlayer = idPlayer;
        this.nome = nome;
        this.progenitor = progenitor;
        this.altura = altura;
        this.nascimento = nascimento;
        this.nivel = nivel;
        this.dinheiro = dinheiro;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaAtual;
        this.energiaMaxima = energiaMaxima;
        this.energiaAtual = energiaAtual;
        this.fkUsuario = fkUsuario;
    }

    public PlayersTable() {
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getProgenitor() {
        return progenitor;
    }

    public void setProgenitor(String progenitor) {
        this.progenitor = progenitor;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public LocalDateTime getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDateTime nascimento) {
        this.nascimento = nascimento;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public int getEnergiaMaxima() {
        return energiaMaxima;
    }

    public void setEnergiaMaxima(int energiaMaxima) {
        this.energiaMaxima = energiaMaxima;
    }

    public int getEnergiaAtual() {
        return energiaAtual;
    }

    public void setEnergiaAtual(int energiaAtual) {
        this.energiaAtual = energiaAtual;
    }

    public UsuariosTable getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(UsuariosTable fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    @Override
    public String toString() {
        return "PlayersTable{" +
                "idPlayer=" + idPlayer +
                ", nome='" + nome + '\'' +
                ", progenitor='" + progenitor + '\'' +
                ", altura=" + altura +
                ", nascimento=" + nascimento +
                ", nivel=" + nivel +
                ", dinheiro=" + dinheiro +
                ", vidaMaxima=" + vidaMaxima +
                ", vidaAtual=" + vidaAtual +
                ", energiaMaxima=" + energiaMaxima +
                ", energiaAtual=" + energiaAtual +
                ", fkUsuario=" + fkUsuario +
                '}';
    }
}
