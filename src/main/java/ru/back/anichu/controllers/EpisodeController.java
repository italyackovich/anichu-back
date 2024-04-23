package ru.back.anichu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.back.anichu.models.Episode;
import ru.back.anichu.repositories.EpisodeRepository;

import java.util.List;

@RestController
public class EpisodeController {

    @Autowired
    private EpisodeRepository episodeRepository;

    @GetMapping("/anime/{id}/episodes")
    public List<Episode> getEpisodesByAnimeId() {
        return episodeRepository.findAll();
    }

    @GetMapping("/anime/{id}/episodes/{ep_id}")
    public Episode getEpisodeById(@PathVariable Long ep_id) {
        return episodeRepository.findById(ep_id).orElse(null);
    }

    @PostMapping("/anime/{id}/episodes")
    public Episode createEpisode(@RequestBody Episode newEpisode) {
        return episodeRepository.save(newEpisode);
    }

    @PutMapping("/anime/{id}/episodes/{ep_id}")
    public Episode updateEpisode(@PathVariable Long ep_id, @RequestBody Episode newEpisode) {
        return episodeRepository.findById(ep_id)
                .map(episode -> {
                    episode.setNumber(newEpisode.getNumber());
                    episode.setUrl(newEpisode.getUrl());
                    return episodeRepository.save(episode);}).orElse(null);
    }

    @DeleteMapping("/anime/{id}/episodes/{ep_id}")
    public void deleteEpisode(@PathVariable Long ep_id) {
        episodeRepository.deleteById(ep_id);
    }

}
