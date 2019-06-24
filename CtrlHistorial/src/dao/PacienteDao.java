/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import contract.IPacienteDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import util.ConsultorioMedicoConst;
import util.Result;
import vo.PacienteVO;

/**
 *
 * @author Alex
 */
public class PacienteDao extends Conexion implements IPacienteDao{

    /**
     * Metodo encargado en Guardar un paciente
     * @param paciente
     * @return 
     */
    @Override
    public Result<PacienteVO> add(PacienteVO paciente) {
        PreparedStatement ps;
        Connection con = getConexion();
       
        
        if(paciente == null ){
            return new Result<PacienteVO>(false, "Debe de completar el formulario", null);
        }
                
        String message = validatePaciente(paciente);
  
        if ( !"".equals(message) ) {
            return new Result<PacienteVO>(false, message, null);
        }
        
        String sql = "INSERT INTO const_dts_pacientes (nombre, ap_paterno,ap_materno, "
                + "domicilio, genero, fecha_nacimiento, telefono, ocupacion) VALUES(?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellidoPaterno());
            ps.setString(3, paciente.getApellidoMaterno());
            ps.setString(4, paciente.getDirecion());
            ps.setString(5, paciente.getGenero());
            ps.setDate(6,  new java.sql.Date(paciente.getFechaNacimiento().getTime()));
            ps.setString(7,paciente.getTelefono());
            ps.setString(8,paciente.getOcupacion());
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                 return new Result<PacienteVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }
            ResultSet generatedKeys = ps.getGeneratedKeys();
            long idGenerado = 0;
            if (generatedKeys.next()) {
                     idGenerado = generatedKeys.getInt(1);
            }
            paciente.setId(idGenerado);
            System.err.println("idGenerado: " + idGenerado);
            return new Result<PacienteVO>(true, ConsultorioMedicoConst.DB_REGISTRADO_CORRECTAMENTE, paciente);
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<PacienteVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }
    
     @Override
    public Result<PacienteVO> update(PacienteVO paciente) {
        PreparedStatement ps;
        Connection con = getConexion();
        
        String message = validatePaciente(paciente);
  
        if ( !"".equals(message) ) {
            return new Result<PacienteVO>(false, message, null);
        }

        String sql = "UPDATE  const_dts_pacientes SET nombre = ?, ap_paterno = ?, "
                + "ap_materno = ?, domicilio = ?, genero = ?, fecha_nacimiento = ?, "
                + "telefono = ?, ocupacion = ?  " +
                "WHERE id_paciente = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellidoPaterno());
            ps.setString(3, paciente.getApellidoMaterno());
            ps.setString(4, paciente.getDirecion());
            ps.setString(5, paciente.getGenero());
            ps.setDate(6, new java.sql.Date(paciente.getFechaNacimiento().getTime()));
            ps.setString(7, paciente.getTelefono());
            ps.setString(8, paciente.getOcupacion());
            ps.setInt(9, (int) paciente.getId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return new Result<PacienteVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }

            return new Result<PacienteVO>(true, ConsultorioMedicoConst.DB_ACTUALIZAR_CORRECTAMENTE, paciente);
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<PacienteVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    /**
     * Metodo para obtener todos los pacientes
     * @return 
     */
    @Override
    public Result<List<PacienteVO>> findAll() {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
             ps = con.prepareStatement("SELECT id_paciente, nombre, ap_paterno,"
                     + " ap_materno, domicilio, genero, fecha_nacimiento, telefono FROM const_dts_pacientes");
             rs = ps.executeQuery();
             List<PacienteVO> pacienteVOs = new ArrayList<PacienteVO>(); 
             
              while (rs.next()) {
                PacienteVO paciente = new PacienteVO();
                paciente.setId(rs.getLong("id_paciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellidoPaterno(rs.getString("ap_paterno"));
                paciente.setApellidoMaterno(rs.getString("ap_materno"));
                paciente.setDirecion(rs.getString("domicilio"));
                paciente.setGenero(rs.getString("genero"));
                paciente.setFechaNacimiento(new java.util.Date( rs.getDate("fecha_nacimiento").getTime() ));
                paciente.setTelefono(rs.getString("telefono"));
                pacienteVOs.add(paciente);
              }
               return new Result<List<PacienteVO>>(true, ConsultorioMedicoConst.OK, pacienteVOs);
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<List<PacienteVO>>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    /**
     * Metodo para obtener una lista de pacientes de acuerdo con criterios
     * @param criteria
     * @return 
     */
    @Override
    public Result<List<PacienteVO>> findByCriteria(String criteria) {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
             ps = con.prepareStatement("SELECT id_paciente, nombre, ap_paterno, "
                     + "ap_materno, domicilio, genero, fecha_nacimiento, telefono FROM const_dts_pacientes where "
                     + "nombre like  CONVERT( _utf8 '%"+ criteria +"%' USING latin1 ) or telefono like  '%" + criteria + "%'");
             rs = ps.executeQuery();
             List<PacienteVO> pacienteVOs = new ArrayList<PacienteVO>(); 
             
              while (rs.next()) {
                PacienteVO paciente = new PacienteVO();
                paciente.setId(rs.getLong("id_paciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellidoPaterno(rs.getString("ap_paterno"));
                paciente.setApellidoMaterno(rs.getString("ap_materno"));
                paciente.setDirecion(rs.getString("domicilio"));
                paciente.setGenero(rs.getString("genero"));
                paciente.setFechaNacimiento(new java.util.Date( rs.getDate("fecha_nacimiento").getTime() ));
                paciente.setTelefono(rs.getString("telefono"));
                pacienteVOs.add(paciente);
              }
               return new Result<List<PacienteVO>>(true, ConsultorioMedicoConst.OK, pacienteVOs);
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<List<PacienteVO>>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<PacienteVO> findById(int id) {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_paciente, nombre, ap_paterno, "
                    + "ap_materno, domicilio, genero, fecha_nacimiento, telefono, "
                    + " ocupacion FROM const_dts_pacientes where "
                    + "id_paciente = " + id);
            rs = ps.executeQuery();
            PacienteVO paciente = null;

            while (rs.next()) {
                paciente = new PacienteVO();
                paciente.setId(rs.getLong("id_paciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellidoPaterno(rs.getString("ap_paterno"));
                paciente.setApellidoMaterno(rs.getString("ap_materno"));
                paciente.setDirecion(rs.getString("domicilio"));
                paciente.setGenero(rs.getString("genero"));
                paciente.setFechaNacimiento(new java.util.Date( rs.getDate("fecha_nacimiento").getTime() ));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setOcupacion(rs.getString("ocupacion"));
            }
            return new Result< PacienteVO>(true, ConsultorioMedicoConst.OK, paciente);
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<PacienteVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }


    /**
     * Metodo encargado de validar Que sea un numero valido
     * @param number
     * @return 
     */
    private boolean validateNumber(String number) {
        try{
            Long.parseLong(number);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    
    
    /**
     * Metodo encargado de validar que el campo no venga vacio
     * @param value
     * @return 
     */
    private boolean validateStringEmpty(String value){
        return  value == null  || "".equals(value);
    }

    private String validatePaciente(PacienteVO paciente){
        String message = "";
        if ( validateStringEmpty(paciente.getNombre())) {
            message = message + "* El nombre es un campo requerido";
        }

        if ( validateStringEmpty(paciente.getApellidoPaterno())) {
            message = message + "\n* El apellido paterno es un campo requerido";
        }

        if ( validateStringEmpty(paciente.getApellidoMaterno())) {
            message = message + "\n* El apellido materno es un campo requerido";
        }
        
        if ( paciente.getFechaNacimiento() == null ||  "".equals(paciente.getFechaNacimiento()) ) {
            message = message + "\n* La fecha de nacimiento es requerido";
        }
        
        if (paciente.getGenero() == null || "Seleccione".equals(paciente.getGenero())) {
            message = message + "\n* El genero es requerido";
        }
        
        if (validateStringEmpty(paciente.getDirecion())) {
            message = message + "\n* La direcion es requerido";
        }
        
      
        if(paciente.getTelefono() != null &&  !"".equals(paciente.getTelefono())
                && !validateNumber(paciente.getTelefono())){
            message = message + "\n* Capture un telefono valido";
        }
        return message;
    }

    @Override
    public Result<PacienteVO> deleteById(int id) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "DELETE from const_dts_pacientes  WHERE id_paciente = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                return new Result<PacienteVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }

            return new Result<PacienteVO>(true, ConsultorioMedicoConst.DB_ELIMANDO_EXITOSAMENTE, null);
        } catch (SQLException ex) {
            Logger.getLogger(ReporteUltrasonicoDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<PacienteVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }
   
    
    
    
}
