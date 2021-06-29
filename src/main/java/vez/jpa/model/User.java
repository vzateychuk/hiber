package vez.jpa.model;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name = "username") private String username;

    @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.PERSIST
    )
    protected Address address;

    protected User() { }
    public User(String username) {
        this.username = username;
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

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

}
