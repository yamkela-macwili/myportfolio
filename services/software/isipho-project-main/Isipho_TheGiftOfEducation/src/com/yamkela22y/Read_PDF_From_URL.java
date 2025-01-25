package com.yamkela22y;

import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import javax.swing.JOptionPane;

public class Read_PDF_From_URL {

    public void downlaodPDF(String course_url, String fileName) throws MalformedURLException, FileNotFoundException, IOException {
        URL courses_url = new URL(course_url);

        byte[] ba1 = new byte[1024];
        int baLength;
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);

        // Contacting the URL
        URLConnection url_Connection = courses_url.openConnection();

        // Checking whether the URL contains a PDF
        if (!url_Connection.getContentType().equalsIgnoreCase("application/pdf")) {
            JOptionPane.showMessageDialog(null, "FAILED.\n[Sorry. File not found.]");
        } else {
            try {

                // Read the PDF from the URL and save to a local file
                InputStream inputStream = courses_url.openStream();
                while ((baLength = inputStream.read(ba1)) != -1) {
                    fileOutputStream.write(ba1, 0, baLength);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                inputStream.close();
                JOptionPane.showMessageDialog(null, " Downloaded");

            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(null, "FAILED.\n[" + npe.getMessage() + "]\n");
                //System.out.println("FAILED.\n[" + npe.getMessage() + "]\n");
            }
        }

        //Open PDF file after download
        try {

            File pdfFile = new File(fileName);
            if (pdfFile.exists()) {

                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    JOptionPane.showMessageDialog(null, "Awt Desktop is not supported!");
                    //System.out.println("Awt Desktop is not supported!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "File is not exists!");
                //System.out.println("File is not exists!");
            }

            JOptionPane.showMessageDialog(null, "Done");
//		System.out.println("Done");

        } catch (HeadlessException | IOException ex) {
            ex.printStackTrace();
        }

    }

    public void wsuCourses() throws MalformedURLException, FileNotFoundException, IOException {

        String url = "https://universityinfo.co.za/prospectus/WSU-general-prospectus-updated.pdf";
        String fileName = "wsu_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void NMUCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/NMU-Prospectus-2023.pdf";
        String fileName = "NMU_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void UKZNCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/UKZN-Prospectus-2021.pdf";
        String fileName = "UKZN_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void UNISACourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/UNISA-Prospectus.pdf";
        String fileName = "UNISA_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void SUNCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/SUN-Prospectus-2023.pdf";
        String fileName = "SUN_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void UNIZULUCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/UNIZULU-Prospectus-2021.pdf";
        String fileName = "UNIZULU_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void RUCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/Rhodes-Prospectus.pdf";
        String fileName = ".pdf";

        downlaodPDF(url, fileName);

    }

    public void UMPCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/UMP%202023%20Full%20Prospectus%20(%20Recent%20Update).pdf";
        String fileName = "UMP_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void CUTCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/CUT-Prospectus-2017.pdf";
        String fileName = "CUT_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void UFSCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/UFS-undergraduate-prospectus-2023.pdf";
        String fileName = "UFS_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void SOL_PLAATJECourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/SPU-Prospectus-2023.pdf";
        String fileName = "SOL_PLAATJE_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void NWUCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/NWU-Prospectus.pdf";
        String fileName = "NWU_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void UNIVENCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/UNIVEN_Undergraduate_Brochure_2023.pdf";
        String fileName = "UNIVEN_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void ULCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/UL-Prospectus-2023.pdf";
        String fileName = "UL_Courses().pdf";

        downlaodPDF(url, fileName);

    }

    public void SUCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "";
        String fileName = "SU_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void CPUTCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/CPUT-Prospectus-2023.pdf";
        String fileName = "CPUT_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void UCTCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/UCT-Prospectus-2021.pdf";
        String fileName = "UCT_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void UWCCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/UWC-Prospectus.pdf";
        String fileName = "UWC_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void UJCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/UJ_undergrad_prospectus2023_pages_for_digital_book.pdf";
        String fileName = "UJ_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void WITSCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/WITS-Requirements-2022.pdf";
        String fileName = "WITS_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void UPCourses() throws MalformedURLException, FileNotFoundException, IOException {
   
        //Open PDF file after download
        try {

            File pdfFile = new File("C:\\Users\\yamke\\OneDrive\\NetBeansProjects\\IsiphoRegistrationForm\\src\\UP-Prospectus\\UP_courses.pdf");
            if (pdfFile.exists()) {

                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    JOptionPane.showMessageDialog(null, "Awt Desktop is not supported!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "File is not exists!");
            }

            JOptionPane.showMessageDialog(null, "Done");

        } catch (HeadlessException | IOException ex) {
            ex.printStackTrace();
        }

    }

    public void TUTCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/TUT-Course-Information-2023.pdf";
        String fileName = "TUT_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void VUTCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/VUT-Prospectus-2023.pdf";
        String fileName = "VUT_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void UFHCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/UFH-Prospectus-2023.pdf";
        String fileName = "UFH_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void DUTCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/DUT-Prospectus-2022.pdf";
        String fileName = "DUT_Courses.pdf";

        downlaodPDF(url, fileName);

    }

    public void MUTCourses() throws MalformedURLException, FileNotFoundException, IOException {
        String url = "https://universityinfo.co.za/prospectus/MUT-Prospectus-2022.pdf";
        String fileName = "MUT_Courses.pdf";

        downlaodPDF(url, fileName);

    }

}
