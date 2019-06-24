/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.util.Date;

/**
 *
 * @author Alex
 */
public class AdministracionPacientesVO extends PacienteVO{
    
    public int citas;
    public Date ultimaCita;

    public int getCitas() {
        return citas;
    }

    public void setCitas(int citas) {
        this.citas = citas;
    }

    public Date getUltimaCita() {
        return ultimaCita;
    }

    public void setUltimaCita(Date ultimaCita) {
        this.ultimaCita = ultimaCita;
    }

    @Override
    public String toString() {
        return super.toString() + "  AdministracionPacientesVO{" +
                "citas=" + citas +
                ", ultimaCita=" + ultimaCita +
                '}';
    }
}
