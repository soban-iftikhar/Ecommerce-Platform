import javax.swing.*;
import java.awt.*;
public class GUI extends JFrame {

    GUI() {
        // Set up the frame
        frame.setTitle("E-commerce Application");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setIconImage(icon.getImage());
        frame.getContentPane().setBackground(new Color(52, 73, 85));
        frame.setLayout(null);

        // Set the welcome label
        label.setText("Welcome to ShopSphere");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(new Color(199, 227, 225));
        label.setBounds(0, 50, 800, 50);
        frame.add(label);

        // Create a glass-like panel for the login section
        JPanel glassPanel = new JPanel();
        glassPanel.setBounds(250, 150, 300, 300);
        glassPanel.setBackground(new Color(80, 114, 123, 255));
        glassPanel.setBorder(BorderFactory.createLineBorder(new Color(120, 160, 131), 2));
        glassPanel.setLayout(null);


        // Add username text field
        JTextField usernameField = new JTextField();
        usernameField.setFont(new Font("Arial", Font.PLAIN, 16));
        usernameField.setBorder(BorderFactory.createTitledBorder("Username"));
        usernameField.setBounds(50, 30, 200, 40);
        glassPanel.add(usernameField);


        // Add password text field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
        passwordField.setBounds(50, 90, 200, 40);
        glassPanel.add(passwordField);

        // Add login button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBackground(new Color(0, 120, 215));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBounds(100, 150, 100, 30);
        glassPanel.add(loginButton);

        // Add sign-up button
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(50, 200, 80, 20);
        signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signUpButton.setForeground(new Color(210, 233, 233, 255));
        signUpButton.setContentAreaFilled(false);
        signUpButton.setBorderPainted(false);
        signUpButton.setFocusPainted(false);
        glassPanel.add(signUpButton);

        // Add forgot password
        JButton forgotPasswordButton = new JButton("Forgot Password?");
        forgotPasswordButton.setBounds(46, 225, 150, 20);
        forgotPasswordButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgotPasswordButton.setForeground(new Color(227, 244, 244, 255));
        forgotPasswordButton.setContentAreaFilled(false);
        forgotPasswordButton.setBorderPainted(false);
        forgotPasswordButton.setFocusPainted(false);
        glassPanel.add(forgotPasswordButton);

        frame.add(glassPanel);
        frame.setVisible(true);

    }

    JFrame frame = new JFrame();
    ImageIcon icon = new ImageIcon("logo.png");
    JLabel label = new JLabel();
}
