package vo;

/**
 * @author Alex
 */
public class HistorialSintomasVO {

    private int id;
    private int idHistorial;
    private int idPaciente;
    private String antecedenteImportante;

    /**
     * not args
     */
    public HistorialSintomasVO() {
        super();
    }
    
    /**
     * @param antecedenteImportante 
     */
    public HistorialSintomasVO(String antecedenteImportante) {
        this.antecedenteImportante = antecedenteImportante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getAntecedenteImportante() {
        return antecedenteImportante;
    }

    public void setAntecedenteImportante(String antecedenteImportante) {
        this.antecedenteImportante = antecedenteImportante;
    }

    @Override
    public String toString() {
        return "HistorialSintomasVO{" +
                "id=" + id +
                ", idHistorial=" + idHistorial +
                ", idPaciente=" + idPaciente +
                ", antecedenteImportante='" + antecedenteImportante + '\'' +
                '}';
    }
}
