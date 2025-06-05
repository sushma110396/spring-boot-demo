package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // allow all origins to test CORS
public class DemoController {

    private String lastNote = "";

    @GetMapping("/message")
    public String getMessage() {
        return "Hello from Spring Boot!";
    }

    @PostMapping("/note")
    public ResponseEntity<String> postNote(@RequestBody Note note) {
        this.lastNote = note.getNote();
        return ResponseEntity.ok("Note received: " + lastNote);
    }
}