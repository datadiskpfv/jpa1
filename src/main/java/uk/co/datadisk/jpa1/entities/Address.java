package uk.co.datadisk.jpa1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street1;
    private String city;

    //@JsonIgnore
    @OneToMany(mappedBy = "address")
    private Set<User> users = new HashSet<>();

    public Address() { }

    public Address(String street1, String city) {
        this.street1 = street1;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
