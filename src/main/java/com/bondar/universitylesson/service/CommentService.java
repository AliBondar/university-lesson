package com.bondar.universitylesson.service;

import com.bondar.universitylesson.entity.Comment;
import com.bondar.universitylesson.entity.Lesson;
import com.bondar.universitylesson.repository.CommentRepository;
import com.bondar.universitylesson.repository.LessonRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final LessonRepository lessonRepository;

    public CommentService(CommentRepository commentRepository,
                          LessonRepository lessonRepository) {
        this.commentRepository = commentRepository;
        this.lessonRepository = lessonRepository;
    }

    public Comment addComment(Long lessonId, Comment comment) {

        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));

        comment.setLesson(lesson);

        return commentRepository.save(comment);
    }
}
