package dev.ant04x.pruebatecnicateralco.controllers.interceptors;

import com.mongodb.client.MongoClients;
import dev.ant04x.pruebatecnicateralco.entities.AccessLog;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.time.Instant;

public class Logger implements HandlerInterceptor {

    private int num;

    public Logger(int exerciseNum) {
        num = exerciseNum;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String ip = request.getRemoteAddr();
        Timestamp timestamp = Timestamp.from(Instant.now());

        MongoOperations mongoOps = new MongoTemplate(
                new SimpleMongoClientDatabaseFactory(MongoClients.create(),
                "prueba_tecnica")
        );

        mongoOps.insert(new AccessLog(ip, timestamp, num));
        System.out.println("LOG => DONE!");

        return true;
    }
}
