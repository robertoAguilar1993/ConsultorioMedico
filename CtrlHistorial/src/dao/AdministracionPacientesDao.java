package dao;

import contract.IAdministracionPacientesDao;
import modelo.Conexion;
import util.ConsultorioMedicoConst;
import util.Result;
import vo.AdministracionPacientesVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdministracionPacientesDao extends Conexion implements IAdministracionPacientesDao{

    @Override
    public Result<List<AdministracionPacientesVO>> findAll() {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT t.*, " +
                    "       ( SELECT COUNT(*) FROM const_dts_historial_mts mts  WHERE mts.id_paciente = t.id_paciente ) AS citas, " +
                    "       (SELECT  mts.fecha FROM const_dts_historial_mts mts  WHERE mts.id_paciente = t.id_paciente ORDER BY mts.fecha DESC LIMIT 1) AS ultima_cita " +
                    "FROM const_dts_pacientes t ORDER BY ultima_cita ASC");
            rs = ps.executeQuery();
            List<AdministracionPacientesVO> reporteUltrasonicoVOList = new ArrayList<AdministracionPacientesVO>();
            while (rs.next()) {
                AdministracionPacientesVO administracionPacientesVO = new AdministracionPacientesVO();
                administracionPacientesVO.setId(rs.getLong("id_paciente"));
                administracionPacientesVO.setNombre(rs.getString("nombre"));
                administracionPacientesVO.setApellidoPaterno(rs.getString("ap_paterno"));
                administracionPacientesVO.setApellidoMaterno(rs.getString("ap_materno"));
                administracionPacientesVO.setDirecion(rs.getString("domicilio"));
                administracionPacientesVO.setGenero(rs.getString("genero"));
                administracionPacientesVO.setFechaNacimiento(new java.util.Date( rs.getDate("fecha_nacimiento").getTime() ));
                administracionPacientesVO.setTelefono(rs.getString("telefono"));
                administracionPacientesVO.setCitas(rs.getInt("citas"));
                administracionPacientesVO.setUltimaCita( rs.getDate("ultima_cita") != null ?
                        new java.util.Date( rs.getDate("ultima_cita").getTime()) : null);

                reporteUltrasonicoVOList.add(administracionPacientesVO);
            }
            return new Result<List<AdministracionPacientesVO>>(true, ConsultorioMedicoConst.OK, reporteUltrasonicoVOList);
        } catch (SQLException ex) {
            Logger.getLogger(AdministracionPacientesDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<List<AdministracionPacientesVO>>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }
}
