package com.yamkela22y.Chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;

/**
 *
 * @author yamkela
 */
public class Connector extends JFrame {

    static final String DATABASE_URL = "jdbc:mysql://localhost/chat_db"; //sql10.freesqldatabase.com
//    static final String DATABASE_URL = "sql10.freesqldatabase.com";
    static final String USER = "root"; 
//    static final String USER = "sql10507944";
    static final String PASS = "yamkela22y!"; //isipho_db.isipho_data_table VWhfn6GQe6
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
//        conn = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com:3306/sql10507944", "sql10507944", "VWhfn6GQe6");
        conn = DriverManager.getConnection(DATABASE_URL, USER, PASS); // for local database
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
                r = null;
            }
            if (s != null) {
                s.close();
                s = null;
            }
            if (con != null) {
                con.close();
                con = null;
            }
        } catch (SQLException ex) {
            throw ex;
        }

    }

    public static boolean add(Message message) throws SQLException, ClassNotFoundException {
        PreparedStatement pstmt;
        Connection conn;
        boolean isInserted = false;
        try {
            String SQL = "INSERT INTO chat(message) VALUES(?)";
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);

            pstmt.setString(1, message.getMessage());

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

}
