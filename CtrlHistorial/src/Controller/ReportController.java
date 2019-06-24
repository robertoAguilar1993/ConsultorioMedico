package Controller;

import contract.IReporteDao;
import dao.ReporteDao;
import util.Result;
import vo.ReporteBody;

import java.util.List;

public class ReportController {

    IReporteDao reporteDao = new ReporteDao();

    public Result<List<ReporteBody>> findByDay(String date){
        return reporteDao.findByDay(date);
    }

    public Result<List<ReporteBody>> findByWeeks(String startDate , String endDate){
        return reporteDao.findByWeeks(startDate, endDate);
    }

    public Result<List<ReporteBody>> findByMonth(int month, int year){
        return reporteDao.findByMonth(month, year);
    }

    public Result<List<ReporteBody>> findByYear(int year){
        return reporteDao.findByYear(year);
    }
    
    /*public static void main(String[] args) {
        ReportController reportController = new ReportController();
        //Result<List<ReporteBody>> result = reportController.findByDay("2019-06-16");
        //Result<List<ReporteBody>> result = reportController.findByWeeks("2019-06-11", "2019-06-16");
        //Result<List<ReporteBody>> result = reportController.findByMonth(6, 2019);Result<List<ReporteBody>> result = reportController.findByMonth(6, 2019);
        Result<List<ReporteBody>> result = reportController.findByYear(2019);
        
        imprimir(result.getResult());
    }

    public static void imprimir(List<ReporteBody> reports){
        for (ReporteBody report: reports) {
            System.err.println(report.toString());
        }
    }*/
}
