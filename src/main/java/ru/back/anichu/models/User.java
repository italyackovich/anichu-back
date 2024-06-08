package ru.back.anichu.models;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<Anime> watchedAnimeList;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<Anime> watchAnimeList;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<Anime> willWatchAnimeList;

//    @Type(JsonType.class)
//    @Column(columnDefinition = "jsonb")
//    private String notifications;

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private List<AnswerComment> answerComments;

    public User() {}

    public User(Long id,String name, String username, String password, String email, List<Anime> watchedAnimeList, List<Anime> watchAnimeList, List<Anime> willWatchAnimeList) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.watchedAnimeList = watchedAnimeList;
        this.watchAnimeList = watchAnimeList;
        this.willWatchAnimeList = willWatchAnimeList;
    }

    public List<Anime> getWatchedAnimeList() {
        return watchedAnimeList;
    }

    public void setWatchedAnimeList(List<Anime> watchedAnimeList) {
        this.watchedAnimeList = watchedAnimeList;
    }

    public List<Anime> getWatchAnimeList() {
        return watchAnimeList;
    }

    public void setWatchAnimeList(List<Anime> watchAnimeList) {
        this.watchAnimeList = watchAnimeList;
    }

    public List<Anime> getWillWatchAnimeList() {
        return willWatchAnimeList;
    }

    public void setWillWatchAnimeList(List<Anime> willWatchAnimeList) {
        this.willWatchAnimeList = willWatchAnimeList;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<AnswerComment> getAnswerComments() {
        return answerComments;
    }

    public void setAnswerComments(List<AnswerComment> answerComments) {
        this.answerComments = answerComments;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
