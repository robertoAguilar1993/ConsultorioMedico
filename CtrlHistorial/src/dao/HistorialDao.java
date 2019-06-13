package dao;

import contract.IHistorialDao;
import modelo.Conexion;
import util.Result;
import vo.HistorialVO;

import java.util.List;

/**
 * @author Alex
 */
public class HistorialDao extends Conexion implements IHistorialDao {

    @Override
    public Result<List<HistorialVO>> findByAll() {
        return null;
    }

    @Override
    public Result<HistorialVO> findById(HistorialVO historialVO) {
        return null;
    }

    @Override
    public Result<HistorialVO> add(HistorialVO historialVO) {
        return null;
    }

    @Override
    public Result<HistorialVO> update(HistorialVO historialVO) {
        return null;
    }

    @Override
    public Result<HistorialVO> delete(int id) {
        return null;
    }
}
