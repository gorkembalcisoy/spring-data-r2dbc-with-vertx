package com.github.gbalcisoy.vertxspringdatar2dbcexample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.Json;
import org.springframework.context.ApplicationContext;
import reactor.core.publisher.Mono;

public class SpringVerticle extends AbstractVerticle {

    static final String ALL_PRODUCTS_ADDRESS = "example.all.products";
    static final String CREATE_PRODUCTS_ADDRESS = "example.create.products";
    private final ObjectMapper mapper = Json.mapper;

    private ProductRepository productRepository;

    public SpringVerticle(final ApplicationContext context) {
        productRepository = (ProductRepository) context.getBean("productRepository");
    }

    @Override
    public void start() throws Exception {
        super.start();
        vertx.eventBus().consumer(ALL_PRODUCTS_ADDRESS, selectProductsHandler());
        vertx.eventBus().consumer(CREATE_PRODUCTS_ADDRESS, createProductsHandler());
//        vertx.eventBus().<String>consumer(ALL_PRODUCTS_ADDRESS, msg -> {
//            Mono.from(productRepository.findById(3))
//                    .subscribe(product -> {
//                        try {
//                            msg.reply(mapper
//                                    .writeValueAsString(product));
//                        } catch (JsonProcessingException e) {
//                            e.printStackTrace();
//                        }
//                    });
//        });
    }

    private Handler<Message<String>> createProductsHandler() {

        return msg -> {
            Product entity = new Product();
            entity.setName("fdfd");
            entity.setPrice(2.0);
            entity.setWeight(3);
            Mono.from(productRepository.save(entity))
                    .subscribe(product -> {
                        try {
                            msg.reply(mapper.writeValueAsString(product));
                        } catch (JsonProcessingException e) {
                            e.printStackTrace();
                        }
                    });
        };
    }

    private Handler<Message<String>> selectProductsHandler() {

        return msg -> Mono.from(productRepository.findById(3))
                .subscribe(product -> {
                    try {
                        msg.reply(mapper.writeValueAsString(product));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                });
    }

}
