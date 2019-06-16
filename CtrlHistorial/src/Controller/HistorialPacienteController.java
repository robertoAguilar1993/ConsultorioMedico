package Controller;

import contract.*;
import dao.*;
import java.util.List;
import util.ConsultorioMedicoConst;
import util.Result;
import vo.*;

/**
 * @author beto
 */
public class HistorialPacienteController {

    @SuppressWarnings("Convert2Diamond")
    public Result<HistorialMtsData> getHistorialPaciente(HistorialMtsVO historialMtsVO){
        HistorialMtsData historialMtsData = new HistorialMtsData();
        IRecetaDao recetaDao = new RecetaDao();
        Result<RecetaVO> recetaVOResult =recetaDao.findById(historialMtsVO.getIdReceta());
        IHistorialDao historialDao = new HistorialDao();
        Result<HistorialVO> historialVOResult = historialDao.findById(historialMtsVO.getIdHistorial());
        IHistorialSintomasDao historialSintomasDao = new HistorialSintomasDao();
        Result<List<HistorialSintomasVO>> historialSintomasVOResult= 
                historialSintomasDao.findByIdHistorial(historialMtsVO.getIdHistorial());
        historialVOResult.getResult().setHistorialSintomasVOList(historialSintomasVOResult.getResult());
        IReporteUltrasonicoDao reporteUltrasonicoDao = new ReporteUltrasonicoDao();
        Result<ReporteUltrasonicoVO> ultrasonicoVOResult=  
                reporteUltrasonicoDao.findById(historialMtsVO.getIdReporteUltrasonico());
        IDiagnosticoDao diagnosticoDao = new DiagnosticoDao();
        Result<DiagnosticoVO> diagnosticoVOResult = 
                diagnosticoDao.findById(historialMtsVO.getIdDiagnostico());
        ISintomasDao sintomasDao = new SintomasDao();
        Result<List<SintomasVO>> sintomasVOResult = 
                sintomasDao.findByIdHistorialMts(historialMtsVO.getId());
        

        historialMtsData.setRecetaVO(recetaVOResult.getResult());
        historialMtsData.setHistorialVO(historialVOResult.getResult());
        historialMtsData.setReporteUltrasonicoVO(ultrasonicoVOResult.getResult());
        historialMtsData.setDiagnosticoVO(diagnosticoVOResult.getResult());
        historialMtsData.setSintomasVOList(sintomasVOResult.getResult());

        return new Result<HistorialMtsData> (true,ConsultorioMedicoConst.OK ,historialMtsData);
    }
    
    public Result<List<HistorialMtsVO>> getHistorialPacienteByIdPaciente(int id){
        IHistorialMtsDao historialMtsDao = new HistorialMtsDao();
        return historialMtsDao.findByIdPaciente(id);
    }

    @SuppressWarnings("Convert2Diamond")
    public Result<HistorialMtsData> add(HistorialMtsData historialMtsData){

        System.out.println("Inicia el proceso de guardar los datos de la receta");
        IRecetaDao recetaDao = new RecetaDao();
        Result<RecetaVO> recetaVOResult =recetaDao.add(historialMtsData.getRecetaVO());
        System.out.println(recetaVOResult.toString());
        System.out.println("fin del proceso de guardar los datos de la receta");


        System.out.println("Inicial el proceso de guardar los datos del historial");
        IHistorialDao historialDao = new HistorialDao();
        Result<HistorialVO> historialVOResult = historialDao.add(historialMtsData.getHistorialVO());
        System.out.println(historialVOResult.toString());
        System.out.println("fin del proceso de guardar los datos del historial");

        System.out.println("Inicial el proceso de guardar el historial de sintomas");
        IHistorialSintomasDao historialSintomasDao = new HistorialSintomasDao();
        for(HistorialSintomasVO historialSintomasVO: 
                historialMtsData.getHistorialVO().getHistorialSintomasVOList()){
            historialSintomasVO.setIdHistorial(historialMtsData.getHistorialVO().getId());
            historialSintomasVO.setIdPaciente(historialMtsData.getIdPaciente());
            Result<HistorialSintomasVO> historialSintomasVOResult= historialSintomasDao.add(historialSintomasVO);
            System.out.println(historialSintomasVOResult.toString());
        }
        System.out.println("fin del proceso de guardar el historial de sintomas");


        System.out.println("Inicia el proceso de guardar el reporte de ultrasonido");
        IReporteUltrasonicoDao reporteUltrasonicoDao = new ReporteUltrasonicoDao();
        Result<ReporteUltrasonicoVO> ultrasonicoVOResult=  reporteUltrasonicoDao.add(historialMtsData.getReporteUltrasonicoVO());
        System.out.println(ultrasonicoVOResult.toString());
        System.out.println("fin del proceso de guardar el reporte de ultrasonido");


        System.out.println("Inicial el proceso de guardar el diagnostico");
        IDiagnosticoDao diagnosticoDao = new DiagnosticoDao();
        Result<DiagnosticoVO> diagnosticoVOResult = diagnosticoDao.add(historialMtsData.getDiagnosticoVO());
        System.out.println(diagnosticoVOResult.toString());
        System.out.println("fin del proceso de guardar el diagnostico");

        System.out.println("Inicial el proceso de guardar El historial del paciente en la tabla maestra");
        IHistorialMtsDao historialMtsDao = new HistorialMtsDao();
        HistorialMtsVO historialMtsVO = new HistorialMtsVO();
        historialMtsVO.setIdPaciente(historialMtsData.getIdPaciente());
        historialMtsVO.setIdReceta(historialMtsData.getRecetaVO().getId());
        historialMtsVO.setIdHistorial(historialMtsData.getHistorialVO().getId());
        historialMtsVO.setIdReporteUltrasonico(historialMtsData.getReporteUltrasonicoVO().getId());
        historialMtsVO.setIdDiagnostico(historialMtsData.getDiagnosticoVO().getId());
        historialMtsVO.setFecha(historialMtsData.getDate());
        Result<HistorialMtsVO> historialMtsVOResult = historialMtsDao.add(historialMtsVO);
        System.out.println(historialMtsVOResult.toString());
        System.out.println("fin del proceso de guardar El historial del paciente en la tabla maestra");


        System.out.println("Inicial el proceso de guardar los sintomas");
        ISintomasDao sintomasDao = new SintomasDao();
        for(SintomasVO sintomasVO: historialMtsData.getSintomasVOList()){
            sintomasVO.setIdHistorialMts(historialMtsVO.getId());
            Result<SintomasVO> sintomasVOResult = sintomasDao.add(sintomasVO);
            System.out.println(sintomasVOResult.toString());
        }
        System.out.println("fin el proceso de guardar los sintomas");
        System.out.println("Data final del historial");
        System.out.println(historialMtsData.toString());

        return new Result<HistorialMtsData>(true, ConsultorioMedicoConst.OK, historialMtsData);
    }

