/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contract;

import java.util.List;
import util.Result;
import vo.PacienteVO;

/**
 *
 * @author Alex
 */
public interface IPacienteDao {
    public Result add(PacienteVO paciente);
    public Result<List<PacienteVO>> findAll();
    public Result<List<PacienteVO>> findByCriteria(String criteria);
    public Result<PacienteVO> findById(int id);
}
