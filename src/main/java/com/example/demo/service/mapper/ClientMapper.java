package com.example.demo.service.mapper;

import com.example.demo.dto.ClientDto;
import com.example.demo.entity.ClientEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientDto transformerEnDto(ClientEntity entity) {
        return new ClientDto(entity.getId(), entity.getNom(), entity.getPrenom());
    }

}