    public Result<HistorialMtsData> update(HistorialMtsData historialMtsData){
        System.out.println("Inicia el proceso de Actualizar los datos de la receta");
        IRecetaDao recetaDao = new RecetaDao();
        Result<RecetaVO> recetaVOResult =recetaDao.update(historialMtsData.getRecetaVO());
        System.out.println(recetaVOResult.toString());
        System.out.println("fin del proceso de Actualizar los datos de la receta");
        
        System.out.println("Inicial el proceso de Actualizar los datos del historial");
        IHistorialDao historialDao = new HistorialDao();
        Result<HistorialVO> historialVOResult = historialDao.update(historialMtsData.getHistorialVO());
        System.out.println(historialVOResult.toString());
        System.out.println("fin del proceso de Actualizar los datos del historial");
        
        
        IHistorialSintomasDao historialSintomasDao = new HistorialSintomasDao();
        System.out.println("Inicial el proceso de Eliminar el historial de sintomas");
        historialSintomasDao.deleteByHistorial(historialMtsData.getHistorialVO().getId());
        System.out.println("Inicial el proceso de Agregar el historial de sintomas");
        for(HistorialSintomasVO historialSintomasVO: 
                historialMtsData.getHistorialVO().getHistorialSintomasVOList()){
            historialSintomasVO.setIdHistorial(historialMtsData.getHistorialVO().getId());
            historialSintomasVO.setIdPaciente(historialMtsData.getIdPaciente());
            Result<HistorialSintomasVO> historialSintomasVOResult= historialSintomasDao.add(historialSintomasVO);
            System.out.println(historialSintomasVOResult.toString());
        }
        System.out.println("fin del proceso de guardar el historial de sintomas");
        
        
        System.out.println("Inicia el proceso de Actualizar el reporte de ultrasonido");
        IReporteUltrasonicoDao reporteUltrasonicoDao = new ReporteUltrasonicoDao();
        Result<ReporteUltrasonicoVO> ultrasonicoVOResult=  reporteUltrasonicoDao.add(historialMtsData.getReporteUltrasonicoVO());
        System.out.println(ultrasonicoVOResult.toString());
        System.out.println("fin del proceso de Actualizar el reporte de ultrasonido");

        System.out.println("Inicial el proceso de Actualizar el diagnostico");
        IDiagnosticoDao diagnosticoDao = new DiagnosticoDao();
        Result<DiagnosticoVO> diagnosticoVOResult = diagnosticoDao.add(historialMtsData.getDiagnosticoVO());
        System.out.println(diagnosticoVOResult.toString());
        System.out.println("fin del proceso de Actualizar el diagnostico");
        
        
        ISintomasDao sintomasDao = new SintomasDao();
        System.out.println("Inicial el proceso para eliminar  los sintomas");
        sintomasDao.deleteByIdHistorialMts(historialMtsData.getHistorialVO().getId());
        System.out.println("Inicial el proceso de guardar los sintomas");
        sintomasDao.deleteByIdHistorialMts(historialMtsData.getHistorialVO().getId());
        for(SintomasVO sintomasVO: historialMtsData.getSintomasVOList()){
            sintomasVO.setIdHistorialMts(historialMtsData.getHistorialVO().getId());
            Result<SintomasVO> sintomasVOResult = sintomasDao.add(sintomasVO);
            System.out.println(sintomasVOResult.toString());
        }
        System.out.println("fin el proceso de guardar los sintomas");
        System.out.println("Data final del historial");
        System.out.println(historialMtsData.toString());
        return new Result<HistorialMtsData> (true, ConsultorioMedicoConst.OK, historialMtsData);
    }

    public Result<HistorialMtsData> delete(HistorialMtsVO historialMtsVO){
        return null;
    }

}
