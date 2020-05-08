/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window;

import actors.IAuthorizationManager;
import actors.authorization.action.IAction;
import actors.authorization.action.ReadAction;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Célisons
 */
public class StockWindow extends JFrame {
    private JButton stockLocal = new JButton("Local Stock");
    private JButton stockGlobal = new JButton("Global Stock");
    private JButton orderProduct = new JButton("Order product");
    private JButton answerOrder = new JButton("Accept/Decline order");
    private JPanel jPanel = new JPanel();
    private IAuthorizationManager aAuthorizationManager;
    private IAction readAction;

    /**
     * Creates new form StockWindow
     */
    public StockWindow(IAuthorizationManager aAuthorizationManager, int service) {
        this.aAuthorizationManager = aAuthorizationManager;
        this.setTitle("Stock Window");
        this.setSize(410,410);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        readAction = new ReadAction<>(true, service);

        stockLocal.setEnabled(true);
        orderProduct.setEnabled(true);
        jPanel.add(stockLocal, BorderLayout.NORTH);

        //Vérifie directement si la personne a le droit à ses actions - si oui, au lancement de la fenêtre
        // elle met les boutons.
        if (aAuthorizationManager.isAuthorized(readAction)){
            stockGlobal.setEnabled(true);
            answerOrder.setEnabled(true);
            jPanel.add(stockGlobal, BorderLayout.NORTH);
            jPanel.add(answerOrder,BorderLayout.NORTH);
            this.setSize(820,820);
        }

        jPanel.add(orderProduct, BorderLayout.NORTH);
        this.getContentPane().add(jPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void JscrollPaneDbLocalTable(){
        //Put code to obtain JScrollPane with a Jtable
        System.out.println("affichage de la base de donnée locale");
    }

    public void JscrollPaneDbGlobalTable(){
        //Put code to obtain JScrollPane with a Jtable
        System.out.println("affichage de la base de donnée globale");
    }

}
