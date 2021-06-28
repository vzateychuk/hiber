package vez.jpa.model;

import javax.persistence.*;

@Entity
@Table(name = "SUBJECT_AREA")
public class SubjArea {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    public SubjArea() { }

    public SubjArea(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SubjArea{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
