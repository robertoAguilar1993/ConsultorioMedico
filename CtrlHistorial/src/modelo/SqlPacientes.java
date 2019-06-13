
package modelo;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SqlPacientes extends Conexion{
    
    public boolean registar_datos(paciente us)
    {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO dts_pacientes (nombre, domicilio, genero, edad, telefono, peso, talla, temperatura, fc, fr, ta) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getNombre());
            ps.setString(2, us.getDirecion());
            ps.setString(3, us.getGenero());
            ps.setInt(4,us.getEdad());
            ps.setString(5,us.getTelefono());
            ps.setFloat(6, us.getPeso());
            ps.setFloat(7, us.getTalla());
            ps.setFloat(8,us.getTemperatura());
            ps.setInt(9,us.getFc());
            ps.setInt(10, us.getFr());
            ps.setInt(11, us.getTa());
            ps.execute();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlPacientes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }   
    
    public boolean registar_sintomas(paciente usr)
    {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO sintomas (idpaciente, sintomas) VALUES (?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, usr.getIdpaci());
            ps.setString(2, usr.getSintoma());
            ps.execute();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlPacientes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    } 
    public boolean registar_diagnostico(paciente usr)
    {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO dignostico (idsintomas, dignostico, tratamiento,fecha) VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, usr.getId2());
            ps.setString(2, usr.getDignostico());
            ps.setString(3, usr.getTratamiento());
            ps.setDate(4,Date.valueOf(usr.getFecha()));
            ps.execute();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlPacientes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean login(paciente usr)
    {
        PreparedStatement ps =null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT idUsuario, usuario, password, jerarquia, nombre_completo,direccion FROM usuario WHERE usuario = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs =ps.executeQuery();
            
            if(rs.next()){
                if(usr.getPassword().equals(rs.getString(3))){
                     
                    usr.setIdusuario(rs.getInt(1));
                    usr.setNomb_comple(rs.getString(5));
                    return true;
                 }else {
                return false; 
                }
             }
            return false;
        }catch (SQLException ex) {
            Logger.getLogger(SqlPacientes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     
    
}
