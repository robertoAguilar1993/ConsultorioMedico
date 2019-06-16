package dao;

import contract.IReporteUltrasonicoDao;
import modelo.Conexion;
import util.ConsultorioMedicoConst;
import util.Result;
import vo.ReporteUltrasonicoVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReporteUltrasonicoDao extends Conexion implements IReporteUltrasonicoDao {

    @Override
    public Result<List<ReporteUltrasonicoVO>> findByAll() {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_reporte_ultrasonico, descripcion FROM const_dts_reporte_ultrasonico");
            rs = ps.executeQuery();
            List<ReporteUltrasonicoVO> reporteUltrasonicoVOList = new ArrayList<ReporteUltrasonicoVO>();
            while (rs.next()) {
                ReporteUltrasonicoVO reporteUltrasonicoVO = new ReporteUltrasonicoVO();
                reporteUltrasonicoVO.setId(rs.getInt("id_reporte_ultrasonico"));
                reporteUltrasonicoVO.setDescripcion(rs.getString("descripcion"));
                reporteUltrasonicoVOList.add(reporteUltrasonicoVO);
            }
            return new Result<List<ReporteUltrasonicoVO>>(true, ConsultorioMedicoConst.OK, reporteUltrasonicoVOList);
        } catch (SQLException ex) {
            Logger.getLogger(ReporteUltrasonicoDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<List<ReporteUltrasonicoVO>>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<ReporteUltrasonicoVO> findById(int id) {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_reporte_ultrasonico, descripcion FROM const_dts_reporte_ultrasonico " +
                    "WHERE id_reporte_ultrasonico = " + id );
            rs = ps.executeQuery();
            ReporteUltrasonicoVO reporteUltrasonicoVO = null;
            while (rs.next()) {
                reporteUltrasonicoVO= new ReporteUltrasonicoVO();
                reporteUltrasonicoVO.setId(rs.getInt("id_reporte_ultrasonico"));
                reporteUltrasonicoVO.setDescripcion(rs.getString("descripcion"));
            }
            return new Result<ReporteUltrasonicoVO>(true, ConsultorioMedicoConst.OK, reporteUltrasonicoVO);
        } catch (SQLException ex) {
            Logger.getLogger(ReporteUltrasonicoDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<ReporteUltrasonicoVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<ReporteUltrasonicoVO> add(ReporteUltrasonicoVO reporteUltrasonicoVO) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "INSERT INTO const_dts_reporte_ultrasonico (descripcion ) " +
                "VALUES(?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, reporteUltrasonicoVO.getDescripcion());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return new Result<ReporteUltrasonicoVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }
            ResultSet generatedKeys = ps.getGeneratedKeys();
            int idGenerado = 0;
            if (generatedKeys.next()) {
                idGenerado = generatedKeys.getInt(1);
            }
            reporteUltrasonicoVO.setId(idGenerado);
            return new Result<ReporteUltrasonicoVO>(true, ConsultorioMedicoConst.DB_REGISTRADO_CORRECTAMENTE, reporteUltrasonicoVO);
        } catch (SQLException ex) {
            Logger.getLogger(ReporteUltrasonicoDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<ReporteUltrasonicoVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<ReporteUltrasonicoVO> update(ReporteUltrasonicoVO reporteUltrasonicoVO) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "UPDATE  const_dts_reporte_ultrasonico SET descripcion = ? " +
                "WHERE id_reporte_ultrasonico = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, reporteUltrasonicoVO.getDescripcion());
            ps.setInt(2, reporteUltrasonicoVO.getId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return new Result<ReporteUltrasonicoVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }

            return new Result<ReporteUltrasonicoVO>(true, ConsultorioMedicoConst.DB_REGISTRADO_CORRECTAMENTE, reporteUltrasonicoVO);
        } catch (SQLException ex) {
            Logger.getLogger(ReporteUltrasonicoDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<ReporteUltrasonicoVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<ReporteUltrasonicoVO> delete(int id) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "DELETE from const_dts_reporte_ultrasonico  WHERE id_reporte_ultrasonico = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                return new Result<ReporteUltrasonicoVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }

            return new Result<ReporteUltrasonicoVO>(true, ConsultorioMedicoConst.DB_ELIMANDO_EXITOSAMENTE, null);
        } catch (SQLException ex) {
            Logger.getLogger(ReporteUltrasonicoDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<ReporteUltrasonicoVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }
}
