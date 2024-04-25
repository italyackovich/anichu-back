package ru.back.anichu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.back.anichu.models.Anime;
import ru.back.anichu.repositories.AnimeRepository;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class AnimeController {

    @Autowired
    private AnimeRepository aniRepository;

    @PostMapping("/anime")
    Anime createAnime(@RequestBody Anime newAnime) {
        return aniRepository.save(newAnime);
    }

    @GetMapping("/anime")
    List<Anime> getAllAnime() {
        return aniRepository.findAll();
    }

    @GetMapping("/anime/{id}")
    Anime getAnimeById(@PathVariable Long id){
        return aniRepository.findById(id)
                .orElse(null);
    }

    @PutMapping("/anime/{id}")
    Anime updateAnime(@PathVariable Long id, @RequestBody Anime newAnime){
        return aniRepository.findById(id)
                .map(anime -> {
                    anime.setName(newAnime.getName());
                    anime.setDescription(newAnime.getDescription());
                    anime.setStatus(newAnime.getStatus());
                    anime.setAgeRating(newAnime.getAgeRating());
                    anime.setRating(newAnime.getRating());
                    anime.setDate(newAnime.getDate());
                    anime.setImg(newAnime.getImg());
                    anime.setLink(newAnime.getLink());
                    return aniRepository.save(anime);
                }).orElse(null);
    }

    @DeleteMapping("/anime/{id}")
    void deleteAnime(@PathVariable Long id) {
        aniRepository.deleteById(id);
    }
}
