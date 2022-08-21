package br.com.ruescas.livraria.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ruescas.livraria.controller.PublisherController;
import br.com.ruescas.livraria.data.vo.v1.PublisherVO;
import br.com.ruescas.livraria.exceptions.RequiredObjectIsNullException;
import br.com.ruescas.livraria.exceptions.ResourceNotFoundException;
import br.com.ruescas.livraria.mapper.DozerMapper;
import br.com.ruescas.livraria.model.Publisher;
import br.com.ruescas.livraria.repositories.PublisherRepository;

@Service
public class PublisherServices {

    private Logger logger = Logger.getLogger(PublisherServices.class.getName());

    @Autowired
    PublisherRepository repository;

    public List<PublisherVO> findAll() {
        logger.info("Finding all publisher!");

        var publishers = DozerMapper.parseListObjects(repository.findAll(), PublisherVO.class);
        publishers
                .stream()
                .forEach(p -> p.add(linkTo(methodOn(PublisherController.class).findById(p.getKey())).withSelfRel()));
        return publishers;
    }

    public PublisherVO findById(Long id) {

        logger.info("Finding one publisher!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var vo = DozerMapper.parseObject(entity, PublisherVO.class);
        vo.add(linkTo(methodOn(PublisherController.class).findById(id)).withSelfRel());
        return vo;
    }

    public PublisherVO create(PublisherVO publisher) {

        if (publisher == null)
            throw new RequiredObjectIsNullException();

        logger.info("Creating one publisher!");
        var entity = DozerMapper.parseObject(publisher, Publisher.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PublisherVO.class);
        vo.add(linkTo(methodOn(PublisherController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public PublisherVO update(PublisherVO publisher) {

        if (publisher == null)
            throw new RequiredObjectIsNullException();

        logger.info("Updating one publisher!");

        var entity = repository.findById(publisher.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setName(publisher.getName());
        var vo = DozerMapper.parseObject(repository.save(entity), PublisherVO.class);
        vo.add(linkTo(methodOn(PublisherController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id) {

        logger.info("Deleting one publisher!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

}
