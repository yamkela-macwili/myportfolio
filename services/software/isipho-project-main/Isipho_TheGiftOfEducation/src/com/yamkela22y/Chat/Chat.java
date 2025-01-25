/**
 * Chat Application
 * This chat application only support group chat.
 * 
 */
package com.yamkela22y.Chat;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import static com.yamkela22y.Chat.Connector.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Yamkela Macwili
 */
public final class Chat extends javax.swing.JFrame {

    //Gets the messages from the database and stores them to the array. And display them in the textArea
    private final ArrayList<String> list = new ArrayList<>();
    //Message object to get the messages
    Message mymessage;
    //To get the user
    String userName;
    //Gets the image icon.
    ImageIcon appIcon = null;

    //Defualt and the only constructor.
    public Chat() {
        initComponents();
        setVisible(true);
        appIcon = new ImageIcon("C:\\Users\\yamke\\OneDrive\\NetBeansProjects\\IsiphoRegistrationForm\\src\\app_icons\\Background_images\\isiphoLogo_icon.jpg");
        setIconImage(appIcon.getImage());
        //Default button (delete) mode
        JBtnDelete.setVisible(false);
        //Sets the user name on the start-up
        setUserName();
        //Loads the messages the the textArea
        messageLoad();
    }//End of constructor

    //Sets the user name
    public  void setUserName(){
       do{
           userName = JOptionPane.showInputDialog(this, "User Name", null);
       }while("".equals(userName));
       
       //Sets the user name 
        jLlUserName.setText(userName);
        
    }

