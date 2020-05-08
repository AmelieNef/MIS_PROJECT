/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window;

import actors.AuthorizationManager;
import actors.AuthorizationManagerImpl;
import actors.authorization.action.ReadAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Célisons
 */
public class StockWindow extends JFrame {

    /**
     * Creates new form StockWindow
     */
    public StockWindow() {
            this.setTitle("Stock Window");
        this.setSize(410,280);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }



}
