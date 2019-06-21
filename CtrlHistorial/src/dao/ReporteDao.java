package dao;

import contract.IReporteDao;
import modelo.Conexion;
import util.ConsultorioMedicoConst;
import util.Result;
import vo.ReporteBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alex
 */
public class ReporteDao extends Conexion implements IReporteDao {


    public static final String SQL_REPORT_BODY = "SELECT mts.fecha, CONCAT(pac.nombre , ' ' , pac.ap_paterno , ' ' , " +
            "pac.ap_materno) as nombre, pac.domicilio ,pac.telefono " +
            "FROM const_dts_historial_mts mts INNER JOIN const_dts_pacientes pac ON mts.id_paciente = pac.id_paciente  ";



    @Override
    public Result<List<ReporteBody>> findByDay(String date) {
        String sql = SQL_REPORT_BODY + "WHERE mts.fecha = " + date;
        return getReportByCriteria(sql);
    }

    @Override
    public Result<List<ReporteBody>> findByWeeks(String startDate, String endDate) {
        String sql = SQL_REPORT_BODY + "WHERE mts.fecha BETWEEN " + startDate +  " AND " + endDate;
        return getReportByCriteria(sql);
    }

    @Override
    public Result<List<ReporteBody>> findByMonth(int month, int year) {
        String sql = SQL_REPORT_BODY + " WHERE MONTH(mts.fecha) = " + month + " AND YEAR(mts.fecha) = " + year;
        return getReportByCriteria(sql);
    }

    @Override
    public Result<List<ReporteBody>> findByYear(int year) {
        String sql = SQL_REPORT_BODY + " WHERE  YEAR(mts.fecha) = " + year;
        return getReportByCriteria(sql);
    }

    public Result<List<ReporteBody>> getReportByCriteria(String sql) {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;
        System.out.println("SQL: " + sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            List<ReporteBody> reporteBodyList = new ArrayList<ReporteBody>();
            int index = 0;
            while (rs.next()) {
                index++;
                ReporteBody reporteBody = new ReporteBody();
                reporteBody.setIndex(index);
                reporteBody.setFecha(rs.getString("fecha"));
                reporteBody.setNombre(rs.getString("nombre"));
                reporteBody.setDomicilio(rs.getString("domicilio"));
                reporteBody.setTelefono(rs.getString("telefono"));
                reporteBodyList.add(reporteBody);
            }
            return new Result<List<ReporteBody>>(true, ConsultorioMedicoConst.OK, reporteBodyList);
        } catch (SQLException ex) {
            Logger.getLogger(ReporteDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<List<ReporteBody>>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }
}