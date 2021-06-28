package vez.jpa.model;

import java.io.Serializable;

public class RefId implements Serializable {
    private Long chartId;
    private Long subjAreaId;

    public RefId() { }

    public RefId(Long chartId, Long subjAreaId) {
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

}
