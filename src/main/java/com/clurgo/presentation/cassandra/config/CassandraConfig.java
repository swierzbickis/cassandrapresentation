package com.clurgo.presentation.cassandra.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${spring.data.cassandra.contact-points}")
    private String contactPoints;

    @Value("${spring.data.cassandra.port}")
    private int port;

    @Value("${spring.data.cassandra.keyspace-name}")
    private String keySpace;

    @Value("${cassandra.basepackages}")
    private String basePackages;

    @Override
    protected String getKeyspaceName() {
        return keySpace;
    }

    @Override
    protected String getContactPoints() {
        return contactPoints;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {basePackages};
    }

    @Override
    protected List<String> getStartupScripts() {
        final String createKeySpaceScript =
                "CREATE KEYSPACE IF NOT EXISTS "
                        + keySpace
                        + " WITH replication = {'class' : 'SimpleStrategy', 'replication_factor' : 1};";

        final String createMessageTableScript = "CREATE TABLE IF NOT EXISTS  " +
                "messages_keyspace.message " +
                "(\n" +
                "    id UUID,\n" +
                "    email varchar,\n" +
                "    title varchar,\n" +
                "    content varchar,\n" +
                "    magic_number int,\n" +
                "    creation_timestamp timestamp,\n" +
                "    primary key(email,id)\n" +
                ") WITH default_time_to_live = 300;";

        final String createIndexOnMessageTableScript = "CREATE INDEX IF NOT EXISTS "
                + "magic_number_idx ON messages_keyspace.message (magic_number);";


        List<String> startupScripts = new ArrayList<>();
        startupScripts.add(createKeySpaceScript);
        startupScripts.add(createMessageTableScript);
        startupScripts.add(createIndexOnMessageTableScript);
        return startupScripts;
    }

    @Override
    protected List<String> getShutdownScripts() {
        return Arrays.asList("DROP KEYSPACE IF EXISTS " + keySpace + ";");
    }

    @Override
    protected boolean getMetricsEnabled() {
        return false;
    }
}
