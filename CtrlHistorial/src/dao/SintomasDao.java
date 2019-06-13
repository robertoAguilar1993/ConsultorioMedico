package dao;

import contract.ISintomasDao;
import modelo.Conexion;
import util.Result;
import vo.SintomasVO;

import java.util.List;

public class SintomasDao extends Conexion implements ISintomasDao {
    @Override
    public Result<List<SintomasVO>> findByAll() {
        return null;
    }

    @Override
    public Result<SintomasVO> findById(SintomasVO sintomasVO) {
        return null;
    }

    @Override
    public Result<SintomasVO> add(SintomasVO sintomasVO) {
        return null;
    }

    @Override
    public Result<SintomasVO> update(SintomasVO sintomasVO) {
        return null;
    }

    @Override
    public Result<SintomasVO> delete(int id) {
        return null;
    }
}
