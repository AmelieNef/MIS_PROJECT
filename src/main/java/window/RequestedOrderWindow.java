/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestedOrderWindow extends JFrame {

    
    private int profession;
    private JLabel selectOrderLabel = new JLabel ("Sélectionnez une commande : ");
    private String[] requestedOrder = {};
    private JList requestedOrderList = new JList<String>(requestedOrder);
    private JScrollPane requestedOrderScroll = new JScrollPane(requestedOrderList); 
    private JButton selectOrderButton = new JButton("Sélectionner cette commande");
    private JLabel supplierInfoLabel = new JLabel("Informations du fournisseur : ");
    private JLabel additionnalNoteLabel = new JLabel ("Note du service :");
    private JButton confirmOrderButton = new JButton ("Confirmer la commande");
    private JButton declineOrderButton = new JButton (" Décliner la commande");
    private String[] selectedOrder = {} ;
    
    public RequestedOrderWindow(int profession) {
        this.profession = profession;
        this.setTitle("Commandes en attente");
        this.setSize(650,650);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel cell1 = new JPanel();
        cell1.setPreferredSize(new Dimension(100,30));
        
        selectOrderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        selectOrderLabel.setPreferredSize(new Dimension(200,30));
        requestedOrderScroll.setPreferredSize(new Dimension(400,200));
        selectOrderButton.setPreferredSize(new Dimension(200,30));
        supplierInfoLabel.setPreferredSize(new Dimension(400,30));
        additionnalNoteLabel.setPreferredSize(new Dimension(400,90));
        confirmOrderButton.setBackground(Color.green);
        confirmOrderButton.setPreferredSize(new Dimension(200, 30));
        declineOrderButton.setBackground(Color.RED);
        declineOrderButton.setPreferredSize(new Dimension(200, 30));
        
        
        
        JPanel content = new JPanel();
        content.setPreferredSize(new Dimension(410, 600));
        
        content.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        //--------------------------------------------- Ligne 0 colonne 0
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        content.add(cell1,gbc);
        //--------------------------------------------- Ligne 0 colonne 1
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        content.add(selectOrderLabel,gbc);
        //--------------------------------------------- Ligne 0 colonne 3
        gbc.gridx = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(cell1,gbc);        
        //--------------------------------------------- Ligne 1 
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(cell1,gbc);
        //--------------------------------------------- Ligne 2
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(requestedOrderScroll,gbc);
        //--------------------------------------------- Ligne 3
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        content.add(cell1,gbc);
        //--------------------------------------------- Ligne 3 colonne 1
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        content.add(selectOrderButton, gbc);
        //--------------------------------------------- Ligne 3 colonne 3
        gbc.gridx = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(cell1,gbc);
        //--------------------------------------------- Ligne 4 
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(cell1,gbc);
        //--------------------------------------------- Ligne 5 
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(supplierInfoLabel,gbc);
        //--------------------------------------------- Ligne 6
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(additionnalNoteLabel,gbc);
        //--------------------------------------------- Ligne 7
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(cell1,gbc);
        //--------------------------------------------- Ligne 8 colonne 0
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        content.add(confirmOrderButton,gbc);
        //--------------------------------------------- Ligne 8 colonne 2
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(declineOrderButton,gbc);
        
        
        this.setContentPane(content);
        
        selectOrderButton.addActionListener(new RequestedOrderWindow.EnabledButton());
        selectOrderButton.setEnabled(true);
        confirmOrderButton.addActionListener(new RequestedOrderWindow.EnabledButton());
        confirmOrderButton.setEnabled(true);
        declineOrderButton.addActionListener(new RequestedOrderWindow.EnabledButton());
        declineOrderButton.setEnabled(true);
        
        this.setVisible(true);
        }

    class EnabledButton implements ActionListener {

        public void actionPerformed(ActionEvent aActionEvent){
            if (aActionEvent.getSource() == confirmOrderButton){
                JOptionPane jop1 = new JOptionPane();
                jop1.showMessageDialog(null, "Merci, cette commande a bien été confirmée.", "Commande acceptée", JOptionPane.INFORMATION_MESSAGE);
                
            }
    }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
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

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
