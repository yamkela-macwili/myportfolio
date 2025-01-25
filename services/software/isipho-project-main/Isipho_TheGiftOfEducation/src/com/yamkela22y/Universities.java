/*Universities Frame
  Provides the list of Universities.
 */
package com.yamkela22y;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yamkela Macwili
 */
public class Universities extends JFrame implements ActionListener {

    //universities 
    private final JButton WSU = new JButton("WSU-Walter Sisulu University");
    private final JButton UJ = new JButton("UJ-University of johannesburg");
    private final JButton UFS = new JButton("UFS-University of Free State");
    private final JButton NWU = new JButton("NWU-North West University");
    private final JButton NMU = new JButton("NMU-Neslom Mandela Universtity");
    private final JButton CPUT = new JButton("CPUT-Cape Peninstula University of Technology");
    private final JButton TUT = new JButton("TUT-Thswane University of Technology");
    private final JButton CUT = new JButton("CUT-Central University of Technology");
    private final JButton UFH = new JButton("UFH-University of Fort Hare");
    private final JButton RU = new JButton("Rhodes University");
    private final JButton UCT = new JButton("University of Cape Town-UCT");
    private final JButton SUN = new JButton("Stellenbosch University-SUN");
    private final JButton UP = new JButton("University of Pretoria-UP");
    private final JButton UWC = new JButton("University of the Western Cape-UWC ");
    private final JButton UMP = new JButton("University of Mpumalanga-UMP");
    private final JButton UL = new JButton("University of Limpopo-UL ");
    private final JButton UNIZULU = new JButton("University of Zululand-UNIZULU");
    private final JButton UNISA = new JButton("University of South Africa-UNISA");
    private final JButton SPU = new JButton("Sol Plaatjie University-SPU");
    private final JButton UKZN = new JButton("University of KwaZulu-Natal-UKZN");

    private final JLabel processUpdateStart = new JLabel("Please wait...");
    private final JLabel processUpdateEnd = new JLabel("Opening your file...");
    ImageIcon icon = null;     // Changing the default icon

    public Universities() {
        super("Universities");
        setBounds(250, 250, 350, 350);
        getContentPane().setBackground(new Color(123, 50, 250)); // backgroung color
        setVisible(true);
        setResizable(false);
        setLayout(new GridLayout(11, 2, 5, 5));
        icon = new ImageIcon("C:\\Users\\yamke\\OneDrive\\NetBeansProjects\\IsiphoRegistrationForm\\src\\app_icons\\Background_images\\isiphoLogo_icon.jpg");
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);

        add(processUpdateStart);
        add(processUpdateEnd);
        processUpdateStart.setVisible(false); 
        processUpdateEnd.setVisible(false); 
        
        add(WSU);
        WSU.addActionListener(this);
        add(UJ);
        UJ.addActionListener(this);
        add(UFS);
        UFS.addActionListener(this);
        add(NWU);
        NWU.addActionListener(this);
        add(NMU);
        NMU.addActionListener(this);
        add(CPUT);
        CPUT.addActionListener(this);
        add(TUT);
        TUT.addActionListener(this);
        add(CUT);
        CUT.addActionListener(this);
        add(UFH);
        UFH.addActionListener(this);
        add(RU);
        RU.addActionListener(this);

