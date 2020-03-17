package com.clurgo.presentation.cassandra.service;


import com.clurgo.presentation.cassandra.domain.Message;

import java.util.List;

public interface MessageService {

    Message save(Message message);

    List<Message> findAllMessagesByEmail(String email);

    List<Message> findAllMessagesByMagicNumber(Integer magicNumber);

    void deleteMessages(List<Message> messages);


}
