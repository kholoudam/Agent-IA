package org.kholoud.aiagent.controllers;

import org.kholoud.aiagent.agents.AIAgent;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@CrossOrigin("*")
public class AgentController
{
    private AIAgent agent;

    public AgentController(AIAgent agent) {
        this.agent = agent;
    }

    @GetMapping(value = "/askAgent", produces = MediaType.TEXT_PLAIN_VALUE)
    public Flux<String> chat(String query) {
        return agent.onQuery(query);
    }
}