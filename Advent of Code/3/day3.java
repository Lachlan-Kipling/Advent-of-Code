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
                //Split lines into individual chars
                char[] chars1 = line.toCharArray();

                String line2 = bufrdr.readLine();
                char[] chars2 = line2.toCharArray();

                String line3 = bufrdr.readLine();
                char[] chars3 = line3.toCharArray();

                char duplicate = ' ';

                for (char char1 : chars1) {
                    for (char char2 : chars2) {
                        for (char char3 : chars3) {
                            if((char1==char2)&&(char2==char3)){
                                duplicate = char1;
                            }
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
