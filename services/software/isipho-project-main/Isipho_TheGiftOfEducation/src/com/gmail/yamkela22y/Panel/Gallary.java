
package com.gmail.yamkela22y.Panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author yamkela
 */
public class Gallary extends javax.swing.JPanel {

    /**
     * Creates new form gallery
     */
    public Gallary() {
        initComponents();
        //timer.start();
        gridImageView();
    }
    
    /**
     * When an image is clicked this method is called to display the selected image.
     * @param imageIcon 
     */
    public static void setlblImageContainer(Icon imageIcon){
        lblImageContainer.removeAll();
        lblImageContainer.setLayout(new BorderLayout());
        lblImageContainer.setIcon(imageIcon);
    }
    
    private void gridImageView(){
        //lblImageContainer.setIcon(null); 
        lblImageContainer.setLayout(new GridLayout(2,5,5,3));
        for(int i=0; i<10; i++){
          lblImageContainer.add(new GalleryImageList(new ImageIcon(new ImageIcon("C:\\Users\\yamke\\Documents\\NetBeansProjects\\Isipho_TheGiftOfEducation\\src\\app_icons\\Animation_photos\\" + i + ".jpg").getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT)),i));
        }
                
    }
    
    int counter = 0;
    Timer timer = new Timer(5000, new ActionListener() {
        @SuppressWarnings("ResultOfObjectAllocationIgnored")
        @Override
        public void actionPerformed(ActionEvent e) {
            counter++;
            
            switch (counter) {
                case 1 -> {
                     gridImageView();
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\yamke\\Documents\\NetBeansProjects\\Isipho_TheGiftOfEducation\\src\\app_icons\\Animation_photos\\0.png").getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
                    lblImageContainer.setIcon(imageIcon);
                }
                case 2 -> {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\yamke\\Documents\\NetBeansProjects\\Isipho_TheGiftOfEducation\\src\\app_icons\\Animation_photos\\1.jpg").getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
                    lblImageContainer.setIcon(imageIcon);
                }
                case 3 -> {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\yamke\\Documents\\NetBeansProjects\\Isipho_TheGiftOfEducation\\src\\app_icons\\Animation_photos\\2.jpg").getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
                    lblImageContainer.setIcon(imageIcon);
                }
                case 4 -> {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\yamke\\Documents\\NetBeansProjects\\Isipho_TheGiftOfEducation\\src\\app_icons\\Animation_photos\\3.jpg").getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
                    lblImageContainer.setIcon(imageIcon);
                }
                case 5 -> {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\yamke\\Documents\\NetBeansProjects\\Isipho_TheGiftOfEducation\\src\\app_icons\\Animation_photos\\4.jpg").getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
                    lblImageContainer.setIcon(imageIcon);
                }
                case 6 -> {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\yamke\\Documents\\NetBeansProjects\\Isipho_TheGiftOfEducation\\src\\app_icons\\Animation_photos\\5.jpg").getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
                    lblImageContainer.setIcon(imageIcon);
                }
                case 7 -> {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\yamke\\Documents\\NetBeansProjects\\Isipho_TheGiftOfEducation\\src\\app_icons\\Animation_photos\\6.jpg").getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
                    lblImageContainer.setIcon(imageIcon);
                }
                case 8 -> {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\yamke\\Documents\\NetBeansProjects\\Isipho_TheGiftOfEducation\\src\\app_icons\\Animation_photos\\7.jpg").getImage().getScaledInstance(702, 401, Image.SCALE_DEFAULT));
                    lblImageContainer.setIcon(imageIcon);
                }
                case 9 -> {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\yamke\\Documents\\NetBeansProjects\\Isipho_TheGiftOfEducation\\src\\app_icons\\Animation_photos\\8.jpg").getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
                    lblImageContainer.setIcon(imageIcon);
                }
                case 10 -> {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\yamke\\Documents\\NetBeansProjects\\Isipho_TheGiftOfEducation\\src\\app_icons\\Animation_photos\\9.jpg").getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
                    lblImageContainer.setIcon(imageIcon);
                }
                case 11 -> {
                    //gridImageView();
                }
            }
        }

    });

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImageContainer = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        lblImageContainer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(lblImageContainer, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel lblImageContainer;
    // End of variables declaration//GEN-END:variables
}