        add(UCT);
        UCT.addActionListener(this);
        add(SUN);
        SUN.addActionListener(this);
        add(UP);
        UP.addActionListener(this);
        add(UWC);
        UWC.addActionListener(this);
        add(UMP);
        UMP.addActionListener(this);
        add(UL);
        UL.addActionListener(this);
        add(UNIZULU);
        UNIZULU.addActionListener(this);
        add(UNISA);
        UNISA.addActionListener(this);
        add(SPU);
        SPU.addActionListener(this);
        add(UKZN);
        UKZN.addActionListener(this);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        Desktop desktop = Desktop.getDesktop();
        processUpdateEnd.setVisible(false); 
        //String opt = JOptionPane.showInputDialog("Select \n1. Proceed to application. \n2. Application fee. \n 3. ");
        if (source == WSU) {

//            String fee = "FREE";
//
//            String[] options = {"Proceed to application", "Application fee", "Available courses"};
//            var ch = JOptionPane.showOptionDialog(null, "Province : EC", "Menu", 1, 1, null, options, null);
//            switch (ch) {
//                case 0:
//                    processUpdateStart.setVisible(true); 
//                    try {
//                    
//                    desktop.browse(new URI("https://wsu.ac.za"));
//                } catch (URISyntaxException | IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//                break;
//
//                case 1:
//                    JOptionPane.showMessageDialog(null, fee, "Application fee", 1);
//                    break;
//                case 2:
//                    processUpdateStart.setVisible(true); 
//                    processUpdateStart.setText("Downlaoding..."); 
//                    Read_PDF_From_URL read_PDF_From_URL = new Read_PDF_From_URL();
//                     {
//                        try {
//                            read_PDF_From_URL.wsuCourses();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        }finally {
//                             processUpdateStart.setVisible(false);
//                        }
//                    } 
//                default:
//                    break;
//            }

        } else if (source == UJ) {
//            String fee = "FREE";
//
//            String[] options = {"Proceed to application", "Application fee", "Available courses"};
//            var ch = JOptionPane.showOptionDialog(null, "Province : GP", "Menu", 1, 1, null, options, null);
//            switch (ch) {
//                case 0:
//                    processUpdateStart.setVisible(true);
//                    try {
//                    desktop.browse(new URI("https://www.uj.ac.za"));
//                } catch (URISyntaxException | IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//                break;
//
//                case 1:
//                    JOptionPane.showMessageDialog(null, fee, "Application fee", 1);
//                    break;
//                case 2:
//                    processUpdateStart.setVisible(true); 
//                    processUpdateStart.setText("Downlaoding..."); 
//                    Read_PDF_From_URL read_PDF_From_URL = new Read_PDF_From_URL();
//                     {
//                        try {
//                            read_PDF_From_URL.UJCourses();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        }finally {
//                             processUpdateStart.setVisible(false);
//                        }
//                    }
//                default:
//                    break;
//            }

        } else if (source == UFS) {

//            String fee = "FREE";
//
//            String[] options = {"Proceed to application", "Application fee", "Available courses"};
//            var ch = JOptionPane.showOptionDialog(null, "Province : EC", "Menu", 1, 1, null, options, null);
//            switch (ch) {
//                case 0:
//                    processUpdateStart.setVisible(true);
//                    try {
//                    desktop.browse(new URI("https://ufs.ac.za"));
//                } catch (URISyntaxException | IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//                break;
//
//                case 1:
//                    JOptionPane.showMessageDialog(null, fee, "Application fee", 1);
//                    break;
//                case 2:
//                    processUpdateStart.setVisible(true); 
//                    processUpdateStart.setText("Downlaoding..."); 
//                    Read_PDF_From_URL read_PDF_From_URL = new Read_PDF_From_URL();
//                     {
//                        try {
//                            read_PDF_From_URL.UFSCourses();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        }finally {
//                             processUpdateStart.setVisible(false);
//                        }
//                    }
//                default:
//                    break;
//            }

        } else if (source == NWU) {

//            String fee = "FREE";
//
//            String[] options = {"Proceed to application", "Application fee", "Available courses"};
//            var ch = JOptionPane.showOptionDialog(null, "Province : NW", "Menu", 1, 1, null, options, null);
//            switch (ch) {
//                case 0:
//                    processUpdateStart.setVisible(true);
//                    try {
//                    desktop.browse(new URI("https://nwu.ac.za"));
//                } catch (URISyntaxException | IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//                break;
//
//                case 1:
//                    JOptionPane.showMessageDialog(null, fee, "Application fee", 1);
//                    break;
//                case 2:
//                    processUpdateStart.setVisible(true); 
//                    processUpdateStart.setText("Downlaoding..."); 
//                    Read_PDF_From_URL read_PDF_From_URL = new Read_PDF_From_URL();
//                     {
//                        try {
//                            read_PDF_From_URL.NMUCourses();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        }finally {
//                             processUpdateStart.setVisible(false);
//                        }
//                    }
//                default:
//                    break;
//            }

        } else if (source == NMU) {
//            String fee = "FREE";
//
//            String[] options = {"Proceed to application", "Application fee", "Available courses"};
//            var ch = JOptionPane.showOptionDialog(null, "Province : EC", "Menu", 1, 1, null, options, null);
//            switch (ch) {
//                case 0:
//                    processUpdateStart.setVisible(true);
//                    try {
//                    desktop.browse(new URI("https://mandela.ac.za"));
//                } catch (URISyntaxException | IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//                break;
//
//                case 1:
//                    JOptionPane.showMessageDialog(null, fee, "Application fee", 1);
//                    break;
//                case 2:
//                    processUpdateStart.setVisible(true); 
//                    processUpdateStart.setText("Downlaoding..."); 
//                    Read_PDF_From_URL read_PDF_From_URL = new Read_PDF_From_URL();
//                     {
//                        try {
//                            read_PDF_From_URL.NMUCourses();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        }finally {
//                             processUpdateStart.setVisible(false);
//                        }
//                    }
//                default:
//                    break;
//            }

        } else if (source == CPUT) {

//            String fee = "FREE";
//
//            String[] options = {"Proceed to application", "Application fee", "Available courses"};
//            var ch = JOptionPane.showOptionDialog(null, "Province : WC", "Menu", 1, 1, null, options, null);
//            switch (ch) {
//                case 0:
//                    processUpdateStart.setVisible(true);
//                    try {
//                    desktop.browse(new URI("https://cput.ac.za"));
//                } catch (URISyntaxException | IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//                break;
//
//                case 1:
//                    JOptionPane.showMessageDialog(null, fee, "Application fee", 1);
//                    break;
//                case 2:
//                    processUpdateStart.setVisible(true); 
//                    processUpdateStart.setText("Downlaoding..."); 
//                    Read_PDF_From_URL read_PDF_From_URL = new Read_PDF_From_URL();
//                     {
//                        try {
//                            read_PDF_From_URL.CPUTCourses();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        }finally {
//                             processUpdateStart.setVisible(false);
//                        }
//                    }
//                default:
//                    break;
//            }

        } else if (source == TUT) {
//            String fee = "R240";
//
//            String[] options = {"Proceed to application", "Application fee", "Available courses"};
//            var ch = JOptionPane.showOptionDialog(null, "Province : GP", "Menu", 1, 1, null, options, null);
//            switch (ch) {
//                case 0:
//                    processUpdateStart.setVisible(true);
//                    try {
//                    desktop.browse(new URI("https://tut.ac.za"));
//                } catch (URISyntaxException | IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//                break;
//
//                case 1:
//                    JOptionPane.showMessageDialog(null, fee, "Application fee", 1);
//                    break;
//                case 2:
//                    processUpdateStart.setVisible(true); 
//                    processUpdateStart.setText("Downlaoding..."); 
//                    Read_PDF_From_URL read_PDF_From_URL = new Read_PDF_From_URL();
//                     {
//                        try {
//                            read_PDF_From_URL.TUTCourses();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } finally {
//                             processUpdateStart.setVisible(false);
//                        }
//                    }
//                default:
//                    break;
//            }

        } else if (source == CUT) {
//            String fee = "FREE";
//
//            String[] options = {"Proceed to application", "Application fee", "Available courses"};
//            var ch = JOptionPane.showOptionDialog(null, "Province : FS", "Menu", 1, 1, null, options, null);
//            switch (ch) {
//                case 0:
//                    processUpdateStart.setVisible(true);
//                    try {
//                    desktop.browse(new URI("https://cut.ac.za"));
//                } catch (URISyntaxException | IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//                break;
//
//                case 1:
//                    JOptionPane.showMessageDialog(null, fee, "Application fee", 1);
//                    break;
//                case 2:
//                    processUpdateStart.setVisible(true); 
//                    processUpdateStart.setText("Downlaoding..."); 
//                    Read_PDF_From_URL read_PDF_From_URL = new Read_PDF_From_URL();
//                     {
//                        try {
//                            read_PDF_From_URL.CUTCourses();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } finally {
//                             processUpdateStart.setVisible(false);
//                        }
//                    }
//                default:
//                    break;
//            }

        } else if (source == UFH) {

//            String fee = "R120";
//
//            String[] options = {"Proceed to application", "Application fee", "Available courses"};
//            var ch = JOptionPane.showOptionDialog(null, "Province : EC", "Menu", 1, 1, null, options, null);
//            switch (ch) {
//                case 0:
//                    processUpdateStart.setVisible(true);
//                    try {
//                    desktop.browse(new URI("https://ufh.ac.za"));
//                } catch (URISyntaxException | IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//                break;
//
//                case 1:
//                    JOptionPane.showMessageDialog(null, fee, "Application fee", 1);
//                    break;
//                case 2:
//                    processUpdateStart.setVisible(true); 
//                    processUpdateStart.setText("Downlaoding..."); 
//                    Read_PDF_From_URL read_PDF_From_URL = new Read_PDF_From_URL();
//                     {
//                        try {
//                            read_PDF_From_URL.UFHCourses();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } finally {
//                             processUpdateStart.setVisible(false);
//                        }
//                    }
//                default:
//                    break;
//            }

        } else if (source == RU) {
//            String fee = "R100";
//
//            String[] options = {"Proceed to application", "Application fee", "Available courses"};
//            var ch = JOptionPane.showOptionDialog(null, "Province : EC", "Menu", 1, 1, null, options, null);
//            switch (ch) {
//                case 0:
//                    processUpdateStart.setVisible(true);
//                    try {
//                    desktop.browse(new URI("https://ru.ac.za"));
//                } catch (URISyntaxException | IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//                break;
//
//                case 1:
//                    JOptionPane.showMessageDialog(null, fee, "Application fee", 1);
//                    break;
//                case 2:
//                    processUpdateStart.setVisible(true); 
//                    processUpdateStart.setText("Downlaoding..."); 
//                    Read_PDF_From_URL read_PDF_From_URL = new Read_PDF_From_URL();
//                     {
//                        try {
//                            read_PDF_From_URL.RUCourses();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } finally {
//                             processUpdateStart.setVisible(false);
//                        }
//                    }
//                default:
//                    break;
//            }

        } else if (source == UCT) {
//            String fee = "R100";
//
//            String[] options = {"Proceed to application", "Application fee", "Available courses"};
//            var ch = JOptionPane.showOptionDialog(null, "Province : WC", "Menu", 1, 1, null, options, null);
//            switch (ch) {
//                case 0:
//                    processUpdateStart.setVisible(true);
//                    try {
//                    desktop.browse(new URI("https://ct.ac.za"));
//                } catch (URISyntaxException | IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//                break;
//
//                case 1:
//                    JOptionPane.showMessageDialog(null, fee, "Application fee", 1);
//                    break;
//                case 2:
//                    processUpdateStart.setVisible(true); 
//                    processUpdateStart.setText("Downlaoding..."); 
//                    Read_PDF_From_URL read_PDF_From_URL = new Read_PDF_From_URL();
//                     {
//                        try {
//                            read_PDF_From_URL.UCTCourses();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } finally {
//                             processUpdateStart.setVisible(false);
//                        }
//                    }
//                default:
//                    break;
//            }

        } else if (source == SUN) {
//            String fee = "R100";
//
//            String[] options = {"Proceed to application", "Application fee", "Available courses"};
//            var ch = JOptionPane.showOptionDialog(null, "Province : WC", "Menu", 1, 1, null, options, null);
//            switch (ch) {
//                case 0:
//                    processUpdateStart.setVisible(true);
//                    try {
//                    desktop.browse(new URI("https://sun.ac.za"));
//                } catch (URISyntaxException | IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//                break;
//
//                case 1:
//                    JOptionPane.showMessageDialog(null, fee, "Application fee", 1);
//                    break;
//                case 2:
//                    processUpdateStart.setVisible(true); 
//                    processUpdateStart.setText("Downlaoding..."); 
//                    Read_PDF_From_URL read_PDF_From_URL = new Read_PDF_From_URL();
//                     {
//                        try {
//                            read_PDF_From_URL.SUNCourses();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } finally {
//                             processUpdateStart.setVisible(false);
//                        }
//                    }
//                default:
//                    break;
//            }

        } else if (source == UP) {
//            String fee = "R240";
//
//            String[] options = {"Proceed to application", "Application fee", "Available courses"};
//            var ch = JOptionPane.showOptionDialog(null, "Province : GP", "Menu", 1, 1, null, options, null);
//            switch (ch) {
//                case 0:
//                    processUpdateStart.setVisible(true);
//                    try {
//                    desktop.browse(new URI("https://up.ac.za"));
//                } catch (URISyntaxException | IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//                break;
//
//                case 1:
//                    JOptionPane.showMessageDialog(null, fee, "Application fee", 1);
//                    break;
//                case 2:
//                    processUpdateStart.setVisible(true); 
//                    processUpdateStart.setText("Downlaoding..."); 
//                    Read_PDF_From_URL read_PDF_From_URL = new Read_PDF_From_URL();
//                     {
//                        try {
//                            read_PDF_From_URL.UPCourses();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } finally {
//                             processUpdateStart.setVisible(false);
//                        }
//                    }
//                default:
//                    break;
//            }

        } else if (source == UWC) {
//            String fee = "FREE";
//
//            String[] options = {"Proceed to application", "Application fee", "Available courses"};
//            var ch = JOptionPane.showOptionDialog(null, "Province : WC", "Menu", 1, 1, null, options, null);
//            switch (ch) {
//                case 0:
//                    processUpdateStart.setVisible(true);
//                    try {
//                    desktop.browse(new URI("https://uwc.ac.za/"));
//                } catch (URISyntaxException | IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//                break;
//
//                case 1:
//                    JOptionPane.showMessageDialog(null, fee, "Application fee", 1);
//                    break;
//                case 2:
//                    processUpdateStart.setVisible(true); 
//                    processUpdateStart.setText("Downlaoding..."); 
//                    Read_PDF_From_URL read_PDF_From_URL = new Read_PDF_From_URL();
//                     {
//                        try {
//                            read_PDF_From_URL.UWCCourses();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } finally {
//                             processUpdateStart.setVisible(false);
//                        }
//                    }
//                default:
//                    break;
//            }

        } else if (source == UMP) {
//            String fee = "R150";
//
//            String[] options = {"Proceed to application", "Application fee", "Available courses"};
//            var ch = JOptionPane.showOptionDialog(null, "Province : MP", "Menu", 1, 1, null, options, null);
//            switch (ch) {
//                case 0:
//                    processUpdateStart.setVisible(true);
//                    try {
//                    desktop.browse(new URI("https://ump.ac.za"));
//                } catch (URISyntaxException | IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//                break;
//
//                case 1:
//                    JOptionPane.showMessageDialog(null, fee, "Application fee", 1);
//                    break;
//                case 2:
//                    processUpdateStart.setVisible(true); 
//                    processUpdateStart.setText("Downlaoding..."); 
//                    Read_PDF_From_URL read_PDF_From_URL = new Read_PDF_From_URL();
//                     {
//                        try {
//                            read_PDF_From_URL.UMPCourses();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } finally {
//                             processUpdateStart.setVisible(false);
//                        }
//                    }
//                default:
//                    break;
//            }

        } else if (source == UL) {
//            String fee = "R200";
//
//            String[] options = {"Proceed to application", "Application fee", "Available courses"};
//            var ch = JOptionPane.showOptionDialog(null, "Province : LP", "Menu", 1, 1, null, options, null);
//            switch (ch) {
//                case 0:
//                    processUpdateStart.setVisible(true);
//                    try {
//                    desktop.browse(new URI("https://ul.ac.za"));
//                } catch (URISyntaxException | IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//                break;
//
//                case 1:
//                    JOptionPane.showMessageDialog(null, fee, "Application fee", 1);
//                    break;
//                case 2:
//                    processUpdateStart.setVisible(true); 
//                    processUpdateStart.setText("Downlaoding..."); 
//                    Read_PDF_From_URL read_PDF_From_URL = new Read_PDF_From_URL();
//                     {
//                        try {
//                            read_PDF_From_URL.ULCourses();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } finally {
//                             processUpdateStart.setVisible(false);
//                        }
//                    }
//                default:
//                    break;
//            }

        } else if (source == UNIZULU) {
//            String fee = "R250";
//
//            String[] options = {"Proceed to application", "Application fee", "Available courses"};
//            var ch = JOptionPane.showOptionDialog(null, "Province : KZN", "Menu", 1, 1, null, options, null);
//            switch (ch) {
//                case 0:
//                    processUpdateStart.setVisible(true);
//                    try {
//                    JOptionPane.showMessageDialog(null, "For KZN Universities Go to : www.cao.ac.za");
//                    desktop.browse(new URI("www.unizulu.ac.za"));
//                } catch (URISyntaxException | IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//                break;
//
//                case 1:
//                    JOptionPane.showMessageDialog(null, fee, "Application fee", 1);
//                    break;
//                case 2:
//                    processUpdateStart.setVisible(true); 
//                    processUpdateStart.setText("Downlaoding..."); 
//                    Read_PDF_From_URL read_PDF_From_URL = new Read_PDF_From_URL();
//                     {
//                        try {
//                            read_PDF_From_URL.UNIZULUCourses();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } finally {
//                             processUpdateStart.setVisible(false);
//                        }
//                    }
//                default:
//                    break;
//            }

        } else if (source == UNISA) {

//            String fee = "R120";
//
//            String[] options = {"Proceed to application", "Application fee", "Available courses"};
//            var ch = JOptionPane.showOptionDialog(null, "Province : EC | WC | KZN | ", "Menu", 1, 1, null, options, null);
//            switch (ch) {
//                case 0:
//                    processUpdateStart.setVisible(true);
//                    try {
//                    desktop.browse(new URI("www.unisa.ac.za"));
//                } catch (URISyntaxException | IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//                break;
//
//                case 1:
//                    JOptionPane.showMessageDialog(null, fee, "Application fee", 1);
//                    break;
//                case 2:
//                    processUpdateStart.setVisible(true); 
//                    processUpdateStart.setText("Downlaoding..."); 
//                    Read_PDF_From_URL read_PDF_From_URL = new Read_PDF_From_URL();
//                     {
//                        try {
//                            read_PDF_From_URL.UNISACourses();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } finally {
//                             processUpdateStart.setVisible(false);
//                        }
//                    }
//                default:
//                    break;
//            }

        } else if (source == SPU) {

//            String fee = "FREE";
//
//            String[] options = {"Proceed to application", "Application fee", "Available courses"};
//            var ch = JOptionPane.showOptionDialog(null, "Province : NC", "Menu", 1, 1, null, options, null);
//            switch (ch) {
//                case 0:
//                    processUpdateStart.setVisible(true);
//                    try {
//                    desktop.browse(new URI("https://spu.ac.za"));
//                } catch (URISyntaxException | IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//                break;
//
//                case 1:
//                    JOptionPane.showMessageDialog(null, fee, "Application fee", 1);
//                    break;
//                case 2:
//                    processUpdateStart.setVisible(true); 
//                    processUpdateStart.setText("Downlaoding..."); 
//                    Read_PDF_From_URL read_PDF_From_URL = new Read_PDF_From_URL();
//                     {
//                        try {
//                            read_PDF_From_URL.SOL_PLAATJECourses();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } finally {
//                             processUpdateStart.setVisible(false);
//                        }
//                    }
//                default:
//                    break;
//            }
//            try {
//                desktop.browse(new URI("www.unisa.ac.za"));
//            } catch (URISyntaxException | IOException ex) {
//                JOptionPane.showMessageDialog(null, ex);
//            }

        } else if (source == UKZN) {

//            String fee = "R250";
//
//            String[] options = {"Proceed to application", "Application fee", "Available courses"};
//            var ch = JOptionPane.showOptionDialog(null, "Province : KZN", "Menu", 1, 1, null, options, null);
//            switch (ch) {
//                case 0:
//                    processUpdateStart.setVisible(true);
//                    try {
//                    JOptionPane.showMessageDialog(null, "For KZN Universities Go to : www.cao.ac.za (R250)");
//                    desktop.browse(new URI("www.ukzn.ac.za"));
//                } catch (URISyntaxException | IOException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//                break;
//
//                case 1:
//                    JOptionPane.showMessageDialog(null, fee, "Application fee", 1);
//                    break;
//                case 2:
//                    processUpdateStart.setVisible(true); 
//                    processUpdateStart.setText("Downlaoding..."); 
//                    Read_PDF_From_URL read_PDF_From_URL = new Read_PDF_From_URL();
//                     {
//                        try {
//                            read_PDF_From_URL.UKZNCourses();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (IOException ex) {
//                            Logger.getLogger(Universities.class.getName()).log(Level.SEVERE, null, ex);
//                        } finally {
//                             processUpdateStart.setVisible(false);
//                        }
//                    }
//                default:
//                    break;
//            }

        }
//        processUpdateStart.setVisible(false);
//        processUpdateEnd.setVisible(true); 
    }

}
