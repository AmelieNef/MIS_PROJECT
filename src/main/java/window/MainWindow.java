/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window;

import actors.Actor;
import actors.ActorType;
import actors.IAuthorizationManager;
import actors.AuthorizationManager;
import actors.authorization.action.IAction;
import actors.authorization.action.ActionType;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

/**
 *
 * @author C�lisons
 */
public class MainWindow extends JFrame {
    //Param�tres li�s aux objets interactifs se trouvant sur la fen�tre d'accueil
    //Initiation du fond sur lequel on va venir coller les interractions avec l'utilisateur
    private JPanel panel = new JPanel();
    //Initiation des interracteurs avec l'utilisateur
    private JButton ConnectButton = new JButton("Connection");
    //private JButton StockButton = new JButton("Go to stock");
    private JLabel labelId = new JLabel("Entrer votre ID :");
    private IAuthorizationManager authorizationManager;
    private JFormattedTextField jFormattedTextField;
    private int service, personnel;
    IAction showStock = new IAction() {
        @Override
        public void performAction() {
            new StockWindow(authorizationManager, service); // etc.
        }

        @Override
        public ActionType getType() {
            return ActionType.ShowStock;
        }
    };
    private Actor user = null;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() throws ParseException {

        //Param�tres li�s � la forme g�n�rale de la fen�tre d'accueil
        this.setTitle("Hospital inventory management software");
        this.setSize(410,280);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Param�tres li�s aux objets interactifs se trouvant sur la fen�tre d'accueil


        //Ajouts de la fonctionnalit� li� � l'action des boutons
        ConnectButton.addActionListener(new EnabledButton());
        //StockButton.addActionListener(new LaunchStockWindow());

        //Dimension des boutons
        ConnectButton.setPreferredSize(new Dimension(200,30));
        //StockButton.setPreferredSize(new Dimension(200,30));

        //Cr�ation de l'image
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(MainWindow.class.getClassLoader().getResource("logo.jpg")).
                getImage().getScaledInstance(300, 160, Image.SCALE_DEFAULT));
        JLabel logo = new JLabel(imageIcon);

        // Cr�ation de l'encadr� ID
        //Medical(0)/Unmedical(1)-Buyer(0)/user(1)-SERVICE(1-29)-Profession(1-8)-Personnel(1-1051)
        MaskFormatter id = new MaskFormatter("#-#-##-#-####");
        jFormattedTextField = new JFormattedTextField(id);
        jFormattedTextField.setFont(new Font("Arial", Font.BOLD,12));
        jFormattedTextField.setPreferredSize(new Dimension(110,30));
        jFormattedTextField.setForeground(Color.BLACK);

        //Ajouts des fonctionnalit�s aux panneaux
        panel.add(logo,BorderLayout.NORTH);
        panel.add(labelId, BorderLayout.CENTER);
        panel.add(jFormattedTextField, BorderLayout.CENTER);
        panel.add(ConnectButton, BorderLayout.SOUTH);
        //panel.add(StockButton, BorderLayout.SOUTH);

        //Mise en sourdine du bouton Stock
        //StockButton.setEnabled(false);

        //Attachement du panel � la fen�tre
        this.setContentPane(panel);

        //Rendre la fen�tre visible
        this.setVisible(true);

    }
    //M�thode permettant le d�clenchement de l'action de v�rification des identifiants.
    class EnabledButton implements ActionListener{
        public void actionPerformed(ActionEvent aActionEvent){
            String idPerson = jFormattedTextField.getText();
            String[] idPersonSplit = idPerson.split("-");
            try{
            int medOrNotMed = Integer.parseInt(idPersonSplit[0]);
            int buyerOrUser = Integer.parseInt(idPersonSplit[1]);
            service = Integer.parseInt(idPersonSplit[2]);
            int profession = Integer.parseInt(idPersonSplit[3]);
            personnel = Integer.parseInt(idPersonSplit[4]);
            user = new Actor( ActorType.from(profession), service , personnel);
            authorizationManager = new AuthorizationManager(user);
            if (authorizationManager.isAuthorized(showStock)){
                showStock.performAction();
            }
            else{
                JOptionPane jop2 = new JOptionPane();
                jop2.showMessageDialog(null, "D�sol�, mais vous n'avez pas les acc�s pour " +
                        "l'inventaire.", "Attention", JOptionPane.WARNING_MESSAGE);
            }

            }catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e){
                JOptionPane jop3 = new JOptionPane();
                jop3.showMessageDialog(null, "Votre identifiant a �t� incorrectement entr�, " +
                        "merci de r�it�rer l'op�ration correctement", "Erreur", JOptionPane.ERROR_MESSAGE);

            }


        }
    }

    public static void main(String[] args) throws ParseException {
        //Lancement de ma fen�tre d'accueil
        MainWindow mainWindow = new MainWindow();
    }
}