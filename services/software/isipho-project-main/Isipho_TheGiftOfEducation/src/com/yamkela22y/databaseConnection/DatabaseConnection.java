/*
    DatabaseConnection.java
    Gives connects to the database.
    And execute the queries.

 */
package com.yamkela22y.databaseConnection;

import com.yamkela22y.RegisterModel;
import com.yamkela22y.Register.Gift_Of_Education_App;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Yamkela Macwili
 */
public class DatabaseConnection {

    static final String DATABASE_URL = "jdbc:mysql://localhost/thegift_db";
    static final String USER = "root";
    static final String PASS = "yamkela22y!"; //isipho_db.isipho_data_table

//    static final String DATABASE_URL = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10507944";
//    static final String USER = "sql10507944";
//    static final String PASS = "VWhfn6GQe6";
    /**
     *
     * @return connection to the database based on the URL, username and
     * password
     * @throws SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conn;
        conn = DriverManager.getConnection(DATABASE_URL, USER, PASS);
        return conn;
    }

    /**
     * Close all resources to the data database
     *
     * @param con database connection
     * @param s statement - prepareStatement, callable statement
     * @param r ResultSet
     * @throws SQLException
     */
    public static void close(Connection con, Statement s, ResultSet r) throws SQLException {
        try {
            if (r != null) {
                r.close();
            }
            if (s != null) {
                s.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }

    }

    /**
     *
     * @param register to be added to the database
     * @return true is the product is added, false if the product is not added.
     * @throws SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static boolean add(RegisterModel register) throws SQLException, ClassNotFoundException, ParseException {
        PreparedStatement pstmt;
        Connection conn;
        boolean isInserted = false;

        Date date = new Date();
        java.sql.Date mysqlDate = new java.sql.Date(date.getTime());
        java.sql.Time time = new java.sql.Time(date.getTime());

        try {

            String SQL = "INSERT INTO thegift_db.reg(first_name, last_name, location, school, phone_No, email, rec_date, rec_time, time_diff ) VALUES(?,?,?,?,?,?,?,?,?)";
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);

            pstmt.setString(1, register.getfName());
            pstmt.setString(2, register.getlName());
            pstmt.setString(3, register.getVill());
            pstmt.setString(4, register.getSchool());
            pstmt.setString(5, register.getcellNo());
            pstmt.setString(6, register.getEmailAdrees());
            pstmt.setDate(7, mysqlDate);
            pstmt.setTime(8, time);
            pstmt.setLong(9, Gift_Of_Education_App.timeDifferenceInMinutes());

            int status = pstmt.executeUpdate(); //use executeUpdate delete, insert update create
            if (status > 0) {
                isInserted = true;
            }
            close(conn, pstmt, null);

        } catch (SQLException e) {
            throw e;
        }
        return isInserted;
    }

    public static boolean addUser(String userName, String password) throws SQLException, ClassNotFoundException {
        PreparedStatement pstmt;
        Connection conn;
        boolean isInserted = false;
        try {
//            String SQL = "INSERT INTO isipho_db.admins(username, password) VALUES(?,?)";
            String SQL = "INSERT INTO admins(username, password) VALUES(?,?)";
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);

            pstmt.setString(1, userName);
            pstmt.setString(2, password);

            int status = pstmt.executeUpdate(); //use executeUpdate delete, insert update create
            if (status > 0) {
                isInserted = true;
            }
            close(conn, pstmt, null);

        } catch (SQLException e) {
            throw e;
        }
        return isInserted;
    }

    /**
     *
     * @param register
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void delete(RegisterModel register) throws SQLException, ClassNotFoundException {
        PreparedStatement pstmt;
        Connection conn;
        try {
            String SQL = "DELETE FROM thegift_db.reg WHERE roll_No = '" + Gift_Of_Education_App.rollNo + "'";
//            String SQL = "DELETE FROM thegift_db.reg WHERE Phone_No = " ;
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
//            pstmt.setInt(1, Gift_Of_Education_App.setRollNo());
            //pstmt.setString(1, register.getcellNo());
            pstmt.executeUpdate(); //use executeUpdate delete, insert update create

            JOptionPane.showMessageDialog(null, "Deleted successfully");

            close(conn, pstmt, null);

        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     *
     * @param register
     * @throws java.lang.ClassNotFoundException
     * @throws SQLException
     */
    public static void upDate(RegisterModel register) throws ClassNotFoundException, SQLException {
        PreparedStatement pstmt;
        Connection conn;

        try {
//            String SQL = "update isipho set Name = ?, Surname = ?, Village = ?, School = ? where Phone_No = ?";
//            String SQL = "update reg set first_name = ?, last_name = ?, location = ?, school = ?, phone_No = ?, email = ?, rec_date = ?, rec_time = ?, time_diff = ? where roll_No = '" + Gift_Of_Education_App.rollNo + "'";
            String SQL = "UPDATE reg SET first_name = ?, last_name = ?, location = ?, school = ?, phone_No = ?, email = ? WHERE roll_No = '" + Gift_Of_Education_App.rollNo + "'";
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, register.getfName());
            pstmt.setString(2, register.getlName());
            pstmt.setString(3, register.getVill());
            pstmt.setString(4, register.getSchool());
            pstmt.setString(5, register.getcellNo());
            pstmt.setString(6, register.getEmailAdrees());
            pstmt.setDate(7, (java.sql.Date) register.getRec_date());
            pstmt.setTime(8, register.getRec_time());
            pstmt.setInt(9, register.getTime_diff());
            pstmt.executeUpdate(); //use executeUpdate delete, insert update create

            JOptionPane.showMessageDialog(null, "Register Updated");
            close(conn, pstmt, null);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
