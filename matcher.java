package valentines;

public class matcher{

    public static void main(String[] args){
        matcher placeholder = new matcher();
        placeholder.myMain();
    }

    public void myMain(){
        /*
         * 0 = dislikes, 1 = likes
         * Organized like: Gender and Prefrence (must be compatible), Strong Hobbies (Should have 2+ aligning Strong hobbies), Strong Prefrence Hobbies (Should have 2+ aligning Strong hobbies), Weak Hobbies (ex: fav subject, lower time commitment things, recent hobbies)
         * Lunch#, Gender (0=male, 1=female), Prefrence (0=male, 1=female), movies, 
         * 
         *  
         */
        //all info. Should be in a seperate text file. This is for testing
        int[][] peopleIntel = 
        {
            {12345,0,1},
            {23456,0,0},
            {34567,0,0},
            {45678,1,1},
            {56789,1,1},
            {99999,1,0}
        };

        //id info
        int[] id = new int[peopleIntel.length];
        for (int i = 0; i<id.length; i++){
            id[i] = peopleIntel[i][0];
            System.out.println(id[i]);
        }

        /* 
         * Sorting Straight Males, Straight Females, Gay Males, Lesbian Females, etc 
         * mfGroup, fmGroup, mmGroup, ffGroup, etc
         * gender-PerfeeredPartnersGender
         * 
         * 
         * 
         * THIS MUST BE MADE INTO A CLASS AND 
         * Surrently there is an  logic error that means people are not being assigned a group
         * 
         * 
        */

        //mfGroup
        int[][] mmGroup = new int[peopleIntel.length][peopleIntel[0].length];
        int[][] mfGroup = new int[peopleIntel.length][peopleIntel[0].length];
        int[][] ffGroup = new int[peopleIntel.length][peopleIntel[0].length];
        int[][] fmGroup = new int[peopleIntel.length][peopleIntel[0].length];
        for (int i = 0; i<peopleIntel.length; i++){
            //mmGroup
            if (peopleIntel[i][2] == 0) {
                if (peopleIntel[i][1] == 0){
                    mmGroup[i][2] = peopleIntel[i][2];
                    mmGroup[i][1] = peopleIntel[i][1];
                    mmGroup[i][0] = peopleIntel[i][0];
                    System.out.println("mmGroup");
                }
            } 
            //mfgroup
            if (peopleIntel[i][1] == 0) { //self sexuality identification
                if (peopleIntel[i][2] == 1){ //preferred partner sexuality identification
                    mfGroup[i][2] = peopleIntel[i][2];
                    mfGroup[i][1] = peopleIntel[i][1];
                    mfGroup[i][0] = peopleIntel[i][0];
                    System.out.println("mfGroup");
                }
            } 
            //ffgroup
            if (peopleIntel[i][1] == 1) { //self sexuality identification
                if (peopleIntel[i][2] == 1){ //preferred partner sexuality identification
                    ffGroup[i][2] = peopleIntel[i][2];
                    ffGroup[i][1] = peopleIntel[i][1];
                    ffGroup[i][0] = peopleIntel[i][0];
                    System.out.println("ffGroup");
                }
            } 
            //fmgroup
            if (peopleIntel[i][1] == 1) { //self sexuality identification
                if (peopleIntel[i][2] == 0){ //preferred partner sexuality identification
                    fmGroup[i][2] = peopleIntel[i][2];
                    fmGroup[i][1] = peopleIntel[i][1];
                    fmGroup[i][0] = peopleIntel[i][0];
                    System.out.println("fmGroup");
                }
            } 
            System.out.println("iterated " + (i+1) + " times");
        }
        //Code to verify output makes sense
        for (int i = 0; i<peopleIntel.length; i++){
            System.out.println(mmGroup[i][0]+" mmGroup");
            System.out.println(mfGroup[i][0]+" mfGroup");
            System.out.println(ffGroup[i][0]+" ffGroup");
            System.out.println(fmGroup[i][0]+" fmGroup");
        }

    }


}
