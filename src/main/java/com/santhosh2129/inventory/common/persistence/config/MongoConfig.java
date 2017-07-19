package com.santhosh2129.inventory.common.persistence.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by santhosh on 7/1/17.
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.santhosh2129.inventory.common.persistence.repository")
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private Integer port;

    @Value("${spring.data.mongodb.username}")
    private String username;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.password}")
    private String password;

    @Override
    protected String getDatabaseName() {
        // TODO Auto-generated method stub
        return database;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(Collections.singletonList(new ServerAddress(host, port)),
                Collections.singletonList(MongoCredential.createCredential(username,database, password.toCharArray())));
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongo(), database);
        MappingMongoConverter mappingConverter = (MappingMongoConverter) mongoTemplate.getConverter();
        mappingConverter.setCustomConversions(mongoCustomConversions());
        mappingConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
        mappingConverter.afterPropertiesSet();
        return mongoTemplate;
    }

    @Bean
    public CustomConversions mongoCustomConversions() {
        List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();
        return new CustomConversions(converters);
    }

}
