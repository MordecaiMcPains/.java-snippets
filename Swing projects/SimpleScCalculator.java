import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridLayout;

// Event listeners
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleScCalculator implements ActionListener {

    // 1. Create a blank Java project in your preferred IDE.
    // 2. Create a new JFrame and set its layout to BorderLayout.
    // 3. Add a text field to the North part of the frame using the BorderLayout.NORTH constant. This text field will display the user's input and the result of the calculation.
    // 4. Create a JPanel and set its layout to GridLayout with 4 rows and 4 columns. This panel will contain the number buttons, the operator buttons, and the clear button.
    // 5. Create 10 number buttons with the labels "0" to "9", and add them to the panel. Use GridLayout coordinates to add them to the correct position.
    // 6. Create 4 operator buttons with the labels "+", "-", "*", and "/", and add them to the panel. Use GridLayout coordinates to add them to the correct position.
    // 7. Create a clear button with the label "C" and add it to the panel. Use GridLayout coordinates to add it to the correct position.
    // 8. Add the panel to the center of the frame using the BorderLayout.CENTER constant.
    // 9. Add action listeners to each button using the addActionListener() method. Define the actionPerformed() method to handle each operation (input numbers, input operators, and clear).
    // 10. In actionPerformed() method, recognize the button clicked and update text field. 
    // 11. Define a class to perform calculations. 
    // 12. When an operator is clicked, store number entered so far with operator clicked. 
    // 13. When an equal button is clicked, perform calculation with the operator. Update the text field. 

    // Global variables
    private JFrame frame;
    private JTextField textField;
    private JPanel panel;

    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subtracButton, mulButton, diButton;  // Operator label
    private JButton deButton, cButton, eqButton;
    private double num1 = 0, num2 = 0, result = 0;
    private String operator = "";
    private boolean newCalculation = true;

    // Main method
    public static void main(String[] args) {
        new SimpleScCalculator();
    }

    public SimpleScCalculator(){
        frame = new JFrame("Calculator");
        textField = new JTextField();
        panel = new JPanel();
        numberButtons = new JButton[10];
        functionButtons = new JButton[4];
        addButton = new JButton("+");
        subtracButton = new JButton("-");
        mulButton = new JButton("*");
        diButton = new JButton("/");
        deButton = new JButton(".");
        cButton = new JButton("C");
        eqButton = new JButton("=");

        initialize();   // Main loop
    }

    private void initialize() {
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        panel.setLayout(new GridLayout(4, 4));

        // instantiate the 10 number buttons [0-9]
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        // Order of the function buttons
        functionButtons[0] = addButton;
        functionButtons[1] = subtracButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = diButton;

        for (int i = 0; i < 4; i++) {
            functionButtons[i].addActionListener(this);
        }

        // adding event listeners to the point buttons
        deButton.addActionListener(this);   // Decimal button
        cButton.addActionListener(this);    // Clear button
        eqButton.addActionListener(this);   // Equals button

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);

        panel.add(diButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);

        panel.add(mulButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);

        panel.add(subtracButton);

        panel.add(numberButtons[0]);

        panel.add(deButton);
        panel.add(cButton);
        panel.add(addButton);

        // Textfields
        frame.add(textField, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(eqButton, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // The program closes normally on exit
        frame.setSize(250, 300);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String value = e.getActionCommand();

        if (newCalculation) {
            textField.setText("");
            newCalculation = false;
        }

        // Action buttons
        if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {
            operator = value;
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
        } else if (value.equals(".")) {
            if (textField.getText().equals("")) {
                textField.setText("0.");
            }else if (!textField.getText().contains(".")) {
                textField.setText(textField.getText() + ".");
            }
        }else if (value.equals("C")) {
            textField.setText("");
            newCalculation = true;
        } else if (value.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 + num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));  // Update textField with result
            newCalculation = true;  // a new calculation can be done
        } else{
            textField.setText(textField.getText() + value);
        }
    }
}
