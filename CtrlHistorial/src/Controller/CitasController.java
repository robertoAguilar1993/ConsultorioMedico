/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;

import contract.ICitaDao;
import dao.CitaDao;
import util.Result;
import util.Util;
import vo.CitaVO;
import vo.HorarioTrabajoVO;

/**
 *
 * @author Alex
 */
public class CitasController {

    ICitaDao citaDao = new CitaDao();
    

    public List<String> getHoras(HorarioTrabajoVO horarioTrabajoVO){
        return Util.getHorasCompletas(horarioTrabajoVO.getHoraInicio(), horarioTrabajoVO.getHoraFinal());
    }
    
    public Result<List<CitaVO>> getCitasByDate(String  fecha){
       return citaDao.findByDate(fecha);
    }

    public Result<CitaVO> addCitas(CitaVO citaVO){
        return citaDao.add(citaVO);
    }

    public Result<CitaVO> deleteCitas(String date, String hour){
        return citaDao.deleteByDateAndHour(date, hour);
    }
}
