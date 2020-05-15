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
    
    
     JPanel cell1 = new JPanel();
     
     private JButton sendOrderButton = new JButton("Envoyer commande");
     private JButton addOrderButton = new JButton("Ajouter commande");
     private int service;
     private String[] productString = { "Je", "Remplirai", "Avec", "Les", "Produits", "De", "La", "Database" };
     private String[] quantityString = { "100", "200", "300", "400", "500" };
     private JComboBox productList = new JComboBox(productString);
     private JTextField quantityTextField = new JTextField();
     private JTextField noteTextField = new JTextField();
     private JLabel fillOrderLabel = new JLabel("Veuillez complèter la commande : ");
     private JLabel chooseProductLabel = new JLabel("Choisissez un produit : ");
     private JLabel chooseQuantityLabel = new JLabel("Précisez une quantité : ");
     private JLabel addNoteLabel = new JLabel("Ajoutez un commentaire : ");
     private String orders[] = {};
     private JList ordersList = new JList<String>(orders);
     private JScrollPane jScrollPane = new JScrollPane(ordersList);

    /**
     * Creates new form NewOrder
     * @param service
     */
    public NewOrder(int service) {
        
        this.service = service;
        this.setTitle("Nouvelle commande");
        this.setSize(410,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        fillOrderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fillOrderLabel.setPreferredSize(new Dimension(360,45));
        chooseProductLabel.setPreferredSize(new Dimension(270,30));
        productList.setPreferredSize(new Dimension(90,30));
        chooseQuantityLabel.setPreferredSize(new Dimension (270,30));
        quantityTextField.setPreferredSize(new Dimension (90,30));
        addOrderButton.setPreferredSize(new Dimension(360,30));
        jScrollPane.setPreferredSize(new Dimension(360,100));
        addNoteLabel.setPreferredSize(new Dimension(360,30));
        noteTextField.setPreferredSize(new Dimension(360,30));
        sendOrderButton.setPreferredSize(new Dimension(180,30));
        
        cell1.setPreferredSize(new Dimension(90,45));
        
        JPanel content = new JPanel();
        content.setPreferredSize(new Dimension(420, 360));
        
        content.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        //On positionne la case de départ du composant
        //--------------------------------------------- Ligne 0 colonne 0
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(fillOrderLabel,gbc);
        //--------------------------------------------- Ligne 1 colonne 0
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        content.add(chooseProductLabel,gbc);
        //--------------------------------------------- Ligne 1 colonne 2
        gbc.gridx = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(productList,gbc);
        //--------------------------------------------- Ligne 2 colonne 0
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 3;
        content.add(chooseQuantityLabel,gbc);
        //--------------------------------------------- Ligne 2 colonne 3
        //Cette instruction informe le layout que c'est une fin de ligne
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 3;	
        content.add(quantityTextField, gbc);
        //--------------------------------------------- Lignes 3 colonne 0
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        content.add(addOrderButton, gbc);
        //--------------------------------------------- Ligne 4 colonne 0
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(jScrollPane,gbc);
        //--------------------------------------------- Ligne 5 colonne 0
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(addNoteLabel,gbc);
        //--------------------------------------------- Ligne 6 colonne 0
        gbc.gridy = 6;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(noteTextField,gbc);
        //--------------------------------------------- Ligne 7 colonne 0
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        content.add(cell1,gbc);
        //--------------------------------------------- Ligne 7 colonne 1
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        content.add(sendOrderButton,gbc);
        //--------------------------------------------- Ligne 7 colonne 3
        gbc.gridx = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(cell1,gbc);
        //On ajoute le conteneur

        
        this.setContentPane(content);
        
        
        //petList.addActionListener();
        
        addOrderButton.addActionListener(new NewOrder.EnabledButton());
        addOrderButton.setEnabled(true);
        sendOrderButton.addActionListener(new NewOrder.EnabledButton());
        sendOrderButton.setEnabled(true);
        
        
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
                JOptionPane jop1 = new JOptionPane();
                jop1.showMessageDialog(null, "Merci, votre commande a bien été envoyée et sera bientôt traitée.", "Commande envoyée", JOptionPane.INFORMATION_MESSAGE);
                
            }
    }
    }

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
