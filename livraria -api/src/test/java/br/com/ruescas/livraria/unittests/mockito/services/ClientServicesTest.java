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

import br.com.ruescas.livraria.data.vo.v1.ClientVO;
import br.com.ruescas.livraria.exceptions.RequiredObjectIsNullException;
import br.com.ruescas.livraria.model.Client;
import br.com.ruescas.livraria.repositories.ClientRepository;
import br.com.ruescas.livraria.services.ClientServices;
import br.com.ruescas.livraria.unittests.mapper.mocks.MockClient;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class ClientServicesTest {
 
    MockClient input;

    @InjectMocks
    private ClientServices service;

    @Mock
    ClientRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception {
        input = new MockClient();
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void testFindById() {
        Client entity = input.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = service.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertTrue(result.toString().contains("links: [</api/client/v1/1>;rel=\"self\"]"));
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Email Test1", result.getEmail());
    }

    @Test
    void testFindAll() {
        List<Client> list = input.mockEntityList();

        when(repository.findAll()).thenReturn(list);

        var clients = service.findAll();

        assertNotNull(clients);
        assertEquals(14, clients.size());

        var clientOne = clients.get(1);

        assertNotNull(clientOne);
        assertNotNull(clientOne.getKey());
        assertNotNull(clientOne.getLinks());

        assertTrue(clientOne.toString().contains("links: [</api/client/v1/1>;rel=\"self\"]"));
        assertEquals("First Name Test1", clientOne.getFirstName());
        assertEquals("Last Name Test1", clientOne.getLastName());
        assertEquals("Email Test1", clientOne.getEmail());

        var clientFour = clients.get(4);

        assertNotNull(clientFour);
        assertNotNull(clientFour.getKey());
        assertNotNull(clientFour.getLinks());

        assertTrue(clientFour.toString().contains("links: [</api/client/v1/4>;rel=\"self\"]"));
        assertEquals("First Name Test4", clientFour.getFirstName());
        assertEquals("Last Name Test4", clientFour.getLastName());
        assertEquals("Email Test4", clientFour.getEmail());

        var clientSeven = clients.get(7);

        assertNotNull(clientSeven);
        assertNotNull(clientSeven.getKey());
        assertNotNull(clientSeven.getLinks());

        assertTrue(clientSeven.toString().contains("links: [</api/client/v1/7>;rel=\"self\"]"));
        assertEquals("First Name Test7", clientSeven.getFirstName());
        assertEquals("Last Name Test7", clientSeven.getLastName());
        assertEquals("Email Test7", clientSeven.getEmail());
    }

    @Test
    void testCreate() {
        Client entity = input.mockEntity(1);
        entity.setId(1L);

        Client persisted = entity;
        persisted.setId(1L);

        ClientVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.save(entity)).thenReturn(persisted);

        var result = service.create(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/client/v1/1>;rel=\"self\"]"));
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Email Test1", result.getEmail());
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
        Client entity = input.mockEntity(1);

        Client persisted = entity;
        persisted.setId(1L);

        ClientVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(persisted);

        var result = service.update(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/client/v1/1>;rel=\"self\"]"));
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Email Test1", result.getEmail());

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
        Client entity = input.mockEntity(1);
        entity.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        service.delete(1L);
    }
}
