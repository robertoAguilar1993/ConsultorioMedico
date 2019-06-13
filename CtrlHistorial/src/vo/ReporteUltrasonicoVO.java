package vo;

/**
 * @author Alex
 */
public class ReporteUltrasonicoVO {
    private int id;
    private String descripcion;

    /**
     * Not args
     */
    public ReporteUltrasonicoVO() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ReporteUltrasonicoVO{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
