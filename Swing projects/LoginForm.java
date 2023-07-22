import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginForm extends JFrame {
    JLabel usernameLabel, passwordLabel;
    JTextField usernameTextField;
    JPasswordField passwordField;
    JButton loginButton;

    public LoginForm() {
        setTitle("Login Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // create components
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameTextField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        // set layout
        setLayout(null);

        // add components to the frame
        usernameLabel.setBounds(50, 50, 80, 30);
        add(usernameLabel);

        passwordLabel.setBounds(50, 100, 80, 30);
        add(passwordLabel);

        usernameTextField.setBounds(150, 50, 150, 30);
        add(usernameTextField);

        passwordField.setBounds(150, 100, 150, 30);
        add(passwordField);

        loginButton.setBounds(150, 150, 80, 30);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = String.valueOf(passwordField.getPassword());
                if (username.equals("admin") && password.equals("123456")) {
                    JOptionPane.showMessageDialog(null, "Login successful");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }
        });

        // Main loop
        setVisible(true);        
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}