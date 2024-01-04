package com.example.demoa.controller;

import com.example.demoa.entity.Service;
import com.example.demoa.serviceImplementation.ServicesServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/demoa")
public class ServiceController {

        @Autowired
        private ServicesServiceImp servicesServiceImp;

        @PostMapping("/createService")
        public ResponseEntity<String> createService(@RequestBody Service service) {
            return new ResponseEntity<>(servicesServiceImp.addService(service), HttpStatus.OK);
        }

        @PatchMapping("/updateService/{serviceId}")
        public ResponseEntity<String> updateService(@PathVariable("serviceId") Integer serviceId, @RequestBody Service service){
            return new ResponseEntity<>(servicesServiceImp.updateService(serviceId, service), HttpStatus.OK);
        }

        @DeleteMapping("/deleteService/{serviceId}")
        public ResponseEntity<String> deleteService(@PathVariable("serviceId") Integer serviceId) {
            return new ResponseEntity<>(servicesServiceImp.deleteService(serviceId), HttpStatus.OK);
        }

        @GetMapping("/readService/{serviceId}")
        public ResponseEntity<Service> readService(@PathVariable("serviceId") Integer serviceId){
            return new ResponseEntity<>(servicesServiceImp.readService(serviceId), HttpStatus.OK);
        }

        @GetMapping("/readAllService")
        public List<Service> readAllService(){
            return servicesServiceImp.readAllService();
        }

}
