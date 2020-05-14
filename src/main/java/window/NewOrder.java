/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author C�lisons
 */
public class NewOrder extends JFrame {
    
     
     //private JPanel jPanelNorth = new JPanel();
     //private JPanel jPanelCenter = new JPanel();
     //private JPanel jPanelSouth = new JPanel();
     
     JPanel cell1 = new JPanel();
     JPanel cell2 = new JPanel();
     JPanel cell3 = new JPanel();
     JPanel cell4 = new JPanel();
     JPanel cell5 = new JPanel();
     JPanel cell6 = new JPanel();
     JPanel cell7 = new JPanel();
     JPanel cell8 = new JPanel();
     
     private JButton sendOrderButton = new JButton("Send Orders");
     private JButton addOrderButton = new JButton("Add Order");
     private int service;
     private String[] productString = { "Je", "Remplirai", "Avec", "Les", "Produits", "De", "La", "Database" };
     private String[] quantityString = { "100", "200", "300", "400", "500" };
     private JComboBox productList = new JComboBox(productString);
     private JTextField quantityTextField = new JTextField();
     private JTextField noteTextField = new JTextField();
     private JLabel fillOrderLabel = new JLabel("Please fill your order : ");
     private JLabel chooseProductLabel = new JLabel("Choose the product for this order : ");
     private JLabel chooseQuantityLabel = new JLabel("Choose the quantity for this order : ");
     private JLabel addNoteJLabel = new JLabel("Add a note : ");
     private String orders[] = {"Pourquoi","suis","je","tout","plat","?"};
     private JList ordersList = new JList<String>(orders);
     private JScrollPane jScrollPane = new JScrollPane(ordersList);

    /**
     * Creates new form NewOrder
     * @param service
     */
    public NewOrder(int service) {
        
        this.service = service;
        this.setTitle("New Order");
        this.setSize(410,410);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        jScrollPane.setPreferredSize(new Dimension(70,80));
        cell1.setBackground(Color.YELLOW);
        cell1.setPreferredSize(new Dimension(70,40));
        cell2.setBackground(Color.red);
        cell2.setPreferredSize(new Dimension(70,40));
        cell3.setBackground(Color.green);
        cell3.setPreferredSize(new Dimension(70,40));
        cell4.setBackground(Color.black);
        cell4.setPreferredSize(new Dimension(70,40));
        cell5.setBackground(Color.cyan);
        cell5.setPreferredSize(new Dimension(70,40));
        cell6.setBackground(Color.BLUE);
        cell6.setPreferredSize(new Dimension(70,40));
        cell7.setBackground(Color.orange);
        cell7.setPreferredSize(new Dimension(70,40));
        cell8.setBackground(Color.DARK_GRAY);
        cell8.setPreferredSize(new Dimension(70,40));
        
        JPanel content = new JPanel();
        content.setPreferredSize(new Dimension(410, 400));
        
        content.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        
        gbc.gridheight = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(fillOrderLabel,gbc);
        //--------------------------------
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        content.add(chooseProductLabel,gbc);
        //--------------------------------
        gbc.gridx = 1;
        content.add(productList,gbc);
        //--------------------------------
        gbc.gridx = 2;
        gbc.gridheight = 1;
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(cell6,gbc);
        //--------------------------------
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        content.add(chooseQuantityLabel,gbc);
        //--------------------------------
        gbc.gridx = 1;
        gbc.gridy = 2;
        content.add(quantityTextField,gbc);
        //--------------------------------
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        content.add(cell7,gbc);
        //--------------------------------
        gbc.gridx = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(cell8,gbc);
        //--------------------------------
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(addOrderButton,gbc);
        //--------------------------------
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        //gbc.gridheight = GridBagConstraints.REMAINDER;
        //gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(jScrollPane,gbc);

        
        this.setContentPane(content);
        
        
        //petList.addActionListener();
        
        
        sendOrderButton.addActionListener(new NewOrder.EnabledButton());
        sendOrderButton.setEnabled(true);
        noteTextField.setPreferredSize(new Dimension(200,20));
        quantityTextField.setPreferredSize(new Dimension(70,20));
        
        //jPanelNorth.add(chooseProductLabel,BorderLayout.NORTH);
        //jPanelNorth.add(productList,BorderLayout.NORTH);
        //jPanelCenter.add(chooseQuantityLabel,BorderLayout.CENTER);
        //jPanelCenter.add(quantityTextField, BorderLayout.CENTER);
        //jPanelSouth.add(addNoteJLabel, BorderLayout.CENTER);
        //jPanelSouth.add(noteTextField, BorderLayout.CENTER);
        //jPanelSouth.add(sendOrderButton, BorderLayout.SOUTH);
        //this.getContentPane().add(jPanelNorth, BorderLayout.NORTH);
        //this.getContentPane().add(jPanelCenter, BorderLayout.CENTER);
        //this.getContentPane().add(jPanelSouth, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    /*@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
*/
    class EnabledButton implements ActionListener {

        public void actionPerformed(ActionEvent aActionEvent){
            if (aActionEvent.getSource() == sendOrderButton){
                
            }
    }
    }

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
