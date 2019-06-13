package vo;

import java.util.List;

/**
 * @author Alex
 */
public class HistorialVO {
    private int id;
    private String parecimientoActual;
    private String dxs;
    private String plan_manejo;
    private List<HistorialSintomasVO> historialSintomasVOList;

    /**
     * super
     */
    public HistorialVO() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParecimientoActual() {
        return parecimientoActual;
    }

    public void setParecimientoActual(String parecimientoActual) {
        this.parecimientoActual = parecimientoActual;
    }

    public String getDxs() {
        return dxs;
    }

    public void setDxs(String dxs) {
        this.dxs = dxs;
    }

    public String getPlan_manejo() {
        return plan_manejo;
    }

    public void setPlan_manejo(String plan_manejo) {
        this.plan_manejo = plan_manejo;
    }

    public List<HistorialSintomasVO> getHistorialSintomasVOList() {
        return historialSintomasVOList;
    }

    public void setHistorialSintomasVOList(List<HistorialSintomasVO> historialSintomasVOList) {
        this.historialSintomasVOList = historialSintomasVOList;
    }

    @Override
    public String toString() {
        return "HistorialVO{" +
                "id=" + id +
                ", parecimientoActual='" + parecimientoActual + '\'' +
                ", dxs='" + dxs + '\'' +
                ", plan_manejo='" + plan_manejo + '\'' +
                ", historialSintomasVOList=" + historialSintomasVOList +
                '}';
    }
}
