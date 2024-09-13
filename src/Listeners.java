package src;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Listeners implements ActionListener, WindowListener {
    PasswordEncryptApp passEncryptApp;
    public Listeners(PasswordEncryptApp passEncryptApp) {
        this.passEncryptApp = passEncryptApp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==passEncryptApp.btnSubmit)
        {
            String EncryptedPassword = getEncryptedPassword();
            passEncryptApp.txtOutput.setText(EncryptedPassword);
/*            System.out.println(EncryptedPassword);

            try {
                DecryptedPassword = passwordMethods.getDecryptedPassword(EncryptedPassword, passEncryptApp.txtKey.getText());
            } catch (NoSuchPaddingException | NoSuchAlgorithmException | IllegalBlockSizeException |
                     InvalidKeyException | BadPaddingException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println(DecryptedPassword);*/
        }
        if(e.getSource()==passEncryptApp.btnReset)
        {
            passEncryptApp.txtInput.setText("");
            passEncryptApp.txtKey.setText("");
            passEncryptApp.txtOutput.setText("");
        }
    }

    private String getEncryptedPassword() {
        PasswordMethods passwordMethods = new PasswordMethods();
        String EncryptedPassword = null;
        String DecryptedPassword = null;
        try {
            EncryptedPassword = passwordMethods.getEncryptedPassword(passEncryptApp.txtInput.getText(),passEncryptApp.txtKey.getText());
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | IllegalBlockSizeException |
                 BadPaddingException | InvalidKeyException ex) {
            throw new RuntimeException(ex);
        }
        return EncryptedPassword;
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
}
