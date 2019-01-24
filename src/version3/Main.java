package version3;

import javax.swing.*;

public class Main
{

    public static void main(String[] args) {
        Check check = new Check(); //neue instanzen erzeugen
        Logfile logger = new Logfile();

        //frage ob account besteht
        int eingabe = JOptionPane.showConfirmDialog(null, "Kennen wir uns schon?","User", JOptionPane.YES_NO_OPTION);

        //Login
        if(eingabe==JOptionPane.YES_OPTION){ //bei ja login ausführen
            login();
        }
        //Register
        if(eingabe==JOptionPane.NO_OPTION) //bei nein registrierung durchführen
        {
            String reg_user = JOptionPane.showInputDialog("Suchen Sie sich einen Usenamen aus");
            String reg_pw = JOptionPane.showInputDialog("Und auch ein Passwort. Aber nur Buchstaben von A-Z und a-z.");

            check.register(reg_user, crypter(reg_pw)); //methode register von check wird ausgeführt und dabei normaler user und verschlüsseltes pw wird an register gegeben

            JOptionPane.showMessageDialog(null, "Du bist nun befugt das Geheimnis zu wissen");

            login();
        }

        System.out.println(logger.failedLogIn()); //in der Kommandozeile anzagl der fehlgeschlagenen versuche

    }

    private static void secret(){
        JOptionPane.showMessageDialog(null, "Das Geheimnis ist: \nKuchen ist super.");

    }
    public static String crypter (String value) {

        //array für buchstaben
        char[] values = value.toCharArray();
        //einen String in ein Array umwandeln in andere zeichen

        for (int i = 0; i < values.length; i++) //jeder buchstabe durchläuft das

            //werden in array gespeichert
        {
            char letter = values[i];

            if (letter >= 'a' && letter <= 'z') {
                if (letter > 'm') //über m wird 13 dazugezählt unter m weg
                {
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
            values[i] = letter; //der buchstabe der sich ergibt speichere ich in die array
        }

        return new String(values); // Array wieder in String umwandeln sodass das verschlüsselte pw ergibt
    }

    public static void login()
    {
        Check check = new Check();//instanz
        Logfile logger = new Logfile();


        String reg_user = JOptionPane.showInputDialog("Bitte gib deinen Benutzernamen ein.");
        String reg_pw = JOptionPane.showInputDialog("Und auch noch dein Passwort");


        if (check.search(reg_user) != null) //wenn nicht null dann überprüft er in methode search ob nutzer existiert
        {
            if (check.search(reg_user).equals(crypter(reg_pw))) //zurückgegebens passwort ist schon verschlüsselt und mit eingegeben pw vergleichen das ich jetzt verschlüssle
            {
                secret(); //geheminis wird zurückgegeben
                logger.logIns(reg_user,reg_pw, true); //hier wird loggs mit date usw. gespeichert
            }

            else {
                JOptionPane.showMessageDialog(null, "falsches Passwort");
                logger.logIns(reg_user,reg_pw, false); //falsches pw gespeichert in logfile
            }
        }

    }
}
