package com.desafio.cayena.model;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "produtos")
public class Produtos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "supplier_id")
    private Long supplierId;

    @UpdateTimestamp
    @Column(name = "date_of_creation")
    private LocalDateTime dateOfCreation;

    @Column(name = "date_of_the_last_update")
    private LocalDateTime dateOfTheLastUpdate;
}