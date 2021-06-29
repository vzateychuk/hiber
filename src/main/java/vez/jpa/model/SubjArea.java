package vez.jpa.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "SUBJECT_AREA")
public class SubjArea {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    // inverse side: it has a mappedBy attribute, and can't decide how the association is mapped, since the other side already decided it.
    @OneToMany(mappedBy = "subjArea", fetch = FetchType.LAZY)
    // @Fetch(FetchMode.JOIN)
    private Collection<Chart> charts;

    public SubjArea() { }
    public SubjArea(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Collection<Chart> getCharts() {
        return charts;
    }
    public void setCharts(Collection<Chart> charts) {
        this.charts = charts;
    }

    @Override
    public String toString() {
        return "SubjArea{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
