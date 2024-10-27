package com.project.megaz.dto;

import com.project.megaz.entity.User;
import jakarta.validation.constraints.*;

// Data Transfer Object
// Basicamente são usados pra não deixar o usuário alterar dados do sistema, é uma linha que está entre o usuário e a classe user
public class UserRegister {
    @NotNull(message = "Campo em Branco")
    @NotBlank(message = "Campo nulo")
    private String nome;
    @NotNull(message = "Campo em Branco")
    @NotBlank(message = "Campo nulo")
    @Email(message = "Estrutura de Email errada")
    private String email;
    @NotNull(message = "Campo em Branco")
    @NotBlank(message = "Campo nulo")
    @Size(min = 8, message = "A sua senha tem menos de 8 caracteres")
    private String senha;
    @NotNull(message = "Campo em Branco")
    @NotBlank(message = "Campo nulo")
    private String relacionamento;
    @Min(value = 0, message = "A idade não pode ser negativa")
    @Max(value = 117, message = "TU ES PICA")
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
