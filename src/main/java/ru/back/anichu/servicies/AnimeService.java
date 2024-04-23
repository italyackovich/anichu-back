package ru.back.anichu.servicies;

import ru.back.anichu.models.Anime;
import ru.back.anichu.repositories.AnimeRepository;

import java.util.List;


public class AnimeService {

    private static AnimeRepository animeRepository;

    public static Anime postAnime(Anime anime) {
        return animeRepository.save(anime);
    }

    public static Anime getAnime(Long id) {
        return animeRepository.findById(id).orElse(null);
    }

    public static List<Anime> getAllAnime() {
        return animeRepository.findAll();
    }

    public static void deleteAnime(Long id) {
        animeRepository.deleteById(id);
    }

    public static Anime putAnime(Anime newAnime, Long id) {
        return animeRepository.findById(id)
                .map(anime -> {
                    anime.setName(newAnime.getName());
                    anime.setDescription(newAnime.getDescription());
                    anime.setEpisodes(newAnime.getEpisodes());
                    anime.setStatus(newAnime.getStatus());
                    anime.setImg(newAnime.getImg());
                    anime.setLink(newAnime.getLink());
                    return animeRepository.save(anime);
                }).orElse(null);
    }

}
