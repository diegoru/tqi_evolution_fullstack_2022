package br.com.ruescas.livraria.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ruescas.livraria.controller.AuthorController;
import br.com.ruescas.livraria.data.vo.v1.AuthorVO;
import br.com.ruescas.livraria.exceptions.RequiredObjectIsNullException;
import br.com.ruescas.livraria.exceptions.ResourceNotFoundException;
import br.com.ruescas.livraria.mapper.DozerMapper;
import br.com.ruescas.livraria.model.Author;
import br.com.ruescas.livraria.repositories.AuthorRepository;

@Service
public class AuthorServives {

    private Logger logger = Logger.getLogger(AuthorServives.class.getName());

    @Autowired
    AuthorRepository repository;

    public List<AuthorVO> findAll() {
        logger.info("Finding all authors");

        var authors = DozerMapper.parseListObjects(repository.findAll(), AuthorVO.class);
        authors
                .stream()
                .forEach(c -> c.add(linkTo(methodOn(AuthorController.class).findById(c.getKey())).withSelfRel()));
        return authors;
    }

    public AuthorVO findById(Long id) {
        logger.info("Finding one author");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        AuthorVO vo = DozerMapper.parseObject(entity, AuthorVO.class);
        vo.add(linkTo(methodOn(AuthorController.class).findById(id)).withSelfRel());
        return vo;
    }

    public AuthorVO create(AuthorVO author) {

        if (author == null)
            throw new RequiredObjectIsNullException();
        logger.info("Creating one author");

        var entity = DozerMapper.parseObject(author, Author.class);
        var vo = DozerMapper.parseObject(repository.save(entity), AuthorVO.class);
        vo.add(linkTo(methodOn(AuthorController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public AuthorVO update(AuthorVO author) {

        if (author == null)
            throw new RequiredObjectIsNullException();
        logger.info("Updating one author");

        var entity = repository.findById(author.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setLastName(author.getLastName());
        entity.setFirstName(author.getFirstName());

        var vo = DozerMapper.parseObject(repository.save(entity), AuthorVO.class);
        vo.add(linkTo(methodOn(AuthorController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id) {
        logger.info("Deleting one author");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(entity);
    }
}
