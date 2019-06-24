package Controller;

import contract.IAdministracionPacientesDao;
import dao.AdministracionPacientesDao;
import util.Result;
import vo.AdministracionPacientesVO;

import java.util.List;

public class AdministracionPacientesController {

    IAdministracionPacientesDao administracionPacientes = new AdministracionPacientesDao();

    public Result<List<AdministracionPacientesVO>> findAll(){
        return administracionPacientes.findAll();
    } 

}
