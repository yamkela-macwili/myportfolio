package com.yamkela22y.Register;

import com.yamkela22y.Bursary;
import com.yamkela22y.Collegies;
import com.yamkela22y.RegisterModel;
import com.yamkela22y.databaseConnection.DatabaseConnection;
import static com.yamkela22y.databaseConnection.DatabaseConnection.delete;
import static com.yamkela22y.databaseConnection.DatabaseConnection.getConnection;
import static com.yamkela22y.databaseConnection.DatabaseConnection.upDate;
import com.yamkela22y.DataTable;
import com.yamkela22y.FeedBack;
import com.yamkela22y.LoginForm;
import com.yamkela22y.Universities;
import com.yamkela22y.University;
import com.yamkela22y.Chat.Chat;
import static com.yamkela22y.Register.Quote.getQuote;
import com.yamkela22y.Register.applications.ApplicationList;
import com.yamkela22y.aps_calculator.ApsCalulator;
import static com.yamkela22y.dashboard.Main.main;
import com.yamkela22y.help.Help;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.sql.Time;
import javax.swing.ImageIcon;
import javax.swing.JTable;

/**
 *
 * @author Yamkela Macwili
 * @version 3
 *
 */
public final class Gift_Of_Education_App extends javax.swing.JFrame {

    //Variable to store the roll Number 
    public static int rollNo;
    ImageIcon icon = null;
    
    /**
     * Creates new form NewJFrame with initialized info panel
     */
    public Gift_Of_Education_App() {

        initComponents();
        icon = new ImageIcon("C:\\Users\\yamke\\OneDrive\\NetBeansProjects\\IsiphoRegistrationForm\\src\\app_icons\\Background_images\\isiphoLogo_icon.jpg");
        this.setIconImage(icon.getImage());
        getQuote(lblQuote);
        init();
    }

    /**
     * This method sets the roll number of the selected row from the table.
     */
    public void setRollNo() {
        rollNo = (int) tblRegister.getValueAt(tblRegister.getSelectedRow(), 0);
    }

