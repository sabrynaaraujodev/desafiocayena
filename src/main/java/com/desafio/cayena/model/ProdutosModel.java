package com.desafio.cayena.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "produtos")
public class ProdutosModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "supplier_id")
    private Long supplierId;

    @Column(name = "date_of_creation")
    private Date dateOfCreation;

    @Column(name = "date_of_the_last_update")
    private Date dateOfTheLastUpdate;

}