/*
    Displays pictures on the login page 
*/

package com.yamkela22y;

import java.awt.Image;
import javax.swing.Timer;
import java.awt.event.*;
import javax.swing.ImageIcon;

/**
 *
 * @author Yamkela Macwili
 */
public class Animation extends javax.swing.JFrame {

    ImageIcon icon = null;
    /**
     * Creates new form Animation
     */
    public Animation() {
        setResizable(false);
        this.setVisible(true);
        icon = new ImageIcon("C:\\Users\\yamke\\OneDrive\\NetBeansProjects\\IsiphoRegistrationForm\\src\\app_icons\\Background_images\\isiphoLogo_icon.jpg");
        setIconImage(icon.getImage());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnSignIn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 100));
        setMinimumSize(new java.awt.Dimension(700, 400));
        setSize(new java.awt.Dimension(700, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBtnSignIn.setBackground(new java.awt.Color(51, 0, 51));
        jBtnSignIn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBtnSignIn.setForeground(new java.awt.Color(255, 204, 255));
        jBtnSignIn.setText("SignIn");
        jBtnSignIn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jBtnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSignInActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 90, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_icons/Animation_photos/main_Icon_710x400.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int counter = 0;
    Timer timer = new Timer(1000, new ActionListener() {
        @SuppressWarnings("ResultOfObjectAllocationIgnored")
        @Override
        public void actionPerformed(ActionEvent e) {
            counter++;
            switch (counter) {
                case 1 ->  {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\yamke\\OneDrive\\NetBeansProjects\\IsiphoRegistrationForm\\src\\app_icons\\Animation_photos\\0.png").getImage().getScaledInstance(702, 401, Image.SCALE_DEFAULT));
                    jLabel1.setIcon(imageIcon);
                }
                case 2 ->  {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\yamke\\OneDrive\\NetBeansProjects\\IsiphoRegistrationForm\\src\\app_icons\\Animation_photos\\1.jpg").getImage().getScaledInstance(702, 401, Image.SCALE_DEFAULT));
                    jLabel1.setIcon(imageIcon);
                }
                case 3 ->  {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\yamke\\OneDrive\\NetBeansProjects\\IsiphoRegistrationForm\\src\\app_icons\\Animation_photos\\2.jpg").getImage().getScaledInstance(702, 401, Image.SCALE_DEFAULT));
                    jLabel1.setIcon(imageIcon);
                }
                case 4 ->  {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\yamke\\OneDrive\\NetBeansProjects\\IsiphoRegistrationForm\\src\\app_icons\\Animation_photos\\3.jpg").getImage().getScaledInstance(702, 401, Image.SCALE_DEFAULT));
                    jLabel1.setIcon(imageIcon);
                }
                case 5 ->  {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\yamke\\OneDrive\\NetBeansProjects\\IsiphoRegistrationForm\\src\\app_icons\\Animation_photos\\4.jpg").getImage().getScaledInstance(702, 401, Image.SCALE_DEFAULT));
                    jLabel1.setIcon(imageIcon);
                }
            }

            if (counter == 6) {
                dispose();
                new LoginForm();
            }
           }

    });

    private void jBtnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSignInActionPerformed

        jBtnSignIn.setVisible(false);
        timer.start();

    }//GEN-LAST:event_jBtnSignInActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnSignIn;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
