package contract;

import util.Result;
import vo.HistorialMtsVO;

import java.util.List;

/**
 * @author beto
 */
public interface IHistorialMtsDao {

    public Result<List<HistorialMtsVO>> findByAll();
    public Result<HistorialMtsVO> findById(HistorialMtsVO historialMtsVO);
    public Result<HistorialMtsVO> add(HistorialMtsVO historialMtsVO);
    public Result<HistorialMtsVO> update(HistorialMtsVO historialMtsVO);
    public Result<HistorialMtsVO> delete(int id);

}
