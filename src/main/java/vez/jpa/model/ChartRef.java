package vez.jpa.model;

import javax.persistence.*;

@Entity
@Table(name = "CHART_TO_SUBJ_AREA_REF")
@IdClass(RefId.class)
public class ChartRef {

    @Id @GeneratedValue(strategy=GenerationType.AUTO) private Long refId;
    @Column(name = "chart_id", insertable = false, updatable = false) private Long chartId;
    @Column(name = "subj_area_id")  private Long subjAreaId;

    public ChartRef() {   }
    public ChartRef(Long chartId, Long subjAreaId) {
        this.chartId = chartId;
        this.subjAreaId = subjAreaId;
    }

    public Long getChartId() {
        return chartId;
    }
    public void setChartId(Long chartId) {
        this.chartId = chartId;
    }

    public Long getSubjAreaId() {
        return subjAreaId;
    }
    public void setSubjAreaId(Long subjAreaId) {
        this.subjAreaId = subjAreaId;
    }

/*
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "chart_id")
    private Chart chart;

    public Chart getChart() {
        return chart;
    }
    public void setChart(Chart chart) {
        this.chart = chart;
    }
*/

    @Override
    public String toString() {
        return "Ref{" +
                "chartId=" + chartId +
                ", subjAreaId=" + subjAreaId +
                '}';
    }
}
