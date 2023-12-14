//package com.example.demoa.serviceImplementation;
//
//import java.io.IOException;
//import java.util.Optional;
//
//import com.example.demoa.entity.CourseImage;
//import com.example.demoa.entity.ImageUploadResponse;
//import com.example.demoa.repository.ICourseImageRepository;
//import com.example.demoa.util.CourseImageUtility;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//@Service
//public class CourseImageService {
//
//        @Autowired
//        private ICourseImageRepository iCourseImageRepository;
//
//        public ImageUploadResponse uploadImage(MultipartFile file) throws IOException {
//            iCourseImageRepository.save(CourseImage.builder()
//                    .name(file.getOriginalFilename())
//                    .type(file.getContentType())
//                    .imageData(CourseImageUtility.compressImage(file.getBytes()))
//                    .build());
//            return new ImageUploadResponse("Image uploaded: " + file.getOriginalFilename());
//        }
//
//    @Transactional
//    public byte[] getImage(String name) {
//        Optional<CourseImage> dbImage = iCourseImageRepository.findByName(name);
//        return CourseImageUtility.decompressImage(dbImage.get().getImageData());
//    }
//
///*
//        @Transactional
//        public ResponseEntity<?> getInfoByImageByName(String name){
//            Optional<CourseImage> imageData = iCourseImageRepository.findByName(name);
//            return CourseImage.builder().name(imageData.get().getName()).type(imageData.get().getType()).i
////            return CourseImageUtility.decompressImage(imageData.get().getImageData());
//        }
//*/
//}
//
