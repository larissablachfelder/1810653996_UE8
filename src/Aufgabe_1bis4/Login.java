package Aufgabe_1bis4;

import javax.swing.*;
import java.io.File;
import java.io.IOException;


public class Login
{
    private File file;


    public void login()
    {
        SearchUser su = new SearchUser();
        Secret secret = new Secret();


        String user = JOptionPane.showInputDialog("Wie lautet dein Benutzername?");
        String pw = JOptionPane.showInputDialog("Wie lautet dein Passwort?");

        if (su.searchUser(user) != null)
        {
            secret.secret();
        }


    }
}
