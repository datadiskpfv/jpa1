package uk.co.datadisk.jpa1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.print.Book;

@Entity
@Table(name = "national_insurance_numbers")
public class NationalInsuranceNumber {

    @Id
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Column(name = "nat_number")
    private String natNumber;

    ///////////////////////////////////////////////
    // mapping relationships
    ///////////////////////////////////////////////
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "nationalInsuranceNumber"})
    @JsonIgnore
    @MapsId
    @OneToOne(mappedBy = "nationalInsuranceNumber")
    @JoinColumn(name = "user_id")
    private User user;


    ///////////////////////////////////////////////
    // Constructors, Getter/Setters, toString, etc
    ///////////////////////////////////////////////
    public NationalInsuranceNumber() { }

    public NationalInsuranceNumber(String natNumber) {
        this.natNumber = natNumber;
    }

    public Long getId() {
        return id;
    }

    public String getNatNumber() {
        return natNumber;
    }

    public void setNatNumber(String natNumber) {
        this.natNumber = natNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
