package com.example.elearning.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class PathEnrollment extends Enrollment {

    @ManyToOne
    @JoinColumn(name = "learning_path_id")
    private LearningPath learningPath;
}
