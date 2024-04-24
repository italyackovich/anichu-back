package ru.back.anichu.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "anime")
public class Anime {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Column(length = 4000)
    private String description;

    private String status;
    private String link;
    private Double rating;
    private String date;
    private String ageRating;
    private String img;

    @OneToMany(mappedBy = "anime_id", cascade = CascadeType.ALL)
    private List<Genre> genres;

    @OneToMany(mappedBy = "anime_id", cascade = CascadeType.ALL)
    private List<Episode> episodes;

    @OneToMany(mappedBy = "anime_id", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Anime() {
    }

    public Anime(String name, String link, String description, String status) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.link = link;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
