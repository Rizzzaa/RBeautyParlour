package com.example.demoa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "courseImage")
@Builder(builderMethodName = "builder")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseImage {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String name;
        private String type;

        @Lob
        @Column(name = "imagedata", length = 1000)
        private byte[] imageData;


//        public Long getId() {
//            return id;
//        }
//        public void setId(Long id) {
//            this.id = id;
//        }
//        public String getName() {
//            return name;
//        }
//        public void setName(String name) {
//            this.name = name;
//        }
//        public String getType() {
//            return type;
//        }
//        public void setType(String type) {
//            this.type = type;
//        }
//        public byte[] getImageData() {
//            return imageData;
//        }
//        public void setImageData(byte[] imageData) {
//            this.imageData = imageData;
//        }
}
