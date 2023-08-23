package com.evans.Accounts.Services;

import com.evans.Accounts.Entities.Client;
import com.evans.Accounts.Models.ClientDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface ClientService {

   Page<ClientDTO> getAllClients(int page,int size);
   ClientDTO getClientById(Long id);
   ClientDTO getClientByCode(Long code);
   ClientDTO createClient(Client client) throws Exception;

}
