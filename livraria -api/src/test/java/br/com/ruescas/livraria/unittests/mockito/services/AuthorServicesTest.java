package br.com.ruescas.livraria.unittests.mockito.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.ruescas.livraria.data.vo.v1.AuthorVO;
import br.com.ruescas.livraria.exceptions.RequiredObjectIsNullException;
import br.com.ruescas.livraria.model.Author;
import br.com.ruescas.livraria.repositories.AuthorRepository;
import br.com.ruescas.livraria.services.AuthorServives;
import br.com.ruescas.livraria.unittests.mapper.mocks.MockAuthor;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class AuthorServicesTest {

    MockAuthor input;

    @InjectMocks
    private AuthorServives service;

    @Mock
    AuthorRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception {
        input = new MockAuthor();
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void testFindById() {
        Author entity = input.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = service.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertTrue(result.toString().contains("links: [</api/author/v1/1>;rel=\"self\"]"));
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
    }

    @Test
    void testFindAll() {
        List<Author> list = input.mockEntityList();

        when(repository.findAll()).thenReturn(list);

        var authors = service.findAll();

        assertNotNull(authors);
        assertEquals(14, authors.size());

        var authorOne = authors.get(1);

        assertNotNull(authorOne);
        assertNotNull(authorOne.getKey());
        assertNotNull(authorOne.getLinks());

        assertTrue(authorOne.toString().contains("links: [</api/author/v1/1>;rel=\"self\"]"));
        assertEquals("First Name Test1", authorOne.getFirstName());
        assertEquals("Last Name Test1", authorOne.getLastName());

        var authorFour = authors.get(4);

        assertNotNull(authorFour);
        assertNotNull(authorFour.getKey());
        assertNotNull(authorFour.getLinks());

        assertTrue(authorFour.toString().contains("links: [</api/author/v1/4>;rel=\"self\"]"));
        assertEquals("First Name Test4", authorFour.getFirstName());
        assertEquals("Last Name Test4", authorFour.getLastName());

        var authorSeven = authors.get(7);

        assertNotNull(authorSeven);
        assertNotNull(authorSeven.getKey());
        assertNotNull(authorSeven.getLinks());

        assertTrue(authorSeven.toString().contains("links: [</api/author/v1/7>;rel=\"self\"]"));
        assertEquals("First Name Test7", authorSeven.getFirstName());
        assertEquals("Last Name Test7", authorSeven.getLastName());
    }

    @Test
    void testCreate() {
        Author entity = input.mockEntity(1);
        entity.setId(1L);

        Author persisted = entity;
        persisted.setId(1L);

        AuthorVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.save(entity)).thenReturn(persisted);

        var result = service.create(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/author/v1/1>;rel=\"self\"]"));
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
    }

    @Test
    void testCreateWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.create(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testUpdate() {
        Author entity = input.mockEntity(1);

        Author persisted = entity;
        persisted.setId(1L);

        AuthorVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(persisted);

        var result = service.update(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/author/v1/1>;rel=\"self\"]"));
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());

    }

    @Test
    void testUpdateWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.update(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testDelete() {
        Author entity = input.mockEntity(1);
        entity.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        service.delete(1L);
    }
}
