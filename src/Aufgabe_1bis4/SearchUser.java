package Aufgabe_1bis4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchUser
{
    private File file;

    public  String searchUser(String user) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.file));
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String regUser = parts[0];
                String regPw = parts[1];
                if (regUser.equals(user))
                    return regPw;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
