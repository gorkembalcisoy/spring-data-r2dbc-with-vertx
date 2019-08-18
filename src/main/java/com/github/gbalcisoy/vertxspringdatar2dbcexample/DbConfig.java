package com.github.gbalcisoy.vertxspringdatar2dbcexample;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.time.Duration;


@Configuration
@EnableR2dbcRepositories(basePackages = "com.github.gbalcisoy.vertxspringdatar2dbcexample")
@PropertySource(value = { "classpath:application.properties" })
public class DbConfig extends AbstractR2dbcConfiguration {

//    @Bean
//    public DatabaseClient dbClient() {
//
//        PostgresqlConnectionFactory postgresqlConnectionFactory = new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder()
//                .host("localhost")
//                .port(5432)
//                .database("postgres")
//                .schema("public")
//                .connectTimeout(Duration.ofMillis(10000))
//                .username("postgres")
//                .password("postgres321")
//                .build());
//
//        return DatabaseClient.create(postgresqlConnectionFactory);
//    }

    @Bean
    @Override
    public ConnectionFactory connectionFactory() {


        PostgresqlConnectionFactory postgresqlConnectionFactory = new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder()
                .host("localhost")
                .port(5432)
                .database("postgres")
                .schema("public")
                .connectTimeout(Duration.ofMillis(10000))
                .username("postgres")
                .password("postgres321")
                .applicationName("gorkem_github")
                .build());

        return postgresqlConnectionFactory;
    }
}
