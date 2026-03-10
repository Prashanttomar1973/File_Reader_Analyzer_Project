import Available_Bytes_Check.Available;
import ChunkBasedReading.Chunk_Reading;
import FileUploadRead.UploadRead;
import File_Summary_Report.File_summary;
import Mark_Reset.Mark;
import Safe_Closing_of_Streams.Safe_Closing;
import Search_Analyze.Search;
import Skip_Data.Skip;

import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner  sc=new Scanner(System.in);
         int i=0;
        do {
            System.out.println("Please enter the path of the file: ");
            String str=sc.nextLine();
            System.out.println("<------- File Menu Operations -------->");
            System.out.println("1. Open and Read File ");
            System.out.println("2. Read File in Small Parts ");
            System.out.println("3. Skip Some content ");
            System.out.println("4. Search in File ");
            System.out.println("5. Mark and Go Back ");
            System.out.println("6. Check Available Data ");
            System.out.println("7. Show File Summary ");
            System.out.println("8. Close File Safely");
            System.out.println("0. Exit Program ");
            try{
            System.out.println("Please enter your choice(0 - 8)!");
            i=sc.nextInt();
            }catch (Exception e) {
                System.out.println("Error due to wrong input, Please enter only number (0 to 8) "+e.getMessage());
            }finally {
                sc.nextLine();
                System.out.println("Please enter your choice(0 - 8)!");
                i=sc.nextInt();
            }
            sc.nextLine();
            switch(i){
                case 1:
                    UploadRead b = new UploadRead();
                    b.userupload(str);
                    break;
                case 2:
                    Chunk_Reading b2 = new Chunk_Reading();
                    b2.byte_reader(str);
                    break;
                case 3:
                    Skip b3 = new Skip();
                    b3.skip_data(str);
                    break;
                case 4:

                    Search b4 = new Search();
                    b4.Search_analyze(str,"");
                    break;
                case 5:
                    Mark b5 = new Mark();
                    b5.mark_reset(str);
                    break;
                case 6:
                    Available b6 = new Available();
                    b6.Available_Check(str);
                    break;
                case 7:
                    File_summary b7 = new File_summary();
                    b7.Report(str);
                    break;
                case  8:
                    Safe_Closing b8 = new Safe_Closing();
                    b8.Closing(str);
                    break;
                case 0:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice please try again!");
            }
        }while(i != 0);
        sc.close();
    }
}
// C:\\Users\\pt240\\Downloads\\sample.txt