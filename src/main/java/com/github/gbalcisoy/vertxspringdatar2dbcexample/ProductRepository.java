package com.github.gbalcisoy.vertxspringdatar2dbcexample;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {
}
