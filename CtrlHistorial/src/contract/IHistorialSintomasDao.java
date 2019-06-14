package contract;

import util.Result;
import vo.HistorialSintomasVO;

import java.util.List;

/**
 * @author Alex
 */
public interface IHistorialSintomasDao {
    public Result<List<HistorialSintomasVO>> findByAll();
    public Result<List<HistorialSintomasVO>> findByIdHistorial(int idHistorial);
    public Result<HistorialSintomasVO> add(HistorialSintomasVO historialSintomasVO);
    public Result<HistorialSintomasVO> update(HistorialSintomasVO historialSintomasVO);
    public Result<HistorialSintomasVO> deleteByHistorial(int idHistorial);
}
