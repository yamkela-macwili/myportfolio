/*Basaries Frame
  Provides the list of basaries.
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

/**
 *
 * @author YAMKELA MACWILI
 */
public class Bursaries extends JFrame implements ActionListener{
    private final JButton btnNSFAS = new JButton("NSFAS");
    private final JButton btnFUNZA = new JButton("FUNZA Lushaka ");
    ImageIcon icon = null;
    
    public Bursaries(){
        super("Bursaries");
        setBounds(450, 350, 450, 450);
        getContentPane().setBackground(new Color(123,50,250)); // backgroung color
        setVisible(true);
        setResizable(false);
        icon = new ImageIcon("C:\\Users\\yamke\\OneDrive\\NetBeansProjects\\IsiphoRegistrationForm\\src\\app_icons\\Background_images\\isiphoLogo_icon.jpg");
        setIconImage(icon.getImage());
        setLayout(new GridLayout(5, 1, 5, 5));
            
        add(btnNSFAS);
        btnNSFAS.addActionListener(this);
        add(btnFUNZA);
        btnFUNZA.addActionListener(this);
        pack(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         Object source = e.getSource();
        Desktop desktop = Desktop.getDesktop();

        if (source == btnNSFAS) {
            try {
                desktop.browse(new URI("https://www.nsfas.org.za"));
            } catch (URISyntaxException | IOException ex) {
                Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(source == btnFUNZA){
             try {
                desktop.browse(new URI("http://www.funzalushaka.doe.gov.za"));
            } catch (URISyntaxException | IOException ex) {
                Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
    

