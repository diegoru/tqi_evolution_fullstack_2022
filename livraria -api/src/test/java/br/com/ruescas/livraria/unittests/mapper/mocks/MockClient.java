package br.com.ruescas.livraria.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.ruescas.livraria.data.vo.v1.ClientVO;
import br.com.ruescas.livraria.model.Client;

public class MockClient {

    public Client mockEntity() {
        return mockEntity(0);
    }

    public ClientVO mockVO() {
        return mockVO(0);
    }

    public List<Client> mockEntityList() {
        List<Client> clients = new ArrayList<Client>();
        for (int i = 0; i < 14; i++) {
            clients.add(mockEntity(i));
        }
        return clients;
    }

    public List<ClientVO> mockVOList() {
        List<ClientVO> clients = new ArrayList<ClientVO>();
        for (int i = 0; i < 14; i++) {
            clients.add(mockVO(i));
        }
        return clients;
    }

    public Client mockEntity(Integer number) {
        Client client = new Client();

        client.setId(number.longValue());
        client.setFirstName("First Name Test" + number);
        client.setLastName("Last Name Test" + number);
        client.setEmail("Email Test" + number);
        return client;
    }

    public ClientVO mockVO(Integer number) {
        ClientVO client = new ClientVO();
        client.setKey(number.longValue());
        client.setFirstName("First Name Test" + number);
        client.setLastName("Last Name Test" + number);
        client.setEmail("Email Test" + number);
        return client;
    }

}