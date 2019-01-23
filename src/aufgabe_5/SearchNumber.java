package aufgabe_5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class SearchNumber
{
    public static int searchNumber(int number)
    {
        File file = null;
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<Integer> list = new ArrayList<Integer>();

        try {

            file = new File("/Users/larissablachfelder/documents/FH_larissa/Semester_1/software_UE/leistungsbeurteilung/1810653996_UE8/zahlen.txt");

            fr = new FileReader(file);
            br = new BufferedReader(fr);

            while (true) {

                String line = br.readLine();
                if (line == null) break; //solange lesen bis in der zeile nichts drinsteht

                if (Integer.parseInt(line) == number) //wenn die gesuchte zahl in der line ist einmal zur liste hinzufügen
                {
                    list.add(Integer.parseInt(line));//zu liste hinzufügen
                }

            }

        } catch(Exception ex){
            ex.printStackTrace();
        }

        return list.size(); //die länge der liste also die anzahl wie oft die zahl enthalten ist wir zurückgegeben

    }


}




