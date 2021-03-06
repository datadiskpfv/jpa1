package uk.co.datadisk.jpa1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "users")
@NamedQuery(name = "User.fetchByEmailAddress",
        query = "SELECT u FROM User u WHERE u.email =:email "
)
public class User {

//    @NotNull                      - prevents the value of the object from being null, a validator of the field not the DB.
//    @Basic (optional = false)     - indicates that the value of the field or property can not be null.
//                                    It can be used to generate the database schema from the entity.
//    @Column (nullable = false)    - means that the field in the database table can not be null.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    @Size(min = 5, max = 20)                    // also caps the database as well so this would be varchar(20)
    private String username;

    @Basic(optional = false)                     // used to change fetchType or optional which means if field can be NULL or NOT NULL
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)                       // db will create timestamp type
    @Column(name = "date_created", updatable = false)
    private Date dateCreated;

    @Transient                                              // dont create in db
    @JsonIgnore                                             // dont send data back to viewer if using REST
    private String youWontSeeThisInTable;

    //@Lob                                                  // by default this is a CLOB (on H2 db)
    @Column(name = "description", columnDefinition="CLOB")
    private String description;

    //@Lob
    @Column(name = "photo", columnDefinition="BLOB")        // we can specify the LOB type
    private byte[] photo;

    ///////////////////////////////////////////////
    // mapping relationships
    ///////////////////////////////////////////////
    //@JsonIgnore
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "user"})
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private NationalInsuranceNumber nationalInsuranceNumber;

    @JsonIgnoreProperties("users")
    @JsonIgnore
    @ManyToMany                   // by default LAZY loaded
    @JoinTable(
            name="user_role",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns={@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles = new HashSet<>();

    @JsonIgnoreProperties("users")
    @JsonIgnore               // if you comment this you get a uk.co.datadisk.jpa1.entities.Address$HibernateProxy error
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @JsonIgnoreProperties("user")
    //@JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("createdOn ASC")
    private List<UserDepartment> userDepartments = new ArrayList<>();

    ///////////////////////////////////////////////
    // Constructors, Getter/Setters, toString, etc
    ///////////////////////////////////////////////

    public User() { }

    public User(String username, String email, Gender gender) {
        this.username = username;
        this.email = email;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getYouWontSeeThisInTable() {
        return youWontSeeThisInTable;
    }

    public void setYouWontSeeThisInTable(String youWontSeeThisInTable) {
        this.youWontSeeThisInTable = youWontSeeThisInTable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public NationalInsuranceNumber getNationalInsuranceNumber() {
        return nationalInsuranceNumber;
    }

    public void setNationalInsuranceNumber(NationalInsuranceNumber nationalInsuranceNumber) {
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Role role) {
        roles.add(role);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<UserDepartment> getUserDepartments() {
        return userDepartments;
    }

    public void addDepartment(UserDepartment userDepartment) {
        userDepartments.add(userDepartment);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }
}
