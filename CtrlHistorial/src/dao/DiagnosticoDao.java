package dao;

import contract.IDiagnosticoDao;
import modelo.Conexion;
import util.Result;
import vo.DiagnosticoVO;

import java.util.List;

/**
 * @author Alex
 */
public class DiagnosticoDao extends Conexion implements IDiagnosticoDao {
    @Override
    public Result<List<DiagnosticoVO>> findByAll() {
        return null;
    }

    @Override
    public Result<DiagnosticoVO> findById(DiagnosticoVO diagnosticoVO) {
        return null;
    }

    @Override
    public Result<DiagnosticoVO> add(DiagnosticoVO diagnosticoVO) {
        return null;
    }

    @Override
    public Result<DiagnosticoVO> update(DiagnosticoVO diagnosticoVO) {
        return null;
    }

    @Override
    public Result<DiagnosticoVO> delete(int id) {
        return null;
    }
}
