/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contract;

import util.Result;
import vo.AdministracionPacientesVO;

import java.util.List;

/**
 *
 * @author Alex
 */
public interface IAdministracionPacientesDao {
    public Result<List<AdministracionPacientesVO>> findAll();
}
