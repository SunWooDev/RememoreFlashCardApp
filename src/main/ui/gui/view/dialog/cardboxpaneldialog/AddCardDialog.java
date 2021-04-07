package ui.gui.view.dialog.cardboxpaneldialog;

import javax.swing.*;

/*
AddCardDialog represents the dialog that pops up when add card button is pressed in the card box panel
It has a text field for entering the question
It has a text field for entering the answer
It has a button for confirm add button
It has a button for canceling

 */
public class AddCardDialog extends JDialog {

    //front info
    private JPanel frontInfoPanel;
    private JLabel frontInfoLabel;
    private JTextField frontInfoTextField;


    //back info
    private JPanel backInfoPanel;
    private JLabel backInfoLabel;
    private JTextField backInfoTextField;

    //button panel
    private JPanel buttonPanel;

    //confirm add button
    private JButton addButton;

    //cancel button
    private JButton cancelButton;


    //REQUIRES: X
    //EFFECTS: constructs pop up modal dialog when user presses add button in the card box screen
    public AddCardDialog(JFrame frame) {
        //true modal false modeless.
        //modal dialog makes users unable to control other windows until dealt with dialog
        super(frame, "Add a card", true);

        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        //initialize panels
        initAddQuestionPanel();
        initAddAnswerPanel();
        initButtonPanel();

        add(frontInfoPanel);
        add(backInfoPanel);
        add(buttonPanel);

        pack();
//        setBounds(100, 100, 500, 150);
        setLocationRelativeTo(null);


    }



    //REQUIRES: X
    //MODIFIES: this
    //EFFECTS: initializes frontInfoPanel for user to type in the question to add a card
    public void initAddQuestionPanel() {
        frontInfoPanel = new JPanel();
        frontInfoLabel = new JLabel("Type in a question: ");
        frontInfoTextField = new JTextField();
        frontInfoTextField.setColumns(30);
        frontInfoPanel.add(frontInfoLabel);
        frontInfoPanel.add(frontInfoTextField);
    }

    //REQUIRES: X
    //MODIFIES: this
    //EFFECTS: initializes backInfoPanel for user to type in the answer to add a card
    public void initAddAnswerPanel() {
        backInfoPanel = new JPanel();
        backInfoLabel = new JLabel("Type in an answer: ");
        backInfoTextField = new JTextField();
        backInfoTextField.setColumns(30);
        backInfoPanel.add(backInfoLabel);
        backInfoPanel.add(backInfoTextField);
    }

    //REQUIRES: X
    //MODIFIES: this
    //EFFECTS: initializes buttonPanel for users to either confirm adding card or cancel adding card.
    public void initButtonPanel() {
        buttonPanel = new JPanel();
        addButton = new JButton("Add card");
        cancelButton = new JButton("Cancel");
        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);
    }


    //getters for initialization and button action implementation-----------------------------------------


    public JButton getAddButton() {
        return addButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }



    public JTextField getFrontInfoTextField() {
        return frontInfoTextField;
    }

    public JTextField getBackInfoTextField() {
        return backInfoTextField;


    }





}
