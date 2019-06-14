package dao;

import contract.IHistorialMtsDao;
import modelo.Conexion;
import util.ConsultorioMedicoConst;
import util.Result;
import vo.HistorialMtsVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author beto
 */
public class HistorialMtsDao extends Conexion implements IHistorialMtsDao {
    @Override
    public Result<List<HistorialMtsVO>> findByAll() {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_historial_mts, id_paciente, id_receta, id_historial, " +
                    "id_reporte_ultrasonico, id_diagnostico, fecha  FROM const_dts_historial_mts");
            rs = ps.executeQuery();
            List<HistorialMtsVO> historialMtsVOList = new ArrayList<HistorialMtsVO>();
            while (rs.next()) {
                HistorialMtsVO historialMtsVO = new HistorialMtsVO();
                historialMtsVO.setId(rs.getInt("id_historial_mts"));
                historialMtsVO.setIdPaciente(rs.getInt("id_paciente"));
                historialMtsVO.setIdReceta(rs.getInt("id_receta"));
                historialMtsVO.setIdHistorial(rs.getInt("id_historial"));
                historialMtsVO.setIdReporteUltrasonico(rs.getInt("id_reporte_ultrasonico"));
                historialMtsVO.setIdDiagnostico(rs.getInt("id_diagnostico"));
                historialMtsVO.setFecha(new java.util.Date(rs.getDate("fecha").getTime()));
                historialMtsVOList.add(historialMtsVO);
            }
            return new Result<List<HistorialMtsVO>>(true, ConsultorioMedicoConst.OK, historialMtsVOList);
        } catch (SQLException ex) {
            Logger.getLogger(HistorialMtsDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<List<HistorialMtsVO>>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<HistorialMtsVO> findById(int id) {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_historial_mts, id_paciente, id_receta, id_historial, " +
                    "id_reporte_ultrasonico, id_diagnostico, fecha  FROM const_dts_historial_mts " +
                    "WHERE id_historial_mts = " + id );
            rs = ps.executeQuery();
            HistorialMtsVO historialMtsVO = null;
            while (rs.next()) {
                historialMtsVO= new HistorialMtsVO();
                historialMtsVO.setId(rs.getInt("id_historial_mts"));
                historialMtsVO.setIdPaciente(rs.getInt("id_paciente"));
                historialMtsVO.setIdReceta(rs.getInt("id_receta"));
                historialMtsVO.setIdHistorial(rs.getInt("id_historial"));
                historialMtsVO.setIdReporteUltrasonico(rs.getInt("id_reporte_ultrasonico"));
                historialMtsVO.setIdDiagnostico(rs.getInt("id_diagnostico"));
                historialMtsVO.setFecha(new java.util.Date(rs.getDate("fecha").getTime()));
            }
            return new Result<HistorialMtsVO>(true, ConsultorioMedicoConst.OK, historialMtsVO);
        } catch (SQLException ex) {
            Logger.getLogger(HistorialDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<HistorialMtsVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<List<HistorialMtsVO>> findByIdPaciente(int id) {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_historial_mts, id_paciente, id_receta, id_historial, " +
                    "id_reporte_ultrasonico, id_diagnostico, fecha  FROM const_dts_historial_mts " +
                    "WHERE id_paciente = " + id );
            rs = ps.executeQuery();
            List<HistorialMtsVO> historialMtsVOList = new ArrayList<HistorialMtsVO>();
            while (rs.next()) {
                HistorialMtsVO historialMtsVO = new HistorialMtsVO();
                historialMtsVO.setId(rs.getInt("id_historial_mts"));
                historialMtsVO.setIdPaciente(rs.getInt("id_paciente"));
                historialMtsVO.setIdReceta(rs.getInt("id_receta"));
                historialMtsVO.setIdHistorial(rs.getInt("id_historial"));
                historialMtsVO.setIdReporteUltrasonico(rs.getInt("id_reporte_ultrasonico"));
                historialMtsVO.setIdDiagnostico(rs.getInt("id_diagnostico"));
                historialMtsVO.setFecha(new java.util.Date(rs.getDate("fecha").getTime()));
                historialMtsVOList.add(historialMtsVO);
            }
            return new Result<List<HistorialMtsVO>>(true, ConsultorioMedicoConst.OK, historialMtsVOList);
        } catch (SQLException ex) {
            Logger.getLogger(HistorialMtsDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<List<HistorialMtsVO>>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<HistorialMtsVO> add(HistorialMtsVO historialMtsVO) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "INSERT INTO const_dts_historial (id_paciente, id_receta, id_historial, id_reporte_ultrasonico, id_diagnostico, fecha) " +
                "VALUES(?,?,?,?,?,?)";
        try {

            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, historialMtsVO.getIdPaciente());
            ps.setInt(2, historialMtsVO.getIdReceta());
            ps.setInt(3, historialMtsVO.getIdHistorial());
            ps.setInt(4, historialMtsVO.getIdReporteUltrasonico());
            ps.setInt(5, historialMtsVO.getIdDiagnostico());
            ps.setDate(6, new java.sql.Date((historialMtsVO.getFecha().getTime())));

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return new Result<HistorialMtsVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }
            ResultSet generatedKeys = ps.getGeneratedKeys();
            int idGenerado = 0;
            if (generatedKeys.next()) {
                idGenerado = generatedKeys.getInt(1);
            }
            historialMtsVO.setId(idGenerado);
            return new Result<HistorialMtsVO>(true, ConsultorioMedicoConst.DB_REGISTRADO_CORRECTAMENTE, historialMtsVO);
        } catch (SQLException ex) {
            Logger.getLogger(HistorialDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<HistorialMtsVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<HistorialMtsVO> update(HistorialMtsVO historialMtsVO) {
        return null;
    }

    @Override
    public Result<HistorialMtsVO> delete(int id) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "DELETE from const_dts_historial  WHERE id_historial_mts = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                return new Result<HistorialMtsVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }

            return new Result<HistorialMtsVO>(true, ConsultorioMedicoConst.DB_ELIMANDO_EXITOSAMENTE, null);
        } catch (SQLException ex) {
            Logger.getLogger(HistorialDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<HistorialMtsVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<HistorialMtsVO> deleteByPaciente(int id) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "DELETE from const_dts_historial  WHERE id_paciente = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                return new Result<HistorialMtsVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }

            return new Result<HistorialMtsVO>(true, ConsultorioMedicoConst.DB_ELIMANDO_EXITOSAMENTE, null);
        } catch (SQLException ex) {
            Logger.getLogger(HistorialDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<HistorialMtsVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }
}
