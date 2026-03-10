package Available_Bytes_Check;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Available {
    public static void Available_Check(String s){
        if(!Files.exists(Paths.get(s))){
            System.out.println("File path is incorrect!");
        }
        try(InputStream input=new FileInputStream(s)){
            int totalbyte=input.available();
            System.out.println("Total byte available "+totalbyte);
            System.out.println("Reading first 10 character ");
            for(int i=0;i<10;i++){
                System.out.print((char)input.read());
            }
            System.out.println();
            int remain= input.available();
            System.out.println("Byte still remaining after reading 10 "+remain);
        }catch(IOException e){
            System.out.println("Some exception occur "+e.getMessage());
        }
    }
}
