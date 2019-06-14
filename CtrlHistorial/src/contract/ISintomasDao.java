package contract;

import util.Result;
import vo.SintomasVO;

import java.util.List;

public interface ISintomasDao {

    public Result<List<SintomasVO>> findByAll();
    public Result<SintomasVO> findById(int id);
    public Result<List<SintomasVO>> findByIdHistorialMts(int id);
    public Result<SintomasVO> add(SintomasVO sintomasVO);
    public Result<SintomasVO> update(SintomasVO sintomasVO);
    public Result<SintomasVO> delete(int id);
    public Result<SintomasVO> deleteByIdHistorialMts(int id);

}
