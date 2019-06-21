package contract;

import util.Result;
import vo.ReporteBody;

import java.util.List;

public interface IReporteDao {

    public Result<List<ReporteBody>> findByDay(String date);
    public Result<List<ReporteBody>> findByWeeks(String startDate , String endDate);
    public Result<List<ReporteBody>> findByMonth(int month, int year);
    public Result<List<ReporteBody>> findByYear(int year);

}
