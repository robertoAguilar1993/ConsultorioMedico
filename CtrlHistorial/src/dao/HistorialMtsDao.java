package dao;

import contract.IHistorialMtsDao;
import modelo.Conexion;
import util.Result;
import vo.HistorialMtsVO;

import java.util.List;

/**
 * @author beto
 */
public class HistorialMtsDao extends Conexion implements IHistorialMtsDao {
    @Override
    public Result<List<HistorialMtsVO>> findByAll() {
        return null;
    }

    @Override
    public Result<HistorialMtsVO> findById(HistorialMtsVO historialMtsVO) {
        return null;
    }

    @Override
    public Result<HistorialMtsVO> add(HistorialMtsVO historialMtsVO) {
        return null;
    }

    @Override
    public Result<HistorialMtsVO> update(HistorialMtsVO historialMtsVO) {
        return null;
    }

    @Override
    public Result<HistorialMtsVO> delete(int id) {
        return null;
    }
}
