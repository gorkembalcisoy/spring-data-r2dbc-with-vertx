package com.github.gbalcisoy.vertxspringdatar2dbcexample;

import io.vertx.core.Vertx;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    private static final Log log = LogFactory.getLog(Application.class);

    public static void main(String[] args) {

//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DbConfig.class);
//        DatabaseClient databaseClient = ctx.getBean(DatabaseClient.class);
//
//        PostgresqlConnectionFactory postgresqlConnectionFactory = new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder()
//                .host("localhost")
//                .port(5432)
//                .database("deneme")
//                .schema("public")
//                .connectTimeout(Duration.ofMillis(10000))
//                .username("postgres")
//                .password("postgres321")
//                .build());

//        PostgresqlConnectionConfiguration configuration = PostgresqlConnectionConfiguration.builder()
//                .host("localhost")
//                .port(5432)
//                .database("deneme")
//                .schema("public")
//                .connectTimeout(Duration.ofMillis(10000))
//                .username("postgres")
//                .password("postgres321")
//                .build();
//        R2dbc r2dbc = new R2dbc(new PostgresqlConnectionFactory(configuration));

//        r2dbc.inTransaction(handle ->
//                handle.execute("INSERT INTO aaa VALUES ($1)", 100))
//
//                .thenMany(
//                        r2dbc.inTransaction(handle ->
//                        handle.select("SELECT value FROM aaa")
//                                .mapResult(result -> result.map((row, rowMetadata) -> row.get("id", String.class)))))
//
//                .subscribe(System.out::println);

//        r2dbc.inTransaction(handle ->
//                handle.select("SELECT id from aaa")
//                        .mapResult(result -> result.map((row, rowMetadata) -> row.get("id", String.class))))
//                                .subscribe(System.out::println);

//        r2dbc.inTransaction(handle ->
//                handle.execute("INSERT INTO aaa VALUES ($1)", "333"))
//                .subscribe(System.out::println);

//        DatabaseClient databaseClient = DatabaseClient.create(postgresqlConnectionFactory);
//        databaseClient.execute()
//                .sql("insert into aaa (id) values ($1)")
//                .bind("$1", "123456ere")
//                .fetch()
//                .rowsUpdated()
//                .subscribe(System.out::println);
//
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        ApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
        final Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new SpringVerticle(context));
        vertx.deployVerticle(new Server());
        System.out.println("Deployment done");
    }

}