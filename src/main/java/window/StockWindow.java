/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window;

import actors.ActorType;
import actors.AuthorizationManager;
import actors.IAuthorizationManager;
import actors.authorization.action.IAction;
import actors.authorization.action.ReadAction;

import javax.swing.*;
import java.awt.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author C�lisons
 */
public class StockWindow extends JFrame {
    private JButton stockLocal = new JButton("Local Stock");
    private JButton stockGlobal = new JButton("Global Stock");
    private JButton orderProduct = new JButton("Order product");
    private JButton answerOrder = new JButton("Accept/Decline order");
    private JPanel jPanelNorth = new JPanel();
    private JPanel jPanelCenter = new JPanel();
    private IAuthorizationManager aAuthorizationManager;
    private IAction readAction;
    private IAction CreateOrder;
    private String items[] = {};
    private JList itemsList = new JList<String>(items);
    private JScrollPane jScrollPane = new JScrollPane(itemsList);
    private int profession;
    private int service;
    /**
     * Creates new form StockWindow
     */
    public StockWindow(IAuthorizationManager aAuthorizationManager, int service, int IDprofession) {
        this.aAuthorizationManager = aAuthorizationManager;
        this.setTitle("Stock Window");
        this.setSize(410,410);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.profession = IDprofession;
        this.service = service;
        jScrollPane.setPreferredSize(new Dimension(400,200));
        
        readAction = new ReadAction<>(true, service);

        stockLocal.addActionListener(new EnabledButton());
        orderProduct.addActionListener(new EnabledButton());
        stockLocal.setEnabled(true);
        orderProduct.setEnabled(true);
        jPanelNorth.add(stockLocal, BorderLayout.NORTH);

        //V�rifie directement si la personne a le droit � ses actions - si oui, au lancement de la fen�tre
        // elle met les boutons.
        if (aAuthorizationManager.isAuthorized(readAction)){
            stockGlobal.addActionListener(new EnabledButton());
            stockGlobal.setEnabled(true);
            answerOrder.setEnabled(true);
            jPanelNorth.add(stockGlobal, BorderLayout.NORTH);
            jPanelNorth.add(answerOrder,BorderLayout.NORTH);
            
            this.setSize(820,820);
        }
        
        jPanelCenter.add(jScrollPane, BorderLayout.CENTER);

        jPanelNorth.add(orderProduct, BorderLayout.NORTH);
        this.getContentPane().add(jPanelNorth, BorderLayout.NORTH);
        this.getContentPane().add(jPanelCenter, BorderLayout.CENTER);
        this.setVisible(true);
    }
    
    
   
    public void JscrollPaneDbLocalTable(){
        //Put code to obtain JScrollPane with a Jtable
        System.out.println("affichage de la base de donn�e locale");
    }

    public void JscrollPaneDbGlobalTable(int profession){
        //Put code to obtain JScrollPane with a Jtable 
        
        System.out.println(profession);
        if (profession == 5 | profession == 6){
            System.out.println("Access to steril stock");
        }
        else if (profession == 7 | profession == 8){
            System.out.println("Access to unsetril stock");
        }
        System.out.println("affichage de la base de donn�e globale");
    }
    
    class EnabledButton implements ActionListener{
        public void actionPerformed(ActionEvent aActionEvent){
            if (aActionEvent.getSource() == stockGlobal){
                
                JscrollPaneDbGlobalTable(profession);
            }
            
            if (aActionEvent.getSource() == stockLocal){
                JscrollPaneDbLocalTable();
            }
            
            if (aActionEvent.getSource() == orderProduct){
                new NewOrder(service);
                
            }
        }
    }
    
    

}
