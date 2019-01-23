package Aufgabe_1bis4;

import javax.swing.*;
import java.io.File;
import java.io.IOException;


public class Login
{
    private File file;

    public void login()
    {


        String user = JOptionPane.showInputDialog("Wie lautet dein Benutzername?");
        String pw = JOptionPane.showInputDialog("Wie lautet dein Passwort?");

        if (SearchUser.searchUser(user) != null)
        {
            Secret.secret();
        }


    }
}