    /**
     * Computes the average time taken to complete one application
     * 
     */
    public void averageTime() {
        try {
            long sum = 0;
            PreparedStatement pstmt;
            Connection conn;
            String SQL = "SELECT SUM(time_diff) FROM thegift_db.reg;";
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery(); //use exectuteQuery for

            while (rs.next()) {
                sum += rs.getInt("SUM(time_diff)");
            }

            sum *= 60;
            float avgSec = sum / 3;
            avgSec /= 60;                                 //Geting minutes from seconds

            int min = (int) (avgSec);                     //Taking the inteher part as minute
            int sec = (int) ((avgSec - min) * 60);        //Getting the seconds from the remainder part
            lblAverageTime.setText( min + " Minutes and " + sec + " Seconds");

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Gift_Of_Education_App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called the the clear button is clicked Clears all the text
     * fields
     */
    public void clear() {
        txtName.setText(null);
        txtSurname.setText(null);
        txtLocation.setText(null);
        txtContactNo.setText(null);
        txtEmail.setText(null);
        txtSchool.setText(null);
        txtName.requestFocus();            //Sets the pointer
    }

    /**
     * Read the data from the database and displays it on the table
     * @param table
     * @param SQL_comm
     */
    public static void tableLoad(JTable table, String SQL_comm) {
        PreparedStatement pstmt;
        Connection conn;
        try {
//            SQL_comm = "SELECT * FROM thegift_db.reg";
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL_comm);
            ResultSet rs = pstmt.executeQuery(); //use exectuteQuery for
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Gift_Of_Education_App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method finds the difference in the time between two time (Last
     * record time and recent record time Reads the last record time from the
     * database.Gets the recent record time when the user add a person on the
     * register.
     *
     * @return minutes
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     * @throws java.text.ParseException
     */
    public static long timeDifferenceInMinutes() throws SQLException, ClassNotFoundException, ParseException {
        LocalTime currentTime = java.time.LocalTime.now();         //New record time

        //Initialized with the current time.
        String db_time = currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond();
        long min;

        PreparedStatement pstmt;
        Connection conn;
        String SQL = "SELECT rec_time FROM thegift_db.reg";
        conn = getConnection();
        pstmt = conn.prepareStatement(SQL);
        ResultSet rs = pstmt.executeQuery(); //use exectuteQuery for

        if (rs.next()) {
            while (rs.next()) {
                db_time = rs.getString("rec_time");          //Last time value is stored
            }

            DateFormat dateformat = new SimpleDateFormat("hh:mm:ss");
            Date date = dateformat.parse(db_time);

            //Plitting the database time "db_time"
            int hour = date.getHours();
            int minute = date.getMinutes();
            int second = date.getMinutes();

            // Parsing Time Period in the format HH:MM:SS
            LocalTime sqlTime = LocalTime.of(hour, minute, second);    //Last recorded database time

            // Calculating the difference in Hours
            long hours = ChronoUnit.HOURS.between(sqlTime, currentTime);
            // Calculating the difference in Minutes
            long minutes = ChronoUnit.MINUTES.between(sqlTime, currentTime) % 60;
            // Calculating the difference in Seconds
            long seconds = ChronoUnit.SECONDS.between(sqlTime, currentTime) % 60;
            if (hours >= 1) {
                minutes += hours * 60;
            }
            min = minutes;
        } else {
            min = 0;
        }
        return min;
    }

    /**
     * This method Counts the overall number of records.
     *
     * @return rowCount
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static int OverallRecords() throws SQLException, ClassNotFoundException {
        int numberOfRows = 0;
        PreparedStatement pstmt;
        Connection conn;
        Date date = new Date();
        date.getDate();
        String SQL = "SELECT COUNT(*) FROM thegift_db.reg";
        conn = getConnection();
        pstmt = conn.prepareStatement(SQL);
        pstmt.getMaxRows();
        ResultSet rs = pstmt.executeQuery(); //use exectuteQuery for
        int rowCount;

        while (rs.next()) {
            numberOfRows = rs.getInt("COUNT(*)");
        }
        return numberOfRows;
    }

    /**
     * Count the numbers of records of today's date.
     *
     * @return numberOfRows
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static int getTodaysRecords() throws SQLException, ClassNotFoundException {
        int numberOfRows = 0;
        PreparedStatement pstmt;
        Connection conn;
        Date date = new Date();
        java.sql.Date mysqlDate = new java.sql.Date(date.getTime());

        String SQL = "SELECT COUNT(*) FROM thegift_db.reg WHERE rec_date = '" + mysqlDate + "'"; //+mysqlDate ;
        conn = getConnection();
        pstmt = conn.prepareStatement(SQL);
        ResultSet rs = pstmt.executeQuery(); //use exectuteQuery for
        while (rs.next()) {
            numberOfRows = rs.getInt("COUNT(*)");
        }
        return numberOfRows;
    }

    /**
     * This method initialize the "Info" form.
     *
     */
    public void init() {
        try {

            tableLoad(tblRegister, "SELECT * FROM thegift_db.reg");
            lblTodayRecord.setText(getTodaysRecords() + " Applications");
            lblOverallRecord.setText(OverallRecords() + " Applications");
            averageTime();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Gift_Of_Education_App.class.getName()).log(Level.SEVERE, null, ex);
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        lblMain = new javax.swing.JLayeredPane();
        lblRegister = new javax.swing.JLayeredPane();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblContactNo = new javax.swing.JLabel();
        txtContactNo = new javax.swing.JTextField();
        lblSchool = new javax.swing.JLabel();
        txtSchool = new javax.swing.JTextField();
        lblSurname = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtSurname = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtLocation = new javax.swing.JTextField();
        lblLocation = new javax.swing.JLabel();
        lblQuote = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnAPS = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblInformation = new javax.swing.JLayeredPane();
        lblTodayRecord = new javax.swing.JLabel();
        lblAverageTime = new javax.swing.JLabel();
        lblOverallRecord = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegister = new javax.swing.JTable();
        mnMain = new javax.swing.JMenuBar();
        mnFile = new javax.swing.JMenu();
        mnSearchBy = new javax.swing.JMenu();
        mnSchool = new javax.swing.JMenuItem();
        mnDate = new javax.swing.JMenuItem();
        mnLocation = new javax.swing.JMenuItem();
        mnChat = new javax.swing.JMenuItem();
        mnGmail = new javax.swing.JMenuItem();
        mnSignOut = new javax.swing.JMenuItem();
        sprtMenu = new javax.swing.JPopupMenu.Separator();
        mnAbout = new javax.swing.JMenuItem();
        mnApplication = new javax.swing.JMenu();
        mnBasary = new javax.swing.JMenuItem();
        mnUniversity = new javax.swing.JMenuItem();
        mnCollege = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ISIPHO");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setName("main _frame"); // NOI18N

        lblRegister.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTER", javax.swing.border.TitledBorder.TRAILING, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        lblName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblName.setText("NAME");

        txtName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtName.setToolTipText("");
        txtName.setActionCommand("");
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        lblContactNo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblContactNo.setText("CONTACT NO.");
        lblContactNo.setMaximumSize(new java.awt.Dimension(38, 16));
        lblContactNo.setMinimumSize(new java.awt.Dimension(38, 16));

        txtContactNo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtContactNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContactNoKeyReleased(evt);
            }
        });

        lblSchool.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblSchool.setText("SCHOOL");
        lblSchool.setMaximumSize(new java.awt.Dimension(38, 16));
        lblSchool.setMinimumSize(new java.awt.Dimension(38, 16));

        txtSchool.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtSchool.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSchoolKeyReleased(evt);
            }
        });

        lblSurname.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblSurname.setText("SURNAME");

        lblEmail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblEmail.setText("EMAIL ADDRESS");
        lblEmail.setMaximumSize(new java.awt.Dimension(38, 16));
        lblEmail.setMinimumSize(new java.awt.Dimension(38, 16));

        txtSurname.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtSurname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSurnameKeyReleased(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        txtLocation.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtLocation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLocationKeyReleased(evt);
            }
        });

        lblLocation.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblLocation.setText("LOCATION");

        lblRegister.setLayer(lblName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblRegister.setLayer(txtName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblRegister.setLayer(lblContactNo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblRegister.setLayer(txtContactNo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblRegister.setLayer(lblSchool, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblRegister.setLayer(txtSchool, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblRegister.setLayer(lblSurname, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblRegister.setLayer(lblEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblRegister.setLayer(txtSurname, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblRegister.setLayer(txtEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblRegister.setLayer(txtLocation, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblRegister.setLayer(lblLocation, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lblRegisterLayout = new javax.swing.GroupLayout(lblRegister);
        lblRegister.setLayout(lblRegisterLayout);
        lblRegisterLayout.setHorizontalGroup(
            lblRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSchool, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(txtName)
                    .addComponent(txtSurname)
                    .addComponent(txtLocation)
                    .addComponent(txtSchool)
                    .addComponent(txtContactNo))
                .addContainerGap())
        );

        lblRegisterLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblContactNo, lblEmail, lblLocation, lblName, lblSchool, lblSurname});

        lblRegisterLayout.setVerticalGroup(
            lblRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSurname, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(lblSurname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(lblLocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSchool, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(lblSchool, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblContactNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtContactNo, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblRegisterLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblContactNo, lblEmail, lblLocation, lblName, lblSchool, lblSurname, txtContactNo, txtEmail, txtLocation, txtName, txtSchool, txtSurname});

        lblQuote.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblQuote.setBorder(javax.swing.BorderFactory.createTitledBorder("Quote of the day"));

        btnAdd.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnView.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnAPS.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnAPS.setText("APS");
        btnAPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAPSActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(153, 204, 255));
        lblTitle.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ISIPHO:- \"THE GIFT OF EDUCATION\"", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        lblInformation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFO", javax.swing.border.TitledBorder.TRAILING, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        lblTodayRecord.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTodayRecord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTodayRecord.setToolTipText("Number of applications compled today");
        lblTodayRecord.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Completed application today", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        lblAverageTime.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblAverageTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAverageTime.setToolTipText("Average time taken per application");
        lblAverageTime.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AVERAGE TIME ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N
        lblAverageTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAverageTimeMouseClicked(evt);
            }
        });

        lblOverallRecord.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblOverallRecord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOverallRecord.setToolTipText("Total number of completed applications");
        lblOverallRecord.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Overall ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        lblInformation.setLayer(lblTodayRecord, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblInformation.setLayer(lblAverageTime, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblInformation.setLayer(lblOverallRecord, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lblInformationLayout = new javax.swing.GroupLayout(lblInformation);
        lblInformation.setLayout(lblInformationLayout);
        lblInformationLayout.setHorizontalGroup(
            lblInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOverallRecord, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblInformationLayout.createSequentialGroup()
                        .addGroup(lblInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAverageTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTodayRecord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        lblInformationLayout.setVerticalGroup(
            lblInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblInformationLayout.createSequentialGroup()
                .addComponent(lblAverageTime, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTodayRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblOverallRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        tblRegister.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRegisterMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRegister);

        jDesktopPane2.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblMain.setLayer(lblRegister, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblMain.setLayer(lblQuote, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblMain.setLayer(btnAdd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblMain.setLayer(btnDelete, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblMain.setLayer(btnUpdate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblMain.setLayer(btnClear, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblMain.setLayer(btnView, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblMain.setLayer(btnAPS, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblMain.setLayer(lblTitle, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblMain.setLayer(lblInformation, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblMain.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lblMain.setLayer(jDesktopPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lblMainLayout = new javax.swing.GroupLayout(lblMain);
        lblMain.setLayout(lblMainLayout);
        lblMainLayout.setHorizontalGroup(
            lblMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblMainLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(156, 156, 156))
                    .addGroup(lblMainLayout.createSequentialGroup()
                        .addComponent(lblRegister)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(lblMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(btnClear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAPS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblInformation))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblMainLayout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addComponent(lblQuote, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDesktopPane2)))
        );
        lblMainLayout.setVerticalGroup(
            lblMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuote, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(lblMainLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAPS, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblInformation)
                    .addComponent(lblRegister))
                .addGap(13, 13, 13)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane2)
                .addContainerGap())
        );

        lblMainLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAPS, btnAdd, btnClear, btnDelete, btnUpdate, btnView});

        jDesktopPane1.setLayer(lblMain, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMain)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(lblMain)
                .addContainerGap())
        );

        mnMain.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        mnFile.setText("File");
        mnFile.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        mnSearchBy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icons/search_10x10.png"))); // NOI18N
        mnSearchBy.setText("Search By");

        mnSchool.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icons/graduation-hat_10x10.png"))); // NOI18N
        mnSchool.setText("School");
        mnSchool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSchoolActionPerformed(evt);
            }
        });
        mnSearchBy.add(mnSchool);

        mnDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icons/calendar_10x10.png"))); // NOI18N
        mnDate.setText("Date");
        mnDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDateActionPerformed(evt);
            }
        });
        mnSearchBy.add(mnDate);

        mnLocation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icons/village_10x10.png"))); // NOI18N
        mnLocation.setText("Location");
        mnLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnLocationActionPerformed(evt);
            }
        });
        mnSearchBy.add(mnLocation);

        mnFile.add(mnSearchBy);

        mnChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icons/chat_10x10.png"))); // NOI18N
        mnChat.setText("Chat");
        mnChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnChatActionPerformed(evt);
            }
        });
        mnFile.add(mnChat);

        mnGmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icons/gmail_1_10x10.png"))); // NOI18N
        mnGmail.setText("Gmail");
        mnGmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGmailActionPerformed(evt);
            }
        });
        mnFile.add(mnGmail);

        mnSignOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icons/logout_10x10.png"))); // NOI18N
        mnSignOut.setText("Sign Out");
        mnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSignOutActionPerformed(evt);
            }
        });
        mnFile.add(mnSignOut);
        mnFile.add(sprtMenu);

        mnAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icons/info_10x10.png"))); // NOI18N
        mnAbout.setText("About");
        mnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAboutActionPerformed(evt);
            }
        });
        mnFile.add(mnAbout);

        mnMain.add(mnFile);

        mnApplication.setText("Application");
        mnApplication.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        mnBasary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icons/fund_10x10.png"))); // NOI18N
        mnBasary.setText("Basary");
        mnBasary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnBasaryActionPerformed(evt);
            }
        });
        mnApplication.add(mnBasary);

        mnUniversity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icons/university_10x10.png"))); // NOI18N
        mnUniversity.setText("University");
        mnUniversity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUniversityActionPerformed(evt);
            }
        });
        mnApplication.add(mnUniversity);

        mnCollege.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icons/college_10x10.png"))); // NOI18N
        mnCollege.setText("College");
        mnCollege.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCollegeActionPerformed(evt);
            }
        });
        mnApplication.add(mnCollege);

        mnMain.add(mnApplication);

        setJMenuBar(mnMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Listening to clear button Calls clear() method
     *
     * @param evt
     *
     */
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        FeedBack feedBack = new FeedBack();
        RegisterModel applicant;
        String Name = txtName.getText();
        String Surname = txtSurname.getText();
//        feedBack.setApplicantName(Name + " " + Surname);  //Sends the names to the feedback class
        String vill = txtLocation.getText();
        String school = txtSchool.getText();
        String cellNo = txtContactNo.getText();
        String emailAddress = txtEmail.getText();

        //Check if all the text fields are filled before adding to the database
        if (!"".equals(Name) || !"".equals(Surname) || !"".equals(vill) || !"".equals(school) || !"".equals(cellNo) || !"".equals(emailAddress)) {
            try {
                applicant = new RegisterModel(Name, Surname, vill, school, cellNo, emailAddress);
                try {
                    DatabaseConnection.add(applicant);

                    tableLoad(tblRegister, "SELECT * FROM thegift_db.reg");    //Refresh the table
                    JOptionPane.showMessageDialog(null, Name + " " + Surname + " Added Successfully", "Success", 1);
//                    feedBack.sendMail(txtEmailField.getText());

                    clear();
                    init();
                    //tableLoad();    //Refresh the table
                } catch (SQLException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

//            } catch (ConnectException connEx) {
//                JOptionPane.showMessageDialog(null, "Email not sent. \n Connection timed out. \nResending...", null, 2);
//                try {
//                    feedBack.sendMail(txtEmailField.getText());
//                } catch (Exception ex) {
//                    Logger.getLogger(Gift_Of_Education_App.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//            } catch (AuthenticationFailedException afe) {
//                JOptionPane.showMessageDialog(null, "Email not sent. \n Username and Password not accepted", null, 2);
//            } 
//        catch (AddressException ae) {
//                JOptionPane.showMessageDialog(null, "Email not sent. \n Address null", null, 2);
//            } catch(MessagingException me){
//                
//                JOptionPane.showMessageDialog(null, "Email not sent. \n Check connection", null, 2);
            } catch (HeadlessException | ParseException ex) {
                Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
            }  //if there are some empty fields print error message 

        } else {
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int yesNo = JOptionPane.showConfirmDialog(this, "Do you want to delete ?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
        if (yesNo == JOptionPane.YES_OPTION) {
            RegisterModel applicant;
            try {
                String Name = txtName.getText();
                String Surname = txtSurname.getText();
                String vill = txtLocation.getText();
                String school = txtSchool.getText();
                String cellNo = txtContactNo.getText();
                String emailAddress = txtEmail.getText();

                applicant = new RegisterModel(Name, Surname, vill, school, cellNo, emailAddress);

                tableLoad(tblRegister, "SELECT * FROM thegift_db.reg");    //Refresh the table
                if (!"".equals(cellNo)) {
                    delete(applicant);
                    clear();
                    tableLoad(tblRegister, "SELECT * FROM thegift_db.reg");    //Refresh the table
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter a number to delete a person");
                }
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

//    public void getRecTime() {
//        RegisterModel applicant = new RegisterModel();
//        applicant.setRec_date((Date) tblRegister.getValueAt(tblRegister.getSelectedRow(), 7));
//        applicant.setRec_time((Time) tblRegister.getValueAt(tblRegister.getSelectedRow(), 8));
//        applicant.setTime_diff((int) tblRegister.getValueAt(tblRegister.getSelectedRow(), 9));
//    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        RegisterModel applicant = new RegisterModel();
        String Name = txtName.getText();
        String Surname = txtSurname.getText();
        String vill = txtLocation.getText();
        String school = txtSchool.getText();
        String cellNo = txtContactNo.getText();
        String emailAddress = txtEmail.getText();
        Date rec_date = applicant.getRec_date();
        Time rec_time = applicant.getRec_time();
        int time_diff = applicant.getTime_diff();

        applicant = new RegisterModel(Name, Surname, vill, school, cellNo, emailAddress, rec_date, rec_time, time_diff);
        try {
            upDate(applicant);
            tableLoad(tblRegister, "SELECT * FROM thegift_db.reg");    //Refresh the table
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        // Sets the text to uppercases
        int position = txtName.getCaretPosition();
        txtName.setText(txtName.getText().toUpperCase());
        txtName.setCaretPosition(position);
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtSurnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSurnameKeyReleased
        int position = txtSurname.getCaretPosition();
        txtSurname.setText(txtSurname.getText().toUpperCase());
        txtSurname.setCaretPosition(position);
    }//GEN-LAST:event_txtSurnameKeyReleased

    private void txtLocationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocationKeyReleased
        int position = txtLocation.getCaretPosition();
        txtLocation.setText(txtLocation.getText().toUpperCase());
        txtLocation.setCaretPosition(position);
    }//GEN-LAST:event_txtLocationKeyReleased

    private void txtSchoolKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSchoolKeyReleased
        int position = txtSchool.getCaretPosition();
        txtSchool.setText(txtSchool.getText().toUpperCase());
        txtSchool.setCaretPosition(position);
    }//GEN-LAST:event_txtSchoolKeyReleased

    private void txtContactNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactNoKeyReleased
        int position = txtContactNo.getCaretPosition();
        txtContactNo.setText(txtContactNo.getText().toUpperCase());
        txtContactNo.setCaretPosition(position);
    }//GEN-LAST:event_txtContactNoKeyReleased

    private void btnAPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAPSActionPerformed
       main.showForm(new ApsCalulator()); 
       main.requestFocus();
    }//GEN-LAST:event_btnAPSActionPerformed

    private void tblRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRegisterMouseClicked
        DefaultTableModel recordTable = (DefaultTableModel) tblRegister.getModel();
        int selectedRow = tblRegister.getSelectedRow();

        txtName.setText(recordTable.getValueAt(selectedRow, 1).toString());
        txtSurname.setText(recordTable.getValueAt(selectedRow, 2).toString());
        txtLocation.setText(recordTable.getValueAt(selectedRow, 3).toString());
        txtSchool.setText(recordTable.getValueAt(selectedRow, 4).toString());
        txtContactNo.setText(recordTable.getValueAt(selectedRow, 5).toString());
        txtEmail.setText(recordTable.getValueAt(selectedRow, 6).toString());
        RegisterModel register = new RegisterModel();

        register.setRec_date((Date) tblRegister.getValueAt(tblRegister.getSelectedRow(), 7));
        register.setRec_time((Time) tblRegister.getValueAt(tblRegister.getSelectedRow(), 8));
        register.setTime_diff((int) tblRegister.getValueAt(tblRegister.getSelectedRow(), 9));
        setRollNo();
//        getRecTime();
    }//GEN-LAST:event_tblRegisterMouseClicked

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        //displays a printable table
        try {
            DataTable data_table = new DataTable();
            data_table.tableLoad();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Gift_Of_Education_App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void mnDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDateActionPerformed
        try {
            DataTable data_table = new DataTable();
            data_table.searchByDate(tblRegister, "SELECT Name, Surname, village, Phone, date FROM isipho where date = ?");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Gift_Of_Education_App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_mnDateActionPerformed

    private void mnSchoolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSchoolActionPerformed
        try {
            DataTable data_table = new DataTable();

            data_table.searchBySchool();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Gift_Of_Education_App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnSchoolActionPerformed

    private void mnLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnLocationActionPerformed
        try {
            DataTable data_table = new DataTable();
            data_table.searchByVillage();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Gift_Of_Education_App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnLocationActionPerformed

    private void mnChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnChatActionPerformed
        new Chat();
    }//GEN-LAST:event_mnChatActionPerformed

    private void mnGmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGmailActionPerformed
        Desktop desktop = Desktop.getDesktop();
        try {

            desktop.browse(new URI("https://accounts.google.com"));
        } catch (URISyntaxException | IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_mnGmailActionPerformed

    private void mnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSignOutActionPerformed
        int yesNo = JOptionPane.showConfirmDialog(this, "Do you want to log out?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
        if (yesNo == JOptionPane.YES_OPTION) {
            new LoginForm();
            dispose();
        }
    }//GEN-LAST:event_mnSignOutActionPerformed

    private void mnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAboutActionPerformed
        try {
            new Help();
        } catch (IOException ex) {
            Logger.getLogger(Gift_Of_Education_App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnAboutActionPerformed

    private void mnUniversityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnUniversityActionPerformed
        try { 
            main.showForm(new ApplicationList(1));
            main.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(Gift_Of_Education_App.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       // new University();
    }//GEN-LAST:event_mnUniversityActionPerformed

    private void mnBasaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnBasaryActionPerformed
        try { 
            main.showForm(new ApplicationList(2));
            main.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(Gift_Of_Education_App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnBasaryActionPerformed

    private void mnCollegeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCollegeActionPerformed
        try { 
            main.showForm(new ApplicationList(0));
            main.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(Gift_Of_Education_App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnCollegeActionPerformed

    private void lblAverageTimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAverageTimeMouseClicked
        new Graphs();
    }//GEN-LAST:event_lblAverageTimeMouseClicked

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Gift_Of_Education_App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Gift_Of_Education_App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Gift_Of_Education_App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Gift_Of_Education_App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Gift_Of_Education_App().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAPS;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAverageTime;
    private javax.swing.JLabel lblContactNo;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLayeredPane lblInformation;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLayeredPane lblMain;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblOverallRecord;
    private javax.swing.JLabel lblQuote;
    private javax.swing.JLayeredPane lblRegister;
    private javax.swing.JLabel lblSchool;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTodayRecord;
    private javax.swing.JMenuItem mnAbout;
    private javax.swing.JMenu mnApplication;
    private javax.swing.JMenuItem mnBasary;
    private javax.swing.JMenuItem mnChat;
    private javax.swing.JMenuItem mnCollege;
    private javax.swing.JMenuItem mnDate;
    private javax.swing.JMenu mnFile;
    private javax.swing.JMenuItem mnGmail;
    private javax.swing.JMenuItem mnLocation;
    private javax.swing.JMenuBar mnMain;
    private javax.swing.JMenuItem mnSchool;
    private javax.swing.JMenu mnSearchBy;
    private javax.swing.JMenuItem mnSignOut;
    private javax.swing.JMenuItem mnUniversity;
    private javax.swing.JPopupMenu.Separator sprtMenu;
    private static javax.swing.JTable tblRegister;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSchool;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration//GEN-END:variables
}
