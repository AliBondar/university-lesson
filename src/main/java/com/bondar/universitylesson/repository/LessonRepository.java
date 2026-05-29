package com.bondar.universitylesson.repository;

import com.bondar.universitylesson.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
