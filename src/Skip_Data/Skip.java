package Skip_Data;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Skip {
    public static void skip_data(String s){
        if(!Files.exists(Paths.get(s))){
            System.out.println("File path is incorrect!");
        }

        try(InputStream m=new BufferedInputStream(new FileInputStream(s)) ){
            byte[] buffer=new byte[10];
            int num=m.read(buffer);

            System.out.println("First "+num+" bytes");
            System.out.println(new String(buffer));

            //skiped byte
            long sk=m.skip(15);
            System.out.println("Skipped bytes is "+sk);

            byte[] rem=m.readAllBytes();
            System.out.println("After skipped remaining bytes: ");
            System.out.println(new String(rem));

            System.out.println("Data skipped successfully!");
        }catch (IOException e){
            System.out.println("Exception occur due to: "+e.getMessage());
        }

    }
}
