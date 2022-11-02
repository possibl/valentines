package valentines;

import java.io.*;
import java.util.*;

public class csvReader {

    public ArrayList<List<String>> csvParser() throws IOException {

        // File path is passed as parameter
        File file = new File("/home/eli/Documents/CSA/valentines/read.csv");
 
        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)
 
        // Creating an object of BufferedReader class
        BufferedReader br
            = new BufferedReader(new FileReader(file));
 
        // Declaring a string variable
        String str;
        // Condition holds true till
        // there is character in a string
        ArrayList<List<String>> fullList = new ArrayList<List<String>>();;

        while ((str = br.readLine()) != null){
            List<String> row = new ArrayList<String>();
            // Print the string
            //System.out.println("test");
            String[] strLine = str.split(",");

            for (int i = 0; i < strLine.length; i++)
            {   
                row.add(strLine[i]);
                //System.out.println(Integer.parseInt(strLine[i]));
            }

            fullList.add(row);
        }


        return fullList;
        
    }

}