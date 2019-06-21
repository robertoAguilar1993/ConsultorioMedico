
package modelo;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    /**
     * Local
     */
    private final String base = "historial_medico";
    private final String user ="root";
    private final String password ="1234";
    private final String url ="jdbc:mysql://localhost:33060/" + base;

    /**
     * db en la nube
     */
//    private final String base = "historial_medico";
//    private final String user ="medico_user";
//    private final String password ="12345678";
//    private final String url ="jdbc:mysql://db4free.net:3306/" + base;

    private Connection con=null;


public Connection getConexion()
{

        if(con != null){
            return con;
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url,user,password);
            
                   
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"erro1");
        
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"error2");
            
        }
        return con;
        
}   

    
}
