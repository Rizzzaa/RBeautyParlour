package com.example.demoa.entity;

import com.example.demoa.enums.Category;
import com.example.demoa.enums.Level;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Builder(builderMethodName = "builder")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String courseName;
    private String description;
    private Integer duration;
    private Level level;
    private Category category;
    private Double courseCost;

    @OneToOne
    @JoinColumn(name = "id")
    private CourseImage courseImageData;

//    @Lob
//    @Column(name = "imagedata", length = 1000)
//    private byte[] imageData;
//
//    private String name;
//    private String type;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
        public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(Double courseCost) {
        this.courseCost = courseCost;
    }

    public CourseImage getCourseImageData() {
        return courseImageData;
    }

    public void setCourseImageData(CourseImage courseImageData) {
        this.courseImageData = courseImageData;
    }
}
