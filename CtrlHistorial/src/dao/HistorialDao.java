package dao;

import contract.IHistorialDao;
import modelo.Conexion;
import util.ConsultorioMedicoConst;
import util.Result;
import vo.HistorialVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alex
 */
public class HistorialDao extends Conexion implements IHistorialDao {

    @Override
    public Result<List<HistorialVO>> findByAll() {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_historial, parecimiento_actual, dxs, plan_manejo FROM const_dts_historial");
            rs = ps.executeQuery();
            List<HistorialVO> historialVOList = new ArrayList<HistorialVO>();
            while (rs.next()) {
                HistorialVO historialVO = new HistorialVO();
                historialVO.setId(rs.getInt("id_historial"));
                historialVO.setParecimientoActual(rs.getString("parecimiento_actual"));
                historialVO.setDxs(rs.getString("dxs"));
                historialVO.setPlanManejo(rs.getString("plan_manejo"));
                historialVOList.add(historialVO);
            }
            return new Result<List<HistorialVO>>(true, ConsultorioMedicoConst.OK, historialVOList);
        } catch (SQLException ex) {
            Logger.getLogger(HistorialDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<List<HistorialVO>>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }

    }

    @Override
    public Result<HistorialVO> findById(int id) {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_historial, parecimiento_actual, dxs, plan_manejo FROM const_dts_historial " +
                    "WHERE id_historial = " + id );
            rs = ps.executeQuery();
            HistorialVO historialVO = null;
            while (rs.next()) {
                historialVO= new HistorialVO();
                historialVO.setId(rs.getInt("id_historial"));
                historialVO.setParecimientoActual(rs.getString("parecimiento_actual"));
                historialVO.setDxs(rs.getString("dxs"));
                historialVO.setPlanManejo(rs.getString("plan_manejo"));
            }
            return new Result<HistorialVO>(true, ConsultorioMedicoConst.OK, historialVO);
        } catch (SQLException ex) {
            Logger.getLogger(HistorialDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<HistorialVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<HistorialVO> add(HistorialVO historialVO) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "INSERT INTO const_dts_historial (parecimiento_actual, dxs, plan_manejo) " +
                "VALUES(?,?,?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, historialVO.getParecimientoActual());
            ps.setString(2, historialVO.getDxs());
            ps.setString(3, historialVO.getPlanManejo());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return new Result<HistorialVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }
            ResultSet generatedKeys = ps.getGeneratedKeys();
            int idGenerado = 0;
            if (generatedKeys.next()) {
                idGenerado = generatedKeys.getInt(1);
            }
            historialVO.setId(idGenerado);
            return new Result<HistorialVO>(true, ConsultorioMedicoConst.DB_REGISTRADO_CORRECTAMENTE, historialVO);
        } catch (SQLException ex) {
            Logger.getLogger(HistorialDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<HistorialVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<HistorialVO> update(HistorialVO historialVO) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "UPDATE  const_dts_historial SET parecimiento_actual = ?, dxs = ?, plan_manejo = ?" +
                    "WHERE id_historial = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, historialVO.getParecimientoActual());
            ps.setString(2, historialVO.getDxs());
            ps.setString(3, historialVO.getPlanManejo());
            ps.setInt(4, historialVO.getId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return new Result<HistorialVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }

            return new Result<HistorialVO>(true, ConsultorioMedicoConst.DB_ACTUALIZAR_CORRECTAMENTE, historialVO);
        } catch (SQLException ex) {
            Logger.getLogger(HistorialDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<HistorialVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<HistorialVO> delete(int id) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "DELETE from const_dts_historial  WHERE id_historial = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                return new Result<HistorialVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }

            return new Result<HistorialVO>(true, ConsultorioMedicoConst.DB_ELIMANDO_EXITOSAMENTE, null);
        } catch (SQLException ex) {
            Logger.getLogger(HistorialDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<HistorialVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }
}
