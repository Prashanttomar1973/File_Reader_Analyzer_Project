package Safe_Closing_of_Streams;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Safe_Closing {
    public static void  Closing(String s){
        try(InputStream input=new FileInputStream(s)){
            int data;
            while((data=input.read())!=-1){
                System.out.println((char) data);
            }
            System.out.println("File closed automatically!");
        }catch(IOException e){
            System.out.println("Error "+e.getMessage());
        }
    }
}
