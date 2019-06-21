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

}
