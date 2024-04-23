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

    private String img;

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
