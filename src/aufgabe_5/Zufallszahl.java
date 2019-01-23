package aufgabe_5;

import java.util.Random;

public class Zufallszahl
{
    public static int randomnumber()
    {
        Random zufallZahlen = new Random(); // neues Random Objekt, namens zufall

        int zufallsZahl = zufallZahlen.nextInt(50)+1; //Ganzahlige Zufallszahl zwischen 0 und 10

        return zufallsZahl;


    }
}
