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

import br.com.ruescas.livraria.data.vo.v1.PublisherVO;
import br.com.ruescas.livraria.exceptions.RequiredObjectIsNullException;
import br.com.ruescas.livraria.model.Publisher;
import br.com.ruescas.livraria.repositories.PublisherRepository;
import br.com.ruescas.livraria.services.PublisherServices;
import br.com.ruescas.livraria.unittests.mapper.mocks.MockPublisher;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PublisherServicesTest {

    MockPublisher input;

    @InjectMocks
    private PublisherServices service;

    @Mock
    PublisherRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception {
        input = new MockPublisher();
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void testFindById() {
        Publisher entity = input.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = service.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertTrue(result.toString().contains("links: [</api/publisher/v1/1>;rel=\"self\"]"));
        assertEquals("Name Test1", result.getName());
    }

    @Test
    void testFindAll() {
        List<Publisher> list = input.mockEntityList();

        when(repository.findAll()).thenReturn(list);

        var publishers = service.findAll();

        assertNotNull(publishers);
        assertEquals(14, publishers.size());

        var publisherOne = publishers.get(1);

        assertNotNull(publisherOne);
        assertNotNull(publisherOne.getKey());
        assertNotNull(publisherOne.getLinks());

        assertTrue(publisherOne.toString().contains("links: [</api/publisher/v1/1>;rel=\"self\"]"));
        assertEquals("Name Test1", publisherOne.getName());

        var publisherFour = publishers.get(4);

        assertNotNull(publisherFour);
        assertNotNull(publisherFour.getKey());
        assertNotNull(publisherFour.getLinks());

        assertTrue(publisherFour.toString().contains("links: [</api/publisher/v1/4>;rel=\"self\"]"));
        assertEquals("Name Test4", publisherFour.getName());

        var publisherSeven = publishers.get(7);

        assertNotNull(publisherSeven);
        assertNotNull(publisherSeven.getKey());
        assertNotNull(publisherSeven.getLinks());

        assertTrue(publisherSeven.toString().contains("links: [</api/publisher/v1/7>;rel=\"self\"]"));
        assertEquals("Name Test7", publisherSeven.getName());
    }

    @Test
    void testCreate() {
        Publisher entity = input.mockEntity(1);
        entity.setId(1L);

        Publisher persisted = entity;
        persisted.setId(1L);

        PublisherVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.save(entity)).thenReturn(persisted);

        var result = service.create(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/publisher/v1/1>;rel=\"self\"]"));
        assertEquals("Name Test1", result.getName());
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
        Publisher entity = input.mockEntity(1);

        Publisher persisted = entity;
        persisted.setId(1L);

        PublisherVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(persisted);

        var result = service.update(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertTrue(result.toString().contains("links: [</api/publisher/v1/1>;rel=\"self\"]"));
        assertEquals("Name Test1", result.getName());

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
        Publisher entity = input.mockEntity(1);
        entity.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        service.delete(1L);
    }

}
