package com.clurgo.presentation.cassandra.controllers;


import com.clurgo.presentation.cassandra.domain.Message;
import com.clurgo.presentation.cassandra.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("messages/{emailValue}")
    public @ResponseBody
    List<Message> findAllMessagesByEmail(@PathVariable String emailValue) {
        return messageService.findAllMessagesByEmail(emailValue);
    }

    @PostMapping("/message")
    public @ResponseBody
    ResponseEntity<String> createMessage(@RequestBody Message message) {
        messageService.save(message);
        if (log.isDebugEnabled()) {
            log.debug("Created Message: " + message);
        }

        return new ResponseEntity(message.toString(), HttpStatus.OK);
    }

}
