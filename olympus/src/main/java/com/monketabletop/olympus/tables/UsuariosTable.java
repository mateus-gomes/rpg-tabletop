package com.monketabletop.olympus.tables;

import javax.persistence.*;

@Entity
@Table(name = "Usuarios")
public class UsuariosTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "senha")
    private String senha;

    public UsuariosTable(int idUsuario, String nome, String nickname, String senha) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.nickname = nickname;
        this.senha = senha;
    }

    public UsuariosTable() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "UsuariosTable{" +
                "idUsuario=" + idUsuario +
                ", nome='" + nome + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
