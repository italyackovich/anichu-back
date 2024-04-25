package ru.back.anichu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.back.anichu.models.AnswerComment;

public interface AnswerCommentRepository extends JpaRepository<AnswerComment, Long> {
}
