package Controller;

import contract.*;
import dao.*;
import java.util.List;
import util.ConsultorioMedicoConst;
import util.Result;
import vo.*;

/**
 * @author Alex
 */
public class HistorialPacienteController {

    IRecetaDao recetaDao = new RecetaDao();
    IHistorialDao historialDao = new HistorialDao();
    IHistorialSintomasDao historialSintomasDao = new HistorialSintomasDao();
    IReporteUltrasonicoDao reporteUltrasonicoDao = new ReporteUltrasonicoDao();
    IHistorialMtsDao historialMtsDao = new HistorialMtsDao();
    ISintomasDao sintomasDao = new SintomasDao();
    
    @SuppressWarnings("Convert2Diamond")
    public Result<HistorialMtsData> getHistorialPaciente(HistorialMtsVO historialMtsVO){
        HistorialMtsData historialMtsData = new HistorialMtsData();
        Result<RecetaVO> recetaVOResult =recetaDao.findById(historialMtsVO.getIdReceta());
        Result<HistorialVO> historialVOResult = historialDao.findById(historialMtsVO.getIdHistorial());
        Result<List<HistorialSintomasVO>> historialSintomasVOResult= 
                historialSintomasDao.findByIdHistorial(historialMtsVO.getIdHistorial());
        historialVOResult.getResult().setHistorialSintomasVOList(historialSintomasVOResult.getResult());
        Result<ReporteUltrasonicoVO> ultrasonicoVOResult=  
                reporteUltrasonicoDao.findById(historialMtsVO.getIdReporteUltrasonico());
        Result<List<SintomasVO>> sintomasVOResult = 
                sintomasDao.findByIdHistorialMts(historialMtsVO.getId());
        

        historialMtsData.setRecetaVO(recetaVOResult.getResult());
        historialMtsData.setHistorialVO(historialVOResult.getResult());
        historialMtsData.setReporteUltrasonicoVO(ultrasonicoVOResult.getResult());
        historialMtsData.setSintomasVOList(sintomasVOResult.getResult());

        
        
        return new Result<HistorialMtsData> (true,ConsultorioMedicoConst.OK ,historialMtsData);
    }
    
    public Result<List<HistorialMtsVO>> getHistorialPacienteByIdPaciente(int id){
        return historialMtsDao.findByIdPaciente(id);
    }

    @SuppressWarnings("Convert2Diamond")
    public Result<HistorialMtsData> add(HistorialMtsData historialMtsData){

        System.out.println("Inicia el proceso de guardar los datos de la receta");
        Result<RecetaVO> recetaVOResult =recetaDao.add(historialMtsData.getRecetaVO());
        System.out.println(recetaVOResult.toString());
        System.out.println("fin del proceso de guardar los datos de la receta");


        System.out.println("Inicial el proceso de guardar los datos del historial");
        Result<HistorialVO> historialVOResult = historialDao.add(historialMtsData.getHistorialVO());
        System.out.println(historialVOResult.toString());
        System.out.println("fin del proceso de guardar los datos del historial");

        System.out.println("Inicial el proceso de guardar el historial de sintomas");
        for(HistorialSintomasVO historialSintomasVO: 
                historialMtsData.getHistorialVO().getHistorialSintomasVOList()){
            historialSintomasVO.setIdHistorial(historialMtsData.getHistorialVO().getId());
            historialSintomasVO.setIdPaciente(historialMtsData.getIdPaciente());
            Result<HistorialSintomasVO> historialSintomasVOResult= historialSintomasDao.add(historialSintomasVO);
            System.out.println(historialSintomasVOResult.toString());
        }
        System.out.println("fin del proceso de guardar el historial de sintomas");


        System.out.println("Inicia el proceso de guardar el reporte de ultrasonido");
        Result<ReporteUltrasonicoVO> ultrasonicoVOResult=  reporteUltrasonicoDao.add(historialMtsData.getReporteUltrasonicoVO());
        System.out.println(ultrasonicoVOResult.toString());
        System.out.println("fin del proceso de guardar el reporte de ultrasonido");


        System.out.println("Inicial el proceso de guardar El historial del paciente en la tabla maestra");
        
        HistorialMtsVO historialMtsVO = new HistorialMtsVO();
        historialMtsVO.setIdPaciente(historialMtsData.getIdPaciente());
        historialMtsVO.setIdReceta(historialMtsData.getRecetaVO().getId());
        historialMtsVO.setIdHistorial(historialMtsData.getHistorialVO().getId());
        historialMtsVO.setIdReporteUltrasonico(historialMtsData.getReporteUltrasonicoVO().getId());
        historialMtsVO.setFecha(historialMtsData.getDate());
        Result<HistorialMtsVO> historialMtsVOResult = historialMtsDao.add(historialMtsVO);
        historialMtsData.setId(historialMtsVO.getId());
        System.out.println(historialMtsVOResult.toString());
        System.out.println("fin del proceso de guardar El historial del paciente en la tabla maestra");


        System.out.println("Inicial el proceso de guardar los sintomas");
        String sintomas = "";
        for(SintomasVO sintomasVO: historialMtsData.getSintomasVOList()){
            sintomasVO.setIdHistorialMts(historialMtsVO.getId());
            Result<SintomasVO> sintomasVOResult = sintomasDao.add(sintomasVO);
            sintomas = sintomasVOResult.getMessage();
            System.out.println(sintomasVOResult.toString());
        }
        System.out.println("fin el proceso de guardar los sintomas");
        System.out.println("Data final del historial");
        System.out.println(historialMtsData.toString());
        
        String mensage = 
                "Sintomas del paciente--->" + sintomas +
                "\nReceta medica----------->" + recetaVOResult.getMessage() +
                "\nHistorial--------------->" + historialMtsVOResult.getMessage()+
                "\nReporte de Ultrasonido-->" + ultrasonicoVOResult.getMessage();
        return new Result<HistorialMtsData>(true, mensage, historialMtsData);
    }

