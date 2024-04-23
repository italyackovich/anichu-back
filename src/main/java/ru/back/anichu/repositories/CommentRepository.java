package ru.back.anichu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.back.anichu.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
