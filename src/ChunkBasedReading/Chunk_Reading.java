package ChunkBasedReading;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Chunk_Reading {
    public static void byte_reader(String s){
        if(!Files.exists(Paths.get(s))){
            System.out.println("File path is incorrect!");
        }
        try(InputStream m=new BufferedInputStream(new FileInputStream(s)) ){
            byte[] buffer=new byte[20];
            int num;
            System.out.println("Buffer data is :");
            while((num=m.read(buffer))!=-1){
                String str=new String(buffer,0,num);
                System.out.print(str);

            }
            System.out.println("Buffer data completely printed!");

        }catch (IOException e){
            System.out.println("Exception occur due to: "+e.getMessage());
        }
    }
}
