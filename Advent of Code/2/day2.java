import java.io.*;

public class day2 {
    public static void main(String[] args) {
        FileInputStream filestrm;
        InputStreamReader rdr;
        BufferedReader bufrdr;
        int totalScore = 0;

        try {
            filestrm = new FileInputStream("input.txt");
            rdr = new InputStreamReader(filestrm);
            bufrdr = new BufferedReader(rdr);

            String line = bufrdr.readLine();


            while(!line.equals("")){
                char[] actions = line.toCharArray();
                char oponentMove = actions[0];
                char yourMove = actions[2];

                int opInt = 0;
                int yourInt = 0;

                switch (oponentMove) {
                    case 'A':
                        opInt = 1;
                        break;
                
                    case 'B':
                        opInt = 2;
                        break;
                    
                    case 'C':
                        opInt = 3;
                        break;
                }

                switch (yourMove) {
                    case 'X':
                        yourInt = 1;
                        break;
                
                    case 'Y':
                        yourInt = 2;
                        break;
                    
                    case 'Z':
                        yourInt = 3;
                        break;
                }

                int result = opInt - yourInt;
                int resultScore = 0;

                switch (result) {
                    case 0:
                        resultScore=3;
                        break;
                    
                    case -1:
                    case 2:
                        resultScore=6;
                        break;

                    case 1:
                    case -2:
                        resultScore=0;
                        break;
                }

                int roundScore = yourInt + resultScore;
                totalScore = totalScore + roundScore;
                line = bufrdr.readLine();
            }
        } catch (Exception e) {
            System.out.println("Error reading file - "+e);
        }

        System.out.println(totalScore);
    }
}
