package microservices.book.socialmultiplication.controller;

import microservices.book.socialmultiplication.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/multiplications")
public class MultiplicationController {

    @Autowired
    private MultiplicationService service;

    @GetMapping(value = "/random")
    public ResponseEntity getRandomMultiplication() {
        return new ResponseEntity(service.createRandomMultiplication(), HttpStatus.OK);
    }
}
