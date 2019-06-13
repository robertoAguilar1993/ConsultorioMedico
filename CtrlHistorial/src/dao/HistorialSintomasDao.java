package dao;

import contract.IHistorialSintomasDao;
import modelo.Conexion;
import util.Result;
import vo.HistorialSintomasVO;

import java.util.List;

/**
 * @author beto
 */
public class HistorialSintomasDao extends Conexion implements IHistorialSintomasDao {


    @Override
    public Result<List<HistorialSintomasVO>> findByAll() {
        return null;
    }

    @Override
    public Result<HistorialSintomasVO> findById(HistorialSintomasVO historialSintomasVO) {
        return null;
    }

    @Override
    public Result<HistorialSintomasVO> add(HistorialSintomasVO historialSintomasVO) {
        return null;
    }

    @Override
    public Result<HistorialSintomasVO> update(HistorialSintomasVO historialSintomasVO) {
        return null;
    }

    @Override
    public Result<HistorialSintomasVO> delete(int id) {
        return null;
    }
}
