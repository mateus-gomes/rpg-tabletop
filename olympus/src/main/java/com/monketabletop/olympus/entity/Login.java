package com.monketabletop.olympus.entity;

public class Login {

    private String nickname;

    private String senha;

    public Login(String nickname, String senha) {
        this.nickname = nickname;
        this.senha = senha;
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
}
