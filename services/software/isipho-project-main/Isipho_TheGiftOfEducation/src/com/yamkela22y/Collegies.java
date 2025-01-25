/*Collagies Frame
  Provides the list of Collagis.
*/
package com.yamkela22y;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author YAMKELA MACWILI
 */
public class Collegies extends JFrame implements ActionListener{
 
    //Collegies 
      private final JButton btnIkhala = new JButton("Ikhala TVET College");
     private final JButton btnBoland = new JButton("Boland TVET College");
     private final JButton btnBuffalo = new JButton("Buffalo City TVET College");
     private final JButton btnCapricorn = new JButton("Capricorn TVET College");
     private final JButton btnCentralJHB = new JButton("Central Johannesburg TVET College");
     private final JButton btnCoastalKZN = new JButton("Coastal KZN TVET College");
     private final JButton btnCollegeCapeTown = new JButton("College of Cape Town");
     private final JButton btnECMidlands = new JButton("Eastcape Midlands TVET College");
     private final JButton btnEhlanzeni= new JButton("Ehlanzeni TVET College");
     private final JButton btnEkurhuleniE = new JButton("Ekurhuleni East TVET College");
     
     ImageIcon icon = null; // Changing the default icon
     
     //Consructor
     public Collegies(){
        super("Collegies"); //Frame title
        setBounds(250, 250, 350, 350);
        getContentPane().setBackground(new Color(123,50,250)); // backgroung color
        setVisible(true);
        setResizable(false);
        //Initialize the image icon
        icon = new ImageIcon("C:\\Users\\yamke\\OneDrive\\NetBeansProjects\\IsiphoRegistrationForm\\src\\app_icons\\Background_images\\isiphoLogo_icon.jpg");
        setIconImage(icon.getImage());//set the image icon
        setLayout(new GridLayout(5, 1, 5, 5)); // 5 row and 1 column
        
        add(btnIkhala);
        btnIkhala.addActionListener(this);
        add(btnBoland);
        add(btnBuffalo);
        add(btnCapricorn);
        add(btnCentralJHB);
        add(btnCoastalKZN);
        add(btnCollegeCapeTown);
        add(btnECMidlands);
        add(btnEhlanzeni);
        add(btnEkurhuleniE);
        
        pack(); 
     }
     private String college;

    public String getCollege() {
        return college;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        Desktop desktop = Desktop.getDesktop();
        college = e.getActionCommand();
        boolean isPressed = !college.isEmpty();
        
        if (source == btnIkhala) {
            try {
                desktop.browse(new URI("https://www.ikhala.edu.za"));
            } catch (URISyntaxException | IOException ex) {
                Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (isPressed) {
            JOptionPane.showMessageDialog(null, "Email feedback underconstruction");
        }
    }

}

