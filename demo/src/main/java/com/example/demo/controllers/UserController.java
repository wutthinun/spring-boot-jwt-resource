package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class UserController {

    private final UserRepository userRepository;

    @RolesAllowed("SUPER_ADMIN")
    @GetMapping("user/{id}")
    public ResponseEntity<User> getUserById(
        @PathVariable Long id,
        Authentication authentication
    ) {
        log.info("#### {}", authentication.getAuthorities());
        User user = userRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(user);
    }
}
