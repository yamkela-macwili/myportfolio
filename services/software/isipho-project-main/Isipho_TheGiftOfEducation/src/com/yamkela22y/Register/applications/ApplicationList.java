package com.yamkela22y.Register.applications;

import com.yamkela22y.dashboard.scrollbar.ScrollBarCustom;
import java.awt.GridLayout;
import java.util.ArrayList;

/**
 *
 * @author yamkela
 */
public class ApplicationList extends javax.swing.JPanel {

    ArrayList<ApplicationModel> university = new ArrayList();
    ArrayList<ApplicationModel> college = new ArrayList();
    ArrayList<ApplicationModel> bursary = new ArrayList();

    private void addBursary() {
        bursary.add(new ApplicationModel("NSFA", "", 0, "www.nsfas.org"));
        bursary.add(new ApplicationModel("FUNZA ", "", 0, "www.funza.org"));
        bursary.add(new ApplicationModel("NSFA", "", 0, "www.nsfas.org"));
        bursary.add(new ApplicationModel("FUNZA ", "", 0, "www.funza.org"));
    }

    private void addCollege() {
        college.add(new ApplicationModel("Walter Sisulu Univerty", "Eastern Cape", 0, "www.wsu.ac.za"));
        college.add(new ApplicationModel("University of johannesburg", "Gauteng Province", 0, "www.uj.ac.za"));
        college.add(new ApplicationModel("University of Free State", "Free State", 0, "www.fs.ac.za"));
        college.add(new ApplicationModel("North West University", "North West", 0, "www.nwu.ac.za"));
        college.add(new ApplicationModel("Neslom Mandela Universtity", "Eastern Cape", 0, "www.nmu.ac.za"));
        college.add(new ApplicationModel("Cape Peninstula University of Technology", "Western Cape", 0, "www.cput.ac.za"));
        college.add(new ApplicationModel("Thswane University of Technology", "Western Cape", 240, "www.tut.ac.za"));
        college.add(new ApplicationModel("Central University of Technology", "Western Cape", 0, "www.cut.ac.za"));

    }

    private void addUniversity() {
        university.add(new ApplicationModel("Walter Sisulu Univerty", "Eastern Cape", 0, "www.wsu.ac.za"));
        university.add(new ApplicationModel("University of johannesburg", "Gauteng Province", 0, "www.uj.ac.za"));
        university.add(new ApplicationModel("University of Free State", "Free State", 0, "www.fs.ac.za"));
        university.add(new ApplicationModel("North West University", "North West", 0, "www.nwu.ac.za"));
        university.add(new ApplicationModel("Neslom Mandela Universtity", "Eastern Cape", 0, "www.nmu.ac.za"));
        university.add(new ApplicationModel("Cape Peninstula University of Technology", "Western Cape", 0, "www.cput.ac.za"));
        university.add(new ApplicationModel("Thswane University of Technology", "Western Cape", 240, "www.tut.ac.za"));
        university.add(new ApplicationModel("Central University of Technology", "Western Cape", 0, "www.cut.ac.za"));

        university.add(new ApplicationModel("University of Fort Hare", "Eastern Cape", 1120, "www.ufh.ac.za"));
        university.add(new ApplicationModel("Rodes University", "Eastern Cape", 100, "www.ru.ac.za"));
        university.add(new ApplicationModel("University of Cape Town", "Western Cape", 100, "www.uct.ac.za"));
        university.add(new ApplicationModel("University of Pretoria", "Gauteng Province", 240, "https://up.ac.za"));
        university.add(new ApplicationModel("University of Fort Hare", "Western Cape", 0, "https://uwc.ac.za/"));
        university.add(new ApplicationModel("University of Mpumalanga", "Mpumalanga Province", 150, "https://ump.ac.za"));
        university.add(new ApplicationModel("University of Limpopo", "Limpopo Province", 200, "https://ul.ac.za"));
        university.add(new ApplicationModel("University of Zulu", "Kwa Zulu Natal", 250, " www.cao.ac.za"));
        university.add(new ApplicationModel("University of South Africa", " EC | WC | KZN ", 120, "www.unisa.ac.za"));
        university.add(new ApplicationModel("University of Kwa Zulu Natal", "Kwa Zulu Natal", 250, "www.cao.ac.za"));
        university.add(new ApplicationModel("University of Mpumalanga", "Mpumalanga Province", 150, "https://ump.ac.za"));

    }

    private void initBursary() {

        for (int i = 0; i < bursary.size(); i++) {
            jPanel1.add(new ApplicationUI(bursary.get(i)));
        }
    }

    private void initCollege() {

        for (int i = 0; i < college.size(); i++) {
            jPanel1.add(new ApplicationUI(college.get(i)));
        }
    }

    private void initUniversity() {

        for (int i = 0; i < university.size(); i++) {
            jPanel1.add(new ApplicationUI(university.get(i)));
        }
    }

    /**
     * Creates new form UniversityList The parameter takes an integer value
     * between 1 and 2 0 - college, 1 - university, 2 - Bursary
     *
     * @param institution
     * @throws java.lang.Exception
     */
    public ApplicationList(int institution) throws Exception {
        initComponents();
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());
        jPanel1.setLayout(new GridLayout(university.size(), 1, 0, 1));
        switch (institution) {
            case 0 -> {
                addCollege();
                initCollege();
            }
            case 1 -> {
                addUniversity();
                initUniversity();
            }
            case 2 -> {
                addBursary();
                initBursary();
            }
            default ->
                throw new Exception("Out of bound, choose 0 or 1.");
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

        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Institutions");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setOpaque(false);

        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
