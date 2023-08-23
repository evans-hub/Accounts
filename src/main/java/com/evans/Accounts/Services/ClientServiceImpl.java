package com.evans.Accounts.Services;

import com.evans.Accounts.Entities.Client;
import com.evans.Accounts.Models.ClientDTO;
import com.evans.Accounts.Repos.ClientRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ModelMapper modelMapper;
    private Logger log= LoggerFactory.getLogger(ClientServiceImpl.class);
    @Override
    public Page<ClientDTO> getAllClients(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Client> clientsPage = clientRepository.findAll(pageable);

        return clientsPage.map(client -> modelMapper.map(client, ClientDTO.class));
    }


    @Override
    public ClientDTO getClientById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        return client != null ? modelMapper.map(client, ClientDTO.class) : null;
    }


    @Override
    public ClientDTO getClientByCode(Long code) {
        Client client=clientRepository.findByClientCode(code);
        return client !=null ? modelMapper.map(client,ClientDTO.class):null;
    }

    @Override
    public ClientDTO createClient(Client request) throws Exception {
        log.info("UserRequest: {}",request);
        Client client = clientRepository.findByClientCode(request.getClientCode());
        if (client == null) {
            client = modelMapper.map(request, Client.class);
            client = clientRepository.save(client);
            return modelMapper.map(client, ClientDTO.class);
        } else {
            log.error("Client already created");
            throw new Exception("Client already created");
        }
    }

}
