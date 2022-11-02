package valentines;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * TODO
 * 
 * Add missing genders and genderprefs. Also should add support for multiple gender prefs. Ughhh.
 * Make sure all my security is correct
 * 
*/ 

public class Main{

    public static void main(String[] args) throws IOException{
        Main placeholder = new Main();
        placeholder.myMain();
    }

    private void myMain() throws IOException{
        /*
         * {id, partner's id (This could be removed), gender, genderpref, age, agepref}
         * 
         * person's grade and grade prefrence
         * 0001 =12th
         * 0010 = 11th
         * 0100 = 10th
         * 1000 = 9th
         */

        csvReader test = new csvReader();
        ArrayList<List<String>> quiz = test.csvParser();


        //System.out.println(quiz);

        String[][] _peopleIntel = new String[quiz.size()][];
 
        int ik = 0;
        for (List<String> l: quiz) {
            _peopleIntel[ik++] = l.toArray(new String[l.size()]);
        }

        int[][] peopleIntel = new int[_peopleIntel.length][_peopleIntel[0].length];

        for(int i = 0; i < _peopleIntel.length;i++){
            for(int k = 0; k<  _peopleIntel[i].length;k++){
                peopleIntel[i][k] = Integer.parseInt(_peopleIntel[i][k]);
            }
        }
        
        

        //id info
        int[] id = new int[peopleIntel.length];
        for (int i = 0; i<id.length; i++){
            id[i] = peopleIntel[i][0];
            //System.out.println(id[i]);
        }

        /* 
         * Soring people into gender and genderPref groups
         * 
        */

        //Striaght Females
        System.out.println("FM");
        prefGroupSorter fm_group = new prefGroupSorter(peopleIntel, 1, 0);
        fm_group.classifier();
        int [][] fmGroup = fm_group.cleaner(0, 0);

        //Straight Males
        System.out.println("MF");
        prefGroupSorter mf_group = new prefGroupSorter(peopleIntel, 0, 1);
        mf_group.classifier();
        int [][] mfGroup = mf_group.cleaner(0, 0);

        //Gay males
        System.out.println("MM");
        prefGroupSorter mm_group = new prefGroupSorter(peopleIntel, 0, 0);
        mm_group.classifier();
        int [][] mmGroup = mm_group.cleaner(0, 0);

        //Lesbian females
        System.out.println("FF");
        prefGroupSorter ff_group = new prefGroupSorter(peopleIntel, 1, 1);
        ff_group.classifier();
        int [][] ffGroup = ff_group.cleaner(0, 0);

        /*
         * Matching people based off of age
         * 
         */

        System.out.println("Matching Results- ");

        //Matching Striaght Males and Straight Females
        matcher mf_match = new matcher(mfGroup, fmGroup);
        int[][] mfMatch = mf_match.agePrefCouples();

        System.out.println("Matching Results for MF- ");
        for (int i = 0; i<mfMatch.length; i++){
            System.out.println(mfMatch[i][0] + " with " + mfMatch[i][1]);
        }

        //Matching Gay Males
        matcher mm_match = new matcher(mmGroup, mmGroup);
        int[][] mmMatch = mm_match.agePrefCouples();

        System.out.println("Matching Results for MM- ");
        for (int i = 0; i<mmMatch.length; i++){
            System.out.println(mmMatch[i][0] + " with " + mmMatch[i][1]);
        }

        //Matching lesbian females
        matcher ff_match = new matcher(ffGroup, ffGroup);
        int[][] ffMatch = ff_match.agePrefCouples();

        System.out.println("Matching Results for FF- ");
        for (int i = 0; i<ffMatch.length; i++){
            System.out.println(ffMatch[i][0] + " with " + ffMatch[i][1]);
        }

    }

}
