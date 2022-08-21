package br.com.ruescas.livraria.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ruescas.livraria.controller.Clientcontroller;
import br.com.ruescas.livraria.data.vo.v1.ClientVO;
import br.com.ruescas.livraria.exceptions.RequiredObjectIsNullException;
import br.com.ruescas.livraria.exceptions.ResourceNotFoundException;
import br.com.ruescas.livraria.mapper.DozerMapper;
import br.com.ruescas.livraria.model.Client;
import br.com.ruescas.livraria.repositories.ClientRepository;

@Service
public class ClientServices {

    private Logger logger = Logger.getLogger(ClientServices.class.getName());

    @Autowired
    ClientRepository repository;

    public List<ClientVO> findAll() {
        logger.info("Finding all clients");

        var clients = DozerMapper.parseListObjects(repository.findAll(), ClientVO.class);
        clients
                .stream()
                .forEach(c -> c.add(linkTo(methodOn(Clientcontroller.class).findById(c.getKey())).withSelfRel()));
        return clients;
    }

    public ClientVO findById(Long id) {
        logger.info("Finding one client");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        ClientVO vo = DozerMapper.parseObject(entity, ClientVO.class);
        vo.add(linkTo(methodOn(Clientcontroller.class).findById(id)).withSelfRel());
        return vo;
    }

    public ClientVO create(ClientVO client) {

        if (client == null)
            throw new RequiredObjectIsNullException();
        logger.info("Creating one client");

        var entity = DozerMapper.parseObject(client, Client.class);
        var vo = DozerMapper.parseObject(repository.save(entity), ClientVO.class);
        vo.add(linkTo(methodOn(Clientcontroller.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public ClientVO update(ClientVO client) {

        if (client == null)
            throw new RequiredObjectIsNullException();
        logger.info("Updating one client");

        var entity = repository.findById(client.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setLastName(client.getLastName());
        entity.setFirstName(client.getFirstName());
        entity.setEmail(client.getEmail());

        var vo = DozerMapper.parseObject(repository.save(entity), ClientVO.class);
        vo.add(linkTo(methodOn(Clientcontroller.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id) {
        logger.info("Deleting one client");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(entity);
    }
}
