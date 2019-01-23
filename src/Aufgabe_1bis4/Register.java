package Aufgabe_1bis4;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Register
{

    Datafile data = new Datafile();


    public boolean newUser(String username, String password)
    {
        //das passwort darf nicht ; benutzen da das unser trennzeichen zwischen name und passwort ist
        if(password.contains(";")){
            JOptionPane.showMessageDialog(null, "Das Passwort darf kein ; beinhalten!");
            return false;
        }

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(String.valueOf(data), true));

            bw.write(username + ";"+ password); //gegebender username und das passwort werden in textfile gespeichert
            bw.newLine(); //es wird alles in eine eigene zeile gespeichert

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(bw != null) //wenn der bufferedreader nicht null ist versuchen zu schließen
                try{
                    bw.close();
                } catch (IOException ioEx){
                    ioEx.printStackTrace();
                }
        }

        return false;


    }

    public void register()
    {

        String regUser = JOptionPane.showInputDialog("Bitte geben Sie einen gewünschten Usernamen ein?");
        String regPw = JOptionPane.showInputDialog("WBitte geben Sie ein Passwort ein.");

       //passwort und username werden an methode newUser übergeben
        newUser(regUser, regPw);

        JOptionPane.showMessageDialog(null, "Du bist nun befugt das Geheimnis zu wissen.");
    }




}




