package microservices.book.socialmultiplication.controller;

import microservices.book.socialmultiplication.domain.MultiplicationResultAttempt;
import microservices.book.socialmultiplication.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/results")
public class MultiplicationResultAttemptController {

    @Autowired
    private MultiplicationService service;

    @PostMapping()
    public ResponseEntity postResult(@RequestBody MultiplicationResultAttempt attempt) {
        boolean result = service.checkResultAttempt(attempt);

        return new ResponseEntity(result, HttpStatus.OK);
    }
}
