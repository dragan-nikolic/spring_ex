package com.nikobit.spring.jpa.postgres.controller;

import com.nikobit.spring.jpa.postgres.exception.TutorialBadRequest;
import com.nikobit.spring.jpa.postgres.model.Tutorial;
import com.nikobit.spring.jpa.postgres.model.User;
import com.nikobit.spring.jpa.postgres.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<> registerUser(@RequestBody User user) throws InterruptedException {
        sleep(1_000); // simplest brute-forcing prevention :)
        validateEmail(user.getEmail());

        if (userRepository.findByEmail(user.getEmail()))
        
        try {
            Tutorial _tutorial = tutorialRepository
                    .save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void validateEmail(String email) {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email != null) email = email.toLowerCase();
        if (!pattern.matcher(email).matches()) throw new TutorialBadRequest("Invalid email format!");
    }
}
