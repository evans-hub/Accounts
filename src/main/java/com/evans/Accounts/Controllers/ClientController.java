package com.evans.Accounts.Controllers;

import com.evans.Accounts.Entities.Client;
import com.evans.Accounts.Models.ClientDTO;
import com.evans.Accounts.Services.ClientServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ClientController {
    @Autowired
    private ClientServiceImpl clientService;
    private Logger logger= LoggerFactory.getLogger(ClientController.class);

    @GetMapping("/getAllClients")
    public ResponseEntity<Page<ClientDTO>> getAllClients(
            @RequestParam(defaultValue = "0") int size,
            @RequestParam(defaultValue = "10") int page) {
        try {
            Page<ClientDTO> clients = clientService.getAllClients(size, page);
            return ResponseEntity.status(HttpStatus.OK).body(clients);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getClientById/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable("id") Long id) {
        try {
            ClientDTO client = clientService.getClientById(id);
            if (client != null) {
                return ResponseEntity.status(HttpStatus.OK).body(client);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getClientByCode/{code}")
    public ResponseEntity<ClientDTO> getClientByCode(@PathVariable("code") Long code) {
        try {
            ClientDTO client = clientService.getClientByCode(code);
            if (client != null) {
                return ResponseEntity.status(HttpStatus.OK).body(client);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/createClient")
    public ResponseEntity<ClientDTO> createClient(@RequestBody Client client) throws Exception {
        ClientDTO existingClient = clientService.getClientByCode(client.getClientCode());

        if (existingClient == null) {
            ClientDTO createdClient = clientService.createClient(client);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
