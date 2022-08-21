package br.com.ruescas.livraria.unittests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.ruescas.livraria.data.vo.v1.ClientVO;
import br.com.ruescas.livraria.mapper.DozerMapper;
import br.com.ruescas.livraria.model.Client;
import br.com.ruescas.livraria.unittests.mapper.mocks.MockClient;

public class DozerConverterTest {

    MockClient inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockClient();
    }

    @Test
    public void parseEntityToVOTest() {
        ClientVO output = DozerMapper.parseObject(inputObject.mockEntity(), ClientVO.class);
        assertEquals(Long.valueOf(0L), output.getKey());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Email Test0", output.getEmail());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<ClientVO> outputList = DozerMapper.parseListObjects(inputObject.mockEntityList(), ClientVO.class);

        ClientVO outputZero = outputList.get(0);
        assertEquals(Long.valueOf(0L), outputZero.getKey());
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Email Test0", outputZero.getEmail());

        ClientVO outputSeven = outputList.get(7);
        assertEquals(Long.valueOf(7L), outputSeven.getKey());
        assertEquals("First Name Test7", outputSeven.getFirstName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Email Test7", outputSeven.getEmail());

        ClientVO outputTwelve = outputList.get(12);
        assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        assertEquals("First Name Test12", outputTwelve.getFirstName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Email Test12", outputTwelve.getEmail());
    }

    @Test
    public void parseVOToEntityTest() {
        Client output = DozerMapper.parseObject(inputObject.mockVO(), Client.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Email Test0", output.getEmail());
    }

    @Test
    public void parseVOListEntityListTest() {
        List<Client> outputList = DozerMapper.parseListObjects(inputObject.mockEntityList(), Client.class);

        Client outputZero = outputList.get(0);
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Email Test0", outputZero.getEmail());

        Client outputSeven = outputList.get(7);
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getFirstName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Email Test7", outputSeven.getEmail());

        Client outputTwelve = outputList.get(12);
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getFirstName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Email Test12", outputTwelve.getEmail());
    }
}
