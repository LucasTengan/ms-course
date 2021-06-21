package com.tengan.hruser.adapter.resources;

import com.tengan.hruser.adapter.repositories.UserRepository;
import com.tengan.hruser.domain.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserResource {

    private static Logger logger = LoggerFactory.getLogger(UserResource.class);
    private final UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userRepository.findById(id).get();

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        User user = userRepository.findByEmail(email);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
