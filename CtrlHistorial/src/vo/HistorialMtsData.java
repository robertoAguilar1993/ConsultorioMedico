package vo;

import java.util.Date;
import java.util.List;

/**
 * @author beto
 */
public class HistorialMtsData {
    private int id;
    private int idPaciente;
    private PacienteVO pacienteVO;
    private RecetaVO recetaVO;
    private HistorialVO historialVO;
    private ReporteUltrasonicoVO reporteUltrasonicoVO;
    private DiagnosticoVO diagnosticoVO;
    private Date date;
    private List<SintomasVO> sintomasVOList;

    /**
     * Not args
     */
    public HistorialMtsData() {
        super();
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PacienteVO getPacienteVO() {
        return pacienteVO;
    }

    public void setPacienteVO(PacienteVO pacienteVO) {
        this.pacienteVO = pacienteVO;
    }

    public RecetaVO getRecetaVO() {
        return recetaVO;
    }

    public void setRecetaVO(RecetaVO recetaVO) {
        this.recetaVO = recetaVO;
    }

    public HistorialVO getHistorialVO() {
        return historialVO;
    }

    public void setHistorialVO(HistorialVO historialVO) {
        this.historialVO = historialVO;
    }

    public ReporteUltrasonicoVO getReporteUltrasonicoVO() {
        return reporteUltrasonicoVO;
    }

    public void setReporteUltrasonicoVO(ReporteUltrasonicoVO reporteUltrasonicoVO) {
        this.reporteUltrasonicoVO = reporteUltrasonicoVO;
    }

    public DiagnosticoVO getDiagnosticoVO() {
        return diagnosticoVO;
    }

    public void setDiagnosticoVO(DiagnosticoVO diagnosticoVO) {
        this.diagnosticoVO = diagnosticoVO;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<SintomasVO> getSintomasVOList() {
        return sintomasVOList;
    }

    public void setSintomasVOList(List<SintomasVO> sintomasVOList) {
        this.sintomasVOList = sintomasVOList;
    }



    @Override
    public String toString() {
        return "HistorialMtsData{" +
                "id=" + id +
                ", pacienteVO=" + pacienteVO +
                ", recetaVO=" + recetaVO +
                ", historialVO=" + historialVO +
                ", reporteUltrasonicoVO=" + reporteUltrasonicoVO +
                ", diagnosticoVO=" + diagnosticoVO +
                ", date=" + date +
                ", sintomasVOList=" + sintomasVOList +
                '}';
    }
}
