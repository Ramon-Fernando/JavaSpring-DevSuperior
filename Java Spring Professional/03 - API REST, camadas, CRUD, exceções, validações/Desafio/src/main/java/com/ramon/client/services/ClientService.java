package com.ramon.client.services;

import com.ramon.client.dto.ClientDTO;
import com.ramon.client.entities.Client;
import com.ramon.client.mapper.ClientMapper;
import com.ramon.client.repositories.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ClientService {

    ClientRepository repository;
    ClientMapper mapper;

    public ClientService(ClientRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return result.map(mapper::toDTO);
    }


}
