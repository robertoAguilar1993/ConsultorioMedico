/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controller.HorarioTrabajoController;
import java.util.List;
import javax.swing.JOptionPane;
import util.ConsultorioMedicoConst;
import util.Result;
import vo.HorarioTrabajoVO;

/**
 *
 * @author apple
 */
public class VtnAdministracionHoras extends javax.swing.JFrame {

    /**
     * Variables globales
     */
    
    HorarioTrabajoController horarioTrabajoController = new HorarioTrabajoController();
    HorarioTrabajoVO horarioLunes = null;
    HorarioTrabajoVO horarioMartes = null;
    HorarioTrabajoVO horarioMiercoles = null;
    HorarioTrabajoVO horarioJueves = null;
    HorarioTrabajoVO horarioViernes = null;
    HorarioTrabajoVO horarioSabado = null;
    HorarioTrabajoVO horarioDomingo = null;
    
    /**
     * Creates new form VtnAdministracionHoras
     */
    public VtnAdministracionHoras() {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.initValores();
    }
    
    public final void initValores() {
        this.removeItemsAll();
        List<String> horas = horarioTrabajoController.getHoras();
        for ( String hora: horas ) {
            cbLunHoraInicio.addItem(hora);
            cbLunHoraFin.addItem(hora);
            cbMarHoraInicio.addItem(hora);
            cbMarHoraFin.addItem(hora);
            cbMierHoraInicio.addItem(hora);
            cbMierHoraFin.addItem(hora);
            cbJuevHoraInicio.addItem(hora);
            cbJuevHoraFin.addItem(hora);
            cbVierHoraInicio.addItem(hora);
            cbVierHoraFin.addItem(hora);
            cbSabHoraInicio.addItem(hora);
            cbSabHoraFin.addItem(hora);
            cbDomHoraInicio.addItem(hora);
            cbDomHoraFin.addItem(hora);
        }
        this.setValoresLunes();
        this.setValoresMartes();
        this.setValoresMiercoles();
        this.setValoresJueves();
        this.setValoresViernes();
        this.setValoresSabado();
        this.setValoresDomingo();
    }
    
    public void setValoresLunes(){
        this.horarioLunes = 
            horarioTrabajoController.getHorarioTrabajo(ConsultorioMedicoConst.LUNES)
                    .getResult();        
        cbLunHoraInicio.setSelectedItem(this.horarioLunes.getHoraInicio());
        cbLunHoraFin.setSelectedItem(this.horarioLunes.getHoraFinal());
        jcbLunes.setSelected((this.horarioLunes.getDiaLobaral() == 1));
    }
    public void setValoresMartes(){
        this.horarioMartes = 
            horarioTrabajoController.getHorarioTrabajo(ConsultorioMedicoConst.MARTES)
                    .getResult();        
        cbMarHoraInicio.setSelectedItem(this.horarioMartes.getHoraInicio());
        cbMarHoraFin.setSelectedItem(this.horarioMartes.getHoraFinal());
        jcbMartes.setSelected((this.horarioMartes.getDiaLobaral() == 1));
    }
    public void setValoresMiercoles(){
        this.horarioMiercoles = 
            horarioTrabajoController.getHorarioTrabajo(ConsultorioMedicoConst.MIERCOLES)
                    .getResult();        
        cbMierHoraInicio.setSelectedItem(this.horarioMiercoles.getHoraInicio());
        cbMierHoraFin.setSelectedItem(this.horarioMiercoles.getHoraFinal());
        jcbMiercoles.setSelected((this.horarioMiercoles.getDiaLobaral() == 1));
    }
    public void setValoresJueves(){
        this.horarioJueves = 
            horarioTrabajoController.getHorarioTrabajo(ConsultorioMedicoConst.JUEVES)
                    .getResult();        
        cbJuevHoraInicio.setSelectedItem(this.horarioJueves.getHoraInicio());
        cbJuevHoraFin.setSelectedItem(this.horarioJueves.getHoraFinal());
        jcbJueves.setSelected((this.horarioJueves.getDiaLobaral() == 1));
    }
    public void setValoresViernes(){
        this.horarioViernes = 
            horarioTrabajoController.getHorarioTrabajo(ConsultorioMedicoConst.VIERNES)
                    .getResult();        
        cbVierHoraInicio.setSelectedItem(this.horarioViernes.getHoraInicio());
        cbVierHoraFin.setSelectedItem(this.horarioViernes.getHoraFinal());
        jcbViernes.setSelected((this.horarioViernes.getDiaLobaral() == 1));
    }
    public void setValoresSabado(){
        this.horarioSabado = 
            horarioTrabajoController.getHorarioTrabajo(ConsultorioMedicoConst.SABADO)
                    .getResult();        
        cbSabHoraInicio.setSelectedItem(this.horarioSabado.getHoraInicio());
        cbSabHoraFin.setSelectedItem(this.horarioSabado.getHoraFinal());
        jcbSabado.setSelected((this.horarioSabado.getDiaLobaral() == 1));
    }
    public void setValoresDomingo(){
        this.horarioDomingo = 
            horarioTrabajoController.getHorarioTrabajo(ConsultorioMedicoConst.DOMINGO)
                    .getResult();        
        cbDomHoraInicio.setSelectedItem(this.horarioDomingo.getHoraInicio());
        cbDomHoraFin.setSelectedItem(this.horarioDomingo.getHoraFinal());
        jcbDomingo.setSelected((this.horarioDomingo.getDiaLobaral() == 1));
    }
    
