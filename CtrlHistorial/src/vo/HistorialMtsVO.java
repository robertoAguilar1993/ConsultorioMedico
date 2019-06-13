package vo;

import java.util.Date;

/**
 * @author Alex
 */
public class HistorialMtsVO {
    private int id;
    private int idPaciente;
    private int idReceta;
    private int idHistorial;
    private int idReporteUltrasonico;
    private int idDiagnostico;
    private Date fecha;

    /**
     * Not args
     */
    public HistorialMtsVO() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getIdReporteUltrasonico() {
        return idReporteUltrasonico;
    }

    public void setIdReporteUltrasonico(int idReporteUltrasonico) {
        this.idReporteUltrasonico = idReporteUltrasonico;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "HistorialMtsVO{" +
                "id=" + id +
                ", idPaciente=" + idPaciente +
                ", idReceta=" + idReceta +
                ", idHistorial=" + idHistorial +
                ", idReporteUltrasonico=" + idReporteUltrasonico +
                ", idDiagnostico=" + idDiagnostico +
                ", fecha=" + fecha +
                '}';
    }
}
