package com.evans.Accounts.Models;
import com.evans.Accounts.Entities.Country;
import com.evans.Accounts.Entities.Employees;
import com.evans.Accounts.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private Long id;
    private String clientName;
    private Long clientCode;
    private String correlator;
    private List<Employees> employees;
    private List<User> users;
    private List<Country> countries;
    private Date dateCreated;
}