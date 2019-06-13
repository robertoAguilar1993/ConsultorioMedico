package dao;

import contract.IReporteUltrasonicoDao;
import modelo.Conexion;
import util.Result;
import vo.ReporteUltrasonicoVO;

import java.util.List;

public class ReporteUltrasonicoDao extends Conexion implements IReporteUltrasonicoDao {

    @Override
    public Result<List<ReporteUltrasonicoVO>> findByAll() {
        return null;
    }

    @Override
    public Result<ReporteUltrasonicoVO> findById(ReporteUltrasonicoVO reporteUltrasonicoVO) {
        return null;
    }

    @Override
    public Result<ReporteUltrasonicoVO> add(ReporteUltrasonicoVO reporteUltrasonicoVO) {
        return null;
    }

    @Override
    public Result<ReporteUltrasonicoVO> update(ReporteUltrasonicoVO reporteUltrasonicoVO) {
        return null;
    }

    @Override
    public Result<ReporteUltrasonicoVO> delete(int id) {
        return null;
    }
}
