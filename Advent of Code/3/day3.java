import java.io.*;

public class day3 {
    public static void main(String[] args) {
        FileInputStream filestrm;
        InputStreamReader rdr;
        BufferedReader bufrdr;

        try {
            filestrm = new FileInputStream("input.txt");
            rdr = new InputStreamReader(filestrm);
            bufrdr = new BufferedReader(rdr);

            String line = bufrdr.readLine();

            int totalScore = 0;

            while(line!=null){
                //Split line into individual chars
                char[] chars = line.toCharArray();

                //create 2 compartments, each half the length of chars
                char[] comp1 = new char[chars.length/2];
                char[] comp2 = new char[chars.length/2];

                //counter variable for looping through chars
                int i = 0;
                //populate comp1
                while(i<comp1.length)
                {
                    comp1[i]=chars[i];
                    i++;
                }

                //counter variable for looping through 
                int j = 0;
                //populate comp2
                while(i<chars.length){
                    comp2[j]=chars[i];
                    i++;
                    j++;
                }

                //Char to store duplicate value
                char duplicate =' ';

                //check each element in comp1, compare it to each element in comp2. If the same value is found, it is the duplicate
                for (char comp1Char : comp1) {
                    for (char comp2Char : comp2) {
                        if(comp1Char==comp2Char){
                            duplicate = comp1Char;
                        }
                    }
                }

                //find the score by adjusting the ASCII values to the required format
                int score = 0;
                if(Character.isUpperCase(duplicate)){
                    score = (int)duplicate - 38;
                }
                else{
                    score = (int)duplicate - 96;
                }

                //Add letter score to the total score
                totalScore += score;

                line = bufrdr.readLine();
            }

            //Print total score
            System.out.println(totalScore);

        } catch (Exception e) {
            System.out.println("Error reading file - "+e);
        }

   
    }    
}
