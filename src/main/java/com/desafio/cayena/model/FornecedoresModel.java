package com.desafio.cayena.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "fornecedores")
public class FornecedoresModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_creation")
    private Date dateOfCreation;

    @Column(name = "date_of_the_last_update")
    private Date dateOfTheLastUpdate;

}
