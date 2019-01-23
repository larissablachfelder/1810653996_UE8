package version3;

import javax.swing.*;

public class Main
{
    public static void main(String[] args) {
        Check check = new Check();
        Logfile logger = new Logfile();

        int eingabe = JOptionPane.showConfirmDialog(null, "Kennen wir uns schon?","User", JOptionPane.YES_NO_OPTION);

        //Login
        if(eingabe==0){
            String reg_user = JOptionPane.showInputDialog("Bitte gib deinen Benutzernamen ein.");
            String reg_pw = JOptionPane.showInputDialog("Und auch noch dein Passwort");
            crypter(reg_pw);
            if (check.search(reg_user) != null) {
                if (crypter(check.search(reg_user)).equals(reg_pw)) {
                    secret();
                    logger.logIns(reg_user, crypter(reg_pw), true);
                }

                else {
                    JOptionPane.showMessageDialog(null, "falsches Passwort");
                    logger.logIns(reg_user,crypter(reg_pw), false);
                }
            }
        }
        //Register
        if(eingabe==1) {
            String _user = JOptionPane.showInputDialog("Suchen Sie sich einen Usenamen aus");
            String _pw = JOptionPane.showInputDialog("Und auch ein Passwort");
            check.register(_user, _pw);
            JOptionPane.showMessageDialog(null, "Du bist nun befugt das Geheimnis zu wissen");
        }

        System.out.println(logger.failedLogIn());

    }

    private static void secret(){
        JOptionPane.showMessageDialog(null, "Das Geheimnis ist: \nKuchen ist super.");

    }
    public static String crypter (String value) {
        char[] values = value.toCharArray();
        //einen String in ein Array mit Werten der einzelnen Zeichen umwandeln

        for (int i = 0; i < values.length; i++) {
            char letter = values[i];

            if (letter >= 'a' && letter <= 'z') {
                if (letter > 'm') {
                    letter -= 13;
                } else {
                    letter += 13;
                }
            } else if (letter >= 'A' && letter <= 'Z') {
                if (letter > 'M') {
                    letter -= 13;
                } else {
                    letter += 13;
                }
            }
            values[i] = letter;
        }
        return new String(values); // Array wieder in String umwandeln
    }
}
