package ru.back.anichu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.back.anichu.models.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
