package contract;

import util.Result;
import vo.RecetaVO;

import java.util.List;

/**
 * @author Alex
 */
public interface IRecetaDao {

    public Result<List<RecetaVO>> findByAll();
    public Result<RecetaVO> findById(int id);
    public Result<RecetaVO> add(RecetaVO recetaVO);
    public Result<RecetaVO> update(RecetaVO recetaVO);
    public Result<RecetaVO> delete(int id);

}
