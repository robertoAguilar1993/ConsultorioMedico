/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contract;

import java.util.List;
import util.Result;
import vo.HorarioTrabajoVO;

/**
 *
 * @author apple
 */
public interface IHorarioTrabajoDao {
    public Result<HorarioTrabajoVO> findByDay(String day);
    public Result<HorarioTrabajoVO> update(HorarioTrabajoVO horarioTrabajoVO);
}
