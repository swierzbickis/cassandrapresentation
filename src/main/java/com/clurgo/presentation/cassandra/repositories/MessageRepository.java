package com.clurgo.presentation.cassandra.repositories;

import com.clurgo.presentation.cassandra.domain.Message;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MessageRepository extends CrudRepository<Message, UUID> {

    List<Message> findByEmail(String email);

    @Query("select * from message_by_magic_number where magic_number =?0")
    List<Message> findByMagicNumber(Integer magicNumber);

}
