package src;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class PasswordEncryptApp {

    public static void main(String[] args) {
        new PasswordEncryptApp();
    }

    public JFrame jFrame;
    public Button btnSubmit,btnReset;
    public JTextField txtInput, txtKey, txtOutput;
    public JLabel labelInput,labelKey,labelOutput;

    PasswordEncryptApp()
    {
        jFrame = new JFrame("Password Encryption Tool");

        jFrame.setSize(350,250);
        jFrame.setLayout(new FlowLayout());
        jFrame.setVisible(true);


        btnSubmit = new Button("Submit");
        btnReset = new Button("Reset");

        txtInput = new JTextField(15);
        txtKey = new JTextField(15);
        txtOutput = new JTextField(15);

        labelInput = new JLabel("Input : ");
        labelKey = new JLabel("Key : ");
        labelOutput = new JLabel("Output : ");

        jFrame.setLayout(new FlowLayout());

            // Created Panel here
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1)); // Layout with 3 rows and 1 column

            // Added all the required component into the panel as per the require order
        panel.add(labelInput);
        panel.add(txtInput);
        panel.add(labelKey);
        panel.add(txtKey);
        panel.add(labelOutput);
        panel.add(txtOutput);
        panel.add(btnSubmit);
        panel.add(btnReset);

            // Added panel into Jframe window
        jFrame.add(panel, BorderLayout.CENTER);

            //Sending object of this App class to the Listeners class
        Listeners listeners = new Listeners(this);

        btnSubmit.addActionListener(listeners);
        btnReset.addActionListener(listeners);
        jFrame.addWindowListener(listeners);
            //To stop execution when users click on close sign.
        jFrame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    });
    }
}
