package com.project.megaz.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String text;
    @ManyToOne
    @JoinColumn(name = "User_id", nullable = true)
    private User user;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    // mappedBy diz que a classe comentario terá um campo chamada "post"
    // o JPA entende que a tabela  terá uma chave estrangeira referenciando a tabela de Post.
    //fetch o EAGLE significa que quando a entidade user for carregada a lista de comentarios também vai ser.

    private List<Comment> comments;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    private List<Like> likes;

    public Post() {}



    public Post(String text, User user, List<Comment> comments, List<Like> likes) {
        this.text = text;
        this.user = user;
        this.comments = comments;
        this.likes = likes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }


    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", user=" + user +
                '}';
    }
}
