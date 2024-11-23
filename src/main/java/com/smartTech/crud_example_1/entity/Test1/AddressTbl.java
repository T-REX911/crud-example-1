package com.smartTech.crud_example_1.entity.Test1;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Address")
public class AddressTbl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;
    private String addressType;

    /*
    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL)
    private Employee employee;
    */
}
