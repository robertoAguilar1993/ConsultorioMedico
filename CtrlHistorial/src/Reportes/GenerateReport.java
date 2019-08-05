/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import util.Result;

/**
 *
 * @author apple
 */
public class GenerateReport {
    
    public Result<String> create(String path, HashMap parametros, String typeReport){       
        System.err.println(path);
        System.err.println(parametros);
        System.err.println(typeReport);
        try{
            JasperPrint reporte = JasperFillManager.fillReport(
                    path,
                    parametros ,
                    new JREmptyDataSource()
            ); 
            reporte.setName(typeReport);
            JasperViewer.viewReport(reporte, false);
            return new Result<>(true, "Se ha generado correctamente el reporte de "+ typeReport, "ok");
        }catch(Exception e){
            e.printStackTrace();
            return new Result<>(false, "Ha ocurrido un error al generar el reporte de " + typeReport, null);
        }
    }
}
