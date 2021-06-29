package vez.jpa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CHART")
public class Chart {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST, mappedBy="chart")
    private ChartRef chartRef;

    public Chart() { }

    public Chart(String name) {
        this.name = name;
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

    public ChartRef getRef() {
        return chartRef;
    }
    public void setRef(ChartRef ref) {
        this.chartRef = ref;
    }

    @Override
    public String toString() {
        return "Chart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", chartRef=" + chartRef +
                '}';
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
