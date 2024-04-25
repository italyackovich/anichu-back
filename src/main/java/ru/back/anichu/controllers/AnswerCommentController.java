package ru.back.anichu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.back.anichu.models.AnswerComment;
import ru.back.anichu.repositories.AnswerCommentRepository;

import java.util.List;

@RestController
public class AnswerCommentController {

    @Autowired
    private AnswerCommentRepository answerCommentRepository;


    @GetMapping("/anime/{id}/comments/{comm_id}/answers")
    public List<AnswerComment> getAllAnswersByComment() {
        return answerCommentRepository.findAll();
    }

    @GetMapping("/anime/{id}/comments/{comm_id}/answers/{ans_id}")
    public AnswerComment getAnswerById(@PathVariable Long ans_id) {
        return answerCommentRepository.findById(ans_id).orElse(null);
    }

    @PostMapping("/anime/{id}/comments/{comm_id}/answers")
    public AnswerComment createAnswer(@RequestBody AnswerComment newAnswer) {
        return answerCommentRepository.save(newAnswer);
    }

    @PutMapping("/anime/{id}/comments/{comm_id}/answers/{ans_id}")
    public AnswerComment updateAnswer(@PathVariable Long ans_id, @RequestBody AnswerComment newAnswer) {
        return answerCommentRepository.findById(ans_id)
                .map(answerComment -> {
                    answerComment.setBody(newAnswer.getBody());
                    return answerCommentRepository.save(answerComment);}).orElse(null);
    }

    @DeleteMapping("/anime/{id}/comments/{comm_id}/answers/{ans_id}")
    public void deleteAnswer(@PathVariable Long ans_id) {
        answerCommentRepository.deleteById(ans_id);
    }


}
