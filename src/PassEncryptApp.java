package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class PassEncryptApp {

    PassEncryptApp()
    {
        JFrame jFrame = new JFrame("Password Encryption Tool");
        Frame frame = new Frame("Password Encryption Tool");

        jFrame.setSize(500,500);
        jFrame.setLayout(new FlowLayout());
        jFrame.setVisible(true);

        JTextField txtInput, txtKey, txtOutput;
        JLabel labelInput,labelKey,labelOutput;

        Button btnSubmit = new Button("Submit");
        Button btnReset = new Button("Reset");

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

        //Have to separate the code w.r.t. code functionality
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display a message dialog when the button is clicked
                Dialog dialog = new Dialog(jFrame, "Message", true);
                dialog.setLayout(new FlowLayout());
                dialog.setSize(200, 100);
                Label label = new Label("Button Clicked!");
                Button okButton = new Button("OK");
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.dispose(); // Close the dialog
                    }
                });
                dialog.add(label);
                dialog.add(okButton);
                dialog.setVisible(true);
            }
        });

        jFrame.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	            System.exit(0);
	        }
	    });
    }

    public static void main(String[] args) {
        PassEncryptApp passEncryptApp = new PassEncryptApp();
    }
}
