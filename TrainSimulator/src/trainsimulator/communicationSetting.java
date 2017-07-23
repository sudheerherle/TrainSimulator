/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * communicationSetting.java
 *
 * Created on Feb 24, 2012, 3:38:57 PM
 */

package trainsimulator;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import trainsimulator.common.SharedData;

/**
 *
 * @author I14746
 */
public class communicationSetting extends javax.swing.JDialog {
    
private communicationSetting this_class = this;
    /** Creates new form communicationSetting */
    public communicationSetting(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
//        com1.setEnabled(false);
//        com2.setEnabled(false);
//        com3.setEnabled(false);
//        com4.setEnabled(false);
        ButtonGroup grp = new ButtonGroup();
        grp.add(usb);
        grp.add(com1);
        grp.add(com2);
        grp.add(com3);
        grp.add(com4);
        usb.setSelected(true);
        usb.setEnabled(true);  
        if(SharedData.getSingletonObject().connected){
            LblStatus.setText("CONNECTED!");
            BtnConnect.setText("Disconnect");
            LblStatus.setForeground(Color.BLUE);
            }else{
                BtnConnect.setText("Connect");
                LblStatus.setText("NOT CONNECTED");
                LblStatus.setForeground(Color.RED);
       }
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        usb = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        com1 = new javax.swing.JRadioButton();
        com2 = new javax.swing.JRadioButton();
        com4 = new javax.swing.JRadioButton();
        com3 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        LblStatus = new javax.swing.JLabel();
        BtnConnect = new javax.swing.JButton();

        jPanel3.setName("jPanel3"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(trainsimulator.TrainSimulatorApp.class).getContext().getResourceMap(communicationSetting.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);

        jPanel4.setName("jPanel4"); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setName("jPanel2"); // NOI18N

        usb.setFont(resourceMap.getFont("usb.font")); // NOI18N
        usb.setText(resourceMap.getString("usb.text")); // NOI18N
        usb.setName("usb"); // NOI18N
        usb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usb, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usb)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        com1.setFont(resourceMap.getFont("usb.font")); // NOI18N
        com1.setText(resourceMap.getString("com1.text")); // NOI18N
        com1.setName("com1"); // NOI18N

        com2.setFont(resourceMap.getFont("usb.font")); // NOI18N
        com2.setText(resourceMap.getString("com2.text")); // NOI18N
        com2.setName("com2"); // NOI18N

        com4.setFont(resourceMap.getFont("usb.font")); // NOI18N
        com4.setText(resourceMap.getString("com4.text")); // NOI18N
        com4.setName("com4"); // NOI18N

        com3.setFont(resourceMap.getFont("usb.font")); // NOI18N
        com3.setText(resourceMap.getString("com3.text")); // NOI18N
        com3.setName("com3"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(com1)
                    .addComponent(com3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(com2)
                    .addComponent(com4))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(com2)
                        .addGap(18, 18, 18)
                        .addComponent(com4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(com1)
                        .addGap(18, 18, 18)
                        .addComponent(com3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel1, jPanel2});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        LblStatus.setForeground(resourceMap.getColor("LblStatus.foreground")); // NOI18N
        LblStatus.setText(resourceMap.getString("LblStatus.text")); // NOI18N
        LblStatus.setName("LblStatus"); // NOI18N

        BtnConnect.setText(resourceMap.getString("BtnConnect.text")); // NOI18N
        BtnConnect.setName("BtnConnect"); // NOI18N
        BtnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(LblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(BtnConnect)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(LblStatus))
                    .addComponent(BtnConnect))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnConnect, LblStatus, jLabel1});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usbActionPerformed
        usb.setSelected(true);
    }//GEN-LAST:event_usbActionPerformed

    private void BtnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConnectActionPerformed
       
      Thread te = new Thread(new Runnable() {

        public void run()
        {
           LblStatus.setText("Please wait...");
           LblStatus.setForeground(Color.BLUE);
           BtnConnect.setEnabled(false);
           if(BtnConnect.getText().equals("Connect")){
           if(usb.isSelected() &&  TrainSimulatorApp.getApplication().getView().com_connect()){
            LblStatus.setText("CONNECTED!");
            BtnConnect.setText("Disconnect");
            LblStatus.setForeground(Color.BLUE);
                try {
                    Thread.sleep(1000);                    
                    this_class.finalize();
                    this_class.dispose();
                }catch (Throwable ex) {
                            Logger.getLogger(communicationSetting.class.getName()).log(Level.SEVERE, null, ex);
                } 
            
            }else{
                LblStatus.setText("NOT CONNECTED");
                //TrainSimulatorApp.getApplication().TSview.connection_indicator_panel.setBackground(Color.RED);
                LblStatus.setForeground(Color.RED);
            }}else{
               if(TrainSimulatorApp.getApplication().TSview.com_disconnect()){
                LblStatus.setText("DISCONNECTED!");
                BtnConnect.setText("Connect");
                LblStatus.setForeground(Color.RED); 
               }
           }
           BtnConnect.setEnabled(true);
        }
        });
        te.start();  
        
      
    }//GEN-LAST:event_BtnConnectActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                communicationSetting dialog = new communicationSetting(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnConnect;
    private javax.swing.JLabel LblStatus;
    private javax.swing.JRadioButton com1;
    private javax.swing.JRadioButton com2;
    private javax.swing.JRadioButton com3;
    private javax.swing.JRadioButton com4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton usb;
    // End of variables declaration//GEN-END:variables

}