    //Loads messages on the textArea 
    public final void messageLoad() {
        //Update the user 
        jLblProcessUpdate.setText("Loading messages...");
        PreparedStatement pstmt;
        Connection conn;
        try {
            String SQL = "SELECT messages FROM chat_db.chat";
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery(); //use exectuteQuery for

            StringBuilder stringBulder = new StringBuilder();
            list.clear();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            for (String num : list) {
                stringBulder.append(num).append("\n\n");
            }
            jTxtChatsArea.setText(stringBulder.toString());

        } catch (CommunicationsException ce) {
            JOptionPane.showMessageDialog(this, "Can't load messages, Poor/No connection");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            jLblProcessUpdate.setText("");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTxtChatsArea = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jLlUserName = new javax.swing.JLabel();
        jBtnSend = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTxtTypeMessage = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        JBtnDelete = new javax.swing.JButton();
        jLblReply = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLblUserProfile = new javax.swing.JLabel();
        jLblRefreshChat = new javax.swing.JLabel();
        jLblProcessUpdate = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMnHelp = new javax.swing.JMenuItem();
        jMnChangeUserName = new javax.swing.JMenuItem();
        jMnDeleteAll = new javax.swing.JMenuItem();
        jMnRefreshChats = new javax.swing.JMenuItem();

        jTxtChatsArea.setEditable(false);
        jTxtChatsArea.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jTxtChatsArea.setRequestFocusEnabled(false);
        jTxtChatsArea.setSelectedTextColor(new java.awt.Color(153, 0, 0));
        jTxtChatsArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTxtChatsAreaMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTxtChatsArea);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Let's chat");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0))));

        jLlUserName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLlUserName.setForeground(new java.awt.Color(255, 255, 255));

        jBtnSend.setBackground(new java.awt.Color(153, 153, 153));
        jBtnSend.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jBtnSend.setText("Send");
        jBtnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSendActionPerformed(evt);
            }
        });

        jTxtTypeMessage.setBackground(new java.awt.Color(204, 204, 204));
        jTxtTypeMessage.setColumns(20);
        jTxtTypeMessage.setRows(5);
        jScrollPane4.setViewportView(jTxtTypeMessage);

        JBtnDelete.setBackground(new java.awt.Color(153, 153, 153));
        JBtnDelete.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        JBtnDelete.setText("Delete");
        JBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtnDeleteActionPerformed(evt);
            }
        });

        jLblReply.setBackground(new java.awt.Color(204, 204, 204));
        jLblReply.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLblReply.setForeground(new java.awt.Color(255, 255, 255));

        jLblUserProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_icons/button_icons/user_label_icon30x30.png"))); // NOI18N

        jLblRefreshChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_icons/button_icons/chat_refresh_label_icon30x30.png"))); // NOI18N
        jLblRefreshChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLblRefreshChatMouseClicked(evt);
            }
        });

        jLblProcessUpdate.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLblProcessUpdate.setForeground(new java.awt.Color(255, 255, 255));
        jLblProcessUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblUserProfile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLlUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLblRefreshChat)
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLblProcessUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(jBtnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLblReply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLblUserProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLblRefreshChat)
                        .addComponent(jLlUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBtnDelete)
                    .addComponent(jLblReply, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnSend)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLblProcessUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 530));

        jMenu.setText("Menu");

        jMnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_icons/menu_icons/help_10x10.png"))); // NOI18N
        jMnHelp.setText("Help");
        jMnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnHelpActionPerformed(evt);
            }
        });
        jMenu.add(jMnHelp);

        jMnChangeUserName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_icons/menu_icons/change_username_10x10.png"))); // NOI18N
        jMnChangeUserName.setText("Change User Name");
        jMnChangeUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnChangeUserNameActionPerformed(evt);
            }
        });
        jMenu.add(jMnChangeUserName);

        jMnDeleteAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_icons/menu_icons/deleteAll_1_10x10.png"))); // NOI18N
        jMnDeleteAll.setText("Delete All");
        jMnDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnDeleteAllActionPerformed(evt);
            }
        });
        jMenu.add(jMnDeleteAll);

        jMnRefreshChats.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_icons/menu_icons/refresh_chats10x10.png"))); // NOI18N
        jMnRefreshChats.setText("Refesh Chats");
        jMnRefreshChats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnRefreshChatsActionPerformed(evt);
            }
        });
        jMenu.add(jMnRefreshChats);

        jMenuBar1.add(jMenu);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //Sends the mesage 
    private void jBtnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSendActionPerformed
        //Will get the message to be sent.
        String message ;
        try {
            //Updating the user about the proces running.
            jLblProcessUpdate.setText("Sending message...");
            
            boolean isInserted = jLblReply.getText().isBlank();
            //Checks if the user typed a mesage before sending 
            if (!"".equals(jTxtTypeMessage.getText())) {
                //Checks if there is a text to reply to.
                if (isInserted) {
                    //Hides the delete button if no text to reply to
                    JBtnDelete.setVisible(false);
                    message = userName.toUpperCase() + " :- " + jTxtTypeMessage.getText();

                } else {
                    //Displays the delete button to remove the reply text
                    JBtnDelete.setVisible(true);

                    String rep = "Reply:  (" + jLblReply.getText() + ") \n" + userName.toUpperCase() + " :- ";
                    message = rep + jTxtTypeMessage.getText();
                }

                mymessage = new Message(message);

            } else {
                throw new NullMessageException("No message to send");
            }
            //Add the message to the database 
            Connector.add(mymessage);
            //Loads the messages after the user sends a messages 
            messageLoad();
            //Clears the message area
            jTxtTypeMessage.setText(null);
            //Hides the delete button on the reply section
            JBtnDelete.setVisible(false);
        } catch (NullMessageException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (CommunicationsException communicationException) {
            //Prints an error message if an error occurs due to internet connection.
            JOptionPane.showMessageDialog(this, "Can't send message. \nPoor/No connection");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Clears the Process Update area.
            jLblProcessUpdate.setText("");
        }
    }//GEN-LAST:event_jBtnSendActionPerformed
    //Clears the selected reply tetx
    private void JBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnDeleteActionPerformed
        //Clears the reply message 
        jLblReply.setText(null);
        //Hides the delete button
        JBtnDelete.setVisible(false);
    }//GEN-LAST:event_JBtnDeleteActionPerformed
    //Gets the selected text to the reply section
    private void jTxtChatsAreaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTxtChatsAreaMouseReleased
        String reply = jTxtChatsArea.getSelectedText();
        if (reply == null) {
            JBtnDelete.setVisible(false);
            jLblReply.setText("");
        } else {
            jLblReply.setText(reply);
            JBtnDelete.setVisible(true);
        }

    }//GEN-LAST:event_jTxtChatsAreaMouseReleased
    //Displys the help message 
    private void jMnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnHelpActionPerformed
        JOptionPane.showMessageDialog(this, ">>  REPLY TO A MESSAGE:\n"
                + "Highlight the message you want to reply to.\n"
                + "Then the highlighted message will be displayed under the chat box, "
                + "then you can type your respone in the typing area.\n\n"
                + ">>  REFRSH CHAT HISTORY\n"
                + "If the chats did not load properly, or you're not getting messages,\n"
                + "press the REFRESH BUTTON.\n\n"
                + ">>  DELETE CHAT HISTORY\n"
                + "You need a password in order to delete chats.\n\n"
                + ">>  CONNECTION TIME OUT ERROR MEESAGE\n"
                + "This error message occurs when there is poor or no connetion.\n"
                + "So you need to chect your connection, then refresh the page.", " Help", 1);

    }//GEN-LAST:event_jMnHelpActionPerformed
    //Reloads the messages
    private void jLblRefreshChatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblRefreshChatMouseClicked
        jTxtChatsArea.setText(null); 
        messageLoad();
    }//GEN-LAST:event_jLblRefreshChatMouseClicked

    //Chagnge user name
    private void jMnChangeUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnChangeUserNameActionPerformed
        setUserName();
    }//GEN-LAST:event_jMnChangeUserNameActionPerformed
    //Delete all the messages in data base
    private void jMnDeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnDeleteAllActionPerformed
        String password = JOptionPane.showInputDialog("Enter Admin password to delete messages");
        if ("isipho2022".equals(password)) {
            PreparedStatement pstmt;
            Connection conn;
            try {
                jLblProcessUpdate.setText("Deleting all messages...");
                String SQL = "TRUNCATE TABLE chat";
                conn = getConnection();
                pstmt = conn.prepareStatement(SQL);
                pstmt.executeUpdate();

                messageLoad();
            } catch (CommunicationsException communicationException) {
                JOptionPane.showMessageDialog(this, "Can't delete messages. \nPoor/No connection");
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                jLblProcessUpdate.setText("");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Can't delete messages, Password incorrect");
        }
    }//GEN-LAST:event_jMnDeleteAllActionPerformed
    //Reloads the chats
    private void jMnRefreshChatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnRefreshChatsActionPerformed
        jTxtChatsArea.setText(null);
        messageLoad();
    }//GEN-LAST:event_jMnRefreshChatsActionPerformed

    public static void main(String[] args) {
        new Chat();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBtnDelete;
    private javax.swing.JButton jBtnSend;
    private javax.swing.JLabel jLblProcessUpdate;
    private javax.swing.JLabel jLblRefreshChat;
    private javax.swing.JLabel jLblReply;
    private javax.swing.JLabel jLblUserProfile;
    private javax.swing.JLabel jLlUserName;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMnChangeUserName;
    private javax.swing.JMenuItem jMnDeleteAll;
    private javax.swing.JMenuItem jMnHelp;
    private javax.swing.JMenuItem jMnRefreshChats;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextPane jTxtChatsArea;
    private javax.swing.JTextArea jTxtTypeMessage;
    // End of variables declaration//GEN-END:variables
}
