FROM openjdk

EXPOSE 8080

VOLUME /tmp
ADD /cassandra-app-0.0.1-SNAPSHOT.jar cassandraapp.jar
RUN sh -c 'touch /cassandraapp.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/cassandraapp.jar"]