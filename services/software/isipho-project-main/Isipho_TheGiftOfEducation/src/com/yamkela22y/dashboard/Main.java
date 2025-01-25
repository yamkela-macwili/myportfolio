/*
    This is the main page.
    Every other component ids added on thisd one.
*/
package com.yamkela22y.dashboard;

import com.gmail.yamkela22y.Panel.Contact;
import com.yamkela22y.databaseConnection.FindRec;
import com.gmail.yamkela22y.Panel.Gallary;
import com.gmail.yamkela22y.Panel.Map;
import com.gmail.yamkela22y.Panel.Staff_Form;
import com.yamkela22y.Chat.ChatApp.LetsChat;
import com.yamkela22y.databaseConnection.DataTable_db;
import com.yamkela22y.dashboard.component.Header;
import com.yamkela22y.dashboard.event.EventMenuSelected;
import com.yamkela22y.dashboard.event.EventShowPopupMenu;
import com.yamkela22y.dashboard.form.MainForm;
import com.yamkela22y.swing.MenuItem;
import com.yamkela22y.swing.PopupMenu;
import dashboard.com.yamkela.swing.icon.GoogleMaterialDesignIcons;
import dashboard.com.yamkela.swing.icon.IconFontSwing;
import com.yamkela22y.dashboard.component.Menu;
import com.yamkela22y.dashboard.dialog.MessageDialog;
import com.yamkela22y.dashboard.form.Form1;
import com.yamkela22y.dashboard.form.Home;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import com.yamkela22y.Register.Gift_Of_Education_App;
import com.yamkela22y.aps_calculator.ApsCalulator;
import com.yamkela22y.chart.BarChart;
import com.yamkela22y.chart.HistogramChart;
import com.yamkela22y.chart.LineChart;
import com.yamkela22y.chart.PieChart;
import com.yamkela22y.login.authenticator.Login;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


/**
 * 
 * @author yamkela
 */
public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    public static MainForm main;
    private Animator animator;

    public Main() {
        initComponents();
        ImageIcon icon = new ImageIcon("C:\\Users\\yamke\\OneDrive\\NetBeansProjects\\IsiphoRegistrationForm\\src\\app_icons\\Background_images\\isiphoLogo_icon.jpg");
        this.setIconImage(icon.getImage());
        init();
    }

    /**
     * Initializes the main page {Home Page) of the application
     */
    private void init() {
        layout = new MigLayout("fill", "10[]10[100%, fill]10", "10[fill, top]10");
        mainPanel.setLayout(layout);
        menu = new Menu();
        header = new Header();
        main = new MainForm();
        //  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        menu.addEvent(new EventMenuSelected() {
            @Override
            
            //***********************Dashboard meu
            public void menuSelected(int menuIndex, int subMenuIndex) {
//                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                    if (subMenuIndex == 0) {
//                        main.showForm(new Form_Home());
                        main.showForm(new Home());
                    } else if (subMenuIndex == 1) {
                        main.showForm(new Form1());
                    }
                } 
                //****************Application menu
                else if (menuIndex == 1) {
                    switch (subMenuIndex) {
                        case 0:
                            new Gift_Of_Education_App().setVisible(true);
                            break;
                        case 1:
                            new Gift_Of_Education_App().setVisible(true);
                            break;
                        case 2:
                            new Gift_Of_Education_App().setVisible(true);
                            break;
                        default:
                            break;
                    }
                } 
                //************************Chart menu
                else if (menuIndex == 2) {
                    switch (subMenuIndex) {
                        case 0:
                            main.showForm(new BarChart());
                            break;
                        case 1:
                            main.showForm(new HistogramChart());
                            break;
                        case 2:
                            main.showForm(new LineChart());
                            break;

                        case 3:
                            main.showForm(new PieChart());
                            break;
                        default:
                            break;
                    }
                } 
                //************************File manger menu
                else if (menuIndex == 3) {
                    switch (subMenuIndex) {
                        case 0:
                            main.showForm(new DataTable_db("SELECT first_name, last_name, location, school, phone_No , rec_date FROM reg"));
                            break;
                        case 1:
                            new DataTable_db().printTable("SELECT first_name, last_name, location, school, phone_No , rec_date FROM reg");
                            break;
                        case 2:
                            main.showForm(new FindRec());
                            break;
                    }
                } 
                //************************Map menu
                else if (menuIndex == 4) {
                    switch (subMenuIndex) {
                        case 0:
                            JOptionPane.showMessageDialog(rootPane, "This feature is under construction.");
                            main.showForm(new Map());
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(rootPane, "This feature is under construction.");
                            main.showForm(new Map());
                            break;
                    }
                }
                //************************Chat App menu
                else if (menuIndex == 5) {
                    main.showForm(new LetsChat());
//                    main.showForm(new MessageDialog());
                }
                //************************Message menu
                else if (menuIndex == 6) {
                   JOptionPane.showMessageDialog(null,"Feature under construction!" );
                   main.showForm(new Map());
//                    main.showForm(new MessageDialog());
                }
                //************************Staff menu
                else if (menuIndex == 7) {
                    main.showForm(new Staff_Form());
                } 
                //************************Contact menu
                else if (menuIndex == 8) {
                    main.showForm(new Contact());
                } 
                //************************APS Calculator menu
                else if (menuIndex == 9) {
                    main.showForm(new ApsCalulator());
                } 
                //************************Gallery menu
                else if (menuIndex == 10) {
                    main.showForm(new Gallary());
                } 
                //************************Logout menu
                else if (menuIndex == 11) {
                    //
                    dispose();
                    new Login().setVisible(true); 
                } 
                //************************Exit menu
                else if (menuIndex == 12) {
                    System.exit(0);
                }
            }
        });
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(Main.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = Main.this.getX() + 62;
                int y = Main.this.getY() + com.getY() + 95;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.initMenuItem();
        mainPanel.add(menu, "w 230!, spany 2");    // Span Y 2cell
        mainPanel.add(header, "h 50!, wrap");
        mainPanel.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });

        //  Start with this form
//        main.showForm(new Form_Home());
        main.showForm(new Home());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Isipho UI");
        setUndecorated(true);

        mainPanel.setOpaque(false);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1356, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
        );

        jDesktopPane1.setLayer(mainPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //SwingAcrylic.prepareSwing();
                Main frame = new Main();
                frame.setVisible(true);
                //SwingAcrylic.processFrame(frame);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
