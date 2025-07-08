package com.ramon.client.services;

import com.ramon.client.dto.ClientDTO;
import com.ramon.client.entities.Client;
import com.ramon.client.mapper.ClientMapper;
import com.ramon.client.repositories.ClientRepository;
import com.ramon.client.services.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    ClientRepository repository;
    ClientMapper mapper;

    public ClientService(ClientRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    //Todos os clientes paginados
    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return result.map(mapper::toDTO);
    }

    //Procurar cliente por id
    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return mapper.toDTO(client);
    }

    //Inserir novo cliente
    @Transactional
    public ClientDTO insert(ClientDTO dto){
        Client entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    //Atualizar cliente
    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        Client entity = repository.getReferenceById(id);
        mapper.updateEntityFromDTO(dto, entity);
        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    //Deletar cliente

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }







}
