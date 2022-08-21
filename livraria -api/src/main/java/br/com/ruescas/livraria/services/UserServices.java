package br.com.ruescas.livraria.services;

import br.com.ruescas.livraria.controller.Clientcontroller;
import br.com.ruescas.livraria.data.vo.v1.ClientVO;
import br.com.ruescas.livraria.exceptions.RequiredObjectIsNullException;
import br.com.ruescas.livraria.exceptions.ResourceNotFoundException;
import br.com.ruescas.livraria.mapper.DozerMapper;
import br.com.ruescas.livraria.model.Client;
import br.com.ruescas.livraria.repositories.ClientRepository;
import br.com.ruescas.livraria.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UserServices implements UserDetailsService {

    private Logger logger = Logger.getLogger(UserServices.class.getName());

    @Autowired
    UserRepository repository;

    public UserServices(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Finding one user by name " + username + "!");
        var user = repository.findByUsername(username);
        if(user != null){
            return user;
        } else {
            throw new UsernameNotFoundException(("Username " + username + " not found!"));
        }
    }
}
