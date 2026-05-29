package com.bondar.universitylesson.controller;

import com.bondar.universitylesson.entity.Lesson;
import com.bondar.universitylesson.service.LessonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
@CrossOrigin("*")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping
    public List<Lesson> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @PostMapping
    public Lesson createLesson(@RequestBody Lesson lesson) {
        return lessonService.saveLesson(lesson);
    }
}
