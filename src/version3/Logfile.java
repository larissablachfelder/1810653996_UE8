package version3;

import java.io.*;
import java.util.Date;

public class Logfile
{
    private File file;

    public Logfile(){
        this.file = new File("/Users/larissablachfelder/documents/FH_larissa/Semester_1/software_UE/leistungsbeurteilung/1810653996_UE8/logfile.txt");
        if(!this.file.exists()){
            try{
                this.file.createNewFile();
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    //aufgabe 3
    public void logIns(String username, String password, boolean successfulLogin){
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(this.file, true));
            bw.write(new Date()+";"+username+";"+ password.substring(0,2)+"###"+password.substring(password.length()-2, password.length())+";"+successfulLogin+System.lineSeparator());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(bw !=null)
                try{
                    bw.close();
                }catch (IOException ioex){
                    ioex.printStackTrace();
                }
        }
    }

    //aufgabe 4
    public int failedLogIn(){
        int zaehler = 0;
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(this.file));
            String line;
            while((line = br.readLine()) != null)
            {
                String[]parts = line.split(";");
                if(parts[3].equals("false"))
                    zaehler++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException ioex) {
                    ioex.printStackTrace();
                }
        }
        return zaehler;

    }

}
