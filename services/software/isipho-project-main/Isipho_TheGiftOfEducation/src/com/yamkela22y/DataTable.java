/*Registe table
   Displays the the database table

*/
package com.yamkela22y;

import static com.yamkela22y.databaseConnection.DatabaseConnection.getConnection;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author YAMKELA MACWILI
 */
public class DataTable extends javax.swing.JFrame {
 
    /**
     * Creates new form DataTable
     */
    ImageIcon icon = null;
    public DataTable() throws ClassNotFoundException {
        super("Isipho Register");
        initComponents();
        icon = new ImageIcon("C:\\Users\\yamke\\OneDrive\\NetBeansProjects\\IsiphoRegistrationForm\\src\\app_icons\\Background_images\\isiphoLogo_icon.jpg");
        setIconImage(icon.getImage());
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

     public final void tableLoad() throws ClassNotFoundException{
         
        PreparedStatement pstmt;
        Connection conn;
        
        try {
//            String SQL = "SELECT Name, Surname, village, school, Cellphone_No , Date FROM isipho_db.isipho_data_table";//
            String SQL = "SELECT first_name, last_name, location, school, phone_No , rec_date FROM reg";//
            
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);   
            ResultSet rs = pstmt.executeQuery(); //use exectuteQuery for
            tblPrintableRegister.setModel(DbUtils.resultSetToTableModel(rs));
        }    
        
        catch (SQLException e) {
            
           JOptionPane.showMessageDialog(null, e);
        } 
     }
     
     public final void searchByDate(JTable tableName, String sql_comm) throws ClassNotFoundException{
         
        PreparedStatement pstmt;
        Connection conn;
        String date = JOptionPane.showInputDialog(null, "Date (yyyy-mm-dd)", null);
        
        try {
//            String SQL = "SELECT Name, Surname, village, Phone, date FROM isipho where date = ?";
            String SQL = sql_comm;
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);  
            pstmt.setString(1, date);
            ResultSet rs = pstmt.executeQuery(); //use exectuteQuery for
            tableName.setModel(DbUtils.resultSetToTableModel(rs));
//            tblPrintableRegister.setModel(DbUtils.resultSetToTableModel(rs));
        }    
        
        catch (SQLException e) {
            
           JOptionPane.showMessageDialog(null, e);
        } 
     }
     
     public final void searchBySchool() throws ClassNotFoundException{
         
        PreparedStatement pstmt;
        Connection conn;
        String school = JOptionPane.showInputDialog(null, "School name", null);
        
        try {
            String SQL = "SELECT Name, Surname, village, Phone, date FROM isipho where school = ?";
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);  
            pstmt.setString(1, school);
            ResultSet rs = pstmt.executeQuery(); //use exectuteQuery for
            tblPrintableRegister.setModel(DbUtils.resultSetToTableModel(rs));
        }    
        
        catch (SQLException e) {
            
           JOptionPane.showMessageDialog(null, e);
        } 
     }
     
     public final void searchByVillage() throws ClassNotFoundException{
         
        PreparedStatement pstmt;
        Connection conn;
        String vill = JOptionPane.showInputDialog(null, "Village", null);
        
        try {
            String SQL = "SELECT Name, Surname, village, Phone, date FROM isipho where village = ?";
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);  
            pstmt.setString(1, vill);
            ResultSet rs = pstmt.executeQuery(); //use exectuteQuery for
            tblPrintableRegister.setModel(DbUtils.resultSetToTableModel(rs));
        }    
        
        catch (SQLException e) {
            
           JOptionPane.showMessageDialog(null, e);
        } 
     }
             
     /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrintableRegister = new javax.swing.JTable();
        jBtnPrintTable = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPrintableRegister.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tblPrintableRegister.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblPrintableRegister.setEnabled(false);
        jScrollPane1.setViewportView(tblPrintableRegister);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 40, 710, 300));

        jBtnPrintTable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jBtnPrintTable.setText("Print Table");
        jBtnPrintTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPrintTableActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnPrintTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, 110, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_icons/Background_images/isiphoLogo_loginPage.PNG"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTER", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnPrintTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPrintTableActionPerformed
        MessageFormat header = new MessageFormat("Register");
        MessageFormat footer = new MessageFormat("Page{0, number, integer}");
        
        try{
            tblPrintableRegister.print(JTable.PrintMode.NORMAL,header,footer );
        }
        catch(PrinterException e){
            JOptionPane.showMessageDialog(null,e);
        }
            
    }//GEN-LAST:event_jBtnPrintTableActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnPrintTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPrintableRegister;
    // End of variables declaration//GEN-END:variables
}
