package vez.jpa.model;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(generator = "addressKeyGenerator")
    @org.hibernate.annotations.GenericGenerator(
            name = "addressKeyGenerator",
            strategy = "foreign",
            parameters =
            @org.hibernate.annotations.Parameter(
                    name = "property", value = "user"
            )
    )
    private Long id;

    @Column(name = "zipcode")
    private String zipcode;

    @OneToOne(optional = false) // Создает ограничение внешнего ключа
    @PrimaryKeyJoinColumn // Адрес должен ссылаться на пользователя
    protected User user;

    public Address() {
    }
    public Address(User user, String zipcode) {
        this.user = user;
        this.zipcode = zipcode;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
