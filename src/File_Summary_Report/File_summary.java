package File_Summary_Report;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class File_summary {
    public static void Report(String s){
        if(!Files.exists(Paths.get(s))){
            System.out.println("File path is incorrect!");
        }
        int Lcount=0;
        int Wcount=0;
        int Chcount=0;
        Map<String,Integer> wordfreq=new HashMap<>();
        try(BufferedReader reader=new BufferedReader(new FileReader(s))){
            String line;
            while((line=reader.readLine())!=null){
                Lcount++;
                Chcount+=line.length();
                String[] words=line.split("\\s+");
                for(String i:words){
                    if(!i.isEmpty()){
                        Wcount++;
                        i=i.toLowerCase().replaceAll("[^a-z0-9]","");
                        if(!i.isEmpty()){
                            wordfreq.put(i,wordfreq.getOrDefault(i,0)+1);
                        }
                    }
                }
            }

        }
        catch(IOException e){
            System.out.println("Some exception occur due to "+e.getMessage());
        }

        String mostfreqword=null;
        int maxcount=0;
        for(Map.Entry<String, Integer> entry:wordfreq.entrySet()){
            if(entry.getValue()>maxcount){
                mostfreqword=entry.getKey();
                maxcount= entry.getValue();
            }
        }

        try{
            long filesize=Files.size(Paths.get(s));
            System.out.println("File Summary Report.");
            System.out.println("---------------------");
            System.out.println("File Path "+s);
            System.out.println("File Size "+filesize);
            System.out.println("Total Line "+Lcount);
            System.out.println("Total Words "+Wcount);
            System.out.println("Total Character "+Chcount);

            if(mostfreqword!=null){
                System.out.println("Most frequent word '"+mostfreqword+"' ("+maxcount+"times)");
            }
        }catch (IOException e){
            System.out.println("File size exception due to "+e.getMessage());
        }
    }
}
