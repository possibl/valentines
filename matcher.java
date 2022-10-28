package valentines;

public class matcher{

    public static void main(String[] args){
        matcher placeholder = new matcher();
        placeholder.myMain();
    }

    private void myMain(){
        /*
         * 0 = dislikes, 1 = likes
         * Organized like: Gender and Prefrence (must be compatible), Strong Hobbies (Should have 2+ aligning Strong hobbies), Strong Prefrence Hobbies (Should have 2+ aligning Strong hobbies), Weak Hobbies (ex: fav subject, lower time commitment things, recent hobbies)
         * Lunch#, Gender (0=male, 1=female), Prefrence (0=male, 1=female), movies, 
         * 
         *  person's grade
         *  grade prefrence
         * 0001 =12th
         * 0010 = 11th
         * 0100 = 10th
         * 1000 = 9th
         */
        //all info. Should be in a seperate text file. This is for testing
        int[][] peopleIntel = 
        {
            {12345,00000,0,1,0100,1100},
            {23456,00000,0,1,1000,1000},
            {34567,00000,0,1,0100,0111},
            {45678,00000,1,0,1000,0111},
            {56789,00000,1,0,1000,0111},
            {99999,00000,1,0,0100,0111}
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

        int[][] mmGroup = new int[peopleIntel.length][peopleIntel[0].length];
        int[][] mfGroup = new int[peopleIntel.length][peopleIntel[0].length];
        int[][] ffGroup = new int[peopleIntel.length][peopleIntel[0].length];
        int[][] fmGroup = new int[peopleIntel.length][peopleIntel[0].length];
        for (int i = 0; i<peopleIntel.length; i++){
            //mmGroup
            if (peopleIntel[i][2] == 1) {
                if (peopleIntel[i][3] == 0){
                    for (int k = 0; k < mmGroup[i].length; k++){
                        mmGroup[i][k] = peopleIntel[i][k];
                    }
                    //System.out.println("mmGroup");
                }
            } 
            //mfgroup
            if (peopleIntel[i][2] == 0) { //self sexuality identification
                if (peopleIntel[i][3] == 1){ //preferred partner sexuality identification
                    for (int k = 0; k < mmGroup[i].length; k++){
                        mfGroup[i][k] = peopleIntel[i][k];
                    }
                    //System.out.println("mfGroup");
                }
            } 
            //ffgroup
            if (peopleIntel[i][2] == 1) { //self sexuality identification
                if (peopleIntel[i][3] == 1){ //preferred partner sexuality identification
                    for (int k = 0; k < mmGroup[i].length; k++){
                        ffGroup[i][k] = peopleIntel[i][k];
                    }
                    //System.out.println("ffGroup");
                }
            } 
            //fmgroup
            if (peopleIntel[i][2] == 1) { //self sexuality identification
                if (peopleIntel[i][3] == 0){ //preferred partner sexuality identification
                    for (int k = 0; k < mmGroup[i].length; k++){
                        fmGroup[i][k] = peopleIntel[i][k];
                    }
                    //System.out.println("fmGroup");
                }
            } 
            //System.out.println("iterated " + (i+1) + " times");
        }
        //Code to verify output makes sense
        /*
        for (int i = 0; i<peopleIntel.length; i++){


            System.out.println(mmGroup[i][0]+" mmGroup");
            System.out.println(mfGroup[i][0]+" mfGroup");
            System.out.println(ffGroup[i][0]+" ffGroup");
            System.out.println(fmGroup[i][0]+" fmGroup");
        }
        */
        //Splitting people based off age prefrence
        //mf and fm for now
        System.out.println("tyesting 1");
        for (int i = 0; i<mmGroup.length; i++){
            System.out.println(mmGroup[i][0]);
            System.out.println(mfGroup[i][0]);
            mmGroup[i][1] = mfGroup[i][0];
            //mfGroup[i][1] = mmGroup[i][0];
        }
        
        System.out.println("tyesting 2");
        for (int i = 0; i<mmGroup.length; i++){
            System.out.println("id for straight male " + i + ": " + mmGroup[i][0]);
            System.out.println("id for straight male partner " + i + ": " + mmGroup[i][1]);

            System.out.println("id for straight female " + i + ": " + mfGroup[i][0]);
            System.out.println("id for straight female partner " + i + ": " + mfGroup[i][1]);
    
        }
        

    }


}
