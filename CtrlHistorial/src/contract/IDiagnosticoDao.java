package contract;

import util.Result;
import vo.DiagnosticoVO;

import java.util.List;

public interface IDiagnosticoDao {
    public Result<List<DiagnosticoVO>> findByAll();
    public Result<DiagnosticoVO> findById(int id);
    public Result<DiagnosticoVO> add(DiagnosticoVO diagnosticoVO);
    public Result<DiagnosticoVO> update(DiagnosticoVO diagnosticoVO);
    public Result<DiagnosticoVO> delete(int id);
}
