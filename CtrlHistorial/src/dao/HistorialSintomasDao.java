package dao;

import contract.IHistorialSintomasDao;
import modelo.Conexion;
import util.ConsultorioMedicoConst;
import util.Result;
import vo.HistorialSintomasVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alex
 */
public class HistorialSintomasDao extends Conexion implements IHistorialSintomasDao {


    @Override
    public Result<List<HistorialSintomasVO>> findByAll() {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_historial_sintomas, id_historial, id_paciente, antecedente_importante " +
                    " FROM const_dts_historial_sintomas");

            rs = ps.executeQuery();
            List<HistorialSintomasVO> historialSintomasVOList = new ArrayList<HistorialSintomasVO>();
            while (rs.next()) {
                HistorialSintomasVO historialSintomasVO = new HistorialSintomasVO();
                historialSintomasVO.setId(rs.getInt("id_historial_sintomas"));
                historialSintomasVO.setIdHistorial(rs.getInt("id_historial"));
                historialSintomasVO.setIdPaciente(rs.getInt("id_paciente"));
                historialSintomasVO.setAntecedenteImportante(rs.getString("antecedente_importante"));
                historialSintomasVOList.add(historialSintomasVO);
            }
            return new Result<List<HistorialSintomasVO>>(true, ConsultorioMedicoConst.OK, historialSintomasVOList);
        } catch (SQLException ex) {
            Logger.getLogger(HistorialSintomasDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<List<HistorialSintomasVO>>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<List<HistorialSintomasVO>> findByIdHistorial(int idHistorial) {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_historial_sintomas, id_historial, id_paciente, antecedente_importante " +
                    "FROM const_dts_historial_sintomas  WHERE id_historial = " + idHistorial );
            rs = ps.executeQuery();
            List<HistorialSintomasVO> historialSintomasVOList = new ArrayList<HistorialSintomasVO>();
            while (rs.next()) {
                HistorialSintomasVO historialSintomasVO = new HistorialSintomasVO();
                historialSintomasVO.setId(rs.getInt("id_historial_sintomas"));
                historialSintomasVO.setIdHistorial(rs.getInt("id_historial"));
                historialSintomasVO.setIdPaciente(rs.getInt("id_paciente"));
                historialSintomasVO.setAntecedenteImportante(rs.getString("antecedente_importante"));
                historialSintomasVOList.add(historialSintomasVO);
            }
            return new Result<List<HistorialSintomasVO>>(true, ConsultorioMedicoConst.OK, historialSintomasVOList);
        } catch (SQLException ex) {
            Logger.getLogger(HistorialSintomasDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<List<HistorialSintomasVO>>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<HistorialSintomasVO> add(HistorialSintomasVO historialSintomasVO) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "INSERT INTO const_dts_historial_sintomas (id_historial, id_paciente, antecedente_importante ) " +
                "VALUES(?,?,?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, historialSintomasVO.getIdHistorial());
            ps.setInt(2, historialSintomasVO.getIdPaciente());
            ps.setString(3, historialSintomasVO.getAntecedenteImportante());


            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return new Result<HistorialSintomasVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }

            ResultSet generatedKeys = ps.getGeneratedKeys();
            int idGenerado = 0;
            if (generatedKeys.next()) {
                idGenerado = generatedKeys.getInt(1);
            }
            historialSintomasVO.setId(idGenerado);
            return new Result<HistorialSintomasVO>(true, ConsultorioMedicoConst.DB_REGISTRADO_CORRECTAMENTE, historialSintomasVO);
        } catch (SQLException ex) {
            Logger.getLogger(HistorialSintomasDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<HistorialSintomasVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<HistorialSintomasVO> update(HistorialSintomasVO historialSintomasVO) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "UPDATE  const_dts_historial_sintomas SET  antecedente_importante = ? " +
                "WHERE id_historial_sintomas = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, historialSintomasVO.getAntecedenteImportante());
            ps.setInt(2, historialSintomasVO.getId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return new Result<HistorialSintomasVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }

            return new Result<HistorialSintomasVO>(true, ConsultorioMedicoConst.DB_REGISTRADO_CORRECTAMENTE, historialSintomasVO);
        } catch (SQLException ex) {
            Logger.getLogger(HistorialSintomasDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<HistorialSintomasVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<HistorialSintomasVO> deleteByHistorial(int idHistorial) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "DELETE from const_dts_historial_sintomas  WHERE id_historial = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idHistorial);
            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                return new Result<HistorialSintomasVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }

            return new Result<HistorialSintomasVO>(true, ConsultorioMedicoConst.DB_ELIMANDO_EXITOSAMENTE, null);
        } catch (SQLException ex) {
            Logger.getLogger(HistorialDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<HistorialSintomasVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }
}
