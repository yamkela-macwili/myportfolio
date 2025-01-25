
package com.yamkela22y.Chat.ChatApp;

import com.gmail.yamkela22y.chat.Chat;
import com.gmail.yamkela22y.chat.Connector;
import static com.gmail.yamkela22y.chat.Connector.getConnection;
import com.gmail.yamkela22y.chat.Message;
import com.gmail.yamkela22y.chat.NullMessageException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author yamkela
 */
public class LetsChat extends javax.swing.JPanel {

    //Gets the messages from the database and stores them to the array. And display them in the textArea
    private final ArrayList<String> list = new ArrayList<>();
    //Message object to get the messages
    Message mymessage;
    //To get the user
    String userName;
    //Gets the image icon.
    ImageIcon appIcon = null;
    /**
     * Creates new form LetsChat
     */
    public LetsChat() {
        initComponents();
    }
    
    //Loads messages on the textArea 
    public final void messageLoad() {
        //Update the user 
        jLblProcessUpdate.setText("Loading messages...");
        PreparedStatement pstmt;
        Connection conn;
        try {
            String SQL = "SELECT * FROM chat";
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
    //Clears the selected reply tetx
    private void JBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //Clears the reply message 
        jLblReply.setText(null);
        //Hides the delete button
        JBtnDelete.setVisible(false);
    }                                          
    //Gets the selected text to the reply section
    private void jTxtChatsAreaMouseReleased(java.awt.event.MouseEvent evt) {                                            
        String reply = jTxtChatsArea.getSelectedText();
        if (reply == null) {
            JBtnDelete.setVisible(false);
            jLblReply.setText("");
        } else {
            jLblReply.setText(reply);
            JBtnDelete.setVisible(true);
        }

    } 
    
    private void jBtnSendActionPerformed(java.awt.event.ActionEvent evt) {                                         
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
    }                
    private void jMnRefreshChatsActionPerformed(java.awt.event.ActionEvent evt) {                                                
        jTxtChatsArea.setText(null);
        messageLoad();
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
        jPanel1 = new javax.swing.JPanel();
        jLblUserProfile = new javax.swing.JLabel();
        jLblRefreshChat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtChatsArea = new javax.swing.JTextArea();
        jLblReply = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLblProcessUpdate = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTxtTypeMessage = new javax.swing.JTextArea();
        JBtnDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(40, 127, 137));

        jLblUserProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/male_user_50px.png"))); // NOI18N
        jLblUserProfile.setText("Username");

        jLblRefreshChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icons/chat_refresh_label_icon30x30.png"))); // NOI18N

        jTxtChatsArea.setEditable(false);
        jTxtChatsArea.setBackground(new java.awt.Color(71, 188, 200));
        jTxtChatsArea.setColumns(20);
        jTxtChatsArea.setForeground(new java.awt.Color(186, 215, 222));
        jTxtChatsArea.setRows(5);
        jScrollPane1.setViewportView(jTxtChatsArea);

        jLblReply.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLblReply.setText("Reply");

        jButton1.setBackground(new java.awt.Color(32, 99, 111));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setText("Send");

        jLblProcessUpdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblProcessUpdate.setText("Sending message...");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTxtTypeMessage.setBackground(new java.awt.Color(186, 215, 222));
        jTxtTypeMessage.setColumns(20);
        jTxtTypeMessage.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jTxtTypeMessage.setRows(5);
        jScrollPane2.setViewportView(jTxtTypeMessage);

        JBtnDelete.setBackground(new java.awt.Color(32, 99, 111));
        JBtnDelete.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        JBtnDelete.setText("Delete");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLblProcessUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLblUserProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(jLblRefreshChat))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLblReply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBtnDelete)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLblUserProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLblRefreshChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblReply, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblProcessUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        jPanel2.setBackground(new java.awt.Color(32, 99, 111));

        jLabel1.setBackground(new java.awt.Color(32, 99, 111));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(186, 215, 222));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chat App");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBtnDelete;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLblProcessUpdate;
    private javax.swing.JLabel jLblRefreshChat;
    private javax.swing.JLabel jLblReply;
    private javax.swing.JLabel jLblUserProfile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTxtChatsArea;
    private javax.swing.JTextArea jTxtTypeMessage;
    // End of variables declaration//GEN-END:variables
}
