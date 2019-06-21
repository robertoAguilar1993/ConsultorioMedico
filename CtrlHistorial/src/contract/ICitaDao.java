package contract;

import util.Result;
import vo.CitaVO;

import java.util.List;

public interface ICitaDao {

    public Result<List<CitaVO>> findByAll();
    public Result<List<CitaVO>> findByDate(String date);
    public Result<CitaVO> add(CitaVO citaVO);
    public Result<CitaVO> deleteByDateAndHour(String date, String hour);
}
