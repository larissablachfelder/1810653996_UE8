package version3;

import javax.swing.*;
import java.io.*;

public class Check
{

        private File file;

        public Check() //erstelle das file für die namen
        {
            this.file = new File("/Users/larissablachfelder/documents/FH_larissa/Semester_1/software_UE/leistungsbeurteilung/1810653996_UE8/data_version3.txt");
            if(!this.file.exists()){
                try{
                    this.file.createNewFile();
                }catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
        public String search(String user) //überprüft ob user existiert
        {

            try {
                BufferedReader br = new BufferedReader(new FileReader(this.file));
                String line;
                while((line = br.readLine()) != null) //while schleife solang bis zeile aus
                {
                    String[] parts = line.split(";"); //neue array; vor ; in index null und passwort index 1
                    String reg_user = parts[0];
                    String reg_pw = parts[1];

                    if (reg_user.equals(user))
                        return reg_pw; //passwort der liste zurückgegeben
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            return null; //wenn pw nicht zurückgegeben dann null zurückgeben
        }

        public boolean register(String username, String password) //speichert das pw und den nutzernamen in das file
        {
            if(password.contains(";")) //wenn passwort mit ; eingegeben wird kommt das
            {
                JOptionPane.showMessageDialog(null, "Das Passwort darf kein ; enthalten."); //trennzeichen zwischen pw und name
                return false;
            }

            if(username.contains(";")) //wenn passwort mit ; eingegeben wird kommt das
            {
                JOptionPane.showMessageDialog(null, "Der Username darf kein ; enthalten."); //trennzeichen zwischen pw und name
                return false;
            }

            BufferedWriter bw = null; //null setzen

            try {
                bw = new BufferedWriter(new FileWriter(this.file, true)); //instanzieren, true dass zeile hinzufügt
                bw.write(username +";"+password); //schreibt username und pw in das file
                bw.newLine(); //neue zeile


            }catch (IOException e){
                e.printStackTrace();
            }finally
            {
                if(bw != null) //wenn bw not null dann closen
                    try{
                        bw.close();
                    } catch (IOException ioEx){
                        ioEx.printStackTrace();
                    }
            }

            return false; //falls irgendwas nicht geht
        }

    }
