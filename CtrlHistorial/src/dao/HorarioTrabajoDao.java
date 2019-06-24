/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import contract.IHorarioTrabajoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import util.ConsultorioMedicoConst;
import util.Result;
import vo.HorarioTrabajoVO;

/**
 *
 * @author apple
 */
public class HorarioTrabajoDao extends Conexion implements IHorarioTrabajoDao{

    @Override
    public Result<HorarioTrabajoVO> findByDay(String day) {
        PreparedStatement ps;
        Connection con = getConexion();
        ResultSet rs;

        try {
            ps = con.prepareStatement( "SELECT id_horario_trabajo, hora_inicio, hora_final, dia, dia_laboral  "
                    + "FROM const_dts_conf_horario_trabajo "
                    + "WHERE dia = '" + day +"'");
            rs = ps.executeQuery();
            HorarioTrabajoVO horarioTrabajoVO = new HorarioTrabajoVO();
            while (rs.next()) {
                horarioTrabajoVO.setId(rs.getInt("id_horario_trabajo"));
                horarioTrabajoVO.setHoraInicio(rs.getString("hora_inicio"));
                horarioTrabajoVO.setHoraFinal(rs.getString("hora_final"));
                horarioTrabajoVO.setDia(rs.getString("dia"));
                horarioTrabajoVO.setDiaLobaral(rs.getByte("dia_laboral"));
            }
            return new Result<HorarioTrabajoVO>(true, ConsultorioMedicoConst.OK, horarioTrabajoVO);
        } catch (SQLException ex) {
            Logger.getLogger(HorarioTrabajoDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<HorarioTrabajoVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

    @Override
    public Result<HorarioTrabajoVO> update(HorarioTrabajoVO horarioTrabajoVO) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "UPDATE  const_dts_conf_horario_trabajo SET hora_inicio = ?, hora_final = ?, dia_laboral = ? " +
                "WHERE id_horario_trabajo = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, horarioTrabajoVO.getHoraInicio());
            ps.setString(2, horarioTrabajoVO.getHoraFinal());
            ps.setByte(3, horarioTrabajoVO.getDiaLobaral());
            ps.setInt(4, horarioTrabajoVO.getId());


            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return new Result<HorarioTrabajoVO>(true, ConsultorioMedicoConst.DB_NO_SE_PUDO_GUARDAR, null);
            }

            return new Result<HorarioTrabajoVO>(true, ConsultorioMedicoConst.DB_ACTUALIZAR_CORRECTAMENTE, horarioTrabajoVO);
        } catch (SQLException ex) {
            Logger.getLogger(ReporteUltrasonicoDao.class.getName()).log(Level.SEVERE, null, ex);
            return new Result<HorarioTrabajoVO>(false, ConsultorioMedicoConst.DB_ERROR_SQL, null);
        }
    }

}
