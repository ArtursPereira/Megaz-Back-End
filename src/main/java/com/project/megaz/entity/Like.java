package com.project.megaz.entity;

import jakarta.persistence.*;


@Entity
//O comando table troca o nome da tabela que será criada no banco de dados, nesse caso "likes" ao inves de "like"
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int constante;

    @ManyToOne
    @JoinColumn(name = "Post_id", nullable = true)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "User_id", nullable = true)
    private User user;


    public Like()  {}

    public Like(int constante, Post post, User user) {
        this.constante = constante;
        this.post = post;
        this.user = user;
    }

    public int getConstante() {
        return constante;
    }

    public void setConstante(int constante) {
        this.constante = constante;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
