package Mark_Reset;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Mark {
    public static void mark_reset(String s){
        if(!Files.exists(Paths.get(s))){
            System.out.println("File path is incorrect!");
        }
        try(InputStream input=new BufferedInputStream(new FileInputStream(s))){
            if(!input.markSupported()){
                System.out.println("Mark/Reset is not supported by stream!");
            }

            System.out.println("Read first 10 character!");
            for(int i=0;i<10;i++){
                System.out.print((char)input.read());
            }
            System.out.println();

            input.mark(50);

            System.out.println("Reading 15 character after mark");
            for(int i=0;i<15;i++){
                System.out.print((char) input.read());
            }
            System.out.println();

            input.reset();
            System.out.println("Reading 15 character after reset");
            for(int i=0;i<15;i++){
                System.out.print((char) input.read());
            }

            System.out.println();

        }catch (IOException e){
            System.out.println("Some exception occur due to "+e.getMessage());
        }
    }
}
