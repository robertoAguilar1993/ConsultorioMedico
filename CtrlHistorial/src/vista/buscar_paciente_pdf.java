package vista;

//package ;

import Controller.PacienteController;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Result;
import vo.PacienteVO;


public class buscar_paciente_pdf extends javax.swing.JFrame {

    /**
     * Declarar variables
     */
    PacienteVO pacienteVO = new PacienteVO();
    PacienteController pacienteController = new PacienteController();
    
    public buscar_paciente_pdf() {
        initComponents();
        this.setLocationRelativeTo(null);
        findAll();
        btnVerHistorial.setEnabled(false);
        
    }
    
    private void findAll(){
        Result<List<PacienteVO>> result  =pacienteController.findAll();
        if ( result.isOperationStatus() ) {
            llenar(result.getResult());
        }else{
           JOptionPane.showMessageDialog(null,result.getMessage()); 
        }
    }
    
    private void bindByCriteria(){
        if(txtBuscar1.getText() == null || "".equals(txtBuscar1.getText())){
            findAll();
        }else{
            Result<List<PacienteVO>> result  = pacienteController
                    .findByCriteria(txtBuscar1.getText());
            if ( result.isOperationStatus() ) {
                llenar(result.getResult());
            }else{
               JOptionPane.showMessageDialog(null,result.getMessage()); 
            }
        }
    }
    
    
    private void llenar(List<PacienteVO> pacienteVOs){
        
        String [] titulo={
            "Clave", 
            "Nombre",
            "Apellido paterno",
            "Apellido materno", 
            "Telefono "};
        
        if( pacienteVOs != null && !pacienteVOs.isEmpty() ) {
            DefaultTableModel modelo = new DefaultTableModel(null,titulo);

            Object [] fila = new Object[8];
            for (PacienteVO paciente:  pacienteVOs ) {
                fila[0] = paciente.getId();
                fila[1] = paciente.getNombre();
                fila[2] = paciente.getApellidoPaterno();
                fila[3] = paciente.getApellidoMaterno();
                fila[4] = paciente.getTelefono();
                modelo.addRow(fila);
            }
            jtbpaciente.setModel(modelo);
        }
        
    }
    
    public int getEdad(Date fechaNacimiento){
        int yearNow = new Date().getYear();
        return yearNow - fechaNacimiento.getYear();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbpaciente = new javax.swing.JTable();
        btnVerHistorial = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtbpaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbpaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbpacienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jtbpacienteMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jtbpaciente);

        btnVerHistorial.setText("Ver historial");
        btnVerHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerHistorialActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir.png"))); // NOI18N
        jLabel2.setText("Imprimir reportes ");

        txtBuscar1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtBuscar1.setMargin(new java.awt.Insets(2, 10, 2, 2));
        txtBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar1ActionPerformed(evt);
            }
        });
        txtBuscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscar1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnVerHistorial))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(txtBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(473, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(43, 43, 43)
                .addComponent(txtBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerHistorial)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbpacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbpacienteMouseClicked
        // TODO add your handling code here:
        int linea = jtbpaciente.getSelectedRow();
        String id = jtbpaciente.getValueAt(linea, 0).toString();
        System.err.println("id: " +  id);
        
        Result<PacienteVO> pacienteResult = pacienteController.findById(Integer.parseInt(id));
        
        if(!pacienteResult.isOperationStatus()){
            JOptionPane.showMessageDialog(null,pacienteResult.getMessage() ,"Error",JOptionPane.ERROR_MESSAGE);
            btnVerHistorial.setEnabled(false);
            
        }else{
            pacienteVO = pacienteResult.getResult();
            pacienteVO.setId(pacienteVO.getId());
           
            
            int numGenero = "Masculino".equalsIgnoreCase(pacienteVO.getGenero()) ? 1: 2;
            
           
            btnVerHistorial.setEnabled(true);
           
        }
        
    }//GEN-LAST:event_jtbpacienteMouseClicked

    private void jtbpacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbpacienteMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jtbpacienteMouseEntered

    private void btnVerHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerHistorialActionPerformed
        // TODO add your handling code here:
        vtnVerHistorialPaciente lp= new vtnVerHistorialPaciente(this.pacienteVO);
        lp.setVisible(true);
    }//GEN-LAST:event_btnVerHistorialActionPerformed

    private void txtBuscar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar1KeyReleased
        bindByCriteria();
        limpairDatos();
    }//GEN-LAST:event_txtBuscar1KeyReleased

    private void txtBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar1ActionPerformed

    public void limpairDatos(){
        
        btnVerHistorial.setEnabled(false);
        
    }
    
    
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
            java.util.logging.Logger.getLogger(buscar_paciente_pdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buscar_paciente_pdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buscar_paciente_pdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buscar_paciente_pdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new buscar_paciente_pdf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerHistorial;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbpaciente;
    private javax.swing.JTextField txtBuscar1;
    // End of variables declaration//GEN-END:variables
}
