package com.intercorp.msthree.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roots")
public class Root implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    private int random;
    private float random_float;
    private boolean bool;
    private String date;
    private String regEx;
    @Column(name = "enum")
    private String enumValue;
    private String elt;
    private String last_update;
    private String last_modified;

}