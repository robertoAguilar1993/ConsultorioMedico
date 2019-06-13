package vo;

/**
 * @author Alex
 */
public class SintomasVO {
    private int id;
    private int idHistorialMts;
    private String sintomas;

    /**
     * Not args
     */
    public SintomasVO() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHistorialMts() {
        return idHistorialMts;
    }

    public void setIdHistorialMts(int idHistorialMts) {
        this.idHistorialMts = idHistorialMts;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    @Override
    public String toString() {
        return "SintomasVO{" +
                "id=" + id +
                ", idHistorialMts=" + idHistorialMts +
                ", sintomas='" + sintomas + '\'' +
                '}';
    }
}
