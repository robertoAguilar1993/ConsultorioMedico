package dao;

import contract.ISintomasDao;
import modelo.Conexion;
import util.ConsultorioMedicoConst;
import util.Result;
import vo.SintomasVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SintomasDao extends Conexion implements ISintomasDao {
    @Override
    public Result<List<SintomasVO>> findByAll() {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_sintoma, id_historial_mts, sintomas  FROM const_dts_sintomas");
            rs = ps.executeQuery();
            List<SintomasVO> sintomasVOList = new ArrayList<SintomasVO>();
            while (rs.next()) {
                SintomasVO sintomasVO = new SintomasVO();
                sintomasVO.setId(rs.getInt("id_sintoma"));
                sintomasVO.setIdHistorialMts(rs.getInt("id_historial_mts"));
                sintomasVO.setSintomas(rs.getString("sintomas"));
                sintomasVOList.add(sintomasVO);
            }
            return new Result<List<SintomasVO>>(true, ConsultorioMedicoConst.OK, sintomasVOList);
        } catch (SQLException ex) {
            Logger.getLogger(SintomasDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<List<SintomasVO>>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<SintomasVO> findById(int id) {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_sintoma, id_historial_mts, sintomas  FROM const_dts_sintomas " +
                    "WHERE id_sintoma = " + id );
            rs = ps.executeQuery();
            SintomasVO sintomasVO = null;
            while (rs.next()) {
                sintomasVO= new SintomasVO();
                sintomasVO.setId(rs.getInt("id_sintoma"));
                sintomasVO.setIdHistorialMts(rs.getInt("id_historial_mts"));
                sintomasVO.setSintomas(rs.getString("sintomas"));
            }
            return new Result<SintomasVO>(true, ConsultorioMedicoConst.OK, sintomasVO);
        } catch (SQLException ex) {
            Logger.getLogger(SintomasDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<SintomasVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<List<SintomasVO>> findByIdHistorialMts(int id) {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_sintoma, id_historial_mts, sintomas  FROM const_dts_sintomas " +
                    "WHERE id_historial_mts = " + id );
            rs = ps.executeQuery();
            List<SintomasVO> sintomasVOList = new ArrayList<SintomasVO>();
            while (rs.next()) {
                SintomasVO sintomasVO = new SintomasVO();
                sintomasVO.setId(rs.getInt("id_sintoma"));
                sintomasVO.setIdHistorialMts(rs.getInt("id_historial_mts"));
                sintomasVO.setSintomas(rs.getString("sintomas"));
                sintomasVOList.add(sintomasVO);
            }
            return new Result<List<SintomasVO>>(true, ConsultorioMedicoConst.OK, sintomasVOList);
        } catch (SQLException ex) {
            Logger.getLogger(SintomasDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<List<SintomasVO>>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }


    @Override
    public Result<SintomasVO> add(SintomasVO sintomasVO) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "INSERT INTO const_dts_sintomas (id_historial_mts, sintomas) " +
                "VALUES(?,?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, sintomasVO.getIdHistorialMts());
            ps.setString(2, sintomasVO.getSintomas());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return new Result<SintomasVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }
            ResultSet generatedKeys = ps.getGeneratedKeys();
            int idGenerado = 0;
            if (generatedKeys.next()) {
                idGenerado = generatedKeys.getInt(1);
            }
            sintomasVO.setId(idGenerado);
            return new Result<SintomasVO>(true, ConsultorioMedicoConst.DB_REGISTRADO_CORRECTAMENTE, sintomasVO);
        } catch (SQLException ex) {
            Logger.getLogger(SintomasDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<SintomasVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<SintomasVO> update(SintomasVO sintomasVO) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "UPDATE  const_dts_sintomas SET sintomas = ? " +
                "WHERE id_sintoma = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sintomasVO.getSintomas());
            ps.setInt(2, sintomasVO.getId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return new Result<SintomasVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }

            return new Result<SintomasVO>(true, ConsultorioMedicoConst.DB_ACTUALIZAR_CORRECTAMENTE, sintomasVO);
        } catch (SQLException ex) {
            Logger.getLogger(HistorialDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<SintomasVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<SintomasVO> delete(int id) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "DELETE from const_dts_sintomas  WHERE id_sintoma = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                return new Result<SintomasVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }

            return new Result<SintomasVO>(true, ConsultorioMedicoConst.DB_ELIMANDO_EXITOSAMENTE, null);
        } catch (SQLException ex) {
            Logger.getLogger(SintomasVO.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<SintomasVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<SintomasVO> deleteByIdHistorialMts(int id) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "DELETE from const_dts_sintomas  WHERE id_historial_mts = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                return new Result<SintomasVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }

            return new Result<SintomasVO>(true, ConsultorioMedicoConst.DB_ELIMANDO_EXITOSAMENTE, null);
        } catch (SQLException ex) {
            Logger.getLogger(SintomasVO.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<SintomasVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }
}
