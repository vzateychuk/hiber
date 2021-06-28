package vez.jpa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CHART")
public class Chart {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name = "chart_id")
    private Long chartId;
    private String name;

/*
    @OneToOne(fetch = FetchType.LAZY, mappedBy="chart")
*/
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chart_id")
    private ChartRef chartRef;

    public Chart() { }

    public Chart(Long chartId, String name) {
        this.chartId = chartId;
        this.name = name;
    }

    public Long getChartId() {
        return chartId;
    }
    public void setChartId(Long id) {
        this.chartId = id;
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
                "id=" + chartId +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chart chart = (Chart) o;
        return chartId.equals(chart.chartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chartId);
    }
}
