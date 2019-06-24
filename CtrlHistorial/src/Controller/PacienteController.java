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
 * @author Alex
 */
public class PacienteController {
    IPacienteDao pacienteDao = new PacienteDao();

    public Result<PacienteVO> add(PacienteVO paciente) {
        return pacienteDao.add(paciente);
    }
    
    public Result<PacienteVO> delete(int id) {
        return pacienteDao.deleteById(id);
    }
    
    public Result<PacienteVO> update(PacienteVO paciente) {
        return pacienteDao.update(paciente);
    }

    public Result<List<PacienteVO>> findAll() {
        return pacienteDao.findAll();
    }

    public Result<List<PacienteVO>> findByCriteria(String criteria) {
        return pacienteDao.findByCriteria(criteria);
    }

    public Result<PacienteVO> findById(int id){
        return pacienteDao.findById(id);
    }
}
