package ru.back.anichu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.back.anichu.models.Comment;
import ru.back.anichu.repositories.CommentRepository;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/anime/{id}/comments")
    public List<Comment> getCommentsByAnimeId() {
        return commentRepository.findAll();
    }

    @GetMapping("/anime/{id}/comments/{com_id}")
    public Comment getCommentById(@PathVariable Long com_id) {
        return commentRepository.findById(com_id).orElse(null);
    }

    @PostMapping("/anime/{id}/comments")
    public Comment createComment(@RequestBody Comment newComment) {
        return commentRepository.save(newComment);
    }

    @PutMapping("/anime/{id}/comments/{com_id}")
    public Comment updateComment(@PathVariable Long com_id, @RequestBody Comment newComment) {
        return commentRepository.findById(com_id)
                .map(comment -> {
                    comment.setBody(newComment.getBody());
                    return commentRepository.save(comment);}).orElse(null);
    }

    @DeleteMapping("/anime/{id}/comments/{com_id}")
    public void deleteComment(@PathVariable Long com_id) {
        commentRepository.deleteById(com_id);
    }
}
