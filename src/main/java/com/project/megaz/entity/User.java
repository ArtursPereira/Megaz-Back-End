package com.project.megaz.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Error")
    @NotBlank(message = "Error")
    private String name;
    @NotNull(message = "Error")
    @NotBlank(message = "Error")
    @Column(unique = true)
    //Unique diz que o atributo email deve ser único, ou seja não pode ter dois emails igual carregados no banco de dados
    private String email;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false)
    private String relacionamento;
    @Column(nullable = false)
    private int idade;


    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Post> posts;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Comment> comments;



    public User() {}

    public User(String name, String email, String senha, String relacionamento, int idade) {
        this.name = name;
        this.email = email;
        this.senha = senha;
        this.relacionamento = relacionamento;
        this.idade = idade;
    }

    public User(String name, String email, String senha, String relacionamento, List<Post> posts, int idade, List<Comment> comments) {
        this.name = name;
        this.email = email;
        this.senha = senha;
        this.relacionamento = relacionamento;
        this.posts = posts;
        this.idade = idade;
        this.comments = comments;
    }

    public List<Post> getPosts() {
        return posts;
    }


    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRelacionamento() {
        return relacionamento;
    }

    public void setRelacionamento(String relacionamento) {
        this.relacionamento = relacionamento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", relacionamento='" + relacionamento + '\'' +
                ", idade=" + idade +
                '}';
    }
}
