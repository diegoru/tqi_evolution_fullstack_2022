package br.com.ruescas.livraria.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.ruescas.livraria.data.vo.v1.AuthorVO;
import br.com.ruescas.livraria.model.Author;


public class MockAuthor {
 
    public Author mockEntity() {
        return mockEntity(0);
    }

    public AuthorVO mockVO() {
        return mockVO(0);
    }

    public List<Author> mockEntityList() {
        List<Author> authors = new ArrayList<Author>();
        for (int i = 0; i < 14; i++) {
            authors.add(mockEntity(i));
        }
        return authors;
    }

    public List<AuthorVO> mockVOList() {
        List<AuthorVO> authors = new ArrayList<AuthorVO>();
        for (int i = 0; i < 14; i++) {
            authors.add(mockVO(i));
        }
        return authors;
    }

    public Author mockEntity(Integer number) {
        Author author = new Author();

        author.setId(number.longValue());
        author.setFirstName("First Name Test" + number);
        author.setLastName("Last Name Test" + number);
        return author;
    }

    public AuthorVO mockVO(Integer number) {
        AuthorVO author = new AuthorVO();
        author.setKey(number.longValue());
        author.setFirstName("First Name Test" + number);
        author.setLastName("Last Name Test" + number);
        return author;
    }
    
}