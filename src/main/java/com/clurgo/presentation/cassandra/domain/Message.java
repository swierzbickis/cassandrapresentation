package com.clurgo.presentation.cassandra.domain;

import com.datastax.driver.core.DataType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@ToString
@Table("message")
@AllArgsConstructor
@Data
@Builder
public class Message implements Serializable {

    @PrimaryKeyColumn(
            name = "email",
            type = PrimaryKeyType.PARTITIONED)
    private String email;

    @PrimaryKeyColumn(
            name = "id",
            type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;

    @Column
    private String title;
    @Column
    private String content;

    @JsonProperty("magic_number")
    @Column("magic_number")
    private Integer magicNumber;

    @Column("creation_timestamp")
    private Instant creationTimeStamp;

    public Message() {
        id = UUID.randomUUID();
        creationTimeStamp = Instant.now();
    }


}
