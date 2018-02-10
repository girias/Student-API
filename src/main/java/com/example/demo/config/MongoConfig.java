package com.example.demo.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.demo.repository")
@Profile("!Test")
public class MongoConfig extends AbstractMongoConfiguration {

    //    @Value("${spring.data.mongodb.uri}")
    String url = "localhost:27017/student?connectTimeoutMS=1000";

    @Value("${spring.data.mongodb.username:mongouser}")
    String userId;

    @Value("${spring.data.mongodb.password:mongouser}")
    String pwd;

    @Value("${spring.data.mongodb.database:student}")
    String databaseName;

    @Override
    @Bean
    public MongoClient mongo() {
        String mongoURL = "mongodb://" + userId + ":" + pwd + "@" + url;
        return new MongoClient(new MongoClientURI(mongoURL));
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongo(), getDatabaseName());
    }

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

}
