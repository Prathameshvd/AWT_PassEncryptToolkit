package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Listeners implements ActionListener, WindowListener {

    PasswordEncryptApp passEncryptApp;
    public Listeners(PasswordEncryptApp passEncryptApp) {
        this.passEncryptApp = passEncryptApp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==passEncryptApp.btnSubmit)
        {
            PasswordMethods passwordMethods = new PasswordMethods();
            String EncryptedPassword = passwordMethods.getEncryptedPassword(passEncryptApp.txtInput.getText(),passEncryptApp.txtKey.getText());
            passEncryptApp.txtOutput.setText(EncryptedPassword);
        }

        if(e.getSource()==passEncryptApp.btnReset)
        {
            passEncryptApp.txtInput.setText("");
            passEncryptApp.txtKey.setText("");
            passEncryptApp.txtOutput.setText("");
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }


//        btnSubmit.addActionListener(new void ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            PasswordMethods passwordMethods = new PasswordMethods();
//            String EncryptedPassword = passwordMethods.getEncryptedPassword(txtInput.getText(),txtKey.getText());
//            txtOutput.setText(EncryptedPassword);
//        }
//    });
//
//                btnReset.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            txtInput.setText("");
//            txtKey.setText("");
//            txtOutput.setText("");
//        }
//    });
//
//        jFrame.addWindowListener(new WindowAdapter() {
//        @Override
//        public void windowClosing(WindowEvent e) {
//            System.exit(0);
//        }
//    });

}
