package dev.ant04x.pruebatecnicateralco.controllers.interceptors;

import com.mongodb.client.MongoClients;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void preHandle() {
        MongoOperations mongoOps = new MongoTemplate(
                new SimpleMongoClientDatabaseFactory(MongoClients.create(),
                        "prueba_tecnica")
        );

        mongoOps.
    }
}