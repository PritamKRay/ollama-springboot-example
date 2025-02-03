package com.example.ollama.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ollama.service.ollamaService;

import reactor.core.publisher.Flux;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/ai")
public class askOllamaController {

    private ollamaService ollamaService;

    public askOllamaController(ollamaService ollamaService) {
        this.ollamaService = ollamaService;
    }
    

    /*
     * This method returns a single response from the AI model
     */
    @GetMapping("/ask")
    public ResponseEntity<String> getAiResponse(
        @RequestParam (value="query" ,required=false ,defaultValue="Which model are you?") String query){

            System.out.println("Inside get mapping");
            String aiResponse=ollamaService.askAi(query);
            return new ResponseEntity<>(aiResponse,HttpStatus.OK);

    }

    /*
     * This method returns a stream of responses from the AI model
     */
    @GetMapping("/stream")
    public Flux<String> getAiResponseStream(
        @RequestParam (value="query" ,required=false ,defaultValue="Which model are you?") String query){

            return ollamaService.streamAiResponse(query);

    }
}
