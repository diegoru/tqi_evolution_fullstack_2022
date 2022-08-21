package br.com.ruescas.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ruescas.livraria.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}