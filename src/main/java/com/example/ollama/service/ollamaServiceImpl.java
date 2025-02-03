package com.example.ollama.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class ollamaServiceImpl implements ollamaService{

    private ChatClient chatClient;

    public ollamaServiceImpl(ChatClient.Builder chatClientBuilder){
        this.chatClient=chatClientBuilder.build();
    }


    /*
     * This method returns a single response from the AI model
     */
    @Override
    public String askAi(String question) {
        System.out.println("ollamaService askAI method: Your response is getting generated, please wait...");
        return chatClient.prompt(question).call().content();
    }


    /*
     * This method returns a stream of responses from the AI model
     */
    @Override
    public Flux<String> streamAiResponse(String question) {
        System.out.println("ollamaService streamAiResponse method: Your response is getting streamed on your screen...");
        return this.chatClient.prompt().user(question).stream().content();
    }


}