    public Result<HistorialMtsData> update(HistorialMtsData historialMtsData){
        System.out.println("Inicia el proceso de Actualizar los datos de la receta");
        Result<RecetaVO> recetaVOResult =recetaDao.update(historialMtsData.getRecetaVO());
        System.out.println(recetaVOResult.toString());
        System.out.println("fin del proceso de Actualizar los datos de la receta");
        
        System.out.println("Inicial el proceso de Actualizar los datos del historial");
        Result<HistorialVO> historialVOResult = historialDao.update(historialMtsData.getHistorialVO());
        System.out.println(historialVOResult.toString());
        System.out.println("fin del proceso de Actualizar los datos del historial");
        
        
        System.out.println("Inicial el proceso de Eliminar el historial de sintomas");
        historialSintomasDao.deleteByHistorial(historialMtsData.getId());
        System.out.println("Inicial el proceso de Agregar el historial de sintomas");
        for(HistorialSintomasVO historialSintomasVO: 
                historialMtsData.getHistorialVO().getHistorialSintomasVOList()){
            historialSintomasVO.setIdHistorial(historialMtsData.getId());
            historialSintomasVO.setIdPaciente(historialMtsData.getIdPaciente());
            Result<HistorialSintomasVO> historialSintomasVOResult= historialSintomasDao.add(historialSintomasVO);
            System.out.println(historialSintomasVOResult.toString());
        }
        System.out.println("fin del proceso de guardar el historial de sintomas");
        
        
        System.out.println("Inicia el proceso de Actualizar el reporte de ultrasonido");
        
        Result<ReporteUltrasonicoVO> ultrasonicoVOResult=  reporteUltrasonicoDao.update(historialMtsData.getReporteUltrasonicoVO());
        System.out.println(ultrasonicoVOResult.toString());
        System.out.println("fin del proceso de Actualizar el reporte de ultrasonido");


        
        System.out.println("Inicial el proceso para eliminar  los sintomas");
        sintomasDao.deleteByIdHistorialMts(historialMtsData.getId());
        System.out.println("Inicial el proceso de guardar los sintomas");
        String sintomas = "";
        for(SintomasVO sintomasVO: historialMtsData.getSintomasVOList()){
            sintomasVO.setIdHistorialMts(historialMtsData.getId());
            Result<SintomasVO> sintomasVOResult = sintomasDao.add(sintomasVO);
            sintomas = sintomasVOResult.getMessage();
            System.out.println(sintomasVOResult.toString());
        }
        System.out.println("fin el proceso de guardar los sintomas");
        System.out.println("Data final del historial");
        System.out.println(historialMtsData.toString());
        String mensage = 
                "Sintomas del paciente--->" + sintomas +
                "\nReceta medica----------->" + recetaVOResult.getMessage() +
                "\nHistorial--------------->" + historialVOResult.getMessage()+
                "\nReporte de Ultrasonido-->" + ultrasonicoVOResult.getMessage();
        return new Result<HistorialMtsData> (true, mensage, historialMtsData);
    }

    public Result<List<HistorialMtsVO>> delete(int idPacinete){
        
        Result<List<HistorialMtsVO>> result = getHistorialPacienteByIdPaciente(idPacinete);
        
        
        if (result.isOperationStatus()) {
            for(HistorialMtsVO historialMtsVO: result.getResult()){
                Result<RecetaVO> recetaVOResult = recetaDao.delete(historialMtsVO.getIdReceta());
                Result<HistorialVO> historialVOResult = historialDao.delete(historialMtsVO.getIdHistorial());
                Result<HistorialSintomasVO> HistorialSintomasResult =historialSintomasDao.deleteByHistorial(historialMtsVO.getIdHistorial());
                Result<ReporteUltrasonicoVO> ultrasonicoVOResult=  reporteUltrasonicoDao.delete(historialMtsVO.getIdReporteUltrasonico());
                Result<SintomasVO> sintomasVOResult = sintomasDao.deleteByIdHistorialMts(historialMtsVO.getId());
            }
            Result<HistorialMtsVO> historialMtsVOResult = historialMtsDao.deleteByPaciente(idPacinete);

        }else {
            return new Result<List<HistorialMtsVO>>(false, result.getMessage(), result.getResult());
        }
        
        return new Result<List<HistorialMtsVO>>(true, "Hitorial del paciente eliminado con exito", result.getResult());
    }

}
