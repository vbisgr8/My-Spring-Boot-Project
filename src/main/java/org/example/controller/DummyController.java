package org.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class DummyController {

    @GetMapping("/")
    public String index() {
        return "index";  // This tells Spring Boot to render index.html from the templates folder
    }

    @PostMapping("/api/next")
    @ResponseBody
    public ResponseEntity<String> getNextValue(@RequestBody Map<String, String> request) {
        String url = request.get("url");
        if (url == null || url.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid URL");
        }
        // Process the URL as needed, e.g., perform validation, save, etc.
        return ResponseEntity.ok("Received URL: " + url);
    }
}
