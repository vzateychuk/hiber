package vez.jpa.model;

import javax.persistence.*;

@Entity
@Table(name = "CHART_REF")
public class ChartRef {

    @Id @GeneratedValue(generator = "refKeyGenerator")
    @org.hibernate.annotations.GenericGenerator(
            name = "refKeyGenerator",
            strategy = "foreign",
            parameters =
                @org.hibernate.annotations.Parameter(
                        name = "property", value = "chart"
                )
    )
    private Long id;

    @OneToOne(optional = false) // Ссылка на chart обязательна
    @PrimaryKeyJoinColumn   // ChartRef должен ссылаться на Chart
    private Chart chart;

    @Column(name = "area_id")  private Long areaId;

    public ChartRef() {   }
    public ChartRef(Long areaId) {
        this.areaId = areaId;
    }
    public ChartRef(Chart chart, Long areaId) {
        this.chart = chart;
        this.areaId = areaId;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long chartId) {
        this.id = chartId;
    }

    public Long getAreaId() {
        return areaId;
    }
    public void setAreaId(Long subjAreaId) {
        this.areaId = subjAreaId;
    }

    public Chart getChart() {
        return chart;
    }
    public void setChart(Chart chart) {
        this.chart = chart;
    }

    @Override
    public String toString() {
        return "Ref{" +
                "chartId=" + id +
                ", subjAreaId=" + areaId +
                '}';
    }
}
