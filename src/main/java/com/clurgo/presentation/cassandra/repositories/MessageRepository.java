package com.clurgo.presentation.cassandra.repositories;

import com.clurgo.presentation.cassandra.domain.Message;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MessageRepository extends CrudRepository<Message, UUID> {

    List<Message> findByEmail(String email);

    @AllowFiltering
    List<Message> findByMagicNumber(Integer magicNumber);

}
