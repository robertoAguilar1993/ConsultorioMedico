package vo;

/**
 * @author beto
 */
public class DiagnosticoVO {
    private int id;
    private String diagnostico;
    private String tratamiento;

    /**
     * Not args
     */
    public DiagnosticoVO() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    @Override
    public String toString() {
        return "DiagnosticoVO{" +
                "id=" + id +
                ", diagnostico='" + diagnostico + '\'' +
                ", tratamiento='" + tratamiento + '\'' +
                '}';
    }
}
