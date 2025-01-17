package ru.back.anichu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.back.anichu.models.Anime;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {
}
