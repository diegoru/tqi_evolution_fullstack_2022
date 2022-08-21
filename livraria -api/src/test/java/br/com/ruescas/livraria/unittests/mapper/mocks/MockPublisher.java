package br.com.ruescas.livraria.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.ruescas.livraria.data.vo.v1.PublisherVO;
import br.com.ruescas.livraria.model.Publisher;

public class MockPublisher {

    public Publisher mockEntity() {
        return mockEntity(0);
    }

    public PublisherVO mockVO() {
        return mockVO(0);
    }

    public List<Publisher> mockEntityList() {
        List<Publisher> clients = new ArrayList<Publisher>();
        for (int i = 0; i < 14; i++) {
            clients.add(mockEntity(i));
        }
        return clients;
    }

    public List<PublisherVO> mockVOList() {
        List<PublisherVO> clients = new ArrayList<PublisherVO>();
        for (int i = 0; i < 14; i++) {
            clients.add(mockVO(i));
        }
        return clients;
    }

    public Publisher mockEntity(Integer number) {
        Publisher publisher = new Publisher();

        publisher.setId(number.longValue());
        publisher.setName("Name Test" + number);
        return publisher;
    }

    public PublisherVO mockVO(Integer number) {
        PublisherVO publisher = new PublisherVO();
        publisher.setKey(number.longValue());
        publisher.setName("Name Test" + number);
        return publisher;
    }

}
