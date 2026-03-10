package Search_Analyze;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.Files.readAllBytes;

public class Search {
    public static void Search_analyze(String s, String keyword){
        if(!Files.exists(Paths.get(s))){
            System.out.println("File path is incorrect!");
        }
        String str = keyword;
        if (str == null) {
            System.out.println("Please enter the keyword which you are want to search!");
            Scanner sc=new Scanner(System.in);
            str=sc.nextLine();
        }

        try(InputStream input=(new BufferedInputStream(new FileInputStream(s)))){
            String con=new String(input.readAllBytes());

            int count=0;
            int index=con.indexOf(str);
            while(index>=0){
                count++;
                System.out.println("Searched keyword is found at index: "+index);
                index=con.indexOf(str,index+str.length());
            }
            if(count>0){
                System.out.println("keyword "+str+" found "+count+" times ");
            }
            else{
                System.out.println("keyword "+str+" not found ");
            }

        }catch(IOException e){
            System.out.println("Some Exception occur due to "+e.getMessage());
        }


    }
}
