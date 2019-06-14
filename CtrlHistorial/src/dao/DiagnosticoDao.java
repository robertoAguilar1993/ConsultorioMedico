package dao;

import contract.IDiagnosticoDao;
import modelo.Conexion;
import util.ConsultorioMedicoConst;
import util.Result;
import vo.DiagnosticoVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alex
 */
public class DiagnosticoDao extends Conexion implements IDiagnosticoDao {
    @Override
    public Result<List<DiagnosticoVO>> findByAll() {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_diagnostico, diagnostico, tratamiento FROM const_dts_diagnostico");
            rs = ps.executeQuery();
            List<DiagnosticoVO> diagnosticoVOList = new ArrayList<DiagnosticoVO>();
            while (rs.next()) {
                DiagnosticoVO diagnosticoVO = new DiagnosticoVO();
                diagnosticoVO.setId(rs.getInt("id_diagnostico"));
                diagnosticoVO.setDiagnostico(rs.getString("diagnostico"));
                diagnosticoVO.setTratamiento(rs.getString("tratamiento"));
                diagnosticoVOList.add(diagnosticoVO);
            }
            return new Result<List<DiagnosticoVO>>(true, ConsultorioMedicoConst.OK, diagnosticoVOList);
        } catch (SQLException ex) {
            Logger.getLogger(DiagnosticoDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<List<DiagnosticoVO>>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<DiagnosticoVO> findById(int id) {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_diagnostico, diagnostico, tratamiento FROM const_dts_diagnostico " +
                    "WHERE id_diagnostico = " + id );
            rs = ps.executeQuery();
            DiagnosticoVO diagnosticoVO = null;
            while (rs.next()) {
                diagnosticoVO= new DiagnosticoVO();
                diagnosticoVO.setId(rs.getInt("id_diagnostico"));
                diagnosticoVO.setDiagnostico(rs.getString("diagnostico"));
                diagnosticoVO.setTratamiento(rs.getString("tratamiento"));
            }
            return new Result<DiagnosticoVO>(true, ConsultorioMedicoConst.OK, diagnosticoVO);
        } catch (SQLException ex) {
            Logger.getLogger(DiagnosticoDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<DiagnosticoVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<DiagnosticoVO> add(DiagnosticoVO diagnosticoVO) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "INSERT INTO const_dts_diagnostico (diagnostico, tratamiento) " +
                "VALUES(?,?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, diagnosticoVO.getDiagnostico());
            ps.setString(2, diagnosticoVO.getTratamiento());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return new Result<DiagnosticoVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }
            ResultSet generatedKeys = ps.getGeneratedKeys();
            int idGenerado = 0;
            if (generatedKeys.next()) {
                idGenerado = generatedKeys.getInt(1);
            }
            diagnosticoVO.setId(idGenerado);
            return new Result<DiagnosticoVO>(true, ConsultorioMedicoConst.DB_REGISTRADO_CORRECTAMENTE, diagnosticoVO);
        } catch (SQLException ex) {
            Logger.getLogger(DiagnosticoDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<DiagnosticoVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<DiagnosticoVO> update(DiagnosticoVO diagnosticoVO) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "UPDATE  const_dts_diagnostico SET diagnostico = ?, tratamiento = ? " +
                "WHERE id_diagnostico = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, diagnosticoVO.getDiagnostico());
            ps.setString(2, diagnosticoVO.getTratamiento());
            ps.setInt(3, diagnosticoVO.getId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return new Result<DiagnosticoVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }

            return new Result<DiagnosticoVO>(true, ConsultorioMedicoConst.DB_REGISTRADO_CORRECTAMENTE, diagnosticoVO);
        } catch (SQLException ex) {
            Logger.getLogger(DiagnosticoDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<DiagnosticoVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<DiagnosticoVO> delete(int id) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "DELETE from const_dts_diagnostico  WHERE id_diagnostico = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                return new Result<DiagnosticoVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }

            return new Result<DiagnosticoVO>(true, ConsultorioMedicoConst.DB_ELIMANDO_EXITOSAMENTE, null);
        } catch (SQLException ex) {
            Logger.getLogger(HistorialDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<DiagnosticoVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }
}
