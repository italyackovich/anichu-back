package ru.back.anichu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.back.anichu.models.Episode;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
