package ru.back.anichu.models;

import jakarta.persistence.*;

@Entity
@Table(name = "episodes")
public class Episode {

    @Id
    @GeneratedValue
    private Long id;
    private Integer number;
    private String url;
    private Long anime_id;

    public Episode() {}

    public Episode(Long id, String url, Long anime_id, Integer number) {
        this.id = id;
        this.url = url;
        this.number = number;
        this.anime_id = anime_id;
    }

    public Long getAnime_id() {
        return anime_id;
    }

    public void setAnime_id(Long anime_id) {
        this.anime_id = anime_id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
