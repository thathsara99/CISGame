/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;



/**
 *
 * @author User
 */
public class Loading extends javax.swing.JFrame {

    /**
     * Creates new form Loading
     */
    public Loading() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        loading = new javax.swing.JLabel();
        precentage = new javax.swing.JLabel();
        loadingbar = new javax.swing.JProgressBar();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loading.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        loading.setForeground(new java.awt.Color(51, 51, 51));
        loading.setText("LOADING........");
        jPanel2.add(loading, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 720, 460, -1));

        precentage.setFont(new java.awt.Font("Papyrus", 1, 20)); // NOI18N
        precentage.setText("0%");
        jPanel2.add(precentage, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 720, 50, -1));

        loadingbar.setBackground(new java.awt.Color(255, 0, 0));
        loadingbar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.add(loadingbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 710, 1250, 40));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/load.png"))); // NOI18N
        Background.setText("jLabel3");
        jPanel2.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 750));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Loading().setVisible(true);
            }
        });
        
    Loading sp= new Loading();
    
    sp.setVisible(true);
    
         Login login;
        login = new Login();
    
    try{
        for (int i=0;i<=100;i++){
            Thread.sleep(100);
            sp.precentage.setText(i +"%");
            
            if (i==10){
                sp.loading.setText("CONNECT TO THE SERVER....");
            }
            if (i==20){
                sp.loading.setText("LOADING SERVER....");
            }
            
            if (i==50){
                sp.loading.setText("CONNECTING TO DATABASE....");
            }
            
            if (i==70){
                sp.loading.setText("CONNECTION SUCCESSFULL....");
            }
            
            if (i==80){
                sp.loading.setText("LOUNCHING THE GAME....");
            }
            sp.loadingbar.setValue(i);
        }
       sp.setVisible(false);
        login.setVisible(true);
        
    }catch (Exception e){
        
        
    }
       
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel loading;
    private javax.swing.JProgressBar loadingbar;
    private javax.swing.JLabel precentage;
    // End of variables declaration//GEN-END:variables
}