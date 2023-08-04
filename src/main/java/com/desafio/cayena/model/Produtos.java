package com.desafio.cayena.model;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotBlank
    @NotNull(message = "O nome do produto não pode ser nulo.")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull(message = "A quantidade em estoque não pode ser nula.")
    @Column(name = "quantity_in_stock", nullable = false)
    private Integer quantityInStock;

    @NotNull(message = "O preço unitário não pode ser nulo.")
    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

    @NotNull(message = "A identificação do fornecedor não pode ser nula.")
    @Column(name = "supplier_id", nullable = false)
    private Long supplierId;

    @Column(name = "date_of_creation")
    private LocalDateTime dateOfCreation;

    @Column(name = "date_of_the_last_update")
    private LocalDateTime dateOfTheLastUpdate;
}