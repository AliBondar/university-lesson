package com.bondar.universitylesson.controller;

import com.bondar.universitylesson.entity.Comment;
import com.bondar.universitylesson.entity.Lesson;
import com.bondar.universitylesson.service.CommentService;
import com.bondar.universitylesson.service.LessonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
    private final LessonService lessonService;

    public CommentController(CommentService commentService,
                             LessonService lessonService) {

        this.commentService = commentService;
        this.lessonService = lessonService;
    }

    @GetMapping("/{lessonId}")
    public String lessonDetails(@PathVariable Long lessonId,
                                Model model) {

        Lesson lesson = lessonService.getLessonById(lessonId);

        model.addAttribute("lesson", lesson);
        model.addAttribute("comment", new Comment());

        return "lesson-details";
    }

    @PostMapping("/{lessonId}")
    public String addComment(@PathVariable Long lessonId,
                             @ModelAttribute Comment comment) {

        commentService.addComment(lessonId, comment);

        return "redirect:/comments/" + lessonId;
    }
}