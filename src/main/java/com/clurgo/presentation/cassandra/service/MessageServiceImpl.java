package com.clurgo.presentation.cassandra.service;


import com.clurgo.presentation.cassandra.domain.Message;
import com.clurgo.presentation.cassandra.repositories.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> findAllMessagesByEmail(String email) {
        return messageRepository.findByEmail(email);
    }

    @Override
    public List<Message> findAllMessagesByMagicNumber(Integer magicNumber) {
        return messageRepository.findByMagicNumber(magicNumber);
    }

    @Override
    public void deleteMessages(List<Message> messages) {
        messageRepository.deleteAll(messages);
    }


}
