package com.desafio.cayena.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "produtos")
public class ProdutosModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity_in_stock")
    private String quantityInStock;

    @Column(name = "unit_price")
    private String unitPrice;

    @Column(name = "supplier_id")
    private String supplierId;

    @Column(name = "date_of_creation")
    private String dateOfCreation;

    @Column(name = "date_of_the_last_update")
    private String dateOfTheLastUpdate;

}