    public void removeItemsAll(){
        cbLunHoraInicio.removeAllItems();
        cbLunHoraFin.removeAllItems();
        cbMarHoraInicio.removeAllItems();
        cbMarHoraFin.removeAllItems();
        cbMierHoraInicio.removeAllItems();
        cbMierHoraFin.removeAllItems();
        cbJuevHoraInicio.removeAllItems();
        cbJuevHoraFin.removeAllItems();
        cbVierHoraInicio.removeAllItems();
        cbVierHoraFin.removeAllItems();
        cbSabHoraInicio.removeAllItems();
        cbSabHoraFin.removeAllItems();
        cbDomHoraInicio.removeAllItems();
        cbDomHoraFin.removeAllItems();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel35 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbLunHoraInicio = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cbLunHoraFin = new javax.swing.JComboBox();
        jcbLunes = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbMarHoraInicio = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        cbMarHoraFin = new javax.swing.JComboBox();
        jcbMartes = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbMierHoraInicio = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        cbMierHoraFin = new javax.swing.JComboBox();
        jcbMiercoles = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbJuevHoraInicio = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        cbJuevHoraFin = new javax.swing.JComboBox();
        jcbJueves = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cbVierHoraInicio = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        cbVierHoraFin = new javax.swing.JComboBox();
        jcbViernes = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cbSabHoraInicio = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        cbSabHoraFin = new javax.swing.JComboBox();
        jcbSabado = new javax.swing.JCheckBox();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cbDomHoraInicio = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        cbDomHoraFin = new javax.swing.JComboBox();
        jcbDomingo = new javax.swing.JCheckBox();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();

        jLabel35.setText("--------------------------------------------------------------------------------------");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Administración de horas");

        jLabel2.setText("Lunes");

        jLabel3.setText("Hora Inicio:");

        cbLunHoraInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Hora Final:");

        cbLunHoraFin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbLunes.setText("Es dia loborable");

        jLabel5.setText("--------------------------------------------------------------------------------------");

        jLabel7.setText("Martes");

        jLabel8.setText("Hora Inicio:");

        cbMarHoraInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Hora Final:");

        cbMarHoraFin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbMartes.setText("Es dia loborable");

        jLabel11.setText("Miercoles");

        jLabel12.setText("Hora Inicio:");

        cbMierHoraInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setText("Hora Final:");

        cbMierHoraFin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbMiercoles.setText("Es dia loborable");

        jLabel15.setText("Jueves");

        jLabel16.setText("Hora Inicio:");

        cbJuevHoraInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel17.setText("Hora Final:");

        cbJuevHoraFin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbJueves.setText("Es dia loborable");

        jLabel19.setText("Viernes");

        jLabel20.setText("Hora Inicio:");

        cbVierHoraInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel21.setText("Hora Final:");

        cbVierHoraFin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbViernes.setText("Es dia loborable");

        jLabel23.setText("Sabado");

        jLabel24.setText("Hora Inicio:");

        cbSabHoraInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel25.setText("Hora Final:");

        cbSabHoraFin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbSabado.setText("Es dia loborable");

        jLabel27.setText("Domingo");

        jLabel28.setText("Hora Inicio:");

        cbDomHoraInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel29.setText("Hora Final:");

        cbDomHoraFin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbDomingo.setText("Es dia loborable");

        jLabel31.setText("--------------------------------------------------------------------------------------");

        jLabel32.setText("--------------------------------------------------------------------------------------");

        jLabel33.setText("--------------------------------------------------------------------------------------");

        jLabel34.setText("--------------------------------------------------------------------------------------");

        jLabel36.setText("--------------------------------------------------------------------------------------");

        jLabel37.setText("--------------------------------------------------------------------------------------");

        jLabel38.setText("--------------------------------------------------------------------------------------");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(335, 335, 335))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnActualizar)
                    .addComponent(jLabel38)
                    .addComponent(jLabel37)
                    .addComponent(jLabel36)
                    .addComponent(jLabel34)
                    .addComponent(jLabel33)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbLunHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbLunHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jcbLunes))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel27)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel28)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbDomHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(jLabel29)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbDomHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel23)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbSabHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(jLabel25)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbSabHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel19)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel20)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbVierHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbVierHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbJuevHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbJuevHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbMierHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbMierHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbMarHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbMarHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(68, 68, 68)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jcbMartes, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jcbMiercoles, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jcbJueves, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jcbViernes, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jcbSabado, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jcbDomingo, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addGap(0, 71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(cbLunHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbLunHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbLunes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(cbMarHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cbMarHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMartes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(cbMierHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cbMierHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMiercoles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(cbJuevHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(cbJuevHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbJueves))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(cbVierHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(cbVierHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbViernes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(cbSabHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(cbSabHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSabado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(cbDomHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(cbDomHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbDomingo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnActualizar)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        
        /**
         * Lunes
         */
        horarioLunes.setHoraFinal(cbLunHoraFin.getSelectedItem().toString());
        horarioLunes.setHoraInicio(cbLunHoraInicio.getSelectedItem().toString());
        horarioLunes.setDiaLobaral((byte) (jcbLunes.isSelected() ? 1:0));
        Result<HorarioTrabajoVO> resultLunes = horarioTrabajoController.update(horarioLunes);
        
        
        /**
         * Martes
         */
        horarioMartes.setHoraFinal(cbMarHoraFin.getSelectedItem().toString());
        horarioMartes.setHoraInicio(cbMarHoraInicio.getSelectedItem().toString());
        horarioMartes.setDiaLobaral((byte) (jcbMartes.isSelected() ? 1:0));
        Result<HorarioTrabajoVO> resultMartes = horarioTrabajoController.update(horarioMartes);
        
        
        /**
         * Miercoles
         */
        horarioMiercoles.setHoraFinal(cbMierHoraFin.getSelectedItem().toString());
        horarioMiercoles.setHoraInicio(cbMierHoraInicio.getSelectedItem().toString());
        horarioMiercoles.setDiaLobaral((byte) (jcbMiercoles.isSelected() ? 1:0));
        Result<HorarioTrabajoVO> resultMiercoles = horarioTrabajoController.update(horarioMartes);
        
        
        /**
         * Jueves
         */
        horarioJueves.setHoraFinal(cbJuevHoraFin.getSelectedItem().toString());
        horarioJueves.setHoraInicio(cbJuevHoraInicio.getSelectedItem().toString());
        horarioJueves.setDiaLobaral((byte) (jcbJueves.isSelected() ? 1:0));
        Result<HorarioTrabajoVO> resultJueves = horarioTrabajoController.update(horarioJueves);
        
        
        /**
         * Viernes
         */
        horarioViernes.setHoraFinal(cbVierHoraFin.getSelectedItem().toString());
        horarioViernes.setHoraInicio(cbVierHoraInicio.getSelectedItem().toString());
        horarioViernes.setDiaLobaral((byte) (jcbViernes.isSelected() ? 1:0));
        Result<HorarioTrabajoVO> resultViernes = horarioTrabajoController.update(horarioViernes);
        
        
        /**
         * Sabado
         */
        horarioSabado.setHoraFinal(cbSabHoraFin.getSelectedItem().toString());
        horarioSabado.setHoraInicio(cbSabHoraInicio.getSelectedItem().toString());
        horarioSabado.setDiaLobaral((byte) (jcbSabado.isSelected() ? 1:0));
        Result<HorarioTrabajoVO> resultSabado = horarioTrabajoController.update(horarioSabado);
        
        /**
         * Domingo
         */
        horarioDomingo.setHoraFinal(cbDomHoraFin.getSelectedItem().toString());
        horarioDomingo.setHoraInicio(cbDomHoraInicio.getSelectedItem().toString());
        horarioDomingo.setDiaLobaral((byte) (jcbDomingo.isSelected() ? 1:0));
        Result<HorarioTrabajoVO> resultDomingo = horarioTrabajoController.update(horarioDomingo);
        
        String mensaje =
                "Lunes------->" + resultLunes.getMessage()     +
                "\nMartes------>" + resultMartes.getMessage()    +
                "\nMiercoles--->" + resultMiercoles.getMessage() +
                "\nJueves------>" + resultJueves.getMessage()    +
                "\nViernes----->" + resultViernes.getMessage()   +
                "\nSabado------>" + resultSabado.getMessage()    +
                "\nDomingo----->" + resultDomingo.getMessage();
        JOptionPane.showMessageDialog(null, mensaje);
    }//GEN-LAST:event_btnActualizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VtnAdministracionHoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnAdministracionHoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnAdministracionHoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnAdministracionHoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnAdministracionHoras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JComboBox cbDomHoraFin;
    private javax.swing.JComboBox cbDomHoraInicio;
    private javax.swing.JComboBox cbJuevHoraFin;
    private javax.swing.JComboBox cbJuevHoraInicio;
    private javax.swing.JComboBox cbLunHoraFin;
    private javax.swing.JComboBox cbLunHoraInicio;
    private javax.swing.JComboBox cbMarHoraFin;
    private javax.swing.JComboBox cbMarHoraInicio;
    private javax.swing.JComboBox cbMierHoraFin;
    private javax.swing.JComboBox cbMierHoraInicio;
    private javax.swing.JComboBox cbSabHoraFin;
    private javax.swing.JComboBox cbSabHoraInicio;
    private javax.swing.JComboBox cbVierHoraFin;
    private javax.swing.JComboBox cbVierHoraInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JCheckBox jcbDomingo;
    private javax.swing.JCheckBox jcbJueves;
    private javax.swing.JCheckBox jcbLunes;
    private javax.swing.JCheckBox jcbMartes;
    private javax.swing.JCheckBox jcbMiercoles;
    private javax.swing.JCheckBox jcbSabado;
    private javax.swing.JCheckBox jcbViernes;
    // End of variables declaration//GEN-END:variables
}
