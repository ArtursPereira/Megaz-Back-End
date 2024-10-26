package com.project.megaz.dto;

import com.project.megaz.entity.User;

// Data Transfer Object
// Basicamente são usados pra não deixar o usuário alterar dados do sistema, é uma linha que está entre o usuário e a classe user
public class UserRegister {
    private String nome;
    private String email;
    private String senha;
    private String relacionamento;
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRelacionamento() {
        return relacionamento;
    }

    public void setRelacionamento(String relacionamento) {
        this.relacionamento = relacionamento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public User ToUser() {
        User user = new User();
        user.setName(this.nome);
        user.setSenha(this.senha);
        user.setEmail(this.email);
        user.setRelacionamento(this.relacionamento);
        user.setIdade(this.idade);
        return user;
    }

    @Override
    public String toString() {
        return "UserRegister{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", relacionamento='" + relacionamento + '\'' +
                ", idade=" + idade +
                '}';
    }
}
