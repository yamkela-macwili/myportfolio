package com.yamkela22y.databaseConnection;

import static com.yamkela22y.databaseConnection.DatabaseConnection.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author yamkela
 */
public class TableAccess {

    /**
     * Loads the table from the database.
     * @param tableName
     * @param sql_comm 
     */
    public void tableLoad(JTable tableName, String sql_comm) {

        PreparedStatement pstmt;
        Connection conn;

        try {
            String SQL = sql_comm;
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery(); //use exectuteQuery for
            tableName.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TableAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param tableName
     * @param sql_comm
     */
    public void searchByDate(JTable tableName, String sql_comm) {

        PreparedStatement pstmt;
        Connection conn;
        String date = JOptionPane.showInputDialog(null, "Date (yyyy-mm-dd)", null);

        try {
            String SQL = sql_comm;
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, date);
            ResultSet rs = pstmt.executeQuery(); //use exectuteQuery for
            tableName.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TableAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param tableName
     * @param sql_comm
     */
    public void searchBySchool(JTable tableName, String sql_comm) {

        PreparedStatement pstmt;
        Connection conn;
        String school = JOptionPane.showInputDialog(null, "School name", null);

        try {
            String SQL = sql_comm;
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, school);
            ResultSet rs = pstmt.executeQuery(); //use exectuteQuery for
            tableName.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TableAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param tableName
     * @param sql_comm
     */
    public void searchByLocation(JTable tableName, String sql_comm) {

        PreparedStatement pstmt;
        Connection conn;
        String vill = JOptionPane.showInputDialog(null, "Location", null);

        try {
            String SQL = sql_comm;
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, vill);
            ResultSet rs = pstmt.executeQuery(); //use exectuteQuery for
            tableName.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TableAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
