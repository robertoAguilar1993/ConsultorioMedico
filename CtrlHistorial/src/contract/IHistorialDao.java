package contract;

import util.Result;
import vo.HistorialVO;

import java.util.List;

/**
 * @author Alex
 */
public interface IHistorialDao {
    public Result<List<HistorialVO>> findByAll();
    public Result<HistorialVO> findById(int id);
    public Result<HistorialVO> add(HistorialVO historialVO);
    public Result<HistorialVO> update(HistorialVO historialVO);
    public Result<HistorialVO> delete(int id);
}
