package PaooGame.Utilitati;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utilitati {

    public static String incarcaLumea(String path){
        StringBuilder builder= new StringBuilder();

        try{
            BufferedReader br=new BufferedReader(new FileReader(path));
            String linie;
            while((linie = br.readLine()) !=null)
                builder.append(linie + "\n");
            br.close();

        }catch(IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static int parseInt(String nr)
    {
        try{
            return Integer.parseInt(nr);
        }catch(NumberFormatException e)
        {
            e.printStackTrace();
            return 0;
        }

    }
}
