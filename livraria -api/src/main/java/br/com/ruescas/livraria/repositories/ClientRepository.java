package br.com.ruescas.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ruescas.livraria.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
