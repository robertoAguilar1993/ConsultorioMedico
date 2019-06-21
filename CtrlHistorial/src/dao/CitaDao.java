package dao;

import contract.ICitaDao;
import modelo.Conexion;
import util.ConsultorioMedicoConst;
import util.Result;
import vo.CitaVO;
import vo.PacienteVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CitaDao extends Conexion implements ICitaDao {

    @Override
    public Result<List<CitaVO>> findByAll() {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT ci.id_cita, ci.fecha, ci.hora, pa.id_paciente, pa.nombre, " +
                    "pa.ap_paterno, pa.ap_materno,  pa.domicilio, pa.genero, pa.fecha_nacimiento, pa.telefono, " +
                    "pa.ocupacion " +
                    "FROM const_dts_citas ci INNER JOIN const_dts_pacientes pa ON ci.id_Paciente = pa.id_paciente ");
            rs = ps.executeQuery();
            List<CitaVO> citaVOList = new ArrayList<CitaVO>();
            while (rs.next()) {
                CitaVO citaVO = new CitaVO();
                PacienteVO pacienteVO = new PacienteVO();
                citaVO.setId(rs.getInt("id_cita"));
                citaVO.setFecha(rs.getString("fecha"));
                citaVO.setHora(rs.getString("hora"));

                pacienteVO.setId(rs.getInt("id_paciente"));
                pacienteVO.setNombre(rs.getString("nombre"));
                pacienteVO.setApellidoPaterno(rs.getString("ap_materno"));
                pacienteVO.setApellidoMaterno(rs.getString("nombre"));
                pacienteVO.setDirecion(rs.getString("domicilio"));
                pacienteVO.setGenero(rs.getString("genero"));
                pacienteVO.setFechaNacimiento(new java.util.Date(rs.getDate("fecha_nacimiento").getTime()));
                pacienteVO.setTelefono(rs.getString("telefono"));
                pacienteVO.setOcupacion(rs.getString("ocupacion"));
                citaVO.setPacienteVO(pacienteVO);
                citaVOList.add(citaVO);
            }
            return new Result<List<CitaVO>>(true, ConsultorioMedicoConst.OK, citaVOList);
        } catch (SQLException ex) {
            Logger.getLogger(CitaDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<List<CitaVO>>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<List<CitaVO>> findByDate(String date) {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT ci.id_cita, ci.fecha, ci.hora, pa.id_paciente, pa.nombre, " +
                    "pa.ap_paterno, pa.ap_materno,  pa.domicilio, pa.genero, pa.fecha_nacimiento, pa.telefono, " +
                    "pa.ocupacion " +
                    "FROM const_dts_citas ci INNER JOIN const_dts_pacientes pa ON ci.id_Paciente = pa.id_paciente " +
                    "WHERE ci.fecha = '" + date + "'");
            rs = ps.executeQuery();
            List<CitaVO> citaVOList = new ArrayList<CitaVO>();
            while (rs.next()) {
                CitaVO citaVO = new CitaVO();
                PacienteVO pacienteVO = new PacienteVO();
                citaVO.setId(rs.getInt("id_cita"));
                citaVO.setFecha(rs.getString("fecha"));
                citaVO.setHora(rs.getString("hora"));

                pacienteVO.setId(rs.getInt("id_paciente"));
                pacienteVO.setNombre(rs.getString("nombre"));
                pacienteVO.setApellidoPaterno(rs.getString("ap_paterno"));
                pacienteVO.setApellidoMaterno(rs.getString("ap_materno"));
                pacienteVO.setDirecion(rs.getString("domicilio"));
                pacienteVO.setGenero(rs.getString("genero"));
                pacienteVO.setFechaNacimiento(new java.util.Date(rs.getDate("fecha_nacimiento").getTime()));
                pacienteVO.setTelefono(rs.getString("telefono"));
                pacienteVO.setOcupacion(rs.getString("ocupacion"));
                citaVO.setPacienteVO(pacienteVO);
                citaVOList.add(citaVO);
            }
            return new Result<List<CitaVO>>(true, ConsultorioMedicoConst.OK, citaVOList);
        } catch (SQLException ex) {
            Logger.getLogger(CitaDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<List<CitaVO>>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<CitaVO> add(CitaVO citaVO) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "INSERT INTO const_dts_citas (fecha, hora, id_paciente) " +
                "VALUES(?,?,?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, citaVO.getFecha());
            ps.setString(2, citaVO.getHora());
            ps.setInt(3, (int) citaVO.getPacienteVO().getId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return new Result<CitaVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }
            ResultSet generatedKeys = ps.getGeneratedKeys();
            int idGenerado = 0;
            if (generatedKeys.next()) {
                idGenerado = generatedKeys.getInt(1);
            }
            citaVO.setId(idGenerado);
            return new Result<CitaVO>(true, ConsultorioMedicoConst.DB_REGISTRADO_CORRECTAMENTE, citaVO);
        } catch (SQLException ex) {
            Logger.getLogger(CitaDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<CitaVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<CitaVO> deleteByDateAndHour(String date, String hour) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "DELETE from const_dts_citas  WHERE fecha = ? AND hora = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, date);
            ps.setString(2, hour);
            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                return new Result<CitaVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }

            return new Result<CitaVO>(true, ConsultorioMedicoConst.DB_ELIMANDO_EXITOSAMENTE, null);
        } catch (SQLException ex) {
            Logger.getLogger(CitaDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<CitaVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }
}
