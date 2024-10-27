package com.project.megaz.dto;

import com.project.megaz.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserLogin {
    @NotNull(message = "Campo em Branco")
    @NotBlank(message = "Campo nulo")
    private String email;
    @NotNull(message = "Campo em Branco")
    @NotBlank(message = "Campo nulo")
    private String senha;


    public UserLogin() {
    }

    public UserLogin(String email, String senha) {
        this.email = email;
        this.senha = senha;
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

    public UserLogin Login() {
        UserLogin user = new UserLogin();
        user.setSenha(this.senha);
        user.setEmail(this.email);
        return user;
    }
}
