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
        //lunch#'s to binary so things can be kept track of. This should be moved to another file.
        //Original lunch #'s
        String[][] peopleIntel = 
        {
            {"12345"},
            {"23456"},
            {"34567"},
            {"45678"},
            {"56789"},
            {"99999"}
        };

        String[] test = peopleIntel[][0];

        //accepts int[]. defaults to 32 digits of binary
        num2Binary lunchNum = new num2Binary("%17s");
        peopleIntel = lunchNum.convert2Binary(peopleIntel[1]);

/*
 * String[] peopleinfo = 
        {
            "12345",
            "23456",
            "34567",
            "45678",
            "56789",
            "99999"
        };

        //accepts int[]. defaults to 32 digits of binary
        num2Binary lunchNum = new num2Binary("%17s");
        String[] lunchNumBinary = lunchNum.convert2Binary(lunchNumAscii);
 */

        //ammend all info about peeps to this
        /*
        int[] people = 
        {
            0b01,
            0b10,
            0b00,
            0b00,
            0b11,
            0b11
        };
        
        //sortedGP(people);
        */
    }


}
