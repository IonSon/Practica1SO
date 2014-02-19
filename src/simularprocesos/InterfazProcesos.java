/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simularprocesos;

import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ion Son
 */
public class InterfazProcesos extends javax.swing.JFrame 
{
    Thread ejecutor;
    Proceso proceso;
    Cola listosCola;
    ProductorProcesos productor;
    ConsumidorProcesos consumidor;
    boolean acabaEjecucion=false;
    double timeActual=0;
    
    int contadorListos=0;
    /**
     * Creates new form InterfazProcesos
     */
    public InterfazProcesos() 
    {
        listosCola=new Cola();
        productor=new ProductorProcesos(listosCola);
        consumidor=new ConsumidorProcesos(listosCola);
        initComponents();
    }
    
    synchronized public void addListaListos(int i)
    {
        listaListosTxtArea.append("ID de proceso: "+listosCola.getProceso(i).getIDProceso()+"\n");
    }
    
    synchronized void addEjecucion()
    {
        Proceso procesoActual= listosCola.quitarProceso();
        idProcesoTxt.setText(procesoActual.idProceso);
        tareaProcesoTxt.setText(procesoActual.tareaProceso);
        timeProcesoTxt.setText(String.valueOf(procesoActual.timeProceso));
        actualizaLineaListos();
        while (timeActual < procesoActual.timeProceso)
        {
            tiempo();
            if (!acabaEjecucion)
            {
                timeActual = timeActual + 1;
                progresoBarra((int) (timeActual * 100) / procesoActual.timeProceso); //transcurre la barra
            } else {
                procesoActual.timeProceso = -1; //valor solo para que termine el ciclo
            }
        }
    }
    
    private void progresoBarra(int incremento)
    {
        timeProcesoProgreso.setValue(incremento);
    }
    
    private void tiempo()
    {
        try
        {
            Thread.sleep(1000);
        }catch(InterruptedException exception)
        {
            JOptionPane.showMessageDialog(null, "Error en la ejecución, respuesta del sistema: "+exception.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void actualizaLineaListos()
    {
        StringTokenizer tokenizer= new StringTokenizer(listaListosTxtArea.getText(), "\n");
        int i=0; String linea="";
        while(tokenizer.hasMoreTokens())
        {
            if(i==0)
            {
                tokenizer.nextToken();
                i++;
            }
            else
            {
                linea = linea.concat(tokenizer.nextToken()).concat("\n");
                i++;
            }
        }
        listaListosTxtArea.setText(linea);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iniProcesosBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaListosTxtArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaEnEsperaTxtArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaTerminadosTxtArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        idProcesoTxt = new javax.swing.JTextField();
        timeProcesoTxt = new javax.swing.JTextField();
        tareaProcesoTxt = new javax.swing.JTextField();
        timeProcesoProgreso = new javax.swing.JProgressBar();
        pauseProcesosBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        iniProcesosBtn.setText("Iniciar procesos");
        iniProcesosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniProcesosBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Procesos listos");

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        listaListosTxtArea.setColumns(20);
        listaListosTxtArea.setRows(5);
        jScrollPane1.setViewportView(listaListosTxtArea);

        jLabel2.setText("Procesos en ejecuciòn");

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        listaEnEsperaTxtArea.setColumns(20);
        listaEnEsperaTxtArea.setRows(5);
        jScrollPane2.setViewportView(listaEnEsperaTxtArea);

        jLabel3.setText("Procesos en espera");

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        listaTerminadosTxtArea.setColumns(20);
        listaTerminadosTxtArea.setRows(5);
        jScrollPane3.setViewportView(listaTerminadosTxtArea);

        jLabel4.setText("Procesos terminados");

        jLabel5.setText("ID del proceso:");

        jLabel6.setText("Tarea a realizar:");

        jLabel7.setText("Duraciòn del proceso:");

        idProcesoTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        pauseProcesosBtn.setText("Pausar proceso actual");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(timeProcesoProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timeProcesoTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tareaProcesoTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idProcesoTxt))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(pauseProcesosBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(idProcesoTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tareaProcesoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(timeProcesoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timeProcesoProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(pauseProcesosBtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2)
                        .addGap(75, 75, 75))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(iniProcesosBtn)
                                .addGap(42, 42, 42)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(12, 12, 12)))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(iniProcesosBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniProcesosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniProcesosBtnActionPerformed
        // TODO add your handling code here:
        Thread panel=Thread.currentThread();
        panel.setPriority(Thread.MAX_PRIORITY);
        productor.setPriority(Thread.MIN_PRIORITY);
        consumidor.setPriority(Thread.MIN_PRIORITY);
        productor.start();
        addListaListos(0);
        consumidor.start();
        addEjecucion();
    }//GEN-LAST:event_iniProcesosBtnActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazProcesos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idProcesoTxt;
    private javax.swing.JButton iniProcesosBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea listaEnEsperaTxtArea;
    private javax.swing.JTextArea listaListosTxtArea;
    private javax.swing.JTextArea listaTerminadosTxtArea;
    private javax.swing.JButton pauseProcesosBtn;
    private javax.swing.JTextField tareaProcesoTxt;
    private javax.swing.JProgressBar timeProcesoProgreso;
    private javax.swing.JTextField timeProcesoTxt;
    // End of variables declaration//GEN-END:variables
}