package Aufgabe_1bis4;

import java.io.File;
import java.io.IOException;

public class Datafile
{
    private File file;

    //Konstruktor für neuen eintrag in die textdatei
    public Datafile()
    {
        this.file = new File("C/Users/larissablachfelder/documents/FH_larissa/Semester_1/software_UE/leistungsbeurteilung/1810653996_UE8/login.txt");
        if(!this.file.exists()){
            try{
                this.file.createNewFile();
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
