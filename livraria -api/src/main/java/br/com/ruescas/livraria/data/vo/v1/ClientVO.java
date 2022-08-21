package br.com.ruescas.livraria.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({ "id", "firstName", "lastName", "email" })
public class ClientVO extends RepresentationModel<ClientVO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Mapping("id")
    private long key;
    private String firstName;
    private String lastName;
    private String email;

    public ClientVO() {
    }

    public long getKey() {
        return this.key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClientVO)) {
            return false;
        }
        ClientVO clientVO = (ClientVO) o;
        return key == clientVO.key && Objects.equals(firstName, clientVO.firstName)
                && Objects.equals(lastName, clientVO.lastName) && Objects.equals(email, clientVO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, firstName, lastName, email);
    }

}
