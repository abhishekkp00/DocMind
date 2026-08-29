package com.abhishek.DocMind.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/chat")
@Tag(
        name = "Chat Management",
        description = "All chat related apis goes here."
)
public class ChatController {

    @PostMapping
    @Operation(summary = "Ask a question against all documents or a specific document with citations")
    public ResponseEntity<String> chat(){
        return ResponseEntity.ok("Testing configuration");
    }
}
