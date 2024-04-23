package ru.back.anichu.models;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private String body;
    private String date;
    private Long user_id;
    private Long anime_id;

    public Comment() {}

    public Comment(Long id, String body, String date, Long user_id, Long anime_id) {
        this.id = id;
        this.body = body;
        this.date = date;
        this.user_id = user_id;
        this.anime_id = anime_id;
    }

    public Long getAnime_id() {
        return anime_id;
    }

    public void setAnime_id(Long anime_id) {
        this.anime_id = anime_id;
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
