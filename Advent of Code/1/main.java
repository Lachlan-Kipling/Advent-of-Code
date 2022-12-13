import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class main{
    public static void main(String[] args) {
        //Create a linked list to store total calories per elf
        LinkedList<Integer> elves = new LinkedList<Integer>();

        //Boolean detecting the end of file so the reader will read past blank lines seperatng elf numbers
        boolean eof = false;

        FileInputStream filestrm;
        InputStreamReader rdr;
        BufferedReader bufrdr;

        try {
            filestrm = new FileInputStream("input.txt");
            rdr = new InputStreamReader(filestrm);
            bufrdr = new BufferedReader(rdr);

            while(!eof){
                //For each new elf, create an entry, add the calories then add this to the list of elves
                String line = bufrdr.readLine();
                int calorie = 0;
                while(!line.equals("")){
                    int thisCal = Integer.parseInt(line);
                    calorie = calorie + thisCal;
                    line = bufrdr.readLine();
                }
                
                elves.addLast(calorie);
            }

            bufrdr.close();
        }   catch(EOFException e){
            eof = true;
        }   catch(NullPointerException n){
            
        }   catch(Exception e2){
            System.out.println("Error in reading file" + e2);
        }

        //For each elf, determine if it is top 3, rearrange top 3 elves accordingly
        int max1 = 0;
        int max2 = 0;
        int max3 = 0;
        for (Integer elf : elves) {
            if(elf>max1){
                max3 = max2;
                max2 = max1;
                max1 = elf;
            }
            else if(elf>max2){
                max3 = max2;
                max2 = elf;
            }
            else if(elf>max3){
                max3 = elf;
            }
        }

        //Display the sum of the top 3 elves
        System.out.println(max1 + max2 + max3);
    }

}