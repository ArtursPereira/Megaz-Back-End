package com.project.megaz.entity;

import jakarta.persistence.*;

//Essa anotação informa ao sistema que vai ser daqui que vai ser informados os atributos e get, set e contrutores.
@Entity
//Id nossa chave primária, nele uso a annotation GeneratedValue, que passa a estrategia para gerar o valor automático.

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    // Diz que a coluna não pode ser falsa.
    private String content;
    @ManyToOne
    // Específica que tem muitos comentarios pra um usuário.
    @JoinColumn(name = "Post_id", nullable = true)
    // Diz que o comando a ser guardado no banco de dados é o id do usuário e que ele não pode ser nulo.
    private Post post;

    @ManyToOne
    @JoinColumn(name = "User_id", nullable = true)
    private User user;

    public Comment() {}
    //Getters, Setters e Contrutores, Tostring.
    public Comment(String content, Post post, User user) {
        this.content = content;
        this.post = post;
        this.user = user;
    }

    public Long getId() {
        return id;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", post=" + post +
                ", user=" + user +
                '}';
    }
}
