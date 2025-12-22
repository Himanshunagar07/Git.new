// Need passwprd to open clculator
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordCalculator extends JFrame implements ActionListener {

    JTextField display;
    double num1 = 0, num2 = 0;
    char operator;

    public PasswordCalculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9]")) {
            display.setText(display.getText() + cmd);
        } 
        else if (cmd.matches("[+\\-*/]")) {
            num1 = Double.parseDouble(display.getText());
            operator = cmd.charAt(0);
            display.setText("");
        } 
        else if (cmd.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            double result = 0;

            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num2 != 0 ? num1 / num2 : 0; break;
            }
            display.setText(String.valueOf(result));
        } 
        else if (cmd.equals("C")) {
            display.setText("");
            num1 = num2 = 0;
        }
    }

    public static void main(String[] args) {

        String password = JOptionPane.showInputDialog(
                null,
                "Enter Password:",
                "Password Required",
                JOptionPane.PLAIN_MESSAGE
        );

        if ("himanshu123".equals(password)) {
            new PasswordCalculator();
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Wrong Password! Access Denied."
            );
            System.exit(0);
        }
    }
}
