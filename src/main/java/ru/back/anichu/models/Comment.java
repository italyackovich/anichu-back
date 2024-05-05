package ru.back.anichu.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private String body;
    private String date;
    private Long anime_id;
    private Long user_id;

    @OneToMany(mappedBy = "comment_id", cascade = CascadeType.ALL)
    private List<AnswerComment> answerComments;

    public Comment() {}

    public Comment(Long id, String body, String date, Long user_id, Long anime_id) {
        this.id = id;
        this.body = body;
        this.date = date;
        this.user_id = user_id;
        this.anime_id = anime_id;
    }

    public void setAnswerComments(List<AnswerComment> answerComments) {
        this.answerComments = answerComments;
    }

    public Long getAnime_id() {
        return anime_id;
    }

    public void setAnime_id(Long anime_id) {
        this.anime_id = anime_id;
    }

    public List<AnswerComment> getAnswerComments() {
        return answerComments;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
