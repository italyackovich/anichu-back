package ru.back.anichu.models;

import jakarta.persistence.*;

@Entity
@Table(name = "anime")
public class Anime {
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(length = 4000)
    private String description;
    private Integer episodes;
    private String status;
    private String link;
    private String img;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Anime() {
    }

    public Anime(String name, String link, String description, Integer episodes, String status) {
        this.name = name;
        this.description = description;
        this.episodes = episodes;
        this.status = status;
        this.link = link;
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

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
