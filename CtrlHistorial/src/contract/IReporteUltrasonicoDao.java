package contract;

import util.Result;
import vo.ReporteUltrasonicoVO;

import java.util.List;

/**
 * @author Alex
 */
public interface IReporteUltrasonicoDao {

    public Result<List<ReporteUltrasonicoVO>> findByAll();
    public Result<ReporteUltrasonicoVO> findById(ReporteUltrasonicoVO reporteUltrasonicoVO);
    public Result<ReporteUltrasonicoVO> add(ReporteUltrasonicoVO reporteUltrasonicoVO);
    public Result<ReporteUltrasonicoVO> update(ReporteUltrasonicoVO reporteUltrasonicoVO);
    public Result<ReporteUltrasonicoVO> delete(int id);

}
