package com.bondar.universitylesson.controller;

import com.bondar.universitylesson.entity.Comment;
import com.bondar.universitylesson.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@CrossOrigin("*")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{lessonId}")
    public Comment addComment(@PathVariable Long lessonId,
                              @RequestBody Comment comment) {

        return commentService.addComment(lessonId, comment);
    }
}
