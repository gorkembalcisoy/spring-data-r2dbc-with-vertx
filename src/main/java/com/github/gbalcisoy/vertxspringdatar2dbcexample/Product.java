package com.github.gbalcisoy.vertxspringdatar2dbcexample;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("products_new2")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private Integer id;
    private String name;
    private Double price;
    private Integer weight;
}
