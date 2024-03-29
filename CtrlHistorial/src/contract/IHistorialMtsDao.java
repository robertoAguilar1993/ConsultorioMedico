package contract;

import util.Result;
import vo.HistorialMtsVO;

import java.util.List;

/**
 * @author Alex
 */
public interface IHistorialMtsDao {

    public Result<List<HistorialMtsVO>> findByAll();
    public Result<HistorialMtsVO> findById(int id);
    public Result<List<HistorialMtsVO>> findByIdPaciente(int id);
    public Result<HistorialMtsVO> add(HistorialMtsVO historialMtsVO);
    public Result<HistorialMtsVO> update(HistorialMtsVO historialMtsVO);
    public Result<HistorialMtsVO> delete(int id);
    public Result<HistorialMtsVO> deleteByPaciente(int id);

}
