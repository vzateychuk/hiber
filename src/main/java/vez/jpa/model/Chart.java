package vez.jpa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CHART")
public class Chart {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;

    // owner side: it doesn't have mappedBy, and can decide how the association is mapped: with a join table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name="chart_ref_subjarea",
            joinColumns={@JoinColumn(name="chart_id")},
            inverseJoinColumns={@JoinColumn(name="subj_id")})
    private SubjArea subjArea;

    protected Chart() { }

    public Chart(SubjArea subjArea, String name) {
        this.name = name;
        this.subjArea = subjArea;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public SubjArea getSubjArea() {
        return subjArea;
    }
    public void setSubjArea(SubjArea subjArea) {
        this.subjArea = subjArea;
    }

    @Override
    public String toString() {
        return "Chart{" +
                "id=" + id +
                ", name='" + name + '\''
                // + ", chartRef=" + subjArea.getId()
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chart chart = (Chart) o;
        return id.equals(chart.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
