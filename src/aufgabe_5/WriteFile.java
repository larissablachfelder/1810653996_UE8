package aufgabe_5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public static void writeFile()
    {
        File file = null;
        FileWriter fw = null;
        BufferedWriter bw = null;

        String lineSeparator = System.lineSeparator(); //zeilenumbruch

        try
        {
            //file erstellen
            file = new File("/Users/larissablachfelder/documents/FH_larissa/Semester_1/software_UE/leistungsbeurteilung/1810653996_UE8/zahlen.txt");

            //überprüfen ob es existiert ansonsten neu erstellen
            if(!file.exists())
            {
                file.createNewFile();
            }

            //writer erstellen um etwas ins file zu schreiben
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);




            for(int i = 1; i <=Zufallszahl.randomnumber(); i++)//anzahl der zufallszahlen ist zufällig
            {
                fw.write(Integer.toString(Zufallszahl.randomnumber())+lineSeparator);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                fw.close();

            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}
