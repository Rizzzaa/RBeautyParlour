//package com.example.demoa.controller;
//
//import java.io.IOException;
//
//import com.example.demoa.entity.CourseImage;
//import com.example.demoa.entity.ImageUploadResponse;
//import com.example.demoa.serviceImplementation.CourseImageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
//
//@CrossOrigin("*")
//@RestController
//@RequestMapping(value = "/demoa")
//
//public class CourseImageController {
//
//        @Autowired
//        private CourseImageService courseImageService;
//
//        @PostMapping(value = "/uploadImage", produces = MediaType.APPLICATION_JSON_VALUE)
//        public ResponseEntity<ImageUploadResponse> uploadImage(@RequestParam ("courseImage") MultipartFile file)  throws IOException{
//            ImageUploadResponse response = courseImageService.uploadImage(file);
//            return ResponseEntity.status(HttpStatus.OK).body(response);
//        }
//
////        @GetMapping("/downloadImage/{fileName}")
////        public ResponseEntity<?> getImageInfoByName(@PathVariable("name") String name) {
////            CourseImage image = courseImageService.getInfoByImageByName(name);
////            return ResponseEntity.status(HttpStatus.OK).body(image);
////        }
//    @GetMapping(value = "/{name}",  produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> getImageByName(@PathVariable("name") String name) {
//            byte[] image = courseImageService.getImage(name);
//        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
//    }
//}
