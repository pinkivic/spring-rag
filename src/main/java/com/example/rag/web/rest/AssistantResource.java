package com.example.rag.web.rest;

import com.example.rag.service.AssistantAiService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssistantResource {

    private final AssistantAiService assistantService;

    public AssistantResource(AssistantAiService assistantService) {
        this.assistantService = assistantService;
    }

    @PostMapping("/assistants/chat")
    public String chat(@RequestBody String query) {
        return assistantService.chat(query);
    }
}
