package com.bondar.universitylesson.controller;

import com.bondar.universitylesson.entity.Lesson;
import com.bondar.universitylesson.service.LessonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping
    public String getAllLessons(Model model) {

        model.addAttribute("lessons",
                lessonService.getAllLessons());

        return "lessons";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {

        model.addAttribute("lesson", new Lesson());

        return "create-lesson";
    }

    @PostMapping
    public String createLesson(@ModelAttribute Lesson lesson) {

        lessonService.saveLesson(lesson);

        return "redirect:/lessons";
    }
}