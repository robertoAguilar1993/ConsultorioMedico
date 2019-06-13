package dao;

import contract.IRecetaDao;
import modelo.Conexion;
import util.Result;
import vo.RecetaVO;

import java.util.List;

/**
 * @author beto
 */
public class RecetaDao extends Conexion implements IRecetaDao {


    @Override
    public Result<List<RecetaVO>> findByAll() {
        return null;
    }

    @Override
    public Result<RecetaVO> findById(RecetaVO recetaVO) {
        return null;
    }

    @Override
    public Result<RecetaVO> add(RecetaVO recetaVO) {
        return null;
    }

    @Override
    public Result<RecetaVO> update(RecetaVO recetaVO) {
        return null;
    }

    @Override
    public Result<RecetaVO> delete(int id) {
        return null;
    }
}
