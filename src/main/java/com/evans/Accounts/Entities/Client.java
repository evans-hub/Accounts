package com.evans.Accounts.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientName;
    private Long clientCode;
    private String correlator;

    @OneToMany(mappedBy = "client")
    private List<Employees> employees;

    @OneToMany(mappedBy = "client")
    private List<User> users;
    @OneToMany(mappedBy = "code")
    private List<Country> country;
    @Column(name = "datecreated", nullable = false)
    private Date dateCreated;

}
