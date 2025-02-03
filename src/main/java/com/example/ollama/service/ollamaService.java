package com.example.ollama.service;

import reactor.core.publisher.Flux;

public interface ollamaService {

    /*
     * This method returns a single response from the AI model
     */
    String askAi(String question);

    /*
     * This method returns a stream of responses from the AI model
     */
    Flux<String> streamAiResponse(String question);

}
