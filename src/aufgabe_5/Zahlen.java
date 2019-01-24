package aufgabe_5;

import javax.swing.*;
import java.io.*;
import java.util.Random;

public class Zahlen
{
    public static void main(String[] args)
    {
        //Zufallszahlen in textdatei speichern

        WriteFile.writeFile();

        //checken wie oft die gesuchte zahl in dem file existiert

        int eingabe = Integer.parseInt(JOptionPane.showInputDialog("Bitte Zahl zwischen eins und 50 einegebn."));
        int anzahl = SearchNumber.searchNumber(eingabe);

            JOptionPane.showMessageDialog(null, "Die Zahle " + eingabe + " ist " + anzahl + " mal zu finden.");

    }


}
