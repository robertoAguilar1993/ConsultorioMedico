/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import contract.IHorarioTrabajoDao;
import dao.HorarioTrabajoDao;
import java.util.ArrayList;
import java.util.List;
import util.ConsultorioMedicoConst;
import util.Result;
import vo.HorarioTrabajoVO;

/**
 *
 * @author Alex
 */
public class HorarioTrabajoController {
    
    IHorarioTrabajoDao horarioTrabajoDao = new HorarioTrabajoDao();

    public Result<HorarioTrabajoVO> getHorarioTrabajo(String dia){
        return  horarioTrabajoDao.findByDay(dia);
    }
    public Result<HorarioTrabajoVO> update(HorarioTrabajoVO horarioTrabajoVO){
        return  horarioTrabajoDao.update(horarioTrabajoVO);
    }
    public List<String> getHoras () {
        List<String> horas = new ArrayList<String>();
        horas.add(ConsultorioMedicoConst.HORA_00_AM);
        horas.add(ConsultorioMedicoConst.HORA_01_AM);
        horas.add(ConsultorioMedicoConst.HORA_02_AM);
        horas.add(ConsultorioMedicoConst.HORA_03_AM);
        horas.add(ConsultorioMedicoConst.HORA_04_AM);
        horas.add(ConsultorioMedicoConst.HORA_05_AM);
        horas.add(ConsultorioMedicoConst.HORA_06_AM);
        horas.add(ConsultorioMedicoConst.HORA_07_AM);
        horas.add(ConsultorioMedicoConst.HORA_08_AM);
        horas.add(ConsultorioMedicoConst.HORA_09_AM);
        horas.add(ConsultorioMedicoConst.HORA_10_AM);
        horas.add(ConsultorioMedicoConst.HORA_11_AM);
        horas.add(ConsultorioMedicoConst.HORA_12_PM);
        horas.add(ConsultorioMedicoConst.HORA_01_PM);
        horas.add(ConsultorioMedicoConst.HORA_02_PM);
        horas.add(ConsultorioMedicoConst.HORA_03_PM);
        horas.add(ConsultorioMedicoConst.HORA_04_PM);
        horas.add(ConsultorioMedicoConst.HORA_05_PM);
        horas.add(ConsultorioMedicoConst.HORA_06_PM);
        horas.add(ConsultorioMedicoConst.HORA_07_PM);
        horas.add(ConsultorioMedicoConst.HORA_08_PM);
        horas.add(ConsultorioMedicoConst.HORA_09_PM);
        horas.add(ConsultorioMedicoConst.HORA_10_PM);
        horas.add(ConsultorioMedicoConst.HORA_11_PM);
        return horas;
    }
    
}
