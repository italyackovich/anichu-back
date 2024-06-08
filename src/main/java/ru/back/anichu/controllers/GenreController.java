package ru.back.anichu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.back.anichu.models.Genre;
import ru.back.anichu.repositories.GenreRepository;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @PostMapping("/anime/{id}/genres")
    Genre createGenre(@RequestBody Genre newGenre) {
        return genreRepository.save(newGenre);
    }

    @GetMapping("/anime/genres")
    List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @GetMapping("/anime/{id}/genres/{genre_id}")
    Genre getGenreById(@PathVariable Long genre_id) {
        return genreRepository.findById(genre_id).orElse(null);
    }

    @PutMapping("/anime/{id}/genres/{genre_id}")
    Genre updateGenre(@PathVariable Long genre_id, @RequestBody Genre newGenre) {
        return genreRepository.findById(genre_id)
                .map(genre -> {
                    genre.setName(newGenre.getName());
                    genre.setAnime_id(newGenre.getAnime_id());
                    return genreRepository.save(genre);
                }).orElse(null);
    }

    @DeleteMapping("/anime/{id}/genres/{genre_id}")
    void deleteGenre(@PathVariable Long genre_id) {
        genreRepository.deleteById(genre_id);
    }

}
