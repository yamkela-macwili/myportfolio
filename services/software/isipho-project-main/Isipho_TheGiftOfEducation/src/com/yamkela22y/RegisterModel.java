//Store the applicant's details
//And return them to the DataAccess class 
package com.yamkela22y;

import java.util.Date;
import java.sql.Time;
/**
 * @author YAMKELA MACWILI
 */
public class RegisterModel {

    private String Name;
    private String Surname;
    private String vill;
    private String school;
    private String cellNo;
    private String emailAddress;
    private int time_diff;
    private Date rec_date;
    private Time rec_time;
    
    
   
    /**
     * 
     * @param Name
     * @param Surname
     * @param vill
     * @param school
     * @param cellNo
     * @param emailAddress 
     */
    public RegisterModel(String Name, String Surname, String vill,String school, String cellNo, String emailAddress) {
        this.Name = Name;
        this.Surname = Surname;
        this.vill = vill;
        this.school =school;
        this.cellNo = cellNo;
        this.emailAddress = emailAddress;
    }
    
    /**
     * 
     * @param Name
     * @param Surname
     * @param vill
     * @param school
     * @param cellNo
     * @param emailAddress
     * @param rec_date
     * @param rec_time
     * @param time_diff 
     */
    public RegisterModel(String Name, String Surname, String vill,String school, String cellNo, String emailAddress,Date rec_date, Time rec_time, int time_diff ) {
        this.Name = Name;
        this.Surname = Surname;
        this.vill = vill;
        this.school =school;
        this.cellNo = cellNo;
        this.emailAddress = emailAddress;
        this.rec_date = rec_date;
        this.rec_time = rec_time;
        this.time_diff = time_diff;
    }

    /**
     * Initialize the data members.
     */
    public RegisterModel() {
        Name = null;
        Surname = null;
        vill = null;
        school = null;
        cellNo = null;
        emailAddress = null;
        rec_date = java.sql.Date.valueOf(java.time.LocalDate.now());
        rec_time = java.sql.Time.valueOf(java.time.LocalTime.now());
        time_diff = 0;
    }

    /**
     * @return Name
     */
    public String getfName() {
        return Name;
    }

    /**
     * @param Name
     */
    public void setfName(String Name) {
        this.Name = Name;
    }

    /**
     * @return Name
     */
    public String getlName() {
        return Surname;
    }

    /**
     * @param Surname
     *
     */
    public void setlName(String Surname) {
        this.Surname = Surname;
    }

    /**
     * @return village
     */
    public String getVill() {
        return vill;
    }

    /**
     * @param vill
     */
    public void setvill(String vill) {
        this.vill = vill;
    }
    
    /**
     * 
     * @param school 
     */
     public void setSchool(String school) {
        this.school = school;
    }
     
    /**
     * @return school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @return cellNo
     */
    public String getcellNo() {
        return cellNo;
    }

    /**
     * @param cellNo 
     */
    public void setcellNo(String cellNo) {
        this.cellNo = cellNo;
    }
    
    /**
     * 
     * @return emailAddress
     */
    public String getEmailAdrees() {
        return emailAddress;
    }

    /**
     * 
     * @param emailAdrees 
     */
    public void setEmailAdrees(String emailAdrees) {
        this.emailAddress = emailAdrees;
    }
    
    public void setTime_diff(int time_diff) {
        this.time_diff = time_diff;
    }

    public void setRec_date(Date rec_date) {
        this.rec_date = rec_date;
    }

    public void setRec_time(Time rec_time) {
        this.rec_time = rec_time;
    }
    
    public int getTime_diff() {
        return time_diff;
    }

    public Date getRec_date() {
        return rec_date;
    }

    public Time getRec_time() {
        return rec_time;
    }
}
