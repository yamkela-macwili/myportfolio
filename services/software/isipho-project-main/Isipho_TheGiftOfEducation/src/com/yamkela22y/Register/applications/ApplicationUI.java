/*
 * This class ceates the Univerty model form.
 * 
 */
package com.yamkela22y.Register.applications;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yamkela
 */
public class ApplicationUI extends javax.swing.JPanel {

    /**
     * Creates new form UniversityUI
     *
     * @param uni_Model
     */
    public ApplicationUI(ApplicationModel uni_Model) {
        initComponents();
        setVisible(true);
        getMessage(uni_Model);
        loadingBar.setVisible(false);
    }

    private void getMessage(ApplicationModel uni_Model) {
        lblUniversity.setText(uni_Model.getUniversity());
        lblProvince.setText(uni_Model.getProvince());
        lblFee.setText("R " + uni_Model.getApplicationFee());
        lblProfile.setText("" + uni_Model.getUniversity().charAt(0));

        //Get the url
        setURL(uni_Model.getApplicationLink());
    }

    private String url = null;

    private void setURL(String url) {
        this.url = url;
    }

    private String getURl() {
        return url;
    }

    Thread th;

    private void load() {

        th = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    loadingBar.setVisible(true);
                    Thread.sleep(4000);
                    loadingBar.setVisible(false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(com.yamkela22y.login.components.PanelSlide.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        th.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        lblUniversity = new javax.swing.JLabel();
        lblProfile = new javax.swing.JLabel();
        lblProvince = new javax.swing.JLabel();
        lblFee = new javax.swing.JLabel();
        loadingBar = new javax.swing.JLabel();

        setOpaque(false);

        jPanel1.setOpaque(false);
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jDesktopPane2.setOpaque(false);

        lblUniversity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUniversity.setForeground(new java.awt.Color(255, 255, 255));
        lblUniversity.setText("University");

        lblProfile.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblProfile.setForeground(new java.awt.Color(255, 0, 0));
        lblProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProfile.setText("W");

        lblProvince.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblProvince.setForeground(new java.awt.Color(255, 255, 255));
        lblProvince.setText("Province");

        lblFee.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFee.setForeground(new java.awt.Color(255, 255, 255));
        lblFee.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblFee.setText("Fee");
        lblFee.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        loadingBar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        loadingBar.setForeground(new java.awt.Color(255, 255, 255));
        loadingBar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loadingBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yamkela/login/icon/loading.gif"))); // NOI18N
        loadingBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jDesktopPane2.setLayer(lblUniversity, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(lblProfile, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(lblProvince, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(lblFee, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(loadingBar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUniversity, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                        .addGap(0, 79, Short.MAX_VALUE))
                    .addComponent(loadingBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFee, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addComponent(lblUniversity, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProvince, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addComponent(lblFee)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loadingBar, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        load();
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(new URI(getURl()));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(ApplicationUI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jPanel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFee;
    private javax.swing.JLabel lblProfile;
    private javax.swing.JLabel lblProvince;
    private javax.swing.JLabel lblUniversity;
    private javax.swing.JLabel loadingBar;
    // End of variables declaration//GEN-END:variables
}
