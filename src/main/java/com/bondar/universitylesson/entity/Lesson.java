package com.bondar.universitylesson.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    Integer terms;

    String code;

    String type;

    String department;

    @JsonManagedReference
    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
