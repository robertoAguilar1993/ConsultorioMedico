package dao;

import contract.IRecetaDao;
import modelo.Conexion;
import util.ConsultorioMedicoConst;
import util.Result;
import vo.RecetaVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alex
 */
public class RecetaDao extends Conexion implements IRecetaDao {


    @Override
    public Result<List<RecetaVO>> findByAll() {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_receta, edad, peso, talla, temp, fc, rf, ta, rx, fecha " +
                    "FROM const_dts_recetas");
            rs = ps.executeQuery();
            List<RecetaVO> recetaVOList = new ArrayList<RecetaVO>();
            while (rs.next()) {
                RecetaVO recetaVO = new RecetaVO();
                recetaVO.setId(rs.getInt("id_receta"));
                recetaVO.setEdad(rs.getInt("edad"));
                recetaVO.setPeso(rs.getFloat("peso"));
                recetaVO.setTalla(rs.getFloat("talla"));
                recetaVO.setTemp(rs.getString("temp"));
                recetaVO.setFc(rs.getString("fc"));
                recetaVO.setRf(rs.getString("rf"));
                recetaVO.setTa(rs.getString("ta"));
                recetaVO.setRx(rs.getString("rx"));
                recetaVO.setFecha(new java.util.Date( rs.getDate("fecha").getTime()));
                recetaVOList.add(recetaVO);
            }
            return new Result<List<RecetaVO>>(true, ConsultorioMedicoConst.OK, recetaVOList);
        } catch (SQLException ex) {
            Logger.getLogger(RecetaDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<List<RecetaVO>>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<RecetaVO> findById(int id) {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_receta, edad, peso, talla, temp, fc, rf, ta, rx, fecha " +
                    "FROM const_dts_recetas  WHERE id_receta = " + id );
            rs = ps.executeQuery();
            RecetaVO receta  = null;
            while (rs.next()) {
                receta= new RecetaVO();
                receta.setId(rs.getInt("id_receta"));
                receta.setEdad(rs.getInt("edad"));
                receta.setPeso(rs.getFloat("peso"));
                receta.setTalla(rs.getFloat("talla"));
                receta.setTemp(rs.getString("temp"));
                receta.setFc(rs.getString("fc"));
                receta.setRf(rs.getString("rf"));
                receta.setTa(rs.getString("ta"));
                receta.setRx(rs.getString("rx"));
                receta.setFecha(new java.util.Date( rs.getDate("fecha").getTime()));
            }
            return new Result<RecetaVO>(true, ConsultorioMedicoConst.OK, receta);
        } catch (SQLException ex) {
            Logger.getLogger(RecetaDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<RecetaVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<RecetaVO> add(RecetaVO recetaVO) {

        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "INSERT INTO const_dts_recetas (edad, peso, talla, temp, fc, rf, ta, rx, fecha ) " +
                "VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, recetaVO.getEdad());
            ps.setFloat(2, recetaVO.getPeso());
            ps.setFloat(3, recetaVO.getTalla());
            ps.setString(4, recetaVO.getTemp());
            ps.setString(5, recetaVO.getFc());
            ps.setString(6, recetaVO.getRf());
            ps.setString(7, recetaVO.getTa());
            ps.setString(8, recetaVO.getRx());
            ps.setDate(9, new java.sql.Date(recetaVO.getFecha().getTime()));

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return new Result<RecetaVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }
            ResultSet generatedKeys = ps.getGeneratedKeys();
            int idGenerado = 0;
            if (generatedKeys.next()) {
                idGenerado = generatedKeys.getInt(1);
            }
            recetaVO.setId(idGenerado);
            return new Result<RecetaVO>(true, ConsultorioMedicoConst.DB_REGISTRADO_CORRECTAMENTE, recetaVO);
        } catch (SQLException ex) {
            Logger.getLogger(RecetaDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<RecetaVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<RecetaVO> update(RecetaVO recetaVO) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "UPDATE  const_dts_recetas  SET edad = ?, peso = ?, talla = ?, temp = ?, fc = ?, rf = ?, ta = ?, rx = ?, fecha= ? " +
                    "WHERE id_receta = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, recetaVO.getEdad());
            ps.setFloat(2, recetaVO.getPeso());
            ps.setFloat(3, recetaVO.getTalla());
            ps.setString(4, recetaVO.getTemp());
            ps.setString(5, recetaVO.getFc());
            ps.setString(6, recetaVO.getRf());
            ps.setString(7, recetaVO.getTa());
            ps.setString(8, recetaVO.getRx());
            ps.setDate(9, new java.sql.Date(recetaVO.getFecha().getTime()));
            ps.setInt(10, recetaVO.getId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return new Result<RecetaVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }

            return new Result<RecetaVO>(true, ConsultorioMedicoConst.DB_ACTUALIZAR_CORRECTAMENTE, recetaVO);
        } catch (SQLException ex) {
            Logger.getLogger(RecetaDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<RecetaVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<RecetaVO> delete(int id) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "DELETE from const_dts_recetas  WHERE id_receta = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                return new Result<RecetaVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }

            return new Result<RecetaVO>(true, ConsultorioMedicoConst.DB_ELIMANDO_EXITOSAMENTE, null);
        } catch (SQLException ex) {
            Logger.getLogger(RecetaDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<RecetaVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }
}
