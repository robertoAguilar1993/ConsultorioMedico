/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import util.Result;
import vo.HistorialSintomasVO;
import vo.HistorialVO;
import vo.PacienteVO;
import vo.RecetaVO;
import vo.ReporteUltrasonicoVO;

/**
 *
 * @author apple
 */
public class GenerateReportBussines {
    
    GenerateReport report = new GenerateReport();
    public  final String pathImagenes = System.getProperty("user.dir") + "/src/imagenes/";
    
    /**
     * Metodo para generar el reporte de receta
     * @param receta
     * @param paciente
     * @return 
     */
    public Result<String> generateReceta(RecetaVO receta, PacienteVO paciente){
        
        String path = System.getProperty("user.dir") + "/src/Reportes/Receta.jasper";

        HashMap parametros = new HashMap();
        
        SimpleDateFormat formatoLargoEsMX = new SimpleDateFormat(
                "dd/MM/yyyy"
             );
        String fecha = formatoLargoEsMX.format( receta.getFecha());
        String proximaCita = receta.getFechaProximaCita() != null ?
                formatoLargoEsMX.format( receta.getFechaProximaCita()): "";
        
        
        parametros.put("nombre ", paciente.getNombre());
        parametros.put("apPat", paciente.getApellidoPaterno());
        parametros.put("apMate", paciente.getApellidoMaterno());
        parametros.put("edad", String.valueOf(new Date().getYear() - paciente.getFechaNacimiento().getYear()));
        parametros.put("peso", String.valueOf(receta.getPeso()));
        parametros.put("talla", String.valueOf(receta.getTalla()));
        parametros.put("tem", receta.getTemp());
        parametros.put("fc", receta.getFc());
        parametros.put("fr", receta.getFr());
        parametros.put("ta", receta.getTa());
        parametros.put("fecha", fecha);
        parametros.put("prox cita", proximaCita);
        parametros.put("rx", receta.getRx());
        parametros.put("imagenDir", pathImagenes);
        
        
        return report.create(path, parametros, "Receta");
    }
    
    /**
     * Metodo para generar reporte de Ultrasonido
     * @param reporteUltrasonicoVO
     * @return 
     */
    public Result<String> generateReporteUltrasonico(ReporteUltrasonicoVO reporteUltrasonicoVO){
        String path = System.getProperty("user.dir") + "/src/Reportes/Ultrasonido.jasper";
         //String path = "./Ultrasonido.jrxml";

        HashMap parametros = new HashMap();
        parametros.put("reporte", reporteUltrasonicoVO.getDescripcion());
        parametros.put("imagenDir", pathImagenes);
        return report.create(path, parametros, "Ultra sonido");
    }
    
    public Result<String> generateReportHistorial(PacienteVO paciente, RecetaVO receta, HistorialVO historial ){
        
        String path = System.getProperty("user.dir") + "/src/Reportes/historial_1.jasper";

        HashMap parametros = new HashMap();
        
        int edad = new Date().getYear() - paciente.getFechaNacimiento().getYear() ;
        
        String antecedentesImportantes  = "";

                
         for (HistorialSintomasVO historialSintomas: historial.
                        getHistorialSintomasVOList()) {
             antecedentesImportantes = antecedentesImportantes +  historialSintomas.getAntecedenteImportante() + "\n";
         }
         
         String telefono = paciente.getTelefono() != null && !"".equals(paciente.getTelefono()) ? 
                 paciente.getTelefono() : "";
         
         String ocupacion = paciente.getOcupacion() != null && !"".equals(paciente.getOcupacion()) ?
                 paciente.getOcupacion() : "";
        
        parametros.put("nombre", paciente.getNombre());
        parametros.put("mater", paciente.getApellidoMaterno());
        parametros.put("pater", paciente.getApellidoPaterno());
        
        parametros.put("domicilio", paciente.getDirecion());
        parametros.put("telefono", telefono);
        parametros.put("ocupacion", ocupacion);
        parametros.put("genero", paciente.getGenero());
        parametros.put("edad", String.valueOf(edad));
        parametros.put("peso", String.valueOf(receta.getPeso()));
        parametros.put("talla", String.valueOf(receta.getTalla()));
        parametros.put("temp", receta.getTemp());
        parametros.put("fc", receta.getFc());
        parametros.put("fr", receta.getFr());
        parametros.put("ta", receta.getTa());
        parametros.put("atecedentes ", antecedentesImportantes);
        parametros.put("actual", historial.getParecimientoActual());
        parametros.put("dxs", historial.getDxs());
        parametros.put("manejo", historial.getPlanManejo());
        parametros.put("imagenDir", pathImagenes);
        
        return report.create(path, parametros, "Historial");
    }

    
}
