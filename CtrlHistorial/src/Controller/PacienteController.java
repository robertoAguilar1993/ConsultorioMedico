/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import contract.IPacienteDao;
import dao.PacienteDao;
import java.util.List;
import util.Result;
import vo.PacienteVO;

/**
 *
 * @author apple
 */
public class PacienteController {
    
    public Result add(PacienteVO paciente) {
        IPacienteDao pacienteDao = new PacienteDao();
        return pacienteDao.add(paciente);
    }

    public Result<List<PacienteVO>> findAll() {
        IPacienteDao pacienteDao = new PacienteDao();
        return pacienteDao.findAll();
    }

    public Result<List<PacienteVO>> findByCriteria(String criteria) {
        IPacienteDao pacienteDao = new PacienteDao();
        return pacienteDao.findByCriteria(criteria);
    }

    public Result<PacienteVO> findById(int id){
        IPacienteDao pacienteDao = new PacienteDao();
        return pacienteDao.findById(id);
    }
}
