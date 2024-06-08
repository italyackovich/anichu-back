package ru.back.anichu.models;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.List;


@Entity
public class AnswerComment {

    @Id
    @GeneratedValue
    private Long id;
    private String body;
    private String date;
    private Long comment_id;
    private Long user_id;

    public AnswerComment() {}

    public AnswerComment(Long id, Long user_id, String body, String date, Long comment_id) {
        this.id = id;
        this.body = body;
        this.date = date;
        this.comment_id = comment_id;
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

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
