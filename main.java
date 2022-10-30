package valentines;

/*
 * TODO
 * Add lesbian females
 * id 0 cannot be used
 * Some out of bounds exceptions
 */

public class Main{

    public static void main(String[] args){
        Main placeholder = new Main();
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
        int[][] peopleIntel = new int [50][6]; 
        /* = 
        {
            {12345,0,0,0,0b0100,0b1000},
            {23456,0,0,0,0b1000,0b1100},
            {34567,0,0,1,0b0100,0b0111},
            {45678,0,1,0,0b1000,0b1111},
            {56789,0,1,0,0b1000,0b1100},
            {99999,0,1,0,0b0100,0b0111} 
        };
        */

        for (int i = 1; i<peopleIntel.length; i++){
            peopleIntel[i][0] = i;
            peopleIntel[i][1] = 0;
            peopleIntel[i][2] = (int) Math.round(Math.random());
            peopleIntel[i][3] = (int) Math.round(Math.random());
            int gender = (int) Math.round(Math.random()*3);
            switch (gender) {
                case 0:
                    gender = 8;
                    break;
                case 1:
                    gender = 4;
                    break;
                case 2:
                    gender = 2;
                    break;
                case 3:
                    gender = 1;
                    break;
            }
            peopleIntel[i][4] = gender;
            peopleIntel[i][5] = (int) Math.round(Math.random()*15);
        }
        for (int i = 0; i<peopleIntel.length; i++){
            System.out.println("Person: " + i);
            for (int j = 1; j<peopleIntel[i].length-2; j++){
                System.out.println(peopleIntel[i][j]);
            }
            num2Binary test1 = new num2Binary("%4s");
            num2Binary test2 = new num2Binary("%4s");
            System.out.println(test1.addPadding(peopleIntel[i][4]));
            System.out.println(test2.addPadding(peopleIntel[i][5]));
        }

        //id info
        int[] id = new int[peopleIntel.length];
        for (int i = 0; i<id.length; i++){
            id[i] = peopleIntel[i][0];
            //System.out.println(id[i]);
        }

        /* 
         * Soring people into gender and genderPref
         * 
        */

        //Striaght Females
        prefGroupSorter fm_group = new prefGroupSorter(peopleIntel, 1, 0);
        fm_group.classifier();
        int [][] fmGroup = fm_group.cleaner(0, 0);

        //Straight Males
        prefGroupSorter mf_group = new prefGroupSorter(peopleIntel, 0, 1);
        mf_group.classifier();
        int [][] mfGroup = mf_group.cleaner(0, 0);

        //Gay males
        prefGroupSorter mm_group = new prefGroupSorter(peopleIntel, 0, 0);
        mm_group.classifier();
        int [][] mmGroup = mm_group.cleaner(0, 0);

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
    }

}
