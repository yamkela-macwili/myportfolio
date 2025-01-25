/*
 * This class contains the model for the message.
 * It has all the data members and methods for manipulating the dialog.
 */
package com.yamkela22y.dashboard.dialog;

import javax.swing.ImageIcon;

/**
 *
 * @author yamkela
 */
public class MessageModel {
    private String user;
    private String text;
    private ImageIcon profile;

    public MessageModel(String user, String text, ImageIcon profile) {
        this.user = user;
        this.text = text;
        this.profile = profile;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ImageIcon getProfile() {
        return profile;
    }

    public void setProfile(ImageIcon profile) {
        this.profile = profile;
    }
   
}
