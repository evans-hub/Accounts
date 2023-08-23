package com.evans.Accounts.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String identityNumber;
    private String staffNo;
    private boolean status;
    private String correlator;

    @ManyToOne
    @JoinColumn(name = "country_code", referencedColumnName = "code")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "token_id")
    private Token token;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
}
