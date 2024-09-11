package src;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class PasswordEncryptApp {

    public JFrame jFrame;
    public Button btnSubmit,btnReset;
    public JTextField txtInput, txtKey, txtOutput;
    public JLabel labelInput,labelKey,labelOutput;

    PasswordEncryptApp()
    {
        jFrame = new JFrame("Password Encryption Tool");

        jFrame.setSize(500,500);
        jFrame.setLayout(new FlowLayout());
        jFrame.setVisible(true);

        btnSubmit = new Button("Submit");
        btnReset = new Button("Reset");

        txtInput = new JTextField(10);
        txtKey = new JTextField(10);
        txtOutput = new JTextField(10);

        labelInput = new JLabel("Input : ");
        labelKey = new JLabel("Key : ");
        labelOutput = new JLabel("Output : ");

        jFrame.setLayout(new FlowLayout());

        jFrame.add(labelInput);
        jFrame.add(txtInput);
        jFrame.add(labelKey);
        jFrame.add(txtKey);
        jFrame.add(labelOutput);
        jFrame.add(txtOutput);
        jFrame.add(btnSubmit);
        jFrame.add(btnReset);

        Listeners listeners = new Listeners(this);
        btnSubmit.addActionListener(listeners);
        btnReset.addActionListener(listeners);
        jFrame.addWindowListener(listeners);

        jFrame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    });
    }

    public static void main(String[] args) {
        new PasswordEncryptApp();
    }
}
