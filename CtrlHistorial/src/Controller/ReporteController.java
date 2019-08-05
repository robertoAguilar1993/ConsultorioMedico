/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Reportes.GenerateReportBussines;
import util.Result;
import vo.HistorialMtsData;
import vo.HistorialVO;
import vo.PacienteVO;
import vo.RecetaVO;
import vo.ReporteUltrasonicoVO;

/**
 *
 * @author Alex
 */
public class ReporteController {
    
    public GenerateReportBussines report = new GenerateReportBussines();
    
    /**
     * Metodo para generar el reporte de receta
     * @param receta
     * @param paciente
     * @return 
     */
    public Result<String> generateReceta(RecetaVO receta, PacienteVO paciente){
        return report.generateReceta(receta, paciente);
    }
    
    /**
     * Metodo para generar reporte de Ultrasonido
     * @param reporteUltrasonicoVO
     * @return 
     */
    public Result<String> generateReporteUltrasonico(ReporteUltrasonicoVO reporteUltrasonicoVO){
        return report.generateReporteUltrasonico(reporteUltrasonicoVO);
    }
    
    /**
     * 
     * @param paciente
     * @param receta
     * @param historial
     * @return 
     */
    public Result<String> generateReportHistorial(PacienteVO paciente, RecetaVO receta, HistorialVO historial ){
        return report.generateReportHistorial(paciente, receta, historial);
    }
    
    public Result<String> generateAll(HistorialMtsData data){
        Result<String> resultReceta = report.generateReceta(data.getRecetaVO(), data.getPacienteVO());
        Result<String> resultUltraSonido = report.generateReporteUltrasonico(data.getReporteUltrasonicoVO());
        Result<String> resultHistorial = report.generateReportHistorial(data.getPacienteVO(), data.getRecetaVO(), data.getHistorialVO());
        
        String mensaje;
        
        mensaje = resultReceta.getMessage()  +"\n" +
                resultUltraSonido.getMessage() + "\n" +
                resultHistorial.getMessage();
        
        return new Result<>(true, mensaje, "ok");
    }
    
}
