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
                if (line == null) break;

                if (Integer.parseInt(line) == number){
                    list.add(Integer.parseInt(line));
                }

            }

        } catch(Exception ex){
            ex.printStackTrace();
        }

        return list.size();

    }


}




