package com.bondar.universitylesson.repository;

import com.bondar.universitylesson.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
