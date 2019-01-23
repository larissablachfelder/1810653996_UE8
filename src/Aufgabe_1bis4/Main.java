package Aufgabe_1bis4;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        //Textdatei erstellen
        Datafile userdata = new Datafile();
        Login login = new Login();
        Register register = new Register();

        //Fragen ob man schon mitglied ist
        int eingabe = JOptionPane.showConfirmDialog(null, "Bist du schon Mitglied?", "User", JOptionPane.YES_NO_OPTION);

        if(eingabe==0) //ja einloggen
        {
            login.login();


        }
        if(eingabe==1)
        {

            register.register();
        }
    }
}
