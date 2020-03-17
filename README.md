# Available commands
---

## Run application with docker images
*** To run application using docker images: *** 

1. *** Navigate to the directory: *** 
    $CASSANDRAAPP_DIRECTORY/src/main/docker
2. *** Run command: *** docker-compose up
---

## Run tests

*** To run tests execute the following command inside $CASSANDRAAPP_DIRECTORY: ***
mvn test 

---
## To run application without using docker image:

1. *** Run cassandra database on server ***: 
    docker run --name cassandra_db -p 9042:9042 -d cassandra
2. *** Install application ***: 
    mvn clean install
3. *** Run spring boot application ***
    mvn spring-boot:run

