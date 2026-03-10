package FileUploadRead;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UploadRead {
    public static void  userupload(String s){
        if( ! Files.exists(Paths.get(s))){
            System.out.println("The given file does not exist"+s);
        }
        try(InputStream n=new BufferedInputStream(new FileInputStream(s))){
            int data;
            System.out.println("File Content:");
            while((data=n.read())!=-1){
                System.out.print((char)data);
            }
            System.out.println("File reading complete.");
        }catch(IOException e){
            System.out.println("Some error occur due exception "+ e.getMessage());
        }

    }
}
