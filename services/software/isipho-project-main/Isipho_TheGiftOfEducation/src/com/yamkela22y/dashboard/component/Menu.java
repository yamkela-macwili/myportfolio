package com.yamkela22y.dashboard.component;

import com.yamkela22y.dashboard.event.EventMenu;
import com.yamkela22y.dashboard.event.EventMenuSelected;
import com.yamkela22y.dashboard.event.EventShowPopupMenu;
import com.yamkela22y.swing.PanelTransparent;
import com.yamkela22y.dashboard.scrollbar.ScrollBarCustom;
import com.yamkela22y.dashboard.model.ModelMenu;
import com.yamkela22y.swing.MenuAnimation;
import com.yamkela22y.swing.MenuItem;
//import dashboard.com.yamkela.swing.MenuItem;
import java.awt.Component;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;


/**
 * 
 * @author yamkela
 */
public class Menu extends PanelTransparent {

    private final MigLayout layout;
    private EventMenuSelected event;
    private EventShowPopupMenu eventShowPopup;
    private boolean enableMenu = true;
    private boolean showMenu = true;
    
    public Menu() {
        initComponents();
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setLayout(layout);
        setTransparent(0.5f);
    }
    
    public boolean isShowMenu() {
        return showMenu;
    }

    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }
    
    /**
     * Initialize the menu items.
     */
    public void initMenuItem() {
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/yamkela22y/dashboard/icon/1.png")), "Dashboard", "Home", "Buttons", "Cards"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/yamkela22y/dashboard/icon/6.png")), "Aplications","Bursary","Collage", "University"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/yamkela22y/dashboard/icon/2.png")), "Charts","Bar", "Histogram", "Line", "Pie"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/yamkela22y/dashboard/icon/12.png")), "File Manager", "Show register", "Print Register", "Find record"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/yamkela22y/dashboard/icon/9.png")), "Maps", "Find", "Check Wheather"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/yamkela22y/dashboard/icon/10.png")), "Chat App"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/yamkela22y/dashboard/icon/4.png")), "Messages"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/yamkela22y/dashboard/icon/5.png")), "Staff"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/yamkela22y/dashboard/icon/11.png")), "Contact"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/yamkela22y/dashboard/icon/9.png")), "APS Calculator"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/yamkela22y/dashboard/icon/14.png")), "Gallery"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/yamkela22y/dashboard/icon/3.png")), "Log Out"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/yamkela22y/dashboard/icon/7.png")), "Exit"));
        //addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/yamkela/icon/8.png")), "Holiday", "Menu 001", "Menu 002", "Menu 003")); 
    }

    private void addMenu(ModelMenu menu) {
        panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()), "h 40!");
    }
    
   

    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if (enableMenu) {
                    if (isShowMenu()) {
                        if (open) {
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    } else {
                        eventShowPopup.showPopup(com);
                    }
                }
                return false;
            }
        };
    }

    public void hideallMenu() {
        for (Component com : panel.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.isOpen()) {
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        profile2 = new com.yamkela22y.dashboard.component.Profile();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setOpaque(false);

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(profile2, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(profile2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private com.yamkela22y.dashboard.component.Profile profile2;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